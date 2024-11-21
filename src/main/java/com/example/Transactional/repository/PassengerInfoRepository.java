package com.example.Transactional.repository;

import com.example.Transactional.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
