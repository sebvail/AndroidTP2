package com.example.snowt.tp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nictamere on 2016-11-05.
 */

public class CustomAdapterInfoEnvoi extends ArrayAdapter<Information> {
    public CustomAdapterInfoEnvoi(Context context, int ressource, ArrayList<Information> infos) {
        super(context, ressource, infos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Information i = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.information_layout, parent, false);
        }
        TextView txtEnvoiInfo = (TextView) convertView.findViewById(R.id.txtEnvoiInfo);
        txtEnvoiInfo.setText(i.info);
        return convertView;
    }
}