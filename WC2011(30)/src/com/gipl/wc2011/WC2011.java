package com.gipl.wc2011;



import com.gipl.wc2011.datamanager.DataManager;
import com.gipl.wc2011.datamanager.StaticDataStorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WC2011 extends Activity {
    /** Called when the activity is first created. */
	Button btn1,btn2;
	DataManager dataManager = new DataManager(this);
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        verifyAndFillData();
        setContentView(R.layout.main);
        btn1 = (Button) findViewById(R.id.btnEnter);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showNextActivity();
			}
        });
		
        btn2 =(Button)findViewById(R.id.btnExit);
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
    }
    public void showNextActivity()
    {	startActivity(new Intent(this,Homescreen.class));
    }
    
    private void verifyAndFillData()
    {
    	if(dataManager.tournamentData.getTournament() == null)
    	{
    		new StaticDataStorage(this);
    	}
    }
    
    
    
    
}