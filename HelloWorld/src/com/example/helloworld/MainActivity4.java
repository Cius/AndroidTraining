package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends Activity {
	private EditText username;
	private EditText pass;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main4);

		TextView textView = (TextView) findViewById(R.id.textView1);
		textView.setText("Username: ");

		TextView textView2 = (TextView) findViewById(R.id.textView2);
		textView2.setText("Password:  ");

		LoginActivity listener = new LoginActivity();

		username = (EditText) findViewById(R.id.editText1);
		pass = (EditText) findViewById(R.id.editText2);
		listener.setUsernamePass(username, pass);

		Button button = (Button) findViewById(R.id.button1);
		button.setText("Login");
		
		button.setOnClickListener(listener);

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setText("Cancel");

		button2.setOnClickListener(listener);
	}

//	public void login() {
//		Toast.makeText(this, pass.getText().toString(), Toast.LENGTH_LONG).show();
//	}
//
//	public void cancel() {
//		Toast.makeText(this, username.getText().toString(), Toast.LENGTH_LONG).show();
//	}
}
