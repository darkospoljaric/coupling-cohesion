package com.ag04.booking.service;


import com.ag04.booking.model.BookingRequest;
import com.ag04.booking.model.Invoice;
import com.ag04.booking.model.Reservation;

public class BookingService {

    public BookingService(AvailabilityService availabilityService, ReservationService reservationService, InvoiceService invoiceService, MailService mailService) {
        this.availabilityService = availabilityService;
        this.reservationService = reservationService;
        this.invoiceService = invoiceService;
        this.mailService = mailService;
    }

    private final AvailabilityService availabilityService;
    private final ReservationService reservationService;
    private final InvoiceService invoiceService;
    private final MailService mailService;

    public boolean book(BookingRequest request) {
        boolean available = availabilityService.isAvailable(request);
        if (available) {
            Reservation reservation = reservationService.makeReservation(request);
            Invoice invoice = invoiceService.createInvoice(reservation);
            mailService.sendInvoice(invoice);
            return true;
        } else {
            return false;
        }
    }


}
