package com.example.Transactional.dto;

import com.example.Transactional.entity.PassengerInfo;
import com.example.Transactional.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private PaymentInfo paymentInfo;
    private PassengerInfo passengerInfo;
}
