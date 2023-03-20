package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ratatuille.Adapter.CategoriaAdapter;
import com.example.ratatuille.Adapter.ListaPiattiOrdinatiAdapter;
import com.example.ratatuille.Adapter.MostraComandaAdapter;
import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Presenter.Ordine_piattoPresenter;
import com.example.ratatuille.R;

import java.util.ArrayList;

public class CameriereComandaActivity extends AppCompatActivity {

    private Ordine_piattoPresenter comanda = Ordine_piattoPresenter.getInstance();
    private RecyclerView recyclerView;
    private TextView textView_mostra_conto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameriere_comanda);

        Button torna_indietro = (Button) findViewById(R.id.btn_torna_indietro);

        torna_indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //la gestione del bottone va fatto in un presenter
                Intent finestraCameriereVisualizzaComanda = new Intent(view.getContext(), CameriereOrdinazioniActivity.class);
                startActivity(finestraCameriereVisualizzaComanda);
            }
        });

        recyclerView = findViewById(R.id.mostra_ordine);
        textView_mostra_conto = findViewById(R.id.testo_totale_conto);

        float costo_totale = 0;
        float tmp = 0;
        for (int i = 0; i < comanda.getOrdini_piatti().size(); i++){
            tmp = (comanda.getOrdini_piatti().get(i).getQta()) * (comanda.getOrdini_piatti().get(i).getPiatto().getCosto());
            costo_totale += tmp;
        }

        textView_mostra_conto.setText("Tot " + String.valueOf(costo_totale) + "€");

        MostraComandaAdapter mostraComandaAdapter = new MostraComandaAdapter(this, (ArrayList<Ordine_piatto>) comanda.getOrdini_piatti());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mostraComandaAdapter);

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