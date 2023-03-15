package com.example.ratatuille.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.R;

import java.util.ArrayList;

public class ListaPiattiCategorieAdapter extends RecyclerView.Adapter<ListaPiattiCategorieAdapter.ListaPiattiCategorieHolder>{

    private ArrayList<String> piatti;
    private Context context;



    public ListaPiattiCategorieAdapter(Context context, ArrayList<String> piatti){
        this.context = context;
        this.piatti = piatti;
    }

    @NonNull
    @Override
    public ListaPiattiCategorieAdapter.ListaPiattiCategorieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_piatto_e_i_pulsanti_di_aggiungi_e_togli, parent, false);
        return new ListaPiattiCategorieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPiattiCategorieAdapter.ListaPiattiCategorieHolder holder, int position) {

        holder.nomePiatto.setText(piatti.get(position).toUpperCase());
        String quantita = (String) holder.quantita_per_piatto.getText();

        holder.button_meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fixxo domani
                int quantitanum = Integer.parseInt(quantita);
                if(quantitanum != 0){
                    quantitanum--;
                    holder.quantita_per_piatto.setText(String.valueOf(quantitanum));
                }
            }
        });

        holder.button_piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fixxo domani
                int quantitanum = Integer.parseInt(quantita);
                quantitanum++;
                holder.quantita_per_piatto.setText(String.valueOf(quantitanum));
            }
        });
    }

    @Override
    public int getItemCount() {
        return piatti.size();
    }


    public class ListaPiattiCategorieHolder extends RecyclerView.ViewHolder{

        private TextView nomePiatto;
        private Button button_meno;
        private TextView quantita_per_piatto;
        private Button button_piu;


        public ListaPiattiCategorieHolder(@NonNull View itemView) {
            super(itemView);
            nomePiatto = itemView.findViewById(R.id.piatto_da_aggiungere_o_togliere_nella_comanda);
            button_meno = itemView.findViewById(R.id.bottone_meno);
            quantita_per_piatto = itemView.findViewById(R.id.quantita);
            button_piu = itemView.findViewById(R.id.bottone_piu);
        }
    }
}
