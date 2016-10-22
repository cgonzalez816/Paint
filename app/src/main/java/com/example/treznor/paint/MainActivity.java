package com.example.treznor.paint;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton negro;
    ImageButton blanco;
    ImageButton rojo;
    ImageButton verde;
    ImageButton azul;

    Lienzo lienzo;
    float ppeque;
    float pmedia;
    float pgran;
    float pdefecto;

    ImageButton trazo;
    ImageButton ADD;
    ImageButton borrar;
    ImageButton guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        negro = (ImageButton)findViewById(R.id.cnegro);
        blanco = (ImageButton)findViewById(R.id.cblanco);
        rojo = (ImageButton)findViewById(R.id.crojo);
        verde = (ImageButton)findViewById(R.id.cverde);
        azul = (ImageButton)findViewById(R.id.cazul);

        trazo = (ImageButton)findViewById(R.id.trazo);
        ADD = (ImageButton)findViewById(R.id.ADD);
        borrar = (ImageButton)findViewById(R.id.borrar);
        guardar = (ImageButton)findViewById(R.id.guardar);

        negro.setOnClickListener(this);
        blanco.setOnClickListener(this);
        rojo.setOnClickListener(this);
        verde.setOnClickListener(this);
        azul.setOnClickListener(this);

        trazo.setOnClickListener(this);
        ADD.setOnClickListener(this);
        borrar.setOnClickListener(this);
        guardar.setOnClickListener(this);




        lienzo = (Lienzo)findViewById(R.id.Lienzo);

        ppeque = 10;
        pmedia = 20;
        pgran = 30;
        pdefecto = pmedia;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        String color = null;

        switch (v.getId()){
            case R.id.cnegro:
                color = v.getTag().toString();
                lienzo.setColor(color);

                break;

            case R.id.cblanco:
                color = v.getTag().toString();
                lienzo.setColor(color);

                break;

            case R.id.cazul:
                color = v.getTag().toString();
                lienzo.setColor(color);


                break;

            case R.id.cverde:
                color = v.getTag().toString();
                lienzo.setColor(color);



                break;

            case R.id.crojo:
                color = v.getTag().toString();
                lienzo.setColor(color);


                break;

            case R.id.trazo:
                final Dialog tamanyo_punto = new Dialog(this);
                tamanyo_punto.setTitle("tamaño del punto:");

                tamanyo_punto.setContentView(R.layout.tamanyo_punto);


                break;

            case R.id.ADD:

                break;

            case R.id.borrar:

                break;

            case R.id.guardar:

                break;


            default:
                break;

        }


    }
}
