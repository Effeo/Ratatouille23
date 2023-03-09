package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class SupervisoreAggiungiPiattoActivity extends AppCompatActivity {

    private UtentePresenter utentePresenter;
    private SupervisoreAggiungiPiattoActivity supervisoreAggiungiPiattoActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisore_aggiungi_piatto);

        utentePresenter = UtentePresenter.getInstance();
        supervisoreAggiungiPiattoActivity = this;

        ImageButton btnLogout = (ImageButton) findViewById(R.id.supervisore_logout);
        ImageButton btnAgginugiOrdine = (ImageButton) findViewById(R.id.supervisore_aggiungi_ordine);
        ImageButton btnOrdinazioni = (ImageButton) findViewById(R.id.supervisore_ordinazioni);
        ImageButton btnConto = (ImageButton) findViewById(R.id.supervisore_conto);
        ImageButton btnMessaggi = (ImageButton) findViewById(R.id.supervisore_conto);
        Button btnAggiungi = (Button) findViewById(R.id.btn_aggiungi);



    }
}