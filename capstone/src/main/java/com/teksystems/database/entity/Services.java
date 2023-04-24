package com.teksystems.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "type")
    private String type;

    @Column(name = "price", columnDefinition = "decimal", precision = 10, scale = 2)
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String image_Url;

    @Column(name = "quote")
    private String quote;

    @ToString.Exclude
    @OneToMany(mappedBy = "services", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

}
