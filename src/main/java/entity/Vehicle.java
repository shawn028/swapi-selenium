package entity;

public class Vehicle {
	private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private String cargo_capacity;
    private String consumables;
    private String vehicle_class;
    
    
    public String Vname;
    public String Vmodel;
    public String Vmanufacturer;
    public String Vcost_in_credits;
    public String Vmax_atmosphering_speed;
    public String Vcrew;
    public String Vpassengers;
    public String Vcargo_capacity;
    public String Vconsumables;
    public String Vvehicle_class;
    
    public void setName(String name) {
        this.name = name;
        Vname = name;
    }
    public String getName() {
        if (name!=Vname){
   		 	return Vname;
        }
        else {
        	return name;
        }
    }
    
    public void setModel(String model) {
        this.model = model;
        Vmodel = model;
    }
    public String getModel() {
        if (model!=Vmodel){
   		 	return Vmodel;
        }
        else {
        	return model;
        }
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        Vmanufacturer = manufacturer;
    }
    public String getManufacturer() {
        if (manufacturer!=Vmanufacturer){
   		 	return Vmanufacturer;
        }
        else {
        	return manufacturer;
        }
    }
    
    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
        Vcost_in_credits = cost_in_credits;
    }
    public String getCost_in_credits() {
        if (cost_in_credits!=Vcost_in_credits){
   		 	return Vcost_in_credits;
        }
        else {
        	return cost_in_credits;
        }
    }
    
    public void setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
        Vmax_atmosphering_speed = max_atmosphering_speed;
    }
    public String getMax_atmosphering_speed() {
        if (max_atmosphering_speed!=Vmax_atmosphering_speed){
   		 	return Vmax_atmosphering_speed;
        }
        else {
        	return max_atmosphering_speed;
        }
    }
    
    public void setCrew(String crew) {
        this.crew = crew;
        Vcrew = crew;
    }
    public String getCrew() {
        if (crew!=Vcrew){
   		 	return Vcrew;
        }
        else {
        	return crew;
        }
    }
    
    public void setPassengers(String passengers) {
        this.passengers = passengers;
        Vpassengers = passengers;
    }
    public String getPassengers() {
        if (passengers!=Vpassengers){
   		 	return Vpassengers;
        }
        else {
        	return passengers;
        }
    }
    
    public void setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
        Vcargo_capacity = cargo_capacity;
    }
    public String getCargo_capacity() {
        if (cargo_capacity!=Vcargo_capacity){
   		 	return Vcargo_capacity;
        }
        else {
        	return cargo_capacity;
        }
    }
    
    public void setConsumables(String consumables) {
        this.consumables = consumables;
        Vconsumables = consumables;
    }
    public String getConsumables() {
        if (consumables!=Vconsumables){
   		 	return Vconsumables;
        }
        else {
        	return consumables;
        }
    }
    
    public void setVehicle_class(String vehicle_class) {
        this.vehicle_class = vehicle_class;
        Vvehicle_class = vehicle_class;
    }
    public String getVehicle_class() {
        if (vehicle_class!=Vvehicle_class){
   		 	return Vvehicle_class;
        }
        else {
        	return vehicle_class;
        }
    }
    
    
}
