package com.example.listviewdemo;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity4 extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);
        
        TabHost host = getTabHost();
        
        TabHost.TabSpec spec;
        Intent intent;
        intent = new Intent().setClass(this, MainActivity2.class);
        
        spec = host.newTabSpec("Country").setIndicator("Country", getResources().getDrawable(R.drawable.ic_action_search))
        		.setContent(intent);
        host.addTab(spec);
        
        TabHost.TabSpec spec2;
        Intent intent2;
        intent2 = new Intent().setClass(this, MainActivity3.class);
        
        spec2 = host.newTabSpec("CountryImages").setIndicator("Country with Images", getResources().getDrawable(R.drawable.ic_launcher))
        		.setContent(intent2);
        host.addTab(spec2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;        
    }
}
