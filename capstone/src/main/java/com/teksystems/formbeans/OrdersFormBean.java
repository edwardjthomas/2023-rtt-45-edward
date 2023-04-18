package com.teksystems.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrdersFormBean {


    private Integer id;

    private Integer userId;

    private Date startDate;


    // private Date endDate;

    private String status;

    private String commissionStatus;

}
