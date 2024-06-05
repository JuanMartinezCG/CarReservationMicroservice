package unimagdalena.edu.payment.controllers;

import org.springframework.web.bind.annotation.RestController;



import unimagdalena.edu.payment.entities.Payment;
import unimagdalena.edu.payment.services.PaymentServices;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/payment")

public class PaymentController {
    @Autowired
    private PaymentServices paymentService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.create(payment), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable("id") Integer idPayment) {
        Payment payment = paymentService.findById(idPayment);
        if (payment == null) {
            throw new RuntimeException("el pago que desea obtener no existe");
        }
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

}