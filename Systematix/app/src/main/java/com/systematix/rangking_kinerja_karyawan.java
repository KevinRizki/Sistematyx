package com.systematix;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link rangking_kinerja_karyawan.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link rangking_kinerja_karyawan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class rangking_kinerja_karyawan extends Fragment {

    public rangking_kinerja_karyawan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rangking_kinerja_karyawan, container, false);
    }
}
