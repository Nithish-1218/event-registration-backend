package com.registration.event_management.controller;
import com.registration.event_management.entity.Registration;
import com.registration.event_management.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    // 1. Register Student
    @PostMapping("/register")
    public ResponseEntity<Registration> registerStudent(
            @Valid @RequestBody Registration registration) {

        Registration savedRegistration =
                registrationService.registerStudent(registration);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedRegistration);
    }
    // 2. View All Registrations
    @GetMapping("/registrations")
    public ResponseEntity<List<Registration>> getAllRegistrations() {

        List<Registration> registrations =
                registrationService.getAllRegistrations();

        return ResponseEntity.ok(registrations);
    }
    // 3. View Single Registration
    @GetMapping("/registrations/{id}")
    public ResponseEntity<Registration> getRegistrationById(
            @PathVariable Long id) {

        Registration registration =
                registrationService.getRegistrationById(id);

        return ResponseEntity.ok(registration);
    }
}
