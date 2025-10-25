package com.symposium.Repository;

import com.symposium.Model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    // Optional: find by email
    Registration findByEmail(String email);
}
