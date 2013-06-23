package com.ajb.testapp.fragments;

import org.holoeverywhere.preference.PreferenceFragment;

import android.os.Bundle;

import com.ajb.testapp.R;

public class SettingsFragment extends PreferenceFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}
}
