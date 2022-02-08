package com.example.greborio2;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;



import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView nv = findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(this);

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_container,new ProfileFragment()).commit();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.nav_drawer_op,R.string.nav_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

    switch (menuItem.getItemId()){
        case R.id.nav_message:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MessageFragment()).commit();
            break;
        case R.id.nav_buy:
            //startActivity(new Intent(getApplicationContext(),BuyActivity.class));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new BuyFragment()).commit();
            break;
        case R.id.nav_profile:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProfileFragment()).commit();
            break;
        case R.id.nav_cart:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new CartFragment()).commit();
            break;
        case R.id.nav_payment:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new PaymentFragment()).commit();
            break;
        case R.id.nav_philanthropy:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new PhilanthropyFragment()).commit();
            break;
        case R.id.nav_about_us:
            Toast.makeText(this,"about us",Toast.LENGTH_SHORT).show();
            break;
        case R.id.nav_works:
            Toast.makeText(this,"It works....",Toast.LENGTH_SHORT).show();
            break;
    }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

}
