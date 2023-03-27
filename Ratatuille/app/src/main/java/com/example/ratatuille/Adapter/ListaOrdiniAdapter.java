package com.example.ratatuille.Adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
import com.example.ratatuille.Presenter.Ordine_piattoPresenter;
import com.example.ratatuille.R;

import java.util.ArrayList;
import java.util.List;

public class ListaOrdiniAdapter extends RecyclerView.Adapter<ListaOrdiniAdapter.ListaOrdiniHolder>{

    private List<Ordine_piatto> ordine_piatti;
    private Context context;
    private Ordine_piattoPresenter ordine_piattoPresenter;
    private RecyclerView recyclerView_c;


    public ListaOrdiniAdapter(Context context, List<Ordine_piatto> ordine_piatti, RecyclerView recyclerView_c){
        this.context = context;
        this.ordine_piatti = ordine_piatti;
        this.recyclerView_c = recyclerView_c;
    }

    @NonNull
    @Override
    public ListaOrdiniAdapter.ListaOrdiniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_cliccabile_tavolo, parent, false);
        return new ListaOrdiniAdapter.ListaOrdiniHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaOrdiniHolder holder, int position) {

        int currentTableId = ordine_piatti.get(position).getOrdine().getIdTavolo();

        holder.id_del_tavolo.setText(String.valueOf(currentTableId));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> listapiattiordinati = new ArrayList<>();
                ArrayList<Integer> listapiattiquantita = new ArrayList<>();
                int id_tavolozzo = ordine_piatti.get(holder.getAdapterPosition()).getOrdine().getIdTavolo();

                ordine_piattoPresenter = Ordine_piattoPresenter.getInstance();
                for(int i = 0; i < ordine_piattoPresenter.getOrdini_piatti().size(); i++){
                    //System.out.println("id_tavolozzo " + id_tavolozzo);
                    //System.out.println(ordine_piattoPresenter.getOrdini_piatti().get(i).getOrdine().getIdTavolo());
                    if(id_tavolozzo == ordine_piattoPresenter.getOrdini_piatti().get(i).getOrdine().getIdTavolo()){
                        listapiattiordinati.add(ordine_piattoPresenter.getOrdini_piatti().get(i).getPiatto().getNome());
                        listapiattiquantita.add(ordine_piattoPresenter.getOrdini_piatti().get(i).getQta());
                        //System.out.println("ordine: " + listapiattiordinati);
                        //System.out.println("quantita: " + listapiattiquantita);
                    }
                }


                ListaPiattiOrdinatiAdapter listaPiattiOrdinatiAdapter = new ListaPiattiOrdinatiAdapter(context, listapiattiordinati, listapiattiquantita);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView_c.setLayoutManager(linearLayoutManager);
                recyclerView_c.setAdapter(listaPiattiOrdinatiAdapter);

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
