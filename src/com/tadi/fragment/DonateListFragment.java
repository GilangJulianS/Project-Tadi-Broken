package com.tadi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.tadiproject.R;

public class DonateListFragment extends Fragment {

	public DonateListFragment() {
		
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.donate_list, container, false);
		
		ListView donateList = (ListView)getActivity().findViewById(R.id.listDonate);
		
		donateList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				
//				fragment = new ;
//				fragmentTransaction.replace(R.id.containerMain, fragment, MainActivity.SUB_FRAGMENT_1);
//				Fragment detSessionFragment = new DetailSessionFragment(position, listData.get(position));
//				fragmentTransaction.replace(R.id.containerDetail, detSessionFragment, MainActivity.SUB_FRAGMENT_2);
//				fragmentTransaction.commit();
			}
			
		});
		
		
		return rootView;
	}

}
