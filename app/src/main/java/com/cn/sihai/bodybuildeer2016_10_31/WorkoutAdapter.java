package com.cn.sihai.bodybuildeer2016_10_31;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import buildWorkOut.WorkOut;

/**
 * Created by vicomte on 01/11/2016.
 */

public class WorkoutAdapter extends ArrayAdapter<WorkOut> {
    public WorkoutAdapter(Context context) {
        super(context, R.layout.item_row);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.item_row, parent, false);

        WorkOut workOut = getItem(position);
        TextView textView7 = (TextView) itemView.findViewById(R.id.textView7);
        TextView textView8 = (TextView) itemView.findViewById(R.id.textView8);
        TextView textView9 = (TextView) itemView.findViewById(R.id.textView9);
        TextView textView10 = (TextView) itemView.findViewById(R.id.textView10);
        TextView textView11 = (TextView) itemView.findViewById(R.id.textView11);
        TextView textView13 = (TextView) itemView.findViewById(R.id.textView13);
        TextView textView14 = (TextView) itemView.findViewById(R.id.textView14);
        TextView textView15 = (TextView) itemView.findViewById(R.id.textView15);

        //assert workOut != null;

        textView8.setText(workOut.getPosition());
        textView9.setText(workOut.getName());
        textView7.setText(Integer.toString(workOut.getGroup()));
        textView10.setText(Integer.toString(workOut.getWeight()));
        textView11.setText(Integer.toString(workOut.getRepeat()));
        textView13.setText("Groupe");
        textView14.setText("Weight");
        textView15.setText("Repeat");

        return itemView;
    }



}
