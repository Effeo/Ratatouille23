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
import android.widget.Toast;

import com.example.ratatuille.Presenter.OpenFoodPresenter;
import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;
import com.google.firebase.analytics.FirebaseAnalytics;

public class AdminAggiungiPiattoActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private PiattoPresenter piattoPresenter;
    private OpenFoodPresenter openFoodPresenter = OpenFoodPresenter.getInstance();

    private AdminAggiungiPiattoActivity adminAggiungiPiattoActivity;

    private FirebaseAnalytics firebaseAnalytics;

    public EditText editNome;
    public EditText editCosto;
    public EditText editDescrizione;
    public EditText editAllergeni;
    public Spinner spinnerCategoria;
    public EditText editPosizione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_aggiungi_piatto);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "AdminAggiungiPiatto");
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "AdminAggiungiPiattoActivity");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);

        utentePresenter = UtentePresenter.getInstance();
        piattoPresenter = PiattoPresenter.getInstance();

        Button btn_aggiungi = (Button) findViewById(R.id.btn_aggiungi);

        ImageButton btn_admin_logout = (ImageButton)  findViewById(R.id.admin_logout);
        ImageButton btn_admin_aggiungi_piatto = (ImageButton) findViewById(R.id.admin_aggiungi_piatto);
        ImageButton btn_admin_modifica_menu = (ImageButton) findViewById(R.id.admin_modifica_menu);
        ImageButton btn_admin_messaggi = (ImageButton) findViewById(R.id.admin_messaggi);
        ImageButton btn_admin_statistiche = (ImageButton) findViewById(R.id.admin_statistiche);
        ImageButton btn_admin_add_utente = (ImageButton) findViewById(R.id.admin_add_utente);

        editNome = (EditText) findViewById(R.id.textView_nome);
        editCosto = (EditText) findViewById(R.id.textView_costo);
        editDescrizione = (EditText) findViewById(R.id.textView_descrizione);
        editAllergeni = (EditText) findViewById(R.id.textView_allergeni);
        editPosizione = (EditText) findViewById(R.id.textView_posizione);
        spinnerCategoria = (Spinner) findViewById(R.id.spinner_admin_aggiungi);

        adminAggiungiPiattoActivity = this;
        openFoodPresenter.setAdminAggiungiPiattoActivity(this);

        editPosizione.setInputType(InputType.TYPE_CLASS_NUMBER);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categorie, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapter);

        btn_admin_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAggiungiPiatto(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminModificaMenu(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminMessaggi(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_statistiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminStatistiche(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_add_utente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAddUtente(adminAggiungiPiattoActivity);
            }
        });

        btn_admin_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAggiungiPiatto(adminAggiungiPiattoActivity);
            }
        });

        btn_aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editNome.getText().toString().equals("")){
                    if(editDescrizione.getText().toString().equals("") || editAllergeni.getText().toString().equals(""))
                        if(editDescrizione.getText().toString().equals(""))
                            openFoodPresenter.getDescrizione(editNome.getText().toString(), utentePresenter.getUtente().getRuolo());
                    if(editAllergeni.getText().toString().equals(""))
                        openFoodPresenter.getAllergeni(editNome.getText().toString(), utentePresenter.getUtente().getRuolo());
                    else
                        piattoPresenter.create(adminAggiungiPiattoActivity, utentePresenter.getUtente().getRuolo());
                }
                else
                    Toast.makeText(adminAggiungiPiattoActivity, "Inserire un nome", Toast.LENGTH_SHORT).show();
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

    public void setDescrizione(){
        editDescrizione.setText(openFoodPresenter.getDescrizione());
    }

    public void setAllergeni(){
        editAllergeni.setText(openFoodPresenter.getAllergeni());
    }



}