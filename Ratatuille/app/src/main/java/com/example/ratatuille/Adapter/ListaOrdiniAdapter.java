package com.example.ratatuille.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratatuille.Model.Ordine;
import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Tavolo;
import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.R;

import java.util.ArrayList;
import java.util.List;

public class ListaOrdiniAdapter extends RecyclerView.Adapter<ListaOrdiniAdapter.ListaOrdiniHolder>{

    private List<Ordine_piatto> ordine_piatti;
    private Context context;

    public ListaOrdiniAdapter(Context context, List<Ordine_piatto> ordine_piatti){
        this.context = context;
        this.ordine_piatti = ordine_piatti;
    }

    @NonNull
    @Override
    public ListaOrdiniAdapter.ListaOrdiniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_cliccabile_tavolo, parent, false);
        return new ListaOrdiniAdapter.ListaOrdiniHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaOrdiniHolder holder, int position) {

        holder.id_del_tavolo.setText(String.valueOf(ordine_piatti.get(position).getOrdine().getIdTavolo()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //faccio dopo
                /*
                ArrayList<String> listapiattinomi = new ArrayList<>();
                String categoria = categorie.get(holder.getAdapterPosition());

                piattoPresenter = PiattoPresenter.getInstance();
                for(int i = 0; i < piattoPresenter.getPiatti().size(); i++){
                    if(categoria.equals(piattoPresenter.getPiatti().get(i).getCategoria())){
                        listapiattinomi.add(piattoPresenter.getPiatti().get(i).getNome());
                    }
                    //System.out.println(listapiattinomi);
                }

                ListaPiattiCategorieAdapter listaPiattiCategorieAdapter = new ListaPiattiCategorieAdapter(context, listapiattinomi);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView_1.setLayoutManager(linearLayoutManager);
                recyclerView_1.setAdapter(listaPiattiCategorieAdapter);
                */
            }
        });
    }

    @Override
    public int getItemCount() {
        return ordine_piatti.size();
    }

    public class ListaOrdiniHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView id_del_tavolo;

        public ListaOrdiniHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.riga_cliccabile_tavolo);
            id_del_tavolo = itemView.findViewById(R.id.text_cardview_1);
        }
    }

}
