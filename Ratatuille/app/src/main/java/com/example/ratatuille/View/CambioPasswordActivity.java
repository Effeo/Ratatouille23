package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class CambioPasswordActivity extends AppCompatActivity {

    private UtentePresenter utentePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_password);

        EditText edit_nuova_password = (EditText) findViewById(R.id.nuova_password);
        EditText edit_conferma_password = (EditText) findViewById(R.id.conferma_password);

        Button continua = (Button) findViewById(R.id.button_continua);

        utentePresenter = UtentePresenter.getInstance();
        utentePresenter.setCambioPasswordActivity(this);

        continua.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(edit_nuova_password.getText().toString().equals(edit_conferma_password.getText().toString())){
                    utentePresenter.cambiaPassword(edit_nuova_password.getText().toString());
                }
                else {
                    //aggiungere pop up message
                    System.out.println("Password diverse");
                }
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