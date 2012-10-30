package com.example.day2;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity {
	Button button;
	Button button2;
	
	EditText username;
	Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
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
				final CharSequence[] items = {"Wandi", "Tedy", "Cius"};
				
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("Pilih");
				builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(context, WelcomeActivity.class);
						intent.putExtra("myUsername", items[which]);
						startActivityForResult(intent, 0);
					}
				});
				
				AlertDialog alertDialog = builder.create();
				alertDialog.show();
			}
		});
        
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setMessage("Sido metu ra dul?")
				.setCancelable(false)
				.setPositiveButton("Iyo", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						MainActivity2.this.finish();
					}
				})
				.setNegativeButton("Ora deng", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				
				AlertDialog alert = builder.create();
				alert.show();
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
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
