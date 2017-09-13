package s.hbogo.rating;

/**
 * Created by silas on 9/13/17.
 */

public class Rating {
    Integer rating;
    String details;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Rating(Integer rating, String details) {
        this.rating = rating;
        this.details = details;
    }

}
