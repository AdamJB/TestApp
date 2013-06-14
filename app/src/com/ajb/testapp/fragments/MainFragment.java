package com.ajb.testapp.fragments;

import org.holoeverywhere.LayoutInflater;
import org.holoeverywhere.app.Fragment;

import com.ajb.testapp.R;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {
	
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
	
}
