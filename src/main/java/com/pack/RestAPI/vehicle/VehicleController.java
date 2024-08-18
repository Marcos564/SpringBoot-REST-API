package com.pack.RestAPI.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController        //The controllers act as "endpoints"
@RequestMapping(path = "api/all")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getVehicles(){
        return vehicleService.getVehicles();
    }

    @PostMapping
    public void registerNewVehicle(@RequestBody Vehicle vehicle){
        vehicleService.addNewVehicle(vehicle);      //from controller, we use the Service to do the operations
    }

    @DeleteMapping(path = "{vehicleId}")
    public void deleteVehicle(@PathVariable("vehicleId") Long vehicleId){
        vehicleService.deleteVehicle(vehicleId);
    }

    @PutMapping(path = "update/{vehicleId}")
    public void updateVehicle(@PathVariable("vehicleId") Long vehicleId,
                              @RequestParam(required = false) String license_plate,
                              @RequestParam(required = false) String model,
                              @RequestParam(required = false) String colour,
                              @RequestParam(required = false) Double price,
                              @RequestParam(required = false) Integer km) {
        vehicleService.updateVehicle(vehicleId,license_plate,model, colour,price,km);
    }

}