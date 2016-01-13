package com.se3a04.medicalmobile;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Vector;

public class LogIn extends Activity {

	boolean loggedin = false;

	Button sign_in, changer, sign_out, main_menu;
	public EditText username, password;
	public TextView whoisit;
	private String deciding_type;
	private String display_name;
	public static String table[] = null;
	
	public static MedicalDatabase database;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * This does not hold out for too long atm. need to fix
		 */
		if (loggedin == false) {
			setContentView(R.layout.activity_log_in);
			SignInListener();
		} else {
			setContentView(R.layout.log_in_signed);
			SignOutListener();
		}
		this.database = new MedicalDatabase(this);
		database.open();
			if (database.readUserColumn("users_name").isEmpty()){
				database.addUser("Sean", "Admin", "", "Admin","20","200","50","120","80","9001","999-999-9999","23/4/93", "90 Somewhere Lane");
				database.addUser("Graeme", "Doctor", "", "Doctor","6","500","300","90","40","6","711-222-5678","11/2/96", "91 Somewhere Lane");
				database.addUser("TK", "Nurse", "", "Nurse","8","70","501","90","40","6","711-225-5678","02/11/13", "92 Somewhere Lane");
				database.addUser("Jim", "Secretary", "", "Secretary","6","500","300","90","40","6","Who you gonna call? GHOST BUSTERS","9/20/93", "P. Sherman 42 Wallaby Way, Sydney");
				database.addUser("Erik", "Patient", "", "Patient1","6","50","300","90","50","6","711-222-5678","11/2/96", "91 Somewhere Lane");
				database.addUser("Lara", "Patient", "", "Patient2","6","500","300","90","40","6","711-222-5678","11/2/96", "91 Somewhere Lane");
			}
		database.close();
	}

	public void SignInListener() {

		sign_in = (Button) findViewById(R.id.sign_in_button);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);

		final LogIn self = this;
		 
		sign_in.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				self.database.open();
				Vector<String> usernames = self.database.readUserColumn("username");
				Vector<String> passwords = self.database.readUserColumn("password");
				Vector<String> usertypes = self.database.readUserColumn("users_type");
				Vector<String> user_names = self.database.readUserColumn("users_name");
				self.database.close();
				for(int i=0; i<usernames.size();i++){
					if(usernames.get(i).equals(username.getText().toString())){
						if(passwords.get(i).equals(password.getText().toString())){
							loggedin = true;
							deciding_type = usertypes.get(i);
							display_name = user_names.get(i);
							Intent menuActivity = new Intent(
							getApplicationContext(), MainMenu.class);

							menuActivity.putExtra("typeSend", deciding_type);
							menuActivity.putExtra("nameSend", display_name);
							startActivity(menuActivity);
		
							if (loggedin == true) {
								setContentView(R.layout.log_in_signed);
								SignOutListener();
							}
		
							whoisit = (TextView) findViewById(R.id.user_display);
							whoisit.setText(deciding_type);
						}
					}
				}
				if (loggedin == false) {
					Toast.makeText(
							getApplicationContext(),
							"Your password seems to be incorrect. Please try again...",
							Toast.LENGTH_SHORT).show();
				}
			}

		});

	}

	public void SignOutListener() {
		sign_out = (Button) findViewById(R.id.Sign_out_from_log_in);
		main_menu= (Button) findViewById(R.id.return_menu);
		
		sign_out.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				loggedin=false;
				
				Toast.makeText(
						getApplicationContext(),
						"You have been successfully logged out",
						Toast.LENGTH_SHORT).show();
			
				setContentView(R.layout.activity_log_in);
				SignInListener();
			}
		});
		
		main_menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent menuActivity = new Intent(
						getApplicationContext(), MainMenu.class);

				menuActivity.putExtra("typeSend", deciding_type);
				menuActivity.putExtra("nameSend", display_name);
				
				startActivity(menuActivity);
			}
			
			});
		
			}
	}

