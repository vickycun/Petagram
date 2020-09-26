package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        //Para verlo en forma de lista. Lo voy a cometnar para combiarlo a forma de GridLayout:
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);// quiero que cada tarjeta este acomodada una debajo de otra

        listaMascotas.setLayoutManager(llm);//con esto le estoy diciendo que este elemento RecyclerView llamado listaContactos

        inicializaListaDeMascotas();

        inicializarAdaptador();

    }

    private void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);//con esto, ahora el RecyclerView, contiene el adaptador
    }

    public void inicializaListaDeMascotas (){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota1,"Rocco", "0"));
        mascotas.add(new Mascota(R.drawable.mascota2,"Luchi", "0"));
        mascotas.add(new Mascota(R.drawable.mascota3,"Dobby", "0"));
        mascotas.add(new Mascota(R.drawable.mascota4,"Rambo", "0"));
        mascotas.add(new Mascota(R.drawable.mascota5,"Dory", "0"));
        mascotas.add(new Mascota(R.drawable.mascota6,"Rufus", "0"));
        mascotas.add(new Mascota(R.drawable.mascota7,"Caty", "0"));
        mascotas.add(new Mascota(R.drawable.mascota8,"Ronny", "0"));
        mascotas.add(new Mascota(R.drawable.mascota9,"Fatiga", "0"));
        mascotas.add(new Mascota(R.drawable.mascota10,"Homero", "0"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.acciones_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch(item.getItemId()){
            case R.id.btn_estrella:
                Intent intent = new Intent(MainActivity.this, Activity5MascotasFavoritas.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                Toast.makeText(this, R.string.opciones, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}