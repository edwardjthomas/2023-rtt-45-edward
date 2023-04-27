package springexamples.database.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_lastname")
    private String contactLastName;

    @Column(name = "contact_firstname")
    private String contactFirstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    // this essentially makes this column a read only variable in this entity object
    // we add the insertable = falese and updatable = false
    // because we are using a @ManyToOne mapping that is on this same column
    // the other option is to simply delete these 2 lines
    @Column(name = "sales_rep_employee_id", insertable = false, updatable = false)
    private Integer salesRepEmployeeNumber;

    @Column(name = "credit_limit", columnDefinition = "decimal", precision = 10, scale = 2)
    private Double creditLimit;

    // salesRepEmployeeNumber
    // to employee
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "sales_rep_employee_id", nullable = true)
    private Employee employee;

    // payments
    // to payment
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<Payment>();

    // to orders
    // @ToString.Exclude
    // @LazyCollection(LazyCollectionOption.FALSE)
    // @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    // private List<Order> orders = new ArrayList<Order>();

}
