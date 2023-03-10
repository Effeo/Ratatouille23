package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class MainActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button amministratore_b = (Button) findViewById(R.id.btn_scarica);
        Button supervisore_b = (Button) findViewById(R.id.btn_chiudi);
        Button cameriere_b = (Button) findViewById(R.id.button_3);
        Button cuoco_b = (Button) findViewById(R.id.button_4);

        utentePresenter = UtentePresenter.getInstance();
        utentePresenter.setMainActivity(this);

        amministratore_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                utentePresenter.goLogin();
            }
        });

        supervisore_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                utentePresenter.goLogin();
            }
        });

        cameriere_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                utentePresenter.goLogin();
            }

        });

        cuoco_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                utentePresenter.goLogin();
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