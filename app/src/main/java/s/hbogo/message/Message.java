package s.hbogo.message;

import java.util.Date;

/**
 * Created by silas on 9/13/17.
 */

public class Message {

    //What about 2 arraylists of messages- messages sent and messages recieved.  They could be organized by time
    //cycling through the list with a merge sort kinda thing that organizes by tim

    String message;
    String sender;
    String reciever;
    long time;

    public Message(String message, String sender, String reciever) {
        this.message = message;
        this.sender = sender;
        this.reciever = reciever;
        time = new Date().getTime();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }



}
