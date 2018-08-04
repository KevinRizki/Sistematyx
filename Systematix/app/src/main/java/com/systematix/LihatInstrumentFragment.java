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
public class LihatInstrumentFragment extends Fragment {

    TextView txtTanggap, txtSopan, txtRajin, txtTeliti, txtBekerja;
    View v;

    public LihatInstrumentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_lihat_instrument, container, false);
        initViews();
        return v;
    }

    private void initViews(){
        txtTanggap = v.findViewById(R.id.txtTanggap);
        txtSopan = v.findViewById(R.id.txtSopan);
        txtRajin = v.findViewById(R.id.txtRajin);
        txtTeliti= v.findViewById(R.id.txtTeliti);
        txtBekerja = v.findViewById(R.id.txtBekerja);

        txtTanggap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Tanggap");
            }
        });

        txtSopan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Sopan");
            }
        });

        txtRajin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Rajin");
            }
        });


        txtTeliti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Teliti");
            }
        });
        txtBekerja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAction("Bekerja Keras");
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

}
