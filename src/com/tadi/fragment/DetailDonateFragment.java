package com.tadi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tadiproject.MainActivity;
import com.example.tadiproject.R;

public class DetailDonateFragment extends Fragment {
	
	public static int position;

	public DetailDonateFragment() {
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_detail_donate, container, false);
		
		ImageView donateLogo = (ImageView)rootView.findViewById(R.id.detailDonateLogo);
		TextView donateTitle = (TextView)rootView.findViewById(R.id.detailDonateTitle);
		TextView donateDescription = (TextView)rootView.findViewById(R.id.detailDonateDescription);
		
		donateLogo.setImageResource(MainActivity.donateItems.get(position).getDonateImage());
		donateTitle.setText(MainActivity.donateItems.get(position).getTitle());
		donateDescription.setText(MainActivity.donateItems.get(position).getDescription());
		
		ImageView subscribeButton = (ImageView)rootView.findViewById(R.id.subscribeButton);
		subscribeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new DialogConfirmSubscribeFragment().show(getFragmentManager(), "");
			}
		});
		
		ImageView donateButton = (ImageView)rootView.findViewById(R.id.donateButton);
		donateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getActivity().getSupportFragmentManager();
				fm.beginTransaction().replace(R.id.container, new DonateAmountFragment()).commit();
			}
		});
		
		return rootView;
		
	}
		
}
