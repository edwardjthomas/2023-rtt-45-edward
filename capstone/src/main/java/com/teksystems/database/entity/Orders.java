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
@Table(name = "orders")
public class Orders {

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

    @Column(name = "commission_status")
    private String commissionStatus;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
