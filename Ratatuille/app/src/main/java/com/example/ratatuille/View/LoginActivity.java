package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

public class LoginActivity extends AppCompatActivity {

    private UtentePresenter utentePresenter;
    private EditText edit_username;
    private EditText edit_password;
    private LoginActivity loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_password = (EditText) findViewById(R.id.edit_password);

        Button login_b = (Button) findViewById(R.id.btn_scarica);
        Button torna_indietro_b = (Button) findViewById(R.id.btn_chiudi);

        utentePresenter = UtentePresenter.getInstance();
        utentePresenter.setLoginActivity(this);
        //L'amministratore va direttamente sulla sua schermata principale

        loginActivity = this;

        login_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                utentePresenter.login(edit_username.getText().toString(), edit_password.getText().toString());
            }
        });

        torna_indietro_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                utentePresenter.logOut(loginActivity);
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