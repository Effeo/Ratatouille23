package com.example.ratatuille.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratatuille.Model.Messaggio;
import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.R;

import java.util.ArrayList;
import java.util.List;

public class MessaggiAdapter extends RecyclerView.Adapter<MessaggiAdapter.MessaggiHolder>{

    private List<Messaggio_utente> messaggi;
    private Context context;

    public MessaggiAdapter(Context context, List<Messaggio_utente> messaggi){
        this.messaggi = messaggi;
        this.context = context;
    }


    @NonNull
    @Override
    public MessaggiAdapter.MessaggiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_cliccabile_messaggio, parent, false);
        return new MessaggiAdapter.MessaggiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessaggiAdapter.MessaggiHolder holder, int position) {
        holder.id_messaggio.setText(String.valueOf(messaggi.get(position).getMessaggio().getId_messaggio()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //faccio dopo
            }
        });
    }

    @Override
    public int getItemCount() {
        return messaggi.size();
    }

    public class MessaggiHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView id_messaggio;

        public MessaggiHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.riga_cliccabile_messaggio);
            id_messaggio = itemView.findViewById(R.id.text_cardview_2);
        }
    }
}
