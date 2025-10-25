package com.symposium.Controller;

import com.symposium.Model.Registration;
import com.symposium.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    // ===== Save a new Registration =====
    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationRepository.save(registration);
    }

    // ===== Get all Registrations =====
    @GetMapping("/all")
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    // ===== Get a Registration by ID =====
    @GetMapping("/{id}")
    public Optional<Registration> getRegistrationById(@PathVariable Long id) {
        return registrationRepository.findById(id);
    }

    // ===== Update a Registration =====
    @PutMapping("/update/{id}")
    public Registration updateRegistration(@PathVariable Long id, @RequestBody Registration regDetails) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id " + id));

        registration.setFullName(regDetails.getFullName());
        registration.setRollnumber(regDetails.getRollnumber());
        registration.setDepartment(regDetails.getDepartment());
        registration.setYear(regDetails.getYear());
        registration.setEmail(regDetails.getEmail());
        registration.setPhone(regDetails.getPhone());
        registration.setCourse(regDetails.getCourse());
        registration.setPassword(regDetails.getPassword());
        registration.setGender(regDetails.getGender());
        registration.setAbout(regDetails.getAbout());

        return registrationRepository.save(registration);
    }

    // ===== Delete a Registration =====
    @DeleteMapping("/delete/{id}")
    public String deleteRegistration(@PathVariable Long id) {
        registrationRepository.deleteById(id);
        return "Registration deleted with id: " + id;
    }
}
