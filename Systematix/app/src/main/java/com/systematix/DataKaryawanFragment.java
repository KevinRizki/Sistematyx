package com.systematix;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataKaryawanFragment extends Fragment {

    TextView budi, caluh, threasia, galuh, budidarma, darmabakti, sinta, arifin, budisusanto;
    View v;

    public DataKaryawanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_data_karyawan, container, false);
        initViews();
        return v;

    }

    private void initViews() {
        budi = v.findViewById(R.id.budi);
        caluh = v.findViewById(R.id.caluh);
        threasia = v.findViewById(R.id.threasia);
        galuh= v.findViewById(R.id.galuh);
        budidarma = v.findViewById(R.id.budidarma);
        darmabakti = v.findViewById(R.id.darmabakti);
        sinta = v.findViewById(R.id.sinta);
        arifin = v.findViewById(R.id.arifin);
        budisusanto = v.findViewById(R.id.budisusanto);

        budi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Budi");
            }
        });
        budi.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialogLihat("Budi");
                return true;
            }
        });

        caluh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Caluh");
            }
        });

        threasia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Treasia");
            }
        });


        galuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Galuh");
            }
        });
        budidarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Budi Darma");
            }
        });
        sinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Sinta");
            }
        });
        budisusanto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Budi Susanto");
            }
        });
    }

    private void dialogAction(String... params){
        new AlertDialog.Builder(getContext())
                .setMessage("Pilih tindakan untuk: "+params[0])
                .setTitle("Systematix")
                .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Data di edit", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hapus", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Data di hapus", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }


    private void dialogLihat(String... params){
        new AlertDialog.Builder(getContext())
                .setMessage("Lihat data: "+params[0])
                .setTitle("Systematix")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Data di lihat", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }

}
