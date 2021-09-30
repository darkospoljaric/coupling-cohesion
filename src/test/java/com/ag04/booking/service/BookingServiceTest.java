package com.ag04.booking.service;

import com.ag04.booking.model.BookingRequest;
import com.ag04.booking.model.Invoice;
import com.ag04.booking.model.Reservation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private AvailabilityService availabilityService;

    @Mock
    private ReservationService reservationService;

    @Mock
    private InvoiceService invoiceService;

    @Mock
    private MailService mailService;

    @InjectMocks
    private BookingService bookingService;

    @Test
    public void testSucessfullBook() {
        // given
        when(availabilityService.isAvailable(any())).thenReturn(true);
        when(reservationService.makeReservation(any())).thenReturn(new Reservation());
        when(invoiceService.createInvoice(any())).thenReturn(new Invoice());

        // when
        BookingRequest request = new BookingRequest();
        boolean booked = bookingService.book(request);

        // then
        assertTrue(booked);

        verify(availabilityService).isAvailable(eq(request));
        verify(reservationService).makeReservation(eq(request));
        verify(invoiceService).createInvoice(any());
        verify(mailService).sendInvoice(any());
    }
}
