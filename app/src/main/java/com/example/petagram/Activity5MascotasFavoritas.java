package com.example.petagram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity5MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5_mascotas_favoritas);

        androidx.appcompat.widget.Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.favoritos);

        //para boton para subir
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarFavoritas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarFavoritas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota6, "Mostaza", "0"));
        mascotas.add(new Mascota(R.drawable.mascota7, "Catty", "0"));
        mascotas.add(new Mascota(R.drawable.mascota8, "Ronny", "0"));
        mascotas.add(new Mascota(R.drawable.mascota5, "Dory", "0"));
        mascotas.add(new Mascota(R.drawable.mascota4, "Rambo", "0"));
    }

}