package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

import java.util.ArrayList;

public class AdminModificaEliminaMenuActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private AdminModificaEliminaMenuActivity adminModificaEliminaMenuActivity;
    private PiattoPresenter piattoPresenter = PiattoPresenter.getInstance();


    private EditText editTextNome;
    private EditText editTextDescrizione;
    private Spinner spinner_admin_modifica;
    private EditText editTextCosto;
    private EditText editTextAllergeni;
    private EditText editTextPosizione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_modifica_elimina_menu);

        utentePresenter = UtentePresenter.getInstance();

        ImageButton btn_admin_logout = (ImageButton) findViewById(R.id.admin_logout);
        ImageButton btn_admin_aggiungi_piatto = (ImageButton) findViewById(R.id.admin_aggiungi_piatto);
        ImageButton btn_admin_modifica_menu = (ImageButton) findViewById(R.id.admin_modifica_menu);
        ImageButton btn_admin_messaggi = (ImageButton) findViewById(R.id.admin_messaggi);
        ImageButton btn_admin_statistiche = (ImageButton) findViewById(R.id.admin_statistiche);
        ImageButton btn_admin_add_utente = (ImageButton) findViewById(R.id.admin_add_utente);

        editTextNome = (EditText) findViewById(R.id.textView_nome_admin);
        editTextDescrizione = (EditText) findViewById(R.id.textView_descrizione_admin);
        spinner_admin_modifica = (Spinner) findViewById(R.id.spinner_admin_modifica_);
        editTextCosto = (EditText) findViewById(R.id.textView_costo_admin);
        editTextAllergeni = (EditText) findViewById(R.id.textView_allergeni_admin);
        editTextPosizione = (EditText) findViewById(R.id.textView_posizione_admin);

        ArrayList<String> categorie = new ArrayList<>();
        categorie.add("antipasti");
        categorie.add("primi");
        categorie.add("secondi");
        categorie.add("contorni");
        categorie.add("dolci");
        categorie.add("bevande");
        categorie.add("frutta");
        categorie.add("varie");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categorie, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_admin_modifica.setAdapter(adapter);



        adminModificaEliminaMenuActivity = this;

        editTextNome.setText(piattoPresenter.getPiatto().getNome());
        editTextDescrizione.setText(piattoPresenter.getPiatto().getDescrizione());
        //spinner_supervisore_modifica;
        editTextCosto.setText(String.valueOf(piattoPresenter.getPiatto().getCosto()));
        editTextAllergeni.setText(piattoPresenter.getPiatto().getAllergeni());
        editTextPosizione.setText(String.valueOf(piattoPresenter.getPiatto().getPosto()));

        btn_admin_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(adminModificaEliminaMenuActivity);
            }
        });

        btn_admin_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAggiungiPiatto(adminModificaEliminaMenuActivity);
            }
        });

        btn_admin_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminModificaMenu(adminModificaEliminaMenuActivity);
            }
        });

        btn_admin_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminMessaggi(adminModificaEliminaMenuActivity);
            }
        });

        btn_admin_statistiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminStatistiche(adminModificaEliminaMenuActivity);
            }
        });

        btn_admin_add_utente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAddUtente(adminModificaEliminaMenuActivity);
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
}