package com.example.ratatuille.View;

import static com.example.ratatuille.Presenter.Messaggio_utentePresenter.messaggio_utentePresenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ratatuille.Adapter.MessaggiAdapter;
import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

import java.util.List;

public class SupervisoreLeggeMessaggiActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private SupervisoreLeggeMessaggiActivity supervisoreLeggeMessaggiActivity;
    private RecyclerView recyclerView;
    private TextView visualizza_messaggio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisore_legge_messaggi);

        recyclerView = findViewById(R.id.supervisore_lista_messaggi);
        visualizza_messaggio = findViewById(R.id.textView_mex_sup);

        utentePresenter = UtentePresenter.getInstance();

        ImageButton btn_supervisore_logout = (ImageButton)  findViewById(R.id.supervisore_logout);
        ImageButton btn_supervisore_aggiungi_piatto = (ImageButton) findViewById(R.id.supervisore_aggiungi_piatto);
        ImageButton btn_supervisore_modifica_menu = (ImageButton) findViewById(R.id.supervisore_modifica_menu);
        ImageButton btn_supervisore_conto = (ImageButton) findViewById(R.id.supervisore_conto);
        ImageButton btn_supervisore_messaggi = (ImageButton) findViewById(R.id.supervisore_messaggi);

        supervisoreLeggeMessaggiActivity = this;

        btn_supervisore_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(supervisoreLeggeMessaggiActivity);
            }
        });

        btn_supervisore_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreAggiungiPiatto(supervisoreLeggeMessaggiActivity);
            }
        });

        btn_supervisore_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreModificaMenu(supervisoreLeggeMessaggiActivity);
            }
        });

        btn_supervisore_conto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreConto(supervisoreLeggeMessaggiActivity);
            }
        });

        btn_supervisore_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreMessaggi(supervisoreLeggeMessaggiActivity);
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
        //qua non entra mai, francesco deve modificare!!
        List<Messaggio_utente> messaggi = messaggio_utentePresenter.getMessaggi_utenti();

        MessaggiAdapter messaggiAdapter = new MessaggiAdapter(supervisoreLeggeMessaggiActivity.getApplicationContext(), messaggi, visualizza_messaggio);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messaggiAdapter);
    }

}