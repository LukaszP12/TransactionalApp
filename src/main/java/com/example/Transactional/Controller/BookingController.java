package com.example.Transactional.Controller;

import com.example.Transactional.dto.BookingRequest;
import com.example.Transactional.dto.BookingResponse;
import com.example.Transactional.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/booking")
    public BookingResponse bookTicket(@RequestBody BookingRequest bookingRequest)  {
        return bookingService.bookTicket(bookingRequest);
    }
}
