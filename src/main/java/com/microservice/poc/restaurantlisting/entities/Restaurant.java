package com.microservice.poc.restaurantlisting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @Column(name="rest_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="rest_created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name="rest_last_updated_at")
    @UpdateTimestamp
    private Date lastUpdatedAt;
    @Column(name = "rest_name")
    private String name;
    @Column(name="rest_add")
    private String address;
    @Column(name = "rest_city")
    private String city;
    @Column(name="rest_desc")
    private String description;
}
