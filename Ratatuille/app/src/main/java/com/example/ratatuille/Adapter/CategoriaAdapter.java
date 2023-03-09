package com.example.ratatuille.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratatuille.R;

import java.util.ArrayList;

public class CategoriaAdapter  extends RecyclerView.Adapter<CategoriaAdapter.CategoriaHolder> {


    private ArrayList<String> categorie;


    @NonNull
    @Override
    public CategoriaAdapter.CategoriaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaAdapter.CategoriaHolder holder, int position) {

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
