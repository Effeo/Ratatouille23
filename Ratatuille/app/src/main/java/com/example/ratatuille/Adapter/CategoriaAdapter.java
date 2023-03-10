package com.example.ratatuille.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratatuille.R;

import java.util.ArrayList;
import java.util.Locale;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaHolder> {

    private ArrayList<String> categorie;
    private Context context;

    public CategoriaAdapter(Context context, ArrayList<String> categorie){
        this.context = context;
        this.categorie = categorie;
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
                //faccio dopo
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
