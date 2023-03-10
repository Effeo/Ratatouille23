package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class SupervisoreAggiungiPiattoActivity extends AppCompatActivity {

    private UtentePresenter utentePresenter;
    private PiattoPresenter piattoPresenter;

    private SupervisoreAggiungiPiattoActivity supervisoreAggiungiPiattoActivity;

    public EditText editNome;
    public EditText editCosto;
    public EditText editDescrizione;
    public EditText editAllergeni;
    public Spinner spinnerCategoria;
    public EditText editPosizione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisore_aggiungi_piatto);

        utentePresenter = UtentePresenter.getInstance();
        piattoPresenter = PiattoPresenter.getInstance();

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
        editPosizione = (EditText) findViewById(R.id.textView_posizione);
        spinnerCategoria = (Spinner) findViewById(R.id.spinner_supervisore_aggiungi);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categorie, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapter);

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

        btnAggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                piattoPresenter.create(supervisoreAggiungiPiattoActivity);
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