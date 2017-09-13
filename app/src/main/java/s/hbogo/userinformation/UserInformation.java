package s.hbogo.userinformation;

import s.hbogo.Vehicle.Vehicle;

/**
 * Created by silas on 9/1/17.
 */

public class UserInformation {
/*
What stuff can be saved to a user profile
 */
    String firstName;
    String lastName;
    String phoneNumber;

    Vehicle vehicle; //not included in constructor



    String bio;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public UserInformation() {
    }

    public UserInformation(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.vehicle = null;
        this.bio = null;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
