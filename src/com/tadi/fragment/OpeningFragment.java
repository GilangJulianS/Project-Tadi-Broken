package com.tadi.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tadiproject.MainActivity;
import com.example.tadiproject.R;
import com.viewpagerindicator.CirclePageIndicator;

public class OpeningFragment extends Fragment {

	private ViewPager pager;
	private Button bNext;
	private PagerAdapter adapter;
	private static final int NUM_PAGES = 4;
	private CirclePageIndicator titleIndicator;
	private ActionBarDrawerToggle toggle;
	private MainActivity main;
	
	public OpeningFragment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_opening, container,
				false);
		
		titleIndicator  = (CirclePageIndicator)rootView.findViewById(R.id.titles);
		pager = (ViewPager)rootView.findViewById(R.id.pager);
		adapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
		pager.setAdapter(adapter);
		titleIndicator.setViewPager(pager);
		bNext = (Button) rootView.findViewById(R.id.button1);
		bNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, new DonateListFragment(true)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
			}
		});
		return rootView;
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		main = (MainActivity) activity;
	}
	
	@Override
	public void onDetach(){
		super.onDetach();
		main.getSupportActionBar().show();
	}
	
	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	SlideImageFragment fragment = new SlideImageFragment();
            switch(position){
            case 0: fragment.setImage(R.drawable.lapangan1);
            		break;
            case 1: fragment.setImage(R.drawable.lapangan2);
    				break;
            case 2: fragment.setImage(R.drawable.lapangan3);
					break;
            case 3: fragment.setImage(R.drawable.lapangan4);
					break;
            }
            return fragment;
        	
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
