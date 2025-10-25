package com.symposium.Repository;

import com.symposium.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    // Optional: find by event ID
    java.util.List<Result> findByEventId(String eventId);
}
