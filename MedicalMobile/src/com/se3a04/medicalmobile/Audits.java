package com.se3a04.medicalmobile;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Audits extends ListActivity {

	private EditText inputFilter;

	// List view Adapter
	private ArrayAdapter<String> adapter;
	private String[] audits = new String[] { "audit january", "audit febuary",
			"audit march", "audit april" };

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_list);

		inputFilter = (EditText) findViewById(R.id.input_filter);

		getListView();

		final ArrayList<String> audits_lst = new ArrayList<String>(); // create
																		// an
		audits_lst.addAll(Arrays.asList(audits));
		adapter = new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.product_name, audits_lst);
		this.setListAdapter(adapter);

		for (int i = 0; i < adapter.getCount(); i++) {
			System.out.println(adapter.getItem(i));
		}

		/**
		 * Enabling Search Filter
		 * */
		inputFilter.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence cs, int arg1, int arg2,
					int arg3) {

				// When user changed the Text
				Audits.this.adapter.getFilter().filter(cs);

			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

}
