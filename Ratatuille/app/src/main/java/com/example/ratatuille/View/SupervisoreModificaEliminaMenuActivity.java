package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;
import com.google.firebase.analytics.FirebaseAnalytics;

public class SupervisoreModificaEliminaMenuActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private SupervisoreModificaEliminaMenuActivity supervisoreModificaEliminaMenuActivity;
    private PiattoPresenter piattoPresenter;

    public EditText editNome;
    public EditText editDescrizione;
    public Spinner spinnerCategoria;
    public EditText editCosto;
    public EditText editAllergeni;
    public EditText editPosizione;

    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisore_modifica_elimina_menu);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "SupervisoreModificaEliminaMenu");
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "SupervisoreModificaEliminaMenuActivity");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);

        utentePresenter = UtentePresenter.getInstance();
        piattoPresenter = PiattoPresenter.getInstance();

        Button btn_modifica = (Button) findViewById(R.id.btn_modifica);
        Button btn_torna_inidetro = (Button) findViewById(R.id.btn_torna_indietro);
        Button btn_elimina = (Button) findViewById(R.id.btn_elimina);

        ImageButton btn_supervisore_logout = (ImageButton)  findViewById(R.id.supervisore_logout);
        ImageButton btn_supervisore_aggiungi_piatto = (ImageButton) findViewById(R.id.supervisore_aggiungi_piatto);
        ImageButton btn_supervisore_modifica_menu = (ImageButton) findViewById(R.id.supervisore_modifica_menu);
        ImageButton btn_supervisore_conto = (ImageButton) findViewById(R.id.supervisore_conto);
        ImageButton btn_supervisore_messaggi = (ImageButton) findViewById(R.id.supervisore_messaggi);

        editNome = (EditText) findViewById(R.id.textView_nome);
        editDescrizione = (EditText) findViewById(R.id.textView_descrizione);
        spinnerCategoria = (Spinner) findViewById(R.id.spinner_supervisore_modifica);
        editCosto = (EditText) findViewById(R.id.textView_costo);
        editAllergeni = (EditText) findViewById(R.id.textView_allergeni);
        editPosizione = (EditText) findViewById(R.id.textView_posizione);

        supervisoreModificaEliminaMenuActivity = this;

        editNome.setText(piattoPresenter.getPiatto().getNome());
        editDescrizione.setText(piattoPresenter.getPiatto().getDescrizione());
        editCosto.setInputType(InputType.TYPE_CLASS_NUMBER);
        editCosto.setText(String.valueOf(piattoPresenter.getPiatto().getCosto()));
        editAllergeni.setText(piattoPresenter.getPiatto().getAllergeni());
        editPosizione.setInputType(InputType.TYPE_CLASS_NUMBER);
        editPosizione.setText(String.valueOf(piattoPresenter.getPiatto().getPosto()));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categorie, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapter);

        btn_supervisore_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(supervisoreModificaEliminaMenuActivity);
            }
        });

        btn_supervisore_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreAggiungiPiatto(supervisoreModificaEliminaMenuActivity);
            }
        });

        btn_supervisore_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreModificaMenu(supervisoreModificaEliminaMenuActivity);
            }
        });

        btn_supervisore_conto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreConto(supervisoreModificaEliminaMenuActivity);
            }
        });

        btn_supervisore_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreMessaggi(supervisoreModificaEliminaMenuActivity);
            }
        });

        btn_torna_inidetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreModificaMenu(supervisoreModificaEliminaMenuActivity);
            }
        });

        btn_elimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                piattoPresenter.delete(supervisoreModificaEliminaMenuActivity, utentePresenter.getUtente().getRuolo(), piattoPresenter.getPiatto());
            }
        });

        btn_modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                piattoPresenter.update(supervisoreModificaEliminaMenuActivity, utentePresenter.getUtente().getRuolo(), piattoPresenter.getPiatto());
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