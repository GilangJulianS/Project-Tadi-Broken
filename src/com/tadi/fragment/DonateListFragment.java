package com.tadi.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.tadiproject.MainActivity;
import com.example.tadiproject.R;
import com.tadi.adapter.DonateListItemAdapter;

public class DonateListFragment extends Fragment {

	private MainActivity main;
	private boolean organization;
	
	public DonateListFragment(boolean isOrganization) {
		organization = isOrganization;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_donate_list, container, false);
		
		ListView donateList = (ListView)rootView.findViewById(R.id.listDonate);
		
		
		DonateListItemAdapter adapter = new DonateListItemAdapter(getActivity(), MainActivity.donateItems);
		
		donateList.setAdapter(adapter);
		
		donateList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				DetailDonateFragment.position = position;
				FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				fragmentManager.beginTransaction().replace(R.id.container, new DetailDonateFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
			}
			
		});
		
		return rootView;
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		main = (MainActivity) activity;
		main.changeMode(true);
	}
	
	@Override
	public void onPause(){
		super.onPause();
		main.changeMode(false);
	}
	
	

}
