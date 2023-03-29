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
import com.example.ratatuille.Adapter.MessaggiCambiaFinestraAdapter;
import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.Presenter.MessaggioPresenter;
import com.example.ratatuille.Presenter.Messaggio_utentePresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.List;

public class SupervisoreScriviMessaggioActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private SupervisoreScriviMessaggioActivity supervisoreScriviMessaggioActivity;
    private Messaggio_utentePresenter messaggio_utentePresenter;
    private MessaggioPresenter messaggioPresenter;
    private RecyclerView recyclerView;
    private EditText editMessaggio;

    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisore_scrivi_messaggio);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "SupervisoreScriviMessaggio");
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "SupervisoreScriviMessaggioActivity");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);

        utentePresenter = UtentePresenter.getInstance();
        messaggio_utentePresenter = Messaggio_utentePresenter.getInstance();
        messaggioPresenter = MessaggioPresenter.getInstance();

        messaggio_utentePresenter.getAllMessaggioUtente(utentePresenter.getUtente().getRuolo(), utentePresenter.getUtente().getUser_name(), null);
        messaggio_utentePresenter.setSupervisoreScriviMessaggioActivity(this);

        recyclerView = findViewById(R.id.supervisore_lista_messaggi_1);

        Button btn_invia = (Button) findViewById(R.id.btn_invia);
        Button btn_scrivi = (Button) findViewById(R.id.btn_scrivi);

        ImageButton btn_supervisore_logout = (ImageButton)  findViewById(R.id.supervisore_logout);
        ImageButton btn_supervisore_aggiungi_piatto = (ImageButton) findViewById(R.id.supervisore_aggiungi_piatto);
        ImageButton btn_supervisore_modifica_menu = (ImageButton) findViewById(R.id.supervisore_modifica_menu);
        ImageButton btn_supervisore_conto = (ImageButton) findViewById(R.id.supervisore_conto);
        ImageButton btn_supervisore_messaggi = (ImageButton) findViewById(R.id.supervisore_messaggi);

        editMessaggio = (EditText) findViewById(R.id.edit_messaggio);

        supervisoreScriviMessaggioActivity = this;

        messaggioPresenter.setSupervisoreScriviMessaggioActivity(this);

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

        btn_scrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreMessaggi(supervisoreScriviMessaggioActivity);
            }
        });

        btn_invia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editMessaggio.getText().toString().equals(""))
                    messaggioPresenter.create(editMessaggio.getText().toString(), utentePresenter.getUtente().getRuolo());
                else
                    Toast.makeText(supervisoreScriviMessaggioActivity.getApplicationContext(), "Scrivere un messaggio da inviare", Toast.LENGTH_SHORT).show();
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

    public void stampaMessaggi(){
        List<Messaggio_utente> messaggi = messaggio_utentePresenter.getMessaggi_utenti();

        MessaggiCambiaFinestraAdapter messaggiCambiaFinestraAdapter = new MessaggiCambiaFinestraAdapter(supervisoreScriviMessaggioActivity.getApplicationContext(), messaggi);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messaggiCambiaFinestraAdapter);


    }

}