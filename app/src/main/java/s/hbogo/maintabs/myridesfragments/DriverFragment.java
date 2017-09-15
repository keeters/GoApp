package s.hbogo.maintabs.myridesfragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import s.hbogo.R;
import s.hbogo.trip.AddTripDrive;

/**
 * A simple {@link Fragment} subclass.
 */
public class DriverFragment extends Fragment {

    public static final String TAG = "DriverFragment";

    Button btnGoAddDrive;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    public DriverFragment() {
        // Required empty public constructor
    }
        public static DriverFragment newInstance() {
            DriverFragment fragment = new DriverFragment();
            return fragment;
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_driver, container, false);

        btnGoAddDrive = (Button) RootView.findViewById(R.id.btnGoAddDrive);
        btnGoAddDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), AddTripDrive.class));
            }
        });
        return RootView;
    }

}
