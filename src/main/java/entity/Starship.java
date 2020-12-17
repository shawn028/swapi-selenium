package entity;

public class Starship {
	private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private String cargo_capacity;
    
    public String Stname;
    public String Stmodel;
    public String Stmanufacturer;
    public String Stcost_in_credits;
    public String Stlength;
    public String Stmax_atmosphering_speed;
    public String Stcrew;
    public String Stpassengers;
    public String Stcargo_capacity;
    
    public void setName(String name) {
        this.name = name;
        Stname = name;
    }
    public String getName() {
        if (name!=Stname){
   		 	return Stname;
        }
        else {
        	return name;
        }
    }
    
    public void setModel(String model) {
        this.model = model;
        Stmodel = model;
    }
    public String getModel() {
        if (model!=Stmodel){
   		 	return Stmodel;
        }
        else {
        	return model;
        }
    }
    
    public void setManufacturer(String manufacturer) {
        this.model = manufacturer;
        Stmanufacturer = manufacturer;
    }
    public String getManufacturer() {
        if (manufacturer!=Stmanufacturer){
   		 	return Stmanufacturer;
        }
        else {
        	return manufacturer;
        }
    }
    
    public void setCost_in_credits(String cost_in_credits) {
        this.model = cost_in_credits;
        Stcost_in_credits = cost_in_credits;
    }
    public String getCost_in_credits() {
        if (cost_in_credits!=Stcost_in_credits){
   		 	return Stcost_in_credits;
        }
        else {
        	return cost_in_credits;
        }
    }
    
    public void setLength(String length) {
        this.model = length;
        Stlength = length;
    }
    public String getLength() {
        if (length!=Stlength){
   		 	return Stlength;
        }
        else {
        	return length;
        }
    }
    
    public void setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.model = max_atmosphering_speed;
        Stmax_atmosphering_speed = max_atmosphering_speed;
    }
    public String getMax_atmosphering_speed() {
        if (max_atmosphering_speed!=Stmax_atmosphering_speed){
   		 	return Stmax_atmosphering_speed;
        }
        else {
        	return max_atmosphering_speed;
        }
    }
    
    public void setCrew(String crew) {
        this.model = crew;
        Stcrew = crew;
    }
    public String getCrew() {
        if (crew!=Stcrew){
   		 	return Stcrew;
        }
        else {
        	return crew;
        }
    }
    
    public void setPassengers(String passengers) {
        this.model = passengers;
        Stpassengers = passengers;
    }
    public String getPassengers() {
        if (passengers!=Stpassengers){
   		 	return Stpassengers;
        }
        else {
        	return passengers;
        }
        
    }
    
    public void setCargo_capacity(String cargo_capacity) {
        this.model = cargo_capacity;
        Stcargo_capacity = cargo_capacity;
    }
    public String getCargo_capacity() {
        if (cargo_capacity!=Stcargo_capacity){
   		 	return Stcargo_capacity;
        }
        else {
        	return cargo_capacity;
        }
    }
    
}
