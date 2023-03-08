package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ratatuille.Presenter.Messaggio_utentePresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class CuocoMessaggiActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private Messaggio_utentePresenter messaggio_utentePresenter;
    private CuocoMessaggiActivity cuocoMessaggiActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuoco_messaggi);

        ImageButton logout = (ImageButton) findViewById(R.id.cuoco_logout);
        ImageButton messaggi = (ImageButton) findViewById(R.id.cuoco_messaggi);
        ImageButton ordinazioni = (ImageButton) findViewById(R.id.cuoco_ordinazioni);
        Button btn_visualizza = (Button) findViewById(R.id.btn_visualizza);

        messaggio_utentePresenter = Messaggio_utentePresenter.getInstance();
        utentePresenter = UtentePresenter.getInstance();

        messaggio_utentePresenter.setCuocoMessaggiActivity(this);
        messaggio_utentePresenter.getAllMessaggioUtente(utentePresenter.getUtente().getRuolo(), utentePresenter.getUtente().getUser_name());

        cuocoMessaggiActivity = this;

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.logOut(cuocoMessaggiActivity);
            }
        });

        messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goMessaggiCuoco(cuocoMessaggiActivity);
            }
        });

        //cambiare tutto per adattarlo agli ordini
        ordinazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utentePresenter.goOrdinazioniCuoco(cuocoMessaggiActivity);
            }
        });

        btn_visualizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messaggio_utentePresenter.setLetto(0);
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

    public void stampaMessaggi(){
        for(int i = 0; i < messaggio_utentePresenter.getMessaggi_utenti().size(); i++){
            System.out.println(messaggio_utentePresenter.getMessaggi_utenti().get(i).getMessaggio().getCorpo());
        }
    }
}