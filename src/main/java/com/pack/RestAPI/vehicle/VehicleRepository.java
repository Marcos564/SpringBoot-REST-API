package com.pack.RestAPI.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.license_plate = ?1")
    Optional<Vehicle> findVehicleByLicense(String license);
}
