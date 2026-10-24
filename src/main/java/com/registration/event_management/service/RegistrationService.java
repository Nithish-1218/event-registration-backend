package com.registration.event_management.service;
import com.registration.event_management.entity.Registration;
import com.registration.event_management.repository.RegistrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    // Register Student
    @Transactional
    public Registration registerStudent(Registration registration) {

        // Check Duplicate Email
        if (registrationRepository.findByEmail(registration.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered");
        }

        // Check Event Capacity
        if (registrationRepository.count() >= 50) {
            throw new RuntimeException("Event is full");
        }

        // Set Registration Time
        registration.setRegistrationTime(LocalDateTime.now());

        // Save Registration
        return registrationRepository.save(registration);
    }

    // View All Registrations
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    // View Single Registration
    public Registration getRegistrationById(Long id) {

        return registrationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Registration not found"));
    }
}
