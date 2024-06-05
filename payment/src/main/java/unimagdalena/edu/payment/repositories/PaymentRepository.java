package unimagdalena.edu.payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagdalena.edu.payment.entities.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}