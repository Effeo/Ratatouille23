package com.example.ratatuille.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Presenter.ContoPresenter;
import com.example.ratatuille.Presenter.OrdinePresenter;
import com.example.ratatuille.Presenter.Ordine_piattoPresenter;
import com.example.ratatuille.Presenter.TavoloPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class CameriereAggiungiTavoloActivity extends AppCompatActivity {
    private CameriereAggiungiTavoloActivity cameriereAggiungiTavoloActivity;

    private UtentePresenter utentePresenter = UtentePresenter.getInstance();
    private OrdinePresenter ordinePresenter = OrdinePresenter.getInstance();
    private Ordine_piattoPresenter ordine_piattoPresenter = Ordine_piattoPresenter.getInstance();
    private TavoloPresenter tavoloPresenter = TavoloPresenter.getInstance();
    private ContoPresenter contoPresenter = ContoPresenter.getInstance();

    private EditText editTavolo;
    private int id_tavolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameriere_aggiungi_tavolo);

        Button conferma = (Button) findViewById(R.id.button_conferma);
        Button torna_indietro = (Button) findViewById(R.id.btn_torna_indietro);

        editTavolo = (EditText) findViewById(R.id.edit_id_tavolo);

        tavoloPresenter.getAllTavoli();

        cameriereAggiungiTavoloActivity = this;
        ordinePresenter.setCameriereAggiungiTavoloActivity(this);
        contoPresenter.setCameriereAggiungiTavoloActivity(this);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ordine_piattoPresenter.getOrdini_piatti().size() != 0)
                    if(checkIdTavolo())
                        ordinePresenter.create(Integer.parseInt(editTavolo.getText().toString()));
                    else
                        Toast.makeText(cameriereAggiungiTavoloActivity.getApplicationContext(), "Numero tavolo non valido", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(cameriereAggiungiTavoloActivity.getApplicationContext(), "Non ci sono ordinazioni", Toast.LENGTH_SHORT).show();
            }
        });

        torna_indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goCameriereOrdinazioni(cameriereAggiungiTavoloActivity);
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

    public void chiamaOrdine(){
        ordinePresenter.getGreatest();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertOrdine_piatto(){
        int i;
        float tot = 0;

        for(i = 0; i < ordine_piattoPresenter.getOrdini_piatti().size(); i++){
            tot += ordine_piattoPresenter.getOrdini_piatti().get(i).getQta() * ordine_piattoPresenter.getOrdini_piatti().get(i).getPiatto().getCosto();

            ordine_piattoPresenter.getOrdini_piatti().get(i).setOrdine(ordinePresenter.getOrdine());
            ordine_piattoPresenter.create(ordine_piattoPresenter.getOrdini_piatti().get(i));
        }

        contoPresenter.create(tot, id_tavolo);

    }

    public boolean checkIdTavolo(){
        boolean trovato = false;
        int i = 0;

        if(!editTavolo.getText().toString().equals("")) {
            id_tavolo = Integer.parseInt(editTavolo.getText().toString());

            while (!trovato && i < tavoloPresenter.getTavoli().size()) {
                if (id_tavolo == tavoloPresenter.getTavoli().get(i).getId_tavolo())
                    trovato = true;

                i++;
            }
        }

        return trovato;
    }
}