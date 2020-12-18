package entity;


public class Planet {
    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }
    public String getRotation_period() {
        return rotation_period;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }
    public String getOrbital_period() {
        return orbital_period;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }
    public String getDiameter() {
        return diameter;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }
    public String getClimate() {
        return climate;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }
    public String getGravity() {
        return gravity;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
    public String getTerrain() {
        return terrain;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }
    public String getSurface_water() {
        return surface_water;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
    public String getPopulation() {
        return population;
    }

    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", rotation_period='" + rotation_period + '\'' +
                ", orbital_period='" + orbital_period + '\'' +
                ", diameter='" + diameter + '\'' +
                ", climate='" + climate + '\'' +
                ", gravity='" + gravity + '\'' +
                ", terrain='" + terrain + '\'' +
                ", surface_water='" + surface_water + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
}