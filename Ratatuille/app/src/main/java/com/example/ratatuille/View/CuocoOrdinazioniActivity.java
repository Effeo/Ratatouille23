package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ratatuille.Presenter.Ordine_piattoPresenter;
import com.example.ratatuille.Presenter.PiattoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class CuocoOrdinazioniActivity extends AppCompatActivity {
    private Ordine_piattoPresenter ordine_piattoPresenter;
    private CuocoOrdinazioniActivity cuocoOrdinazioniActivity;
    private UtentePresenter utentePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuoco_ordinazioni);

        ImageButton logout = (ImageButton) findViewById(R.id.cuoco_logout);
        ImageButton messaggi = (ImageButton) findViewById(R.id.cuoco_messaggi);
        ImageButton ordinazioni = (ImageButton) findViewById(R.id.cuoco_ordinazioni);

        utentePresenter = UtentePresenter.getInstance();

        ordine_piattoPresenter = Ordine_piattoPresenter.getInstance();
        ordine_piattoPresenter.setCuocoOrdinazioniActivity(this);

        ordine_piattoPresenter.findAllOrdiniPiatti();

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
        for(int i = 0; i < ordine_piattoPresenter.getOrdini_piatti().size(); i++){
            System.out.println("tavolo: " + ordine_piattoPresenter.getOrdini_piatti().get(i).getOrdine().getIdTavolo());
            System.out.println(ordine_piattoPresenter.getOrdini_piatti().get(i).getPiatto().getNome());
        }
    }
}