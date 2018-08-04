package com.systematix;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences.Editor editor;
    SharedPreferences prefs;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(ContextCompat.getColor(DashboardActivity.this, R.color.yellow));
        editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
        prefs = getSharedPreferences("Login", MODE_PRIVATE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActivityUtils.addFragment(this, R.id.container, new HomeFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                if (findViewById(R.id.container) == null) {
                    ActivityUtils.addFragment(this, R.id.container, new HomeFragment());
                } else {
                    ActivityUtils.replaceFragment(this, R.id.container, new HomeFragment());
                }
                break;
            case R.id.nav_instrumen:
                if (findViewById(R.id.container) == null) {
                    ActivityUtils.addFragment(this, R.id.container, new InstrumenFragment());
                } else {
                    ActivityUtils.replaceFragment(this, R.id.container, new InstrumenFragment());
                }
                break;

            case R.id.nav_pegawai:
                if (findViewById(R.id.container) == null) {
                    ActivityUtils.addFragment(this, R.id.container, new InputKaryawanFragment());
                } else {
                    ActivityUtils.replaceFragment(this, R.id.container, new InputKaryawanFragment());
                }
                break;

            case R.id.nav_survey:
                break;

            case R.id.nav_hasil:
                if (findViewById(R.id.container) == null) {
                    ActivityUtils.addFragment(this, R.id.container, new HasilPenilaian());
                } else {
                    ActivityUtils.replaceFragment(this, R.id.container, new HasilPenilaian());
                }
                break;
//               Intent i = new Intent(DashboardActivity.this, activity_penilaian_kinerja.class);
//               startActivity(i);
//               this.finish();

            case R.id.nav_keluar:
                new AlertDialog.Builder(DashboardActivity.this)
                        .setMessage("Keluar aplikasi?")
                        .setTitle("Systematix")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editor.clear();
                                editor.apply();
                                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
