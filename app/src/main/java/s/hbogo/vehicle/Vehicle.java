package s.hbogo.vehicle;

/**
 * Created by silas on 9/2/17.
 */
/*
WHat a vehicle object will look like
 */


public class Vehicle {

    String make;
    String year;
    String model;
    String color;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehicle(String make, String year, String model, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }



}
