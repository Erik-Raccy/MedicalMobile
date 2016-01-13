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

public class PatientList extends ListActivity implements OnClickListener {

	Vector<String> userNames = new Vector<String>();
	Vector<String> patientNames = new Vector<String>();
	Vector<String> userTypes = new Vector<String>();
	String[] indexFind;

	final ArrayList<String> displayList = new ArrayList<String>();

	// List view Adapter
	private ArrayAdapter<String> adapter;
	private ListView lv;
	private EditText inputFilter;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_list);
		
		lv = getListView(); // get the type of view
		inputFilter = (EditText) findViewById(R.id.input_filter);

		MedicalDatabase staffInfo = new MedicalDatabase(this);
		staffInfo.open();
		
		userNames = staffInfo.readUserColumn("users_name");
		userTypes = staffInfo.readUserColumn("users_type");
		staffInfo.close();
		
		for (int i = 0; i < userNames.size(); i++) {
			if (userTypes.get(i).equals("Patient")) {
				patientNames.add(userNames.get(i));
			}
		}
		
		final String[] staff_list = new String[patientNames.size()];

		for (int i = 0; i < patientNames.size(); i++) {
			staff_list[i] = patientNames.get(i);
		}

		displayList.addAll(Arrays.asList(staff_list));
		adapter = new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.product_name, staff_list);
		this.setListAdapter(adapter);

		indexFind = userNames.toArray(new String[0]); // Takes the elements in
		// the Vector String and
		// populates it into a
		// STring array for
		// comparing which
		// element was pressed

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
				PatientList.this.adapter.getFilter().filter(cs);

			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}
		});

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapter, View lv, int i,
					long l) {

				String inputted_name = (((TextView) lv).getText().toString());

				int index = findIndexValue(indexFind, inputted_name);

				String output = indexFind[index];

				Toast.makeText(getApplicationContext(), output + "'s profile",
						Toast.LENGTH_SHORT).show();
				
				Intent toProfile = new Intent(getApplicationContext(),
						Profile.class);
				// we need to pass name to profile class in order to get the
				// right profile
				toProfile.putExtra("typeSend", "Patient");
				toProfile.putExtra("nameSend", output);
				startActivity(toProfile);

			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	public int findIndexValue(String[] array, String value) {
		int i;
		for (i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				return i;
			}

		}
		return 0;
	}

}
