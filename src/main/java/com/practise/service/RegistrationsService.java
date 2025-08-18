package com.practise.service;

import com.practise.entity.Registrations;

import java.util.List;

public interface RegistrationsService {

    String saveRegistrations(Registrations registrations);

    List<Registrations> addAllRegistrations();

    Registrations getRegistrationById(int id);

    String deleteRegistrationById(int id);

    Registrations updateRegistration(int id, Registrations newRegistration);

    List<Registrations> savelistOfRegistrations(List<Registrations> registrationsList);
}
