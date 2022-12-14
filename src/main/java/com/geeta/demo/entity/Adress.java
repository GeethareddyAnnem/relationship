package com.geeta.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
    @Id
    @GeneratedValue
    private Integer id;

    private String street;
    private String city;
    private String state;
    private Long pincode;
    
    // @OneToOne(cascade = CascadeType.ALL,mappedBy = "adress")
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "adress")
    private List<Customer> customer;

    
}
