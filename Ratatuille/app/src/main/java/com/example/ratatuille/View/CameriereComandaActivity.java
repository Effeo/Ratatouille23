package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ratatuille.R;

public class CameriereComandaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameriere_comanda);

        Button torna_indietro = (Button) findViewById(R.id.btn_torna_indietro);

        torna_indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //la gestione del bottone va fatto in un presenter
                Intent finestraCameriereVisualizzaComanda = new Intent(view.getContext(), CameriereOrdinazioniActivity.class);
                startActivity(finestraCameriereVisualizzaComanda);
            }
        });
    }
}