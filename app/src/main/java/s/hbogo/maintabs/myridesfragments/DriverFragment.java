package s.hbogo.maintabs.myridesfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import s.hbogo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DriverFragment extends Fragment {

    public static final String TAG = "DriverFragment";


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
        return inflater.inflate(R.layout.fragment_driver, container, false);
    }

}
