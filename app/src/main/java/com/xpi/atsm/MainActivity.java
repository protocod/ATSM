package com.xpi.atsm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.xpi.atsm.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    public void showLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();

        AccountManager am = AccountManager.get(this); // "this" references the current Context
        Account[] accounts = am.getAccountsByType("com.xpi.atsm");
        if (accounts.length == 0) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {

        }

         /*
         if (!userLogged) {

         }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;
            case R.id.menu_exit:
                moveTaskToBack(true);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
}
