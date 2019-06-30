package com.devpro.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {

    private ArrayList<String> mListString;
    private Context mContext;
    private LayoutInflater mLayoutInflator;
    public HistoryAdapter(
            ArrayList<String> listString,
            Context context) {
        this.mListString = listString;
        this.mContext = context;
        mLayoutInflator = (LayoutInflater)
                context.getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mListString.size();
    }

    @Override
    public Object getItem(int i) {
        return mListString.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = mLayoutInflator.inflate(R.layout.history_item, null);
        }
        TextView tvDisplay = view.findViewById(R.id.tvDisplay);
        tvDisplay.setText(mListString.get(i));
        return view;
    }

}
