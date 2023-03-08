package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class CameriereOrdinazioniActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private PiattoPresenter piattoPresenter;
    private CameriereOrdinazioniActivity cameriereOrdinazioniActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameriere_ordinazioni);

        ImageButton logout = (ImageButton) findViewById(R.id.cameriere_logout);
        ImageButton aggiungi_tavolo = (ImageButton) findViewById(R.id.cameriere_aggiungi_tavolo);
        ImageButton visualizza_comanda = (ImageButton) findViewById(R.id.cameriere_visualizza_comanda);
        ImageButton messaggi = (ImageButton) findViewById(R.id.cameriere_messaggi);
        ImageButton ordinazioni = (ImageButton) findViewById(R.id.cameriere_ordinazioni);

        utentePresenter = UtentePresenter.getInstance();
        piattoPresenter = PiattoPresenter.getInstance();

        piattoPresenter.setCameriereOrdinazioniActivity(this);
        piattoPresenter.getAllPiatti();

        cameriereOrdinazioniActivity = this;

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.logOut(cameriereOrdinazioniActivity);
            }
        });

        aggiungi_tavolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goCameriereAggiungiTavolo(cameriereOrdinazioniActivity);
            }
        });

        visualizza_comanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goCameriereComanda(cameriereOrdinazioniActivity);
            }
        });

        messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goCameriereMessaggi(cameriereOrdinazioniActivity);
            }
        });

        ordinazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goCameriereOrdinazioni(cameriereOrdinazioniActivity);
            }
        });
    }

    public void stampaPiatti(){
        for(int i = 0; i < piattoPresenter.getPiatti().size(); i++){
            System.out.println(piattoPresenter.getPiatti().get(i).getNome());
        }
    }
}