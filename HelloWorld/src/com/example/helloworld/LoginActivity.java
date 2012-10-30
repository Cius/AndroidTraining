package com.example.helloworld;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity implements OnClickListener {

	private EditText username;
	private EditText pass;
	
	public void setUsernamePass(EditText user, EditText pass) {
		username = user;
		this.pass = pass;
	}
	
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.button1:
			Toast.makeText(v.getContext(), pass.getText().toString(), Toast.LENGTH_SHORT).show();
			break;
		case R.id.button2:
			Toast.makeText(v.getContext(), username.getText().toString(), Toast.LENGTH_LONG).show();
			break;
		default: break;
		}
	} 
}
