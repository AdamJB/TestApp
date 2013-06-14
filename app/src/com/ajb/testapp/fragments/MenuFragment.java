package com.ajb.testapp.fragments;

import org.holoeverywhere.LayoutInflater;
import org.holoeverywhere.app.ListFragment;

import com.ajb.testapp.R;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MenuFragment extends ListFragment{
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu, container, false);
    }
}
