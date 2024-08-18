package com.pack.RestAPI.vehicle;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;   //use a VehicleRepository object

    @Autowired    //this is the constructor
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    //------------- GET or READ METHOD --------------
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }


    //---------------- ADD METHOD -------------
    public void addNewVehicle(Vehicle vehicle) {

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByLicense(vehicle.getLicense_plate());

        if(vehicleOptional.isPresent()){
            throw new IllegalStateException("license already registered");
        }

        vehicleRepository.save(vehicle);
    }



    //----------------  DELETE METHOD -----------------------
    public void deleteVehicle(Long vehicleId) {

        boolean exists = vehicleRepository.existsById(vehicleId);

        if(!exists){
            throw new IllegalStateException("Vehicle not found");
        }
        vehicleRepository.deleteById(vehicleId);
    }


    //----------------- UPDATE METHOD ------------------
    @Transactional
    public void updateVehicle(Long vehicleId,String license_place, String model, String colour, Double price, Integer km) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(
                ()-> new IllegalStateException("vehicle with ID = not found")
        );

        if(license_place != null && license_place.length()>0 && !Objects.equals(vehicle.getLicense_plate(),license_place)){
            vehicle.setLicense_plate(license_place);
        }

        if(model !=null && model.length()>0 && !Objects.equals(vehicle.getModel(),model)){
            vehicle.setModel(model);
        }

        if(colour != null && colour.length()>0 && !Objects.equals(vehicle.getColour(),colour)){
            vehicle.setColour(colour);
        }

        if(price != null && price > 0 && !Objects.equals(vehicle.getPrice(),price)){
            vehicle.setPrice(price);
        }

        if(km!= null && km >= 0 && !Objects.equals(vehicle.getKm(),km) ){
            vehicle.setKm(km);
        }

    }
}