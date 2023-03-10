package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class AdminAggiungiPiattoActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private AdminAggiungiPiattoActivity adminAggiungiPiattoActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_aggiungi_piatto);

        utentePresenter = UtentePresenter.getInstance();

        Button btn_aggiungi = (Button) findViewById(R.id.btn_aggiungi);

        ImageButton btn_admin_logout = (ImageButton)  findViewById(R.id.admin_logout);
        ImageButton btn_admin_aggiungi_piatto = (ImageButton) findViewById(R.id.admin_aggiungi_piatto);
        ImageButton btn_admin_modifica_menu = (ImageButton) findViewById(R.id.admin_modifica_menu);
        ImageButton btn_admin_messaggi = (ImageButton) findViewById(R.id.admin_messaggi);
        ImageButton btn_admin_statistiche = (ImageButton) findViewById(R.id.admin_statistiche);
        ImageButton btn_admin_add_utente = (ImageButton) findViewById(R.id.admin_add_utente);

        adminAggiungiPiattoActivity = this;

        btn_admin_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAggiungiPiatto(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminModificaMenu(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminMessaggi(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_statistiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminStatistiche(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_add_utente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAddUtente(adminAggiungiPiattoActivity);
            }
        });
    }
}