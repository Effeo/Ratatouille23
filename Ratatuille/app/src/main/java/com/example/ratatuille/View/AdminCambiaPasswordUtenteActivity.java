package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class AdminCambiaPasswordUtenteActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private AdminCambiaPasswordUtenteActivity adminCambiaPasswordUtenteActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cambia_password_utente);

        utentePresenter = UtentePresenter.getInstance();

        ImageButton btn_admin_logout = (ImageButton)  findViewById(R.id.admin_logout);
        ImageButton btn_admin_aggiungi_piatto = (ImageButton) findViewById(R.id.admin_aggiungi_piatto);
        ImageButton btn_admin_modifica_menu = (ImageButton) findViewById(R.id.admin_modifica_menu);
        ImageButton btn_admin_messaggi = (ImageButton) findViewById(R.id.admin_messaggi);
        ImageButton btn_admin_statistiche = (ImageButton) findViewById(R.id.admin_statistiche);
        ImageButton btn_admin_add_utente = (ImageButton) findViewById(R.id.admin_add_utente);

        adminCambiaPasswordUtenteActivity = this;

        btn_admin_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(adminCambiaPasswordUtenteActivity);
            }
        });

        btn_admin_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAggiungiPiatto(adminCambiaPasswordUtenteActivity);
            }
        });

        btn_admin_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminModificaMenu(adminCambiaPasswordUtenteActivity);
            }
        });

        btn_admin_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminMessaggi(adminCambiaPasswordUtenteActivity);
            }
        });

        btn_admin_statistiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminStatistiche(adminCambiaPasswordUtenteActivity);
            }
        });

        btn_admin_add_utente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAddUtente(adminCambiaPasswordUtenteActivity);
            }
        });
    }
}