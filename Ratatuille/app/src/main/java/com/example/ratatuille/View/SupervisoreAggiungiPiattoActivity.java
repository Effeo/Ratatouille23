package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class SupervisoreAggiungiPiattoActivity extends AppCompatActivity {

    private UtentePresenter utentePresenter;
    private SupervisoreAggiungiPiattoActivity supervisoreAggiungiPiattoActivity;
    private EditText editNome;
    private EditText editCosto;
    private EditText editDescrizione;
    private EditText editAllergeni;
    private Spinner spinnerCategoria;
    private EditText editPosizione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisore_aggiungi_piatto);

        utentePresenter = UtentePresenter.getInstance();
        supervisoreAggiungiPiattoActivity = this;

        ImageButton btnLogout = (ImageButton) findViewById(R.id.supervisore_logout);
        ImageButton btnAgginugiPiatto = (ImageButton) findViewById(R.id.supervisore_aggiungi_piatto);
        ImageButton btnModificaMenu = (ImageButton) findViewById(R.id.supervisore_modifica_menu);
        ImageButton btnConto = (ImageButton) findViewById(R.id.supervisore_conto);
        ImageButton btnMessaggi = (ImageButton) findViewById(R.id.supervisore_conto);

        Button btnAggiungi = (Button) findViewById(R.id.btn_aggiungi);

        editNome = (EditText) findViewById(R.id.textView_nome);
        editCosto = (EditText) findViewById(R.id.textView_costo);
        editDescrizione = (EditText) findViewById(R.id.textView_descrizione);
        editAllergeni = (EditText) findViewById(R.id.textView_allergeni);
        spinnerCategoria = (Spinner) findViewById(R.id.spinner_supervisore_aggiungi);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(supervisoreAggiungiPiattoActivity);
            }
        });

        btnModificaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreModificaMenu(supervisoreAggiungiPiattoActivity);
            }
        });

        btnConto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreConto(supervisoreAggiungiPiattoActivity);
            }
        });

        btnMessaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreMessaggi(supervisoreAggiungiPiattoActivity);
            }
        });

        btnAgginugiPiatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreAggiungiPiatto(supervisoreAggiungiPiattoActivity);
            }
        });
    }
}