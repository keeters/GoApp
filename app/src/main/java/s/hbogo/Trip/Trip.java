package s.hbogo.Trip;

import android.location.Location;
import android.text.style.TtsSpan;

import java.util.Date;

/**
 * Created by silas on 9/2/17.
 */

public class Trip {
/*
What an individual trip will look like
 */
    Location start;
    Location destination;

    Integer seats;
    Integer bags;

    Date date;

    public Trip(Location start, Location destination, Integer seats, Integer bags, Date date) {
        this.start = start;
        this.destination = destination;
        this.seats = seats;
        this.bags = bags;
        this.date = date;
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
