package com.systematix;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class InstrumenFragment extends Fragment {

    Button btnSimpan, btnLihat;
    View v;

    public InstrumenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_instrumen, container, false);
        initViews();
        return v;
    }

    private void initViews() {
        btnSimpan = v.findViewById(R.id.btnSimpan);
        btnLihat = v.findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.replaceFragment(getActivity(), R.id.container, new LihatInstrumentFragment());
            }
        });
    }

}
