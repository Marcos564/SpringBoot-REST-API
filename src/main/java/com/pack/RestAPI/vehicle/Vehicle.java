package com.pack.RestAPI.vehicle;

import jakarta.persistence.*;

@Entity
@Table   //it doesn't do anything
public class Vehicle {
    @Id
    @SequenceGenerator(
            name = "vehicle_sequence",
            sequenceName = "vehicle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_sequence")
    public Long id;                     //this ID is used to identify the vehicle on the DB
    public String license_plate;
    public String model;
    public String colour;
    public String type;               // may be car - motorcycle - pick up. Should have some kind of filter
    public double price;
    public int km;


    // ------ METHODS -----

    //Constructors
    public Vehicle(){

    }

    public Vehicle(Long id, String license_plate, String model, String colour, String type, double price, int km) {
        this.id = id;
        this.license_plate = license_plate;
        this.model = model;
        this.colour = colour;
        this.type = type;
        this.price = price;
        this.km = km;
    }

    public Vehicle(String license_plate, String model, String colour, String type, double price, int km) {
        this.license_plate = license_plate;
        this.model = model;
        this.colour = colour;
        this.type = type;
        this.price = price;
        this.km = km;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", license_plate='" + license_plate + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", km=" + km +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}