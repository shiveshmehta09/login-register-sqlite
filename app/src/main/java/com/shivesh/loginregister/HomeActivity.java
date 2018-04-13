package com.shivesh.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shivesh.loginregister.activities.UsersListActivity;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    NavigationView mNavigationView;
    TextView tv_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, UsersListActivity.class);
                i.putExtra("EMAIL",getIntent().getStringExtra("EMAIL"));
                startActivity(i);
            }
        });

*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = findViewById(R.id.nav_view);

        View header=mNavigationView.getHeaderView(0);
        tv_email= header.findViewById(R.id.textV_email);
        tv_email.setText(getIntent().getStringExtra("EMAIL"));

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

     public void meclick(View v)
    {
        if(v.getId()==R.id.img_btn_one) {
            Intent i = new Intent(getApplicationContext(),UsersListActivity.class);
            Toast.makeText(this, "You Clicked On DATA INFO", Toast.LENGTH_SHORT).show();
            startActivity(i);
        }

        if(v.getId()==R.id.img_btn_two) {
            Toast.makeText(this, "You Clicked On RESUME", Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.img_btn_three) {
            Toast.makeText(this, "You Clicked On APTITUDE", Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.img_btn_four) {
            Toast.makeText(this, "You Clicked On C++", Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.img_btn_five) {
            Toast.makeText(this, "You Clicked On VALUE TAG", Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.img_btn_six) {
            Toast.makeText(this, "You Clicked On FIND CENTER", Toast.LENGTH_SHORT).show();
        }
    }
}
