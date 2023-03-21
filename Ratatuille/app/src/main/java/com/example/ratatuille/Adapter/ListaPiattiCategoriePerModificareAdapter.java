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

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.R;
import com.example.ratatuille.View.SupervisoreModificaEliminaMenuActivity;

import java.util.ArrayList;

public class ListaPiattiCategoriePerModificareAdapter extends RecyclerView.Adapter<ListaPiattiCategoriePerModificareAdapter.ListaPiattiCategoriePerModificareHolder>{

    private ArrayList<String> piatti_modificabili;
    private Context context;
    private PiattoPresenter piattoPresenter = PiattoPresenter.getInstance();

    public ListaPiattiCategoriePerModificareAdapter(Context context, ArrayList<String> piatti_modificabili){
        this.context = context;
        this.piatti_modificabili = piatti_modificabili;
    }

    @NonNull
    @Override
    public ListaPiattiCategoriePerModificareAdapter.ListaPiattiCategoriePerModificareHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_non_cliccabile, parent, false);
        return new ListaPiattiCategoriePerModificareAdapter.ListaPiattiCategoriePerModificareHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPiattiCategoriePerModificareAdapter.ListaPiattiCategoriePerModificareHolder holder, int position) {
        holder.nomePiatto.setText(piatti_modificabili.get(position).toUpperCase());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                boolean trovato = false;
                Piatto piatto = new Piatto();

                while(i < piattoPresenter.getPiatti().size() && !trovato){
                    if(piattoPresenter.getPiatti().get(i).getNome().equals(piatti_modificabili.get(holder.getAdapterPosition()))){
                        trovato = true;

                        //modifica a volo

                        piatto.setIdPiatto(piattoPresenter.getPiatti().get(i).getIdPiatto());
                        piatto.setNome(piattoPresenter.getPiatti().get(i).getNome());
                        piatto.setCategoria(piattoPresenter.getPiatti().get(i).getCategoria());
                        piatto.setCosto(piattoPresenter.getPiatti().get(i).getCosto());
                        piatto.setAllergeni(piattoPresenter.getPiatti().get(i).getAllergeni());
                        piatto.setDescrizione(piattoPresenter.getPiatti().get(i).getDescrizione());
                        piatto.setPosto(piattoPresenter.getPiatti().get(i).getPosto());

                        piattoPresenter.setPiatto(piatto);
                    }

                    i++;
                }


                Intent finestraSupervisoreModificaEliminaMenuActivity = new Intent(v.getContext(), SupervisoreModificaEliminaMenuActivity.class);
                context.startActivity(finestraSupervisoreModificaEliminaMenuActivity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return piatti_modificabili.size();
    }

    public class ListaPiattiCategoriePerModificareHolder extends RecyclerView.ViewHolder {
        private TextView nomePiatto;
        private CardView cardView;

        public ListaPiattiCategoriePerModificareHolder(@NonNull View itemView) {
            super(itemView);
            nomePiatto = itemView.findViewById(R.id.text_nome_piatti);
            cardView = itemView.findViewById(R.id.riga_non_cliccabile);
        }
    }
}
