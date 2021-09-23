package com.robert.nisum.challenge.repository;

import com.robert.nisum.challenge.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String> {
}
