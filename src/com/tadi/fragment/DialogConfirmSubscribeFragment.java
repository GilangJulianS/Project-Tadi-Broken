package com.tadi.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tadiproject.R;

public class DialogConfirmSubscribeFragment extends DialogFragment {

	Dialog dialog;
	
    public DialogConfirmSubscribeFragment() {
    
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	dialog = new Dialog(getActivity());
    	dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm_subscribe);
        
        ImageView yesSubscribeButton = (ImageView)dialog.findViewById(R.id.yesSubscribeButton);
        
        yesSubscribeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Subscribed", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
			}
		});
        
        ImageView noSubscribeButton = (ImageView)dialog.findViewById(R.id.noSubscribeButton);
        
        noSubscribeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
        
        
    	return dialog;
    }
}
