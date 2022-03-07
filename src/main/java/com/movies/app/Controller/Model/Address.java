package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int addressId;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private int district;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;

    @ManyToOne
    private City city;


    @OneToMany(mappedBy = "address1")
    private List<Customer> customers = new ArrayList<Customer>();

    @OneToMany(mappedBy = "address1")
    private List<Staff> staffs = new ArrayList<Staff>();

    @OneToMany(mappedBy = "address1")
    private List<Store> stores = new ArrayList<Store>();
}
