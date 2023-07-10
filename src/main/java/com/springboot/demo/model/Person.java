package com.springboot.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="person")
public class Person {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")

    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    public Person(){
    }

    public Person(@JsonProperty("id") long id,
                  @JsonProperty("name") String name,
                    @JsonProperty("address") String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
