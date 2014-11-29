package com.tadi.adapter;

import java.util.List;

import com.example.tadiproject.DonateItem;
import com.example.tadiproject.R;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DonateListItemAdapter extends BaseAdapter {
	
	LayoutInflater inflater;
	FragmentManager fragmentManager;
	List<DonateItem> donateItems;
	
	public DonateListItemAdapter(Context context, List<DonateItem> donateItems) {
		fragmentManager = ((ActionBarActivity)context).getSupportFragmentManager();
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.donateItems = donateItems;
	}

	@Override
	public int getCount() {
		return donateItems.size();
	}

	@Override
	public Object getItem(int position) {
		return donateItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.donate_list_item, parent, false);
			ImageView donateImage = (ImageView)convertView.findViewById(R.id.listItemDonateImage);
			TextView donateTitle = (TextView)convertView.findViewById(R.id.listItemDonateTitle);
			TextView donateDescription = (TextView)convertView.findViewById(R.id.listItemDonateDescirption);
			
			donateImage.setImageResource(donateItems.get(position).getDonateImage());
			donateTitle.setText(donateItems.get(position).getTitle());
			
			if(donateItems.get(position).getDescription().length() > 36){
				donateDescription.setText(donateItems.get(position).getDescription().substring(0, 35) + "...");
			}
			else{
				donateDescription.setText(donateItems.get(position).getDescription());
			}
		}
		
		return convertView;
	}

}
