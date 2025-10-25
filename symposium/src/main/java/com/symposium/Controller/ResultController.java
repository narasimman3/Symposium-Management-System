package com.symposium.Controller;

import com.symposium.Model.Result;
import com.symposium.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    // ===== Add new Result =====
    @PostMapping("/add")
    public ResponseEntity<Result> addResult(@RequestBody Result result) {
        Result savedResult = resultRepository.save(result);
        return ResponseEntity.ok(savedResult);
    }

    // ===== Get all Results =====
    @GetMapping("/all")
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> results = resultRepository.findAll();
        return ResponseEntity.ok(results);
    }

    // ===== Get Result by ID =====
    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id) {
        Optional<Result> result = resultRepository.findById(id);
        return result.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // ===== Update Result =====
    @PutMapping("/update/{id}")
    public ResponseEntity<Result> updateResult(@PathVariable Long id, @RequestBody Result resultDetails) {
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found with id " + id));

        result.setEventId(resultDetails.getEventId());
        result.setWinnerName(resultDetails.getWinnerName());
        result.setPosition(resultDetails.getPosition());
        result.setScore(resultDetails.getScore());
        result.setTotalMark(resultDetails.getTotalMark());
        result.setJudgeRemark(resultDetails.getJudgeRemark());
        result.setCertificate(resultDetails.getCertificate());

        Result updatedResult = resultRepository.save(result);
        return ResponseEntity.ok(updatedResult);
    }

    // ===== Delete Result =====
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable Long id) {
        resultRepository.deleteById(id);
        return ResponseEntity.ok("Result deleted with id: " + id);
    }
}
