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

import com.example.ratatuille.Model.Conto;
import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Presenter.ContoPresenter;
import com.example.ratatuille.Presenter.Ordine_piattoPresenter;
import com.example.ratatuille.R;

import java.util.ArrayList;
import java.util.List;

public class ListaTavoliContoAdapter extends RecyclerView.Adapter<ListaTavoliContoAdapter.ListaTavoliContoHolder>{

    private List<Conto> tavoli;
    private Context context;
    private ContoPresenter contoPresenter = ContoPresenter.getInstance();
    private RecyclerView recyclerView_conto;
    private Ordine_piattoPresenter ordine_piattoPresenter = Ordine_piattoPresenter.getInstance();

    public ListaTavoliContoAdapter(Context context, List<Conto> tavoli, RecyclerView recyclerView_conto){
        this.tavoli = tavoli;
        this.context = context;
        this.recyclerView_conto = recyclerView_conto;
    }

    @NonNull
    @Override
    public ListaTavoliContoAdapter.ListaTavoliContoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_cliccabile_tavolo, parent, false);
        return new ListaTavoliContoAdapter.ListaTavoliContoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaTavoliContoAdapter.ListaTavoliContoHolder holder, int position) {
        int currentTableId = tavoli.get(position).getId_tavolo();

        contoPresenter.setPosizione_conto(position);

        holder.id_del_tavolo.setText(String.valueOf(currentTableId));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ordine_piattoPresenter.setOrdine_piatti_tmp(new ArrayList<>());
                for (int i = 0; i < ordine_piattoPresenter.getOrdini_piatti().size(); i++ ){
                    if(currentTableId == ordine_piattoPresenter.getOrdini_piatti().get(i).getOrdine().getIdTavolo()){
                        ordine_piattoPresenter.getOrdini_piatti_tmp().add(ordine_piattoPresenter.getOrdini_piatti().get(i));
                    }
                }

                MostraComandaAdapter mostraComandaAdapter = new MostraComandaAdapter(context, ordine_piattoPresenter.getOrdini_piatti_tmp());

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView_conto.setLayoutManager(linearLayoutManager);
                recyclerView_conto.setAdapter(mostraComandaAdapter);

            }
        });
    }

    @Override
    public int getItemCount() {
        return tavoli.size();
    }

    public class ListaTavoliContoHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView id_del_tavolo;

        public ListaTavoliContoHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.riga_cliccabile_tavolo);
            id_del_tavolo = itemView.findViewById(R.id.text_cardview_1);
        }

    }
}
