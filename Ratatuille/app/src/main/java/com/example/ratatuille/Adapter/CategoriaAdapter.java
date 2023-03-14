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

import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.R;
import com.example.ratatuille.View.CameriereOrdinazioniActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaHolder> {

    private ArrayList<String> categorie;
    private Context context;
    private PiattoPresenter piattoPresenter;
    private RecyclerView recyclerView_1;

    public CategoriaAdapter(Context context, ArrayList<String> categorie, RecyclerView recyclerView_1){
        this.context = context;
        this.categorie = categorie;
        this.recyclerView_1 = recyclerView_1;
    }

    @NonNull
    @Override
    public CategoriaAdapter.CategoriaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_cliccabile, parent, false);
        return new CategoriaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaAdapter.CategoriaHolder holder, int position) {
        holder.nomeCategoria.setText(categorie.get(position).toUpperCase());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
    }

    @Override
    public int getItemCount() {
        return categorie.size();
    }

    public class CategoriaHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView nomeCategoria;

        public CategoriaHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.riga_cliccabile);
            nomeCategoria = itemView.findViewById(R.id.text_cardview);
        }
    }
}
