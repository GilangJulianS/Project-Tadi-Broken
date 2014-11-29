package com.tadi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tadiproject.R;

public class FinishDonateFragment extends Fragment {

	public FinishDonateFragment() {
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_donate_ending, container, false);
		
		ImageView finishButton = (ImageView)rootView.findViewById(R.id.finishButton);
		ImageView shareButton = (ImageView)rootView.findViewById(R.id.shareButton);
		
		finishButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager fm = getActivity().getSupportFragmentManager();
				fm.beginTransaction().replace(R.id.container, new DonateListFragment(true)).commit();
			}
		});
		
		shareButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			}
		});
		
		return rootView;
	}
}
