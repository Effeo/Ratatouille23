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

import com.example.ratatuille.Model.Ordine;
import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Presenter.Ordine_piattoPresenter;
import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.R;

import java.util.ArrayList;
import java.util.Locale;

public class ListaPiattiCategorieAdapter extends RecyclerView.Adapter<ListaPiattiCategorieAdapter.ListaPiattiCategorieHolder>{

    private ArrayList<String> piatti;
    private Context context;
    private PiattoPresenter piattoPresenter = PiattoPresenter.getInstance();
    private Ordine_piattoPresenter ordine_piattoPresenter = Ordine_piattoPresenter.getInstance();

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
        int i = 0;
        boolean trovato = false;

        while(i < ordine_piattoPresenter.getOrdini_piatti().size() && !trovato){
            if(ordine_piattoPresenter.getOrdini_piatti().get(i).getPiatto().getNome().equals(piatti.get(holder.getAdapterPosition()))){
                trovato = true;

                holder.quantita_per_piatto.setText(String.valueOf(ordine_piattoPresenter.getOrdini_piatti().get(i).getQta()));
            }

            i++;
        }

        if(!trovato){
            holder.quantita_per_piatto.setText("0");
        }
        holder.button_meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantita = (String) holder.quantita_per_piatto.getText();
                int quantitanum = Integer.parseInt(quantita);
                int i = 0;
                boolean trovato = false;

                if(quantitanum != 0){
                    quantitanum--;
                    holder.quantita_per_piatto.setText(String.valueOf(quantitanum));

                    while(i < ordine_piattoPresenter.getOrdini_piatti().size() && !trovato){
                        if(ordine_piattoPresenter.getOrdini_piatti().get(i).getPiatto().getNome().equals(piatti.get(holder.getAdapterPosition()))){
                            trovato = true;
                            if(quantitanum == 0)
                                ordine_piattoPresenter.getOrdini_piatti().remove(i);
                            else
                                ordine_piattoPresenter.getOrdini_piatti().get(i).setQta(quantitanum);
                        }

                        i++;
                    }

                    System.out.println("ordine piatto dopo meno:");
                    for(i = 0; i < ordine_piattoPresenter.getOrdini_piatti().size(); i++){
                        System.out.println(ordine_piattoPresenter.getOrdini_piatti().get(i).getPiatto().getNome());
                    }
                }
            }
        });

        holder.button_piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //devo salvarmi da qualche parte quantitanum
                String quantita = (String) holder.quantita_per_piatto.getText();
                int quantitanum = Integer.parseInt(quantita);
                int i = 0;
                boolean trovato = false;

                quantitanum++;
                holder.quantita_per_piatto.setText(String.valueOf(quantitanum));

                while(i < ordine_piattoPresenter.getOrdini_piatti().size() && !trovato){
                    if(ordine_piattoPresenter.getOrdini_piatti().get(i).getPiatto().getNome().equals(piatti.get(holder.getAdapterPosition()))){
                        trovato = true;
                        ordine_piattoPresenter.getOrdini_piatti().get(i).setQta(quantitanum);
                    }

                    i++;
                }

                if(!trovato){
                    addPiatto(holder);
                }

                System.out.println("ordine piatto dopo piu:");
                for(i = 0; i < ordine_piattoPresenter.getOrdini_piatti().size(); i++){
                    System.out.println(ordine_piattoPresenter.getOrdini_piatti().get(i).getPiatto().getNome());
                }
            }
        });
    }

    private void addPiatto(@NonNull ListaPiattiCategorieAdapter.ListaPiattiCategorieHolder holder){
        int i = 0;
        boolean trovato = false;
        Ordine_piatto ordine_piatto = new Ordine_piatto();
        Piatto piatto = new Piatto();

        while(i < piattoPresenter.getPiatti().size() && !trovato){
            if(piattoPresenter.getPiatti().get(i).getNome().equals(piatti.get(holder.getAdapterPosition()))){
                trovato = true;
                ordine_piatto.setQta(1);

                piatto.setIdPiatto(piattoPresenter.getPiatti().get(i).getIdPiatto());
                piatto.setNome(piattoPresenter.getPiatti().get(i).getNome());
                piatto.setCategoria(piattoPresenter.getPiatti().get(i).getCategoria());
                piatto.setCosto(piattoPresenter.getPiatti().get(i).getCosto());
                piatto.setAllergeni(piattoPresenter.getPiatti().get(i).getAllergeni());
                piatto.setDescrizione(piattoPresenter.getPiatti().get(i).getDescrizione());
                piatto.setPosto(piattoPresenter.getPiatti().get(i).getPosto());

                ordine_piatto.setPiatto(piatto);
                ordine_piattoPresenter.getOrdini_piatti().add(ordine_piatto);
            }

            i++;
        }
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
