package com.example.Transactional.service;

import com.example.Transactional.dto.BookingRequest;
import com.example.Transactional.dto.BookingResponse;
import com.example.Transactional.entity.PassengerInfo;
import com.example.Transactional.entity.PaymentInfo;
import com.example.Transactional.exception.InsufficientBalanceException;
import com.example.Transactional.repository.PassengerInfoRepository;
import com.example.Transactional.repository.PaymentInfoRepository;
import com.example.Transactional.utility.PaymentGatewaySimulator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    private final PaymentInfoRepository paymentInfoRepository;
    private final PassengerInfoRepository passengerInfoRepository;

    public BookingServiceImpl(PaymentInfoRepository paymentInfoRepository, PassengerInfoRepository passengerInfoRepository) {
        this.paymentInfoRepository = paymentInfoRepository;
        this.passengerInfoRepository = passengerInfoRepository;
    }

    public BookingResponse bookTicket(BookingRequest bookingRequest) throws InsufficientBalanceException {

        BookingResponse bookingResponse = null;
        PassengerInfo passengerInfo = passengerInfoRepository.save(bookingRequest.getPassengerInfo());

        PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();
        // simulate transaction failure due to insufficient balance in account
        PaymentGatewaySimulator.validateFareBalanceCriteria(paymentInfo.getAccountNo(), paymentInfo.getTotalFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setTotalFare(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);

        bookingResponse = new BookingResponse();
        bookingResponse.setStatus("SUCCESS");
        bookingResponse.setPassengerInfo(passengerInfo);
        bookingResponse.setPnr(UUID.randomUUID().toString().split("-")[0]);
        bookingResponse.setTotalFare(passengerInfo.getFare());
        return bookingResponse;
    }
}
