package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ratatuille.Adapter.MessaggiAdapter;
import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Presenter.Messaggio_utentePresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

import java.util.List;

public class CameriereMessaggiActivity extends AppCompatActivity {
    private Messaggio_utentePresenter messaggio_utentePresenter;
    private UtentePresenter utentePresenter;
    private CameriereMessaggiActivity cameriereMessaggiActivity;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameriere_messaggi);

        ImageButton logout = (ImageButton) findViewById(R.id.cameriere_logout);
        ImageButton aggiungi_tavolo = (ImageButton) findViewById(R.id.cameriere_aggiungi_tavolo);
        ImageButton visualizza_comanda = (ImageButton) findViewById(R.id.cameriere_visualizza_comanda);
        ImageButton messaggi = (ImageButton) findViewById(R.id.cameriere_messaggi);
        ImageButton ordinazioni = (ImageButton) findViewById(R.id.cameriere_ordinazioni);
        Button btn_visualizza = (Button) findViewById(R.id.btn_visualizza);

        messaggio_utentePresenter = Messaggio_utentePresenter.getInstance();
        utentePresenter = UtentePresenter.getInstance();

        messaggio_utentePresenter.setCameriereMessaggiActivity(this);
        messaggio_utentePresenter.getAllMessaggioUtente(utentePresenter.getUtente().getRuolo(), utentePresenter.getUtente().getUser_name());

        cameriereMessaggiActivity = this;

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.logOut(cameriereMessaggiActivity);
            }
        });

        aggiungi_tavolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goCameriereAggiungiTavolo(cameriereMessaggiActivity);
            }
        });

        visualizza_comanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goCameriereComanda(cameriereMessaggiActivity);
            }
        });

        messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goCameriereMessaggi(cameriereMessaggiActivity);
            }
        });

        ordinazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goCameriereOrdinazioni(cameriereMessaggiActivity);
            }
        });

        btn_visualizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //da cambiare mettendo l'id giusto
                messaggio_utentePresenter.setLetto(0);
            }
        });
    }

    public void stampaMessaggi(){
        List<Messaggio_utente> messaggi = messaggio_utentePresenter.getMessaggi_utenti();

        MessaggiAdapter messaggiAdapter = new MessaggiAdapter(cameriereMessaggiActivity.getApplicationContext(), messaggi);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messaggiAdapter);
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
}