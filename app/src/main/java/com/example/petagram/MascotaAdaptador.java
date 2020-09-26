package com.example.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador  extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    //método constructor de esta clase
    public MascotaAdaptador(ArrayList<Mascota>mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Para inflar el layout y pasarlo al ViewHolder para que el obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//este viewHolder va a darle vista a nuestro view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        return new MascotaViewHolder(v);
    }

    //Para pasarle la lista de mascotas
    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvNumCV.setText(mascota.getNum());

       //agrego el onClickListener al btnHuesoLike
        mascotaViewHolder.btnHuesoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = "1";
                mascotaViewHolder.tvNumCV.setText(num);
            }
        });
    }

    //Cantidad de elementos que contiene mi lista de mascotas
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        //declaro los views del CardView
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvNumCV;
        private ImageButton btnHuesoLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            //asocio los objetos con su respectivo View
            imgFoto      = (ImageView)itemView.findViewById(R.id.imgFotoCV); //a través del objeto itemView del super paso el view
            tvNombreCV   = (TextView)itemView.findViewById(R.id.tvNombreCV);
            tvNumCV      = (TextView)itemView.findViewById(R.id.tvNumCV);
            btnHuesoLike = (ImageButton)itemView.findViewById(R.id.btnHueso);
        }
    }
}
