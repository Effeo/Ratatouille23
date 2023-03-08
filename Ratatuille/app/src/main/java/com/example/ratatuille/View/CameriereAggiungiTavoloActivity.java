package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ratatuille.R;

public class CameriereAggiungiTavoloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameriere_aggiungi_tavolo);

        Button conferma = (Button) findViewById(R.id.button_conferma);
        Button torna_indietro = (Button) findViewById(R.id.button_2);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //la gestione del bottone va fatto in un presenter
                Intent finestraCameriereConfermaTavoli = new Intent(view.getContext(), CameriereOrdinazioniActivity.class);
                startActivity(finestraCameriereConfermaTavoli);
                //manda anche info al db
            }
        });

        torna_indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //la gestione del bottone va fatto in un presenter
                Intent finestraCameriereConfermaTavoli = new Intent(view.getContext(), CameriereOrdinazioniActivity.class);
                startActivity(finestraCameriereConfermaTavoli);
            }
        });


    }
}