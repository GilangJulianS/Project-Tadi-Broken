package com.tadi.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.tadiproject.DonateItem;
import com.example.tadiproject.MainActivity;
import com.example.tadiproject.R;
import com.tadi.adapter.DonateListItemAdapter;

public class DonateListFragment extends Fragment {

	public DonateListFragment() {
		
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
				fragmentManager.beginTransaction().replace(R.id.container, new DetailDonateFragment()).commit();
			}
			
		});
		
		
		return rootView;
	}

}
