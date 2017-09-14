package s.hbogo.trip;

import java.util.ArrayList;
import java.util.Queue;

import s.hbogo.maintabs.Messages;

/**
 * Created by silas on 9/13/17.
 */

public class Offer {

    String poster;
    String buyer;
    Queue<Messages> messagesQueue;

    public Offer(String poster, String buyer) {
        this.poster = poster;
        this.buyer = buyer;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }


    public Queue<Messages> getMessagesQueue() {
        return messagesQueue;
    }

    public void setMessagesQueue(Queue<Messages> messagesQueue) {
        this.messagesQueue = messagesQueue;
    }



}
