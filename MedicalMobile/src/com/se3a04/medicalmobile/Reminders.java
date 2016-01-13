package com.se3a04.medicalmobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import android.app.ListActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Reminders extends ListActivity{
	
	private ArrayAdapter<String> adapter;
	private ListView lv;
	private String[] reminders = new String[] { "rem 1",
			"rem 2", "rem 3"};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_list);
		
		MedicalDatabase database = new MedicalDatabase(this);
		database.open();
		//get reminders
		database.close();
		
		lv = getListView(); // get the type of view

		final ArrayList<String> reminders_lst = new ArrayList<String>(); // create an
		reminders_lst.addAll(Arrays.asList(reminders));
		adapter = new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.product_name, reminders_lst);
		this.setListAdapter(adapter);
		
	}
	
}
