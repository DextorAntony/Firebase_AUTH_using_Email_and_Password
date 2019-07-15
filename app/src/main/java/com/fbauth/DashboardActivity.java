package com.fbauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {
//FirebaseAuth mAuth;
ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        cl = findViewById(R.id.cl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId())
       {
           case R.id.signout:
               so();
               break;

           case R.id.ch:
               Intent i = new Intent(getApplicationContext(),ChangeEmail.class);
               startActivity(i);
               break;
               case R.id.cp:
               Intent o = new Intent(getApplicationContext(),Changepassword.class);
               startActivity(o);


        }
        return super.onOptionsItemSelected(item);
    }
    public void so(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);//makesure user cant go back
        startActivity(intent);



    }

    @Override
    public void onBackPressed() {
        finish();
        finishAffinity();
        super.onBackPressed();
    }
}
