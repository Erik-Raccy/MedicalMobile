package com.se3a04.medicalmobile;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LinkStaff extends ListActivity {
	
	private String [] selectedStaff = {"",""};
	// List view Adapter
	private ArrayAdapter<String> adapter;
	private ListView lv;
	private String[] staff = new String[] { "Bob",
			"Bobbette", "Bobby", "Bobbelyn", "Bobbosa" };
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_list);

		lv = getListView(); // get the type of view

		final ArrayList<String> staff_lst = new ArrayList<String>(); // create an
		staff_lst.addAll(Arrays.asList(staff));
		adapter = new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.product_name, staff_lst);
		this.setListAdapter(adapter);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapter, View lv, int i, long l){
				//if the first one is not blank.
				if(!selectedStaff[0].equals("")&!(selectedStaff[0].equals(staff[i])))
				{
					//if second member isn't selected, fill second selection
					if (selectedStaff[1].equals(""))
					{
				Toast.makeText(getApplicationContext(),staff[i]+ " is selected",
						Toast.LENGTH_SHORT).show();
				//saves staff
				selectedStaff[1]=staff[i];
				
					}
					//if selected  staff is selected, unselect staff
					else if(selectedStaff[1].equals(staff[i]))
					{
						Toast.makeText(getApplicationContext(),staff[i]+ " is unselected",
								Toast.LENGTH_SHORT).show();
						selectedStaff[1]="";
					}
					else//if second member is chosen and
						//new member is chosen tell user 2 selections already made
					{
						Toast.makeText(getApplicationContext(),"2 staff members already selected. Unselect one",
								Toast.LENGTH_SHORT).show();
					}
				
				}//if selected staff is selected
				else if(selectedStaff[0].equals(staff[i]))
						{
					Toast.makeText(getApplicationContext(),staff[i]+ " is unselected",
							Toast.LENGTH_SHORT).show();
					
					selectedStaff[0]="";
						}
				else
				{
					Toast.makeText(getApplicationContext(),staff[i]+ " is selected",
							Toast.LENGTH_SHORT).show();
					//saves staff
					selectedStaff[0]=staff[i];
				}
				
			//add shit about the confirm button here
				//intent blah blah blah
			
			}
		});
	}
	

	
}
