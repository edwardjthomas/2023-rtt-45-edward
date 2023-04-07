package com.teksystems.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;

    @Column(name = "start_date")
    // something that helps with specifying dates
    @Temporal(TemporalType.DATE)
    private Date startDate;

    // @Column(name = "end_date")
    // something that helps with specifying dates
    // @Temporal(TemporalType.DATE)
    // private Date endDate;

    @Column(name = "status")
    private String status;

}
