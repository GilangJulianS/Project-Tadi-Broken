package com.tadi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.tadiproject.R;

public class DonateAmountFragment extends Fragment {

	String choosenPayment;
	EditText countPayment;
	boolean radioChecked;
	
	public DonateAmountFragment() {
		radioChecked = false;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_donate_amount, container, false);
		
		ImageView button500 = (ImageView)rootView.findViewById(R.id.donate500);
		ImageView button1k = (ImageView)rootView.findViewById(R.id.donate1k);
		ImageView button5k = (ImageView)rootView.findViewById(R.id.donate5k);
		ImageView finalButtonDonate = (ImageView)rootView.findViewById(R.id.finalDonateButton);
		RadioButton tmoneyButton = (RadioButton)rootView.findViewById(R.id.tmoneyButton);
		RadioButton pulsaButton = (RadioButton)rootView.findViewById(R.id.pulsaButton);
		countPayment = (EditText)rootView.findViewById(R.id.countPayment);
		
		tmoneyButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					choosenPayment = "T-Money";
				}
				radioChecked = true;
			}
		});
		
		pulsaButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					choosenPayment = "Pulsa";
				}
				radioChecked = true;
			}
		});
		
		button500.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!radioChecked){
					Toast.makeText(getActivity(), "Silahkan Pilih cara payment terlebih dahulu", Toast.LENGTH_SHORT).show();
				}
				else new DialogConfirmDonateFragment("Apakah kamu yakin untuk mendonasi sebesar Rp 500,- dengan menggunakan " + 
						choosenPayment + " anda?").show(getFragmentManager(), "MyDialog");
			}
		});
		
		button1k.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!radioChecked){
					Toast.makeText(getActivity(), "Silahkan Pilih cara payment terlebih dahulu", Toast.LENGTH_SHORT).show();
				}
				else new DialogConfirmDonateFragment("Apakah kamu yakin untuk mendonasi sebesar Rp 1000,- dengan menggunakan " + 
						choosenPayment + "?").show(getFragmentManager(), "MyDialog");
			}
		});
		
		button5k.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!radioChecked){
					Toast.makeText(getActivity(), "Silahkan Pilih cara payment terlebih dahulu", Toast.LENGTH_SHORT).show();
				}
				else new DialogConfirmDonateFragment("Apakah kamu yakin untuk mendonasi sebesar Rp 5000,- dengan menggunakan " + 
						choosenPayment + "?").show(getFragmentManager(), "MyDialog");
			}
		});
		
		finalButtonDonate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!radioChecked){
					Toast.makeText(getActivity(), "Silahkan Pilih cara payment terlebih dahulu", Toast.LENGTH_SHORT).show();
				}
				else new DialogConfirmDonateFragment("Apakah kamu yakin untuk mendonasi sebesar Rp"+ 
						countPayment.getText()  +",- dengan menggunakan " + 
						choosenPayment + "?").show(getFragmentManager(), "MyDialog");
			}
		});
		return rootView;
	}

}
