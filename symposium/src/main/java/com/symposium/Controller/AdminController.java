package com.symposium.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.symposium.Model.Admin;
import com.symposium.Model.Event;
import com.symposium.Model.Registration;
import com.symposium.Model.Result;
import com.symposium.Model.User;
import com.symposium.Repository.AdminRepository;
import com.symposium.Repository.EventRepository;
import com.symposium.Repository.RegistrationRepository;
import com.symposium.Repository.ResultRepository;
import com.symposium.Repository.UserRepository;

@Controller
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ResultRepository resultRepository;

    // ===== Admin Register =====
    @GetMapping("/adminregister")
    public String showRegister() {
        return "index"; // Admin registration page
    }

    @PostMapping("/adminregister")
    @ResponseBody
    public String register(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password) {
        if(adminRepository.existsByEmail(email)) {
            return "Email already registered!";
        }
        Admin admin = new Admin();
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        adminRepository.save(admin);
        return "success";
    }

    // ===== Admin Login =====
    @GetMapping("/adminlogin")
    public String showLogin() {
        return "adminlogin"; // Login page
    }

    @PostMapping("/adminlogin")
    @ResponseBody
    public String login(@RequestParam String email,
                        @RequestParam String password) {
        Optional<Admin> admin = adminRepository.findByEmailAndPassword(email, password);
        if(admin.isPresent()) {
            return "success"; // You can later redirect to /admindashboard
        } else {
            return "Invalid email or password!";
        }
    }

    // ===== Admin Dashboard =====
    @GetMapping("/admindashboard")
    public String dashboard(Model model) {

        // Fetch all data
        List<User> users = userRepository.findAll();
        List<Event> events = eventRepository.findAll();
        List<Registration> registrations = registrationRepository.findAll();
        List<Result> results = resultRepository.findAll();
        List<Admin> admins = adminRepository.findAll();

        // Add full data to model (for tables)
        model.addAttribute("users", users);
        model.addAttribute("events", events);
        model.addAttribute("registrations", registrations);
        model.addAttribute("results", results);
        model.addAttribute("admins", admins);

        // Add counts to model (for summary and charts)
        model.addAttribute("userCount", users.size());
        model.addAttribute("eventCount", events.size());
        model.addAttribute("registrationCount", registrations.size());
        model.addAttribute("resultCount", results.size());
        model.addAttribute("adminCount", admins.size());

        // Optional: prepare numeric data for heatmaps/charts
        // e.g., scores, totalMarks, maxParticipates
        // You can pass JSON strings to Thymeleaf for Chart.js usage
        return "admindashboard"; // Thymeleaf template
    }
}
