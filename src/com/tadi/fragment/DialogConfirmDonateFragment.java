package com.tadi.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tadiproject.R;

public class DialogConfirmDonateFragment extends DialogFragment {

	String textConfirm;
	Dialog dialog;
	
	public DialogConfirmDonateFragment(String textConfirm) {
		this.textConfirm = textConfirm;
	}
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	dialog = new Dialog(getActivity());
    	dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm_donate);
        
        TextView confirmText = (TextView)dialog.findViewById(R.id.confirmText);
        ImageView yesDonateButton = (ImageView)dialog.findViewById(R.id.yesDonateButton);
        ImageView noDonateButton = (ImageView)dialog.findViewById(R.id.noDonateButton);
        
        confirmText.setText(textConfirm);
        
        yesDonateButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Terima kasih telah menyumbang", Toast.LENGTH_SHORT).show();
				FragmentManager fm = getActivity().getSupportFragmentManager();
				dialog.dismiss();
				fm.beginTransaction().replace(R.id.container, new FinishDonateFragment()).commit();
			}
		});
        
        noDonateButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
        
    	return dialog;
    }
	
	

}
