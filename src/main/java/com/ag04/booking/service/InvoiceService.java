package com.ag04.booking.service;

import com.ag04.booking.model.Invoice;
import com.ag04.booking.model.Reservation;

public class InvoiceService {
    public Invoice createInvoice(Reservation reservation) {
        return new Invoice();
    }
}
