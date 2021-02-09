package com.example.declinator;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private EditText palabra;
    private RadioButton generoF, generoM, generoN, animadoS, animadoN;
    private RadioGroup esAnimado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        palabra = (EditText)findViewById(R.id.et_palabra);
        generoF = (RadioButton)findViewById(R.id.rb_generoF);
        generoM = (RadioButton)findViewById(R.id.rb_generoM);
        generoN = (RadioButton)findViewById(R.id.rb_generoN);
        animadoS = (RadioButton)findViewById(R.id.rb_animadoS);
        animadoN = (RadioButton)findViewById(R.id.rb_animadoN);
        esAnimado = (RadioGroup)findViewById(R.id.rg_esAnimado);


        generoN.setOnClickListener( new View.OnClickListener() { //Probando método para deshabilitar botón cuando la palabra es neutra
            @Override
            public void onClick(View v) {
                esAnimado.setEnabled(false);
            }
        });
    }



    public void buscar(View view) {
        if(generoF.isChecked()== true || generoM.isChecked()== true) {
            if(animadoS.isChecked()== true || animadoN.isChecked()== true) {
                Intent tabla = new Intent(this, TableActivity.class);
                tabla.putExtra("palabra", palabra.getText().toString());
                tabla.putExtra("generoF", generoF.isChecked());
                tabla.putExtra("generoM", generoM.isChecked());
                tabla.putExtra("generoN", generoN.isChecked());
                tabla.putExtra("animadoS", animadoS.isChecked());
                tabla.putExtra("animadoN", animadoN.isChecked());
                startActivity(tabla);
            }
        }
        else if(generoN.isChecked()== true) {
            Intent tabla = new Intent(this, TableActivity.class);
            tabla.putExtra("palabra", palabra.getText().toString());
            tabla.putExtra("generoF", generoF.isChecked());
            tabla.putExtra("generoM", generoM.isChecked());
            tabla.putExtra("generoN", generoN.isChecked());
            tabla.putExtra("animadoS", animadoS.isChecked());
            tabla.putExtra("animadoN", animadoN.isChecked());
            startActivity(tabla);
        }
        else {
            Toast.makeText(this, "Valida género y si es animado", Toast.LENGTH_LONG).show();
        }

    }



    //Métodos que vienen por default ---------------------------------------------------------------
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
