package com.example.ratatuille.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.R;

import java.util.ArrayList;

public class MostraComandaAdapter extends RecyclerView.Adapter<MostraComandaAdapter.MostraComandaHolder>{

    private ArrayList<Ordine_piatto> comanda;
    private Context context;
    private TextView textView_mostra_conto;

    public MostraComandaAdapter(Context context, ArrayList<Ordine_piatto> comanda){
        this.comanda = comanda;
        this.context = context;
        this.textView_mostra_conto = textView_mostra_conto;
    }

    @NonNull
    @Override
    public MostraComandaAdapter.MostraComandaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_non_cliccabile_mostra_comanda, parent, false);
        return new MostraComandaAdapter.MostraComandaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostraComandaAdapter.MostraComandaHolder holder, int position) {
        holder.nomePiatto.setText(comanda.get(position).getPiatto().getNome());
        holder.quantita.setText(String.valueOf(comanda.get(position).getQta()));
        holder.prezzo.setText(String.valueOf(comanda.get(position).getPiatto().getCosto()));
    }

    @Override
    public int getItemCount() {
        return comanda.size();
    }

    public class MostraComandaHolder extends RecyclerView.ViewHolder {
        private TextView nomePiatto;
        private TextView prezzo;
        private TextView quantita;

        public MostraComandaHolder(@NonNull View itemView) {
            super(itemView);
            nomePiatto = itemView.findViewById(R.id.nome_piatto);
            prezzo = itemView.findViewById(R.id.prezzo);
            quantita = itemView.findViewById(R.id.quantita_piatto);
        }
    }
}
