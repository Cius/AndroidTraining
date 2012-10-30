package com.example.day2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends Activity implements OnClickListener {
	TextView textView;
	String username;
	Button button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        
        textView = (TextView) findViewById(R.id.tv);
        username = getIntent().getExtras().getString("myUsername");
        
        textView.setText("Welcome, " + username + "!");
        
        button = (Button) findViewById(R.id.buttonBack);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	return false;
    }

	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.buttonBack:
			Intent intent = new Intent();
			intent.putExtra("hasil", username);
			setResult(RESULT_OK, intent);
			
			
			
			finish();
			break;
			default: break;
		}
	}
}
