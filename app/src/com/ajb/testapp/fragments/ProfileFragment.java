package com.ajb.testapp.fragments;

import org.holoeverywhere.LayoutInflater;
import org.holoeverywhere.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajb.testapp.R;

public class ProfileFragment extends Fragment {
	TextView firstNameTextView, lastNameTextView;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.profile);

		firstNameTextView = (TextView) view
				.findViewById(R.id.firstNameTextView);
		lastNameTextView = (TextView) view.findViewById(R.id.lastNameTextView);

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		firstNameTextView.setText("Daenerys");
		lastNameTextView.setText("Targaryen");
	}
}
