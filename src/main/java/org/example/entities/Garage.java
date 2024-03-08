package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "garageId", fetch = FetchType.LAZY)
    private List<Car> car;

    public Garage() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }
}
