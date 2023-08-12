package com.example.groceryapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView burgerIcon;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        burgerIcon=findViewById(R.id.iv_burgerIcon);
        drawer=findViewById(R.id.drawer_layout);
        burgerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });
    }
    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(Gravity.LEFT);
        }else{

            //super.onBackPressed();
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Cerrar aplicación?");
            adb.setMessage("¿Está seguro que quiere salir?");
            adb.setCancelable(false);

            adb.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            adb.setNegativeButton("No", null);

            AlertDialog alertDialog =adb.create();
            alertDialog.show();

        }
    }

}