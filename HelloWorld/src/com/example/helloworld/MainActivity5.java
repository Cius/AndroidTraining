package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends Activity {
	Button button;
	EditText username;
	Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5);
        
        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText("Username: ");
        
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		textView2.setText("Password:  ");

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setText("Cancel");
        
        button = (Button) findViewById(R.id.button1);
        button.setText("Login");
        
        username = (EditText) findViewById(R.id.editText1);
        
        context = this;
        
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(context, WelcomeActivity.class);
				intent.putExtra("myUsername", username.getText().toString());
				startActivityForResult(intent, 0);
			}
		});
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	switch(requestCode) {
    	case 0: 
    		if(resultCode == RESULT_OK) {
    			button.setText(data.getExtras().getString("hasil"));
    			Toast.makeText(this, "Lalala,  Ok", Toast.LENGTH_LONG).show();
    		}else {
    			Toast.makeText(this, "Canceled", Toast.LENGTH_LONG).show();
    		}
    	default: break;
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_activity5, menu);
        return true;
    }
}
