package com.example.mylogin;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BMain extends AppCompatActivity {
    SwipeRefreshLayout swipeLayout;
    LinearLayout vista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vista = (LinearLayout) findViewById(R.id.info);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_texto);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Snackbar snackbar = Snackbar.make(vista, "blanquito?", Snackbar.LENGTH_SHORT);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "peco", Toast.LENGTH_LONG).show();
                    }
                });
                snackbar.show();
                swipeLayout.setRefreshing(false);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.corazon) {
            Toast toast = Toast.makeText(this, "Te ha gusta esta página", Toast.LENGTH_LONG);
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
