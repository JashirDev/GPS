package com.example.gamer.apploginv2.adaptadores;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gamer.apploginv2.R;
import com.example.gamer.apploginv2.modelo.Familia;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FamiliaAdapter extends RecyclerView.Adapter<FamiliaAdapter.FamiliaViewHolder>
        implements View.OnClickListener{

    ArrayList<Familia> lista;
    private  View.OnClickListener listener;

    public FamiliaAdapter(ArrayList<Familia> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public FamiliaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_familia,parent,false);
        v.setOnClickListener(this);
        return new FamiliaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FamiliaViewHolder holder, int position) {

        // holder.nombre.setText(lista.get(position).getNombre());
        holder.nombre.setText(lista.get(position).getProducto());
        holder.precio.setText(String.valueOf(lista.get(position).getPre_unit()));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }
    public void setonclciklsitener(View.OnClickListener listener){
        this.listener=listener;
    }

    public class FamiliaViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nombreproducto)
        TextView nombre;

        @BindView(R.id.precioproducto)
        TextView precio;

        public FamiliaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
