package entity;

public class Person {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    public String getHeight() {
        return height;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }
    public String getMass() {
        return mass;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }
    public String getHair_color() {
        return hair_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }
    public String getSkin_color() {
        return skin_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }
    public String getEye_color() {
        return eye_color;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }
    public String getBirth_year() {
        return birth_year;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", hair_color='" + hair_color + '\'' +
                ", skin_color='" + skin_color + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", birth_year='" + birth_year + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
