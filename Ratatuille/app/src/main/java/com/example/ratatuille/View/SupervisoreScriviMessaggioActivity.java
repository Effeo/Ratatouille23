package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class SupervisoreScriviMessaggioActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private SupervisoreScriviMessaggioActivity supervisoreScriviMessaggioActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisore_scrivi_messaggio);

        utentePresenter = UtentePresenter.getInstance();

        Button btn_scrivi = (Button) findViewById(R.id.btn_scrivi);

        ImageButton btn_supervisore_logout = (ImageButton)  findViewById(R.id.supervisore_logout);
        ImageButton btn_supervisore_aggiungi_piatto = (ImageButton) findViewById(R.id.supervisore_aggiungi_piatto);
        ImageButton btn_supervisore_modifica_menu = (ImageButton) findViewById(R.id.supervisore_modifica_menu);
        ImageButton btn_supervisore_conto = (ImageButton) findViewById(R.id.supervisore_conto);
        ImageButton btn_supervisore_messaggi = (ImageButton) findViewById(R.id.supervisore_messaggi);

        supervisoreScriviMessaggioActivity = this;

        btn_supervisore_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(supervisoreScriviMessaggioActivity);
            }
        });

        btn_supervisore_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreAggiungiPiatto(supervisoreScriviMessaggioActivity);
            }
        });

        btn_supervisore_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreModificaMenu(supervisoreScriviMessaggioActivity);
            }
        });

        btn_supervisore_conto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreConto(supervisoreScriviMessaggioActivity);
            }
        });

        btn_supervisore_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreMessaggi(supervisoreScriviMessaggioActivity);
            }
        });
    }
}