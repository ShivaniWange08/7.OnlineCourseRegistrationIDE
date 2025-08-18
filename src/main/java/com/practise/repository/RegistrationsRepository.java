package com.practise.repository;

import com.practise.entity.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationsRepository extends JpaRepository <Registrations, Integer>{
}
