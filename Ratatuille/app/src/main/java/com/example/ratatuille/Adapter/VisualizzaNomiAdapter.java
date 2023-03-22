package com.example.ratatuille.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.R;
import com.example.ratatuille.View.SupervisoreLeggeMessaggiActivity;

import java.util.List;

public class VisualizzaNomiAdapter extends RecyclerView.Adapter<VisualizzaNomiAdapter.VisualizzaNomiHolder>{

    private List<Utente> utenti;
    private Context context;

    public VisualizzaNomiAdapter(Context context, List<Utente> utenti){
        this.utenti = utenti;
        this.context = context;
    }

    @NonNull
    @Override
    public VisualizzaNomiAdapter.VisualizzaNomiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_non_cliccabile, parent, false);
        return new VisualizzaNomiAdapter.VisualizzaNomiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VisualizzaNomiAdapter.VisualizzaNomiHolder holder, int position) {
        holder.nome_utente.setText(utenti.get(position).getUser_name());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //faccio dopo
            }
        });
    }

    @Override
    public int getItemCount() {
        return utenti.size();
    }

    public class VisualizzaNomiHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private TextView nome_utente;

        public VisualizzaNomiHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.riga_non_cliccabile);
            nome_utente = itemView.findViewById(R.id.text_nome_piatti);
        }
    }
}
