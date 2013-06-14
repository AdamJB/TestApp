package com.ajb.testapp.fragments;

import android.os.Bundle;
import org.holoeverywhere.preference.PreferenceFragment;

import com.ajb.testapp.R;

public class SettingsFragment extends PreferenceFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}
}
