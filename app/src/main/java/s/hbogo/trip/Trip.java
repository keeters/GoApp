package s.hbogo.trip;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by silas on 9/2/17.
 */

public class Trip {

/*
What an individual trip will look like.  This will make it easy to upload into Firebase database
 */
    Location start;
    Location destination;

    Integer seats;
    Integer bags;

    Date date;

    ArrayList<Offer> offers;

    public Short rideType; //make sure to make 2 final static shorts in the make a ride thing


    public Trip(Location start, Location destination, Integer seats, Integer bags, Date date, Short rideType) {
        this.start = start;
        this.destination = destination;

        this.seats = seats;
        this.bags = bags;

        this.date = date;

        this.rideType = rideType;
        this.offers = null;
    }

    public Short getRideType() {
        return rideType;
    }

    public void setRideType(Short rideType) {
        this.rideType = rideType;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
