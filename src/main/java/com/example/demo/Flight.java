package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long flightNum;
    @NotNull
    private String departingAirport;
    @NotNull
    private String arrivingAirport;
    @NotNull
    private String type;
    @NotNull
    private String price;
    @NotNull
    private String dateDepart;
    private String photo;

    //this constructor is for dataloader, populate flight database ahead of time
    public Flight(@NotNull String departingAirport, @NotNull String arrivingAirport, @NotNull String type, @NotNull String dateDepart, @NotNull String price) {
        this.departingAirport = departingAirport;
        this.arrivingAirport = arrivingAirport;
        this.type = type;
        this.dateDepart = dateDepart;
        this.price = price;

    }

    public Flight() {
    }

    public long getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(long flightNum) {
        this.flightNum = flightNum;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDepartingAirport() {
        return departingAirport;
    }

    public void setDepartingAirport(String departingAirport) {
        this.departingAirport = departingAirport;
    }

    public String getArrivingAirport() {
        return arrivingAirport;
    }

    public void setArrivingAirport(String arrivingAirport) {
        this.arrivingAirport = arrivingAirport;
    }
}
