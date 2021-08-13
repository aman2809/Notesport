package com.example.notesport;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser fUser = mAuth.getCurrentUser();

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            {
            super.onBackPressed();
        }
    }
    Fragment fragment;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                fragment= new HomeFragment();
                break;
            case R.id.Item2:
                break;
            case R.id.Item3:
                break;
            case R.id.Item4:
                break;
            case R.id.nav_login:
                break;
            case R.id.nav_profile:
                fragment= new ProfileFragment();
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                FirebaseUser fUser = mAuth.getCurrentUser();
                if(fUser != null){
                    Toast.makeText(HomeActivity.this,"Logout Unsuccessfully!!!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent homeIntent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_rate:
                break;
            default:
                break;
        }
       // getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}