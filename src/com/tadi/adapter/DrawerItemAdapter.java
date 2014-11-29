package com.tadi.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tadiproject.MainActivity;
import com.example.tadiproject.R;

public class DrawerItemAdapter extends BaseAdapter {

	private static final int DISABLED_ITEM = 0;
	private static final int LIST_ITEM = 1;
	private List<String> items;
	
	private LayoutInflater inflater;

	public DrawerItemAdapter(Context context) {
		items = new ArrayList<String>();
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void addItem(String item){
		items.add(item);
		notifyDataSetChanged();
	}
	
	@Override
	public int getItemViewType(int position){
		if(position == 0 && MainActivity.loggedIn)
			return DISABLED_ITEM;
		return LIST_ITEM;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		int type = getItemViewType(position);
		System.out.println(type);
		if(convertView == null || position == 0){
			holder = new ViewHolder();
			switch(type){
			case DISABLED_ITEM:
					convertView = inflater.inflate(R.layout.drawer_item_profile, null);
					break;
			case LIST_ITEM:
					convertView = inflater.inflate(R.layout.drawer_item, null);
					holder.textView = (TextView)convertView.findViewById(R.id.text1);
					break;		
			}
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder)convertView.getTag();
		}
		if(position != 0 || !MainActivity.loggedIn)
			holder.textView.setText(items.get(position));
		return convertView;
	}
	
	public static class ViewHolder {
		public TextView textView;
	}

}
