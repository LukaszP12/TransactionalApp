package com.example.Transactional.service;

import com.example.Transactional.dto.BookingRequest;
import com.example.Transactional.dto.BookingResponse;
import com.example.Transactional.exception.InsufficientBalanceException;

public interface BookingService {
    BookingResponse bookTicket(BookingRequest bookingRequest) throws InsufficientBalanceException;
}
