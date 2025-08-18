package com.practise.controller;

import com.practise.entity.Registrations;
import com.practise.service.RegistrationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationsController {

    @Autowired
    private RegistrationsService registrationsService;

    @PostMapping("/addRegistrations")
    public ResponseEntity<String> addRegistrations(@RequestBody Registrations registrations){
        System.err.println(registrations);
        registrationsService.saveRegistrations(registrations);
        return new ResponseEntity<>("Data Registered Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllRegistration")
    public ResponseEntity<List<Registrations>> addAllData(){
    List<Registrations> registrationsList = registrationsService.addAllRegistrations();
    return new ResponseEntity<>(registrationsList, HttpStatus.OK);
    }

    @GetMapping("/getRegistrationsById/{id}")
    public ResponseEntity<Registrations> addRegitrationsById(@PathVariable ("id") int id){
        Registrations registrations = registrationsService.getRegistrationById(id);
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRegistrationById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ("id") int id){
        String delete = registrationsService.deleteRegistrationById(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    @PutMapping("/updateRegistration/{id}")
    public ResponseEntity<Registrations> updateRegistration(@PathVariable ("id") int id, @RequestBody Registrations registrations){
        Registrations updateRegistration = registrationsService.updateRegistration(id, registrations);
        return new ResponseEntity<>(updateRegistration, HttpStatus.OK);
    }

    @PostMapping("/listOfRegistration")
    public ResponseEntity<List<Registrations>> savelistOfRegistration(@RequestBody List<Registrations> registrationsList){
        registrationsService.savelistOfRegistrations(registrationsList);
        return new ResponseEntity<>(registrationsList, HttpStatus.CREATED);
    }
}
