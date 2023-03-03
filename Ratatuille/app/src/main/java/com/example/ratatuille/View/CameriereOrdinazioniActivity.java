package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ratatuille.R;

public class CameriereOrdinazioniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameriere_ordinazioni);

        ImageButton logout = (ImageButton) findViewById(R.id.cameriere_logout);
        ImageButton aggiungi_tavolo = (ImageButton) findViewById(R.id.cameriere_aggiungi_tavolo);
        ImageButton visualizza_comanda = (ImageButton) findViewById(R.id.cameriere_visualizza_comanda);
        ImageButton messaggi = (ImageButton) findViewById(R.id.cameriere_messaggi);
        ImageButton ordinazioni = (ImageButton) findViewById(R.id.cameriere_ordinazioni);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //la gestione del bottone va fatto in un presenter
                Intent finestraWelcome = new Intent(view.getContext(), MainActivity.class);
                startActivity(finestraWelcome);
            }
        });

        aggiungi_tavolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //la gestione del bottone va fatto in un presenter
                Intent finestraAggiungiTavolo = new Intent(view.getContext(), CameriereAggiungiTavoloActivity.class);
                startActivity(finestraAggiungiTavolo);
            }
        });

        visualizza_comanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //la gestione del bottone va fatto in un presenter
                Intent finestraVisualizzaComanda = new Intent(view.getContext(), CameriereComandaActivity.class);
                startActivity(finestraVisualizzaComanda);
            }
        });

        messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //la gestione del bottone va fatto in un presenter
                Intent finestraMessaggi = new Intent(view.getContext(), CameriereMessaggiActivity.class);
                startActivity(finestraMessaggi);
            }
        });

        ordinazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //la gestione del bottone va fatto in un presenter
                Intent finestraOrdinazioni = new Intent(view.getContext(), CameriereOrdinazioniActivity.class);
                startActivity(finestraOrdinazioni);
            }
        });
    }
}