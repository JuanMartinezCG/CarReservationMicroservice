package unimagdalena.edu.payment.services;

import unimagdalena.edu.payment.entities.Payment;

public interface PaymentServices {
    Payment create(Payment payment);

    Payment findById(Integer id);

}