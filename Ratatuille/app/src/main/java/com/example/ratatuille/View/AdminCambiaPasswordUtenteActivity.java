package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ratatuille.Adapter.MessaggiAdapter;
import com.example.ratatuille.Adapter.VisualizzaNomiAdapter;
import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.List;

public class AdminCambiaPasswordUtenteActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private AdminCambiaPasswordUtenteActivity adminCambiaPasswordUtenteActivity;
    private FirebaseAnalytics firebaseAnalytics;

    public EditText editPassword;
    public EditText editConfermaPassword;

    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cambia_password_utente);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "AdminCambiaPasswordUtente");
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "AdminCambiaPAsswordUtenteActivity");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);

        utentePresenter = UtentePresenter.getInstance();

        ImageButton btn_admin_logout = (ImageButton)  findViewById(R.id.admin_logout);
        ImageButton btn_admin_aggiungi_piatto = (ImageButton) findViewById(R.id.admin_aggiungi_piatto);
        ImageButton btn_admin_modifica_menu = (ImageButton) findViewById(R.id.admin_modifica_menu);
        ImageButton btn_admin_messaggi = (ImageButton) findViewById(R.id.admin_messaggi);
        ImageButton btn_admin_statistiche = (ImageButton) findViewById(R.id.admin_statistiche);
        ImageButton btn_admin_add_utente = (ImageButton) findViewById(R.id.admin_add_utente);

        Button btn_conferma_cambio = (Button) findViewById(R.id.btn_conferma_cambio);
        Button btn_torna_indietro = (Button) findViewById(R.id.btn_torna_indietro);

        editPassword = (EditText) findViewById(R.id.edit_new_password);
        editConfermaPassword = (EditText) findViewById(R.id.edit_conferma_password);
        recyclerView = (RecyclerView) findViewById(R.id.lista_nomi_utenti);

        adminCambiaPasswordUtenteActivity = this;

        utentePresenter.setAdminCambiaPasswordUtenteActivity(this);
        utentePresenter.getAllUser();

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

        btn_conferma_cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editPassword.getText().toString().equals("") && !editConfermaPassword.getText().toString().equals(""))
                    if(editPassword.getText().toString().equals(editConfermaPassword.getText().toString()))
                        utentePresenter.cambiaPasswordAdmin(editPassword.getText().toString());
                    else
                        Toast.makeText(adminCambiaPasswordUtenteActivity, "Le password non corripondono", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(adminCambiaPasswordUtenteActivity, "Inserire la password", Toast.LENGTH_SHORT).show();
            }
        });

        btn_torna_indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAddUtente(adminCambiaPasswordUtenteActivity);
            }
        });
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    public void stampaUteni(){
        VisualizzaNomiAdapter visualizzaNomiAdapter = new VisualizzaNomiAdapter(adminCambiaPasswordUtenteActivity.getApplicationContext(), utentePresenter.getUtenti());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(visualizzaNomiAdapter);


    }
}