package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ratatuille.Adapter.CategoriePerModificareAdapter;
import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;

public class AdminModificaMenuActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private PiattoPresenter piattoPresenter;
    private RecyclerView recyclerView_categorie;
    private RecyclerView recyclerView_piatti;

    private FirebaseAnalytics firebaseAnalytics;

    private AdminModificaMenuActivity adminModificaMenuActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_modifica_menu);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "AdminModificaMenu");
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "AdminModificaMenuActivity");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);

        utentePresenter = UtentePresenter.getInstance();
        piattoPresenter = PiattoPresenter.getInstance();
        recyclerView_categorie = findViewById(R.id.categorie_da_poter_modificare_admin);
        recyclerView_piatti = findViewById(R.id.piatti_da_poter_modificare_admin);

        piattoPresenter.setAdminModificaMenuActivity(this);

        ImageButton btn_admin_logout = (ImageButton)  findViewById(R.id.admin_logout);
        ImageButton btn_admin_aggiungi_piatto = (ImageButton) findViewById(R.id.admin_aggiungi_piatto);
        ImageButton btn_admin_modifica_menu = (ImageButton) findViewById(R.id.admin_modifica_menu);
        ImageButton btn_admin_messaggi = (ImageButton) findViewById(R.id.admin_messaggi);
        ImageButton btn_admin_statistiche = (ImageButton) findViewById(R.id.admin_statistiche);
        ImageButton btn_admin_add_utente = (ImageButton) findViewById(R.id.admin_add_utente);

        adminModificaMenuActivity = this;

        ArrayList<String> categorie = new ArrayList<>();
        categorie.add("antipasti");
        categorie.add("primi");
        categorie.add("secondi");
        categorie.add("contorni");
        categorie.add("dolci");
        categorie.add("bevande");
        categorie.add("frutta");
        categorie.add("varie");

        CategoriePerModificareAdapter categoriePerModificareAdapter = new CategoriePerModificareAdapter(this, categorie, recyclerView_piatti);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_categorie.setLayoutManager(linearLayoutManager);
        recyclerView_categorie.setAdapter(categoriePerModificareAdapter);

        piattoPresenter.getAllPiatti(utentePresenter.getUtente().getRuolo());

        btn_admin_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(adminModificaMenuActivity);
            }
        });

        btn_admin_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAggiungiPiatto(adminModificaMenuActivity);
            }
        });

        btn_admin_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminModificaMenu(adminModificaMenuActivity);
            }
        });

        btn_admin_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminMessaggi(adminModificaMenuActivity);
            }
        });

        btn_admin_statistiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminStatistiche(adminModificaMenuActivity);
            }
        });

        btn_admin_add_utente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAddUtente(adminModificaMenuActivity);
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

    public void stampaPiatti(){
        for(int i = 0; i < piattoPresenter.getPiatti().size(); i++){
            System.out.println(piattoPresenter.getPiatti().get(i).getNome());
        }
    }
}