package com.tadi.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class LoginFragment extends Fragment {

	private EditText tEmail;
	private EditText tPassword;
	private Button bLogin;
	private ImageView bFacebook;
	private TextView bSkip;
	private MainActivity main;
	
	public LoginFragment() {
		
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_login, container, false);
		tEmail = (EditText) view.findViewById(R.id.editText1);
		tPassword = (EditText) view.findViewById(R.id.editText2);
		bLogin = (Button) view.findViewById(R.id.button1);
		bFacebook = (ImageView) view.findViewById(R.id.imageView2);
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
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		main = (MainActivity) activity;
		main.getSupportActionBar().hide();
	}
	
	@Override
	public void onDetach(){
		super.onDetach();
		main.getSupportActionBar().show();
	}

}
