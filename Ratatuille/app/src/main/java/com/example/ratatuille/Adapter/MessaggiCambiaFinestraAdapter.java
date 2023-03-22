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

import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.R;
import com.example.ratatuille.View.SupervisoreLeggeMessaggiActivity;
import com.example.ratatuille.View.SupervisoreModificaEliminaMenuActivity;

import java.util.List;

public class MessaggiCambiaFinestraAdapter extends RecyclerView.Adapter<MessaggiCambiaFinestraAdapter.MessaggiCambiaFinestraHolder>{


    private List<Messaggio_utente> messaggi;
    private Context context;

    public MessaggiCambiaFinestraAdapter (Context context, List<Messaggio_utente> messaggi){
        this.messaggi = messaggi;
        this.context = context;
    }

    @NonNull
    @Override
    public MessaggiCambiaFinestraAdapter.MessaggiCambiaFinestraHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.riga_cliccabile_messaggio, parent, false);
        return new MessaggiCambiaFinestraAdapter.MessaggiCambiaFinestraHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessaggiCambiaFinestraAdapter.MessaggiCambiaFinestraHolder holder, int position) {
        holder.id_messaggio.setText(String.valueOf(messaggi.get(position).getMessaggio().getId_messaggio()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finestraSupervisoreLeggeMex = new Intent(v.getContext(), SupervisoreLeggeMessaggiActivity.class);
                finestraSupervisoreLeggeMex.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(finestraSupervisoreLeggeMex);


            }
        });
    }

    @Override
    public int getItemCount() {
        return messaggi.size();
    }

    public class MessaggiCambiaFinestraHolder extends RecyclerView.ViewHolder{
        private TextView id_messaggio;
        private CardView cardView;


        public MessaggiCambiaFinestraHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.riga_cliccabile_messaggio);
            id_messaggio = itemView.findViewById(R.id.text_cardview_2);
        }
    }
}
