package s.hbogo.trip;

import android.location.Location;

import java.util.ArrayList;

import s.hbogo.vehicle.Vehicle;

/**
 * Created by silas on 9/2/17.
 */

public class Trip {

    /*
    What an individual trip will look like.  This will make it easy to upload into Firebase database
     */
    String start; //we might need to change these to locations but that's ok


    String destination;

    Integer seats;
    Integer bags;

    String description;
    String poster;

    Integer day;
    Integer month;
    Integer year;

    ArrayList<Offer> offers;

    private Integer DRIVERIDETYPE = 0;
    public Integer RIDERIDETYPE = 1;

    public Integer rideType;
    Vehicle vehicle;


    public Trip(String start, String destination) { //Test thingy
        this.start = start;
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trip() {
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getRideType() {
        return rideType;
    }

    public void setRideTypeRide() {
        this.rideType = RIDERIDETYPE;
    }

    public void setRideTypeDrive() {
        this.rideType = DRIVERIDETYPE;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getBags() {
        return bags;
    }

    public void setBags(Integer bags) {
        this.bags = bags;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
