package springexamples.database.entity;

import java.util.Date;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // remember that we're doing this to prevent the duplicate customer object
    // also remember to just remove it as an alternative option
    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;

    @Column(name = "check_number")
    private String checkNumber;

    @Column(name = "payment_date")
    // something that helps with specifying dates
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "amount", columnDefinition = "decimal", precision = 10, scale = 2)
    private Double amount;

    // has to be the column name of the "FOREIGN KEY COLUMN" so like
    // also make sure to use @ToString.Exclude on the manytoones and so on
    // points back to customer
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
