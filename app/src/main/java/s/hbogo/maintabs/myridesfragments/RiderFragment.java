package s.hbogo.maintabs.myridesfragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import s.hbogo.R;
import s.hbogo.trip.AddTripRide;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiderFragment extends Fragment {

    public static final String TAG = "RiderFragment";

    Button btnGoAddRide;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    public RiderFragment() {
        // Required empty public constructor
    }
    public static RiderFragment newInstance() {
        RiderFragment fragment = new RiderFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_rider, container, false);

        btnGoAddRide = (Button) RootView.findViewById(R.id.btnGoAddRide);
        btnGoAddRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), AddTripRide.class));
            }
        });
        return RootView;
    }

}
