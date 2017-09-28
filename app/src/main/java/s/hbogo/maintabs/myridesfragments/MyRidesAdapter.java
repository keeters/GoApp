package s.hbogo.maintabs.myridesfragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import s.hbogo.R;
import s.hbogo.trip.Trip;

/**
 * Created by silas on 9/22/17.
 */

public class MyRidesAdapter extends RecyclerView.Adapter<MyRidesAdapter.UserViewHolder> {

    private List<Trip> tripList;

    public MyRidesAdapter(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_trip, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        Trip trip = tripList.get(position);

        holder.tvDestination.setText(trip.getDestination().toString());
        holder.tvStart.setText(trip.getStart().toString());
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tvStart;
        TextView tvDestination;
        Button btnEditTrip;

        public UserViewHolder(View itemView) {
            super(itemView);

            tvStart = (TextView) itemView.findViewById(R.id.tvStart);
            tvDestination = (TextView) itemView.findViewById(R.id.tvDestination);
            btnEditTrip = (Button) itemView.findViewById(R.id.btnEditTrip);
        }
    }

}
