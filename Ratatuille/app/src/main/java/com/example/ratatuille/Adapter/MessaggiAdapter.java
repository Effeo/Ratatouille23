package com.example.ratatuille.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.Presenter.Messaggio_utentePresenter;
import com.example.ratatuille.R;

import java.util.List;

public class MessaggiAdapter extends RecyclerView.Adapter<MessaggiAdapter.MessaggiHolder>{

    private List<Messaggio_utente> messaggi;
    private Messaggio_utentePresenter messaggio_utentePresenter = Messaggio_utentePresenter.getInstance();
    private Context context;
    private TextView visualizza_messaggio;




    public MessaggiAdapter(Context context, List<Messaggio_utente> messaggi, TextView visualizza_messaggio){
        this.messaggi = messaggi;
        this.context = context;
        this.visualizza_messaggio = visualizza_messaggio;
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
                visualizza_messaggio.setText(messaggi.get(holder.getAdapterPosition()).getMessaggio().getCorpo());
                messaggio_utentePresenter.setPosizione_messaggio_letto(holder.getAdapterPosition());
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
