package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//database to populate flight detailsc
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    FlightRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Flight flight;
        flight = new Flight("LAX","BWI","One-Way","11/25/2019","97.00");
        repository.save(flight);

        flight = new Flight("DFW","LAX","One-Way","11/26/2019","99.00");
        repository.save(flight);

        flight = new Flight("LAX","BWI","One-Way","11/27/2019","98.00");
        repository.save(flight);

        flight = new Flight("DFW","LAX","One-Way","12/02/2019","101.00");
        repository.save(flight);
        flight = new Flight("LAX","BWI","One-Way","12/03/2019","120.00");
        repository.save(flight);
        flight = new Flight("LAX","BWI","One-Way","12/04/2019","87.00");
        repository.save(flight);
    }
}
