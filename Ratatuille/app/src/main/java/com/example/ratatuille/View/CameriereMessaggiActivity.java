package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ratatuille.Adapter.MessaggiAdapter;
import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.Presenter.Messaggio_utentePresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.List;

public class CameriereMessaggiActivity extends AppCompatActivity {
    private Messaggio_utentePresenter messaggio_utentePresenter;
    private UtentePresenter utentePresenter;
    private CameriereMessaggiActivity cameriereMessaggiActivity;
    private RecyclerView recyclerView;
    private TextView visualizza_messaggio;
    private Button btn_visualizza;

    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameriere_messaggi);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "CameriereMessaggi");
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "CameriereMessaggiActivity");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);

        ImageButton logout = (ImageButton) findViewById(R.id.cameriere_logout);
        ImageButton aggiungi_tavolo = (ImageButton) findViewById(R.id.cameriere_aggiungi_tavolo);
        ImageButton visualizza_comanda = (ImageButton) findViewById(R.id.cameriere_visualizza_comanda);
        ImageButton messaggi = (ImageButton) findViewById(R.id.cameriere_messaggi);
        ImageButton ordinazioni = (ImageButton) findViewById(R.id.cameriere_ordinazioni);
        btn_visualizza = (Button) findViewById(R.id.btn_visualizza);

        recyclerView = findViewById(R.id.cameriere_lista_messaggi);
        visualizza_messaggio = findViewById(R.id.textView_mex_cam);

        messaggio_utentePresenter = Messaggio_utentePresenter.getInstance();
        utentePresenter = UtentePresenter.getInstance();

        messaggio_utentePresenter.setCameriereMessaggiActivity(this);
        messaggio_utentePresenter.getAllMessaggioUtente(utentePresenter.getUtente().getRuolo(), utentePresenter.getUtente().getUser_name(), null);

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
                messaggio_utentePresenter.setLetto();
            }
        });
    }

    public void stampaMessaggi(){
        if(messaggio_utentePresenter.getMessaggi_utenti().size() != 0){
            List<Messaggio_utente> messaggi = messaggio_utentePresenter.getMessaggi_utenti();

            MessaggiAdapter messaggiAdapter = new MessaggiAdapter(cameriereMessaggiActivity.getApplicationContext(), messaggi, visualizza_messaggio);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(messaggiAdapter);
        }
        else
            btn_visualizza.setEnabled(false);

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