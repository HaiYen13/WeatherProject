package com.devpro.weatherapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {
    private ListView mLvData;
    private HistoryAdapter mAdapter;
    private ArrayList<String> mListString;


    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        mLvData = v.findViewById(R.id.lvHistory);
        setDataForListString();
        mAdapter = new HistoryAdapter(mListString, getActivity());
        mLvData.setAdapter(mAdapter);
        return v;
    }

    private void setDataForListString() {
        mListString = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mListString.add("Lich su thu: " + String.valueOf(i));
        }
    }
}
