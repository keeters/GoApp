package s.hbogo.maintabs.myridesfragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import s.hbogo.R;
import s.hbogo.trip.AddTripDrive;
import s.hbogo.trip.Trip;

/**
 * A simple {@link Fragment} subclass.
 */
public class DriverFragment extends Fragment {

    public static final String TAG = "DriverFragment";

    Button btnGoAddDrive; //should probably change this to a FAB but I'm tired

    private RecyclerView recyclerView;
    private List<Trip> tripList;
    private MyRidesAdapter myRidesAdapter;

    protected LinearLayoutManager linearLayoutManager;

    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tripList = createTripList();



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
        recyclerView = (RecyclerView) RootView.findViewById(R.id.rvDrive);
        linearLayoutManager = new LinearLayoutManager(this.getActivity()); //Think we need this not sure
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        myRidesAdapter = new MyRidesAdapter(tripList);
        recyclerView.setAdapter(myRidesAdapter );


        return RootView;
    }

    private List<Trip> createTripList() { //this is all just for test
        List<Trip> tripList = new ArrayList<Trip>();
        for (int i=0; i<10; i++){
            tripList.add(new Trip("start", "end"));
        }
        return tripList;
    }


}
