package com.demo.teppei.appsflyerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.teppei.appsflyerdemo.R;

public class LoginActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public  void LoginButton() {
        username = (EditText)findViewById(R.id.editText_user);
        password = (EditText)findViewById(R.id.editText_password);
        attempts = (TextView)findViewById(R.id.textView_attemt_Count);
        login_btn = (Button)findViewById(R.id.button_login);

        attempts.setText(Integer.toString(attempt_counter));

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("user") &&
                                password.getText().toString().equals("pass")  ) {
                            Toast.makeText(LoginActivity.this,"User and Password is correct",
                                    Toast.LENGTH_SHORT).show();
                            //Intent intent = new Intent("HomeActivity");
                            Intent intent = new Intent("com.demo.teppei.appsflyerdemo.HomeActivity");
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this,"User and Password is not correct",
                                    Toast.LENGTH_SHORT).show();
                            attempt_counter--;
                            attempts.setText(Integer.toString(attempt_counter));
                            if(attempt_counter == 0){
                                login_btn.setEnabled(false);
                            }
                        }

                    }
                }
        );
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_login, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
