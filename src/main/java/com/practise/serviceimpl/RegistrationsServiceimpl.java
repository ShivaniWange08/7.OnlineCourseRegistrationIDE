package com.practise.serviceimpl;

import com.practise.entity.Registrations;
import com.practise.repository.RegistrationsRepository;
import com.practise.service.RegistrationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationsServiceimpl implements RegistrationsService {

    @Autowired
    private RegistrationsRepository registrationsRepository;

    @Override
    public String saveRegistrations(Registrations registrations) {
        Registrations savedRegistrations = registrationsRepository.save(registrations);
        return "registration saved";
    }

    @Override
    public List<Registrations> addAllRegistrations() {
        List<Registrations> registrationsList = registrationsRepository.findAll();
        return registrationsList;
    }

    @Override
    public Registrations getRegistrationById(int id) {
        Registrations registrations = registrationsRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Registration with id not found" +id));
        return registrations;
    }

    @Override
    public String deleteRegistrationById(int id) {
        registrationsRepository.deleteById(id);
        return "Registration Deleted";
    }

    @Override
    public Registrations updateRegistration(int id, Registrations newRegistration) {
        Registrations registrations = registrationsRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Registration with id not found in database" +id));
        System.err.println("old registration from db" +registrations);
        System.err.println("Developer object with value to be updated " +newRegistration);
        registrations.setStudentName(newRegistration.getStudentName());
        registrations.setCourseName(newRegistration.getCourseName());
        registrations.setRegistrationDate(newRegistration.getRegistrationDate());
        registrations.setFeesPaid(newRegistration.getFeesPaid());

        Registrations updateRegistration = registrationsRepository.save(registrations);
        System.err.println("Registration with updated value " +updateRegistration);
        return updateRegistration;
    }

    @Override
    public List<Registrations> savelistOfRegistrations(List<Registrations> registrationsList) {
        registrationsRepository.saveAll(registrationsList);
        return registrationsList;
    }
}
