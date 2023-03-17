package com.example.ratatuille.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratatuille.R;

import java.util.ArrayList;

public class ListaPiattiOrdinatiAdapter extends RecyclerView.Adapter<ListaPiattiOrdinatiAdapter.ListaPiattiOrdinatiHolder>{

    private ArrayList<String> piatti_ordinati;
    private ArrayList<Integer> qta;
    private Context context;

    public ListaPiattiOrdinatiAdapter(Context context, ArrayList<String> piatti_ordinati, ArrayList<Integer> qta){
        this.context = context;
        this.piatti_ordinati = piatti_ordinati;
        this.qta = qta;
    }

    @NonNull
    @Override
    public ListaPiattiOrdinatiAdapter.ListaPiattiOrdinatiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_non_cliccabile_visualizza_piatto, parent, false);
        return new ListaPiattiOrdinatiAdapter.ListaPiattiOrdinatiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPiattiOrdinatiAdapter.ListaPiattiOrdinatiHolder holder, int position) {
        holder.nomePiattoOrdinato.setText(piatti_ordinati.get(position).toUpperCase());
        holder.quantita_per_piatto.setText(qta.get(position));
    }

    @Override
    public int getItemCount() {
        return piatti_ordinati.size();
    }

    public class ListaPiattiOrdinatiHolder extends RecyclerView.ViewHolder{

        private TextView nomePiattoOrdinato;
        private TextView quantita_per_piatto;


        public ListaPiattiOrdinatiHolder(@NonNull View itemView) {
            super(itemView);
            nomePiattoOrdinato = itemView.findViewById(R.id.nome_piatto);
            quantita_per_piatto = itemView.findViewById(R.id.quantita_piatto);
        }
    }
}
