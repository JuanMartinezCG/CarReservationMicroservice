package unimagdalena.edu.payment.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //cambiar a tipo UID
    private Integer idCliente;

    @Column(name = "bookingId", nullable = false, length = 10)
    private String bookingId;
    @Column(name = "creditCard", nullable = true, length = 50)
    private String creditCard;
    @Column(name = "amount", nullable = true, length = 150)
    private String amount;
    @Column(name = "status", nullable = true, length = 9)
    private String status;
    @Column(name = "transactionId", nullable = true, length = 50)
    private String transactionId;
}