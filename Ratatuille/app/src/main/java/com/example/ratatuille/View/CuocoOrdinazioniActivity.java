package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ratatuille.Adapter.CategoriaAdapter;
import com.example.ratatuille.Adapter.ListaOrdiniAdapter;
import com.example.ratatuille.Model.Ordine;
import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Presenter.Ordine_piattoPresenter;
import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CuocoOrdinazioniActivity extends AppCompatActivity {
    private Ordine_piattoPresenter ordine_piattoPresenter;
    private CuocoOrdinazioniActivity cuocoOrdinazioniActivity;
    private UtentePresenter utentePresenter;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView_c;
    private TextView visualizza_messaggio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuoco_ordinazioni);

        ImageButton logout = (ImageButton) findViewById(R.id.cuoco_logout);
        ImageButton messaggi = (ImageButton) findViewById(R.id.cuoco_messaggi);
        ImageButton ordinazioni = (ImageButton) findViewById(R.id.cuoco_ordinazioni);

        recyclerView = findViewById(R.id.lista_tavoli_ordinazioni);
        recyclerView_c = findViewById(R.id.lista_piatti_ordinati);

        utentePresenter = UtentePresenter.getInstance();

        ordine_piattoPresenter = Ordine_piattoPresenter.getInstance();
        ordine_piattoPresenter.setCuocoOrdinazioniActivity(this);

        ordine_piattoPresenter.findAllOrdiniPiatti(utentePresenter.getUtente().getRuolo());

        cuocoOrdinazioniActivity = this;



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.logOut(cuocoOrdinazioniActivity);
            }
        });

        messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goMessaggiCuoco(cuocoOrdinazioniActivity);
            }
        });


        //cambiare tutto per adattarlo agli ordini
        ordinazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goOrdinazioniCuoco(cuocoOrdinazioniActivity);
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

    public void stampaOrdiniPiatti(){
        List<Ordine_piatto> ordine_piatti = ordine_piattoPresenter.getOrdini_piatti();

        ArrayList<Ordine_piatto> piattiSenzaDuplicati = new ArrayList<>();

        piattiSenzaDuplicati.add(ordine_piatti.get(0));
        for (int i = 0; i < ordine_piatti.size(); i++){
            for (int j = 0; j < piattiSenzaDuplicati.size(); j++){
                if (ordine_piatti.get(i).getOrdine().getIdTavolo() != piattiSenzaDuplicati.get(j).getOrdine().getIdTavolo()){
                    piattiSenzaDuplicati.add(ordine_piatti.get(i));
                }
            }
        }

        ListaOrdiniAdapter listaOrdiniAdapter = new ListaOrdiniAdapter(cuocoOrdinazioniActivity.getApplicationContext(), piattiSenzaDuplicati, recyclerView_c);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listaOrdiniAdapter);

    }
}