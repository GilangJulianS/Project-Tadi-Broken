package com.example.tadiproject;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.tadi.fragment.DonateListFragment;
import com.tadi.fragment.FirstLoginFragment;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks, TabListener {

	public static boolean loggedIn;
	public static List<DonateItem> donateItems = new ArrayList<>();
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private ActionBar actionBar;
	private boolean hooh;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		donateItems.add(new DonateItem("Disaster", "Pada hari minggu kuturut ayah ke kota naik delman istimewa", R.drawable.test_asset));
		donateItems.add(new DonateItem("Disaster", "Medium disaster", R.drawable.test_asset));
		donateItems.add(new DonateItem("Disaster", "High disaster", R.drawable.test_asset));
		donateItems.add(new DonateItem("Disaster", "Great disaster", R.drawable.test_asset));
		donateItems.add(new DonateItem("Disaster", "Very Great disaster", R.drawable.test_asset));
		
		actionBar = getSupportActionBar();
		actionBar.addTab(actionBar.newTab().setText("Organizational").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Personal").setTabListener(this));
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));	
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		if(position == 0)
			fragmentManager.beginTransaction()
					.replace(R.id.container, new FirstLoginFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public NavigationDrawerFragment getDrawer(){
		return mNavigationDrawerFragment;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		if(hooh){
			if(tab.getPosition() == 0)
				getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, new DonateListFragment(true)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
			else
				getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, new DonateListFragment(false)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
		}
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void changeMode(boolean tabMode){
		hooh = false;
		if(tabMode)
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		else
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		hooh = true;
	}


}
