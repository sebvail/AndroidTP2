package com.example.snowt.tp2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nicta on 2016-11-10.
 */

public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    View rootView;
    Bitmap bmp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final ArrayList<Information> listeEnvoi = new ArrayList<>();
        listeEnvoi.add(new Information("info1"));
        listeEnvoi.add(new Information("info2"));
        listeEnvoi.add(new Information("info3"));
        listeEnvoi.add(new Information("info4"));
        listeEnvoi.add(new Information("info5"));
        switch (getArguments().getInt(ARG_SECTION_NUMBER)){
            case 1: {
                rootView = inflater.inflate(R.layout.activity_scan, container, false);


                break;
            }
            case 2: {
                rootView = inflater.inflate(R.layout.envoi_layout,container, false);
                (rootView.findViewById(R.id.btnEnvoyerInfo)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bmp = QREncoder.encodeAsBitmap(rootView.findViewById(R.id.editAjouterEnvoi).toString());
                        ImageView iv = (ImageView)rootView.findViewById(R.id.imageView);
                        iv.setImageBitmap(bmp);

                    }
                });
                (rootView.findViewById(R.id.btnAjouterEnvoi)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText txt = (EditText)rootView.findViewById(R.id.editAjouterEnvoi);
                        String text = txt.getText().toString();
                        listeEnvoi.add(new Information(text));
                        ListView lv = (ListView)rootView.findViewById(R.id.lv_envoi);
                        CustomAdapterInfoEnvoi adapter = new CustomAdapterInfoEnvoi(getActivity().getBaseContext(),R.layout.envoi_layout,listeEnvoi);
                        lv.setAdapter(adapter);
                    }
                });
                (rootView.findViewById(R.id.btnSupprimerInfo)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((MainActivity)getActivity()).retirerListe(rootView.findViewById(R.id.txtEnvoiInfo).toString());
                    }
                });
                break;
            }
            case 3: {
                rootView = inflater.inflate(R.layout.recu_layout,container,false);
                break;
            }
        }


        return rootView;
    }
}