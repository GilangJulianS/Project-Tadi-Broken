package com.tadi.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tadiproject.MainActivity;
import com.example.tadiproject.R;

public class FirstLoginFragment extends Fragment {

	private EditText tEmail;
	private EditText tPassword;
	private Button bLogin;
	private ImageView bFacebook;
	private TextView bSkip;
	private MainActivity main;
	
	public FirstLoginFragment() {
		
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_first_login, container, false);
		tEmail = (EditText) view.findViewById(R.id.editText1);
		tPassword = (EditText) view.findViewById(R.id.editText2);
		bLogin = (Button) view.findViewById(R.id.button1);
		bLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(tEmail.getText().toString().equals("dummy") && tPassword.getText().toString().equals("dummy"))
					login();
			}
		});
		bFacebook = (ImageView) view.findViewById(R.id.imageView3);
		bSkip = (TextView) view.findViewById(R.id.textView2);
		bSkip.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((ActionBarActivity)getActivity()).getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, new OpeningFragment()).commit();
			}
		});
		return view;
	}
	
	public void login(){
		MainActivity.loggedIn = true;
		((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, new DonateListFragment(true)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		main = (MainActivity) activity;
		main.getSupportActionBar().hide();
	}

}
