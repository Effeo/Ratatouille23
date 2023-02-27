package com.example.ratatuille;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button amministratore_b = (Button) findViewById(R.id.button_1);
        Button supervisore_b = (Button) findViewById(R.id.button_2);
        Button cameriere_b = (Button) findViewById(R.id.button_3);
        Button cuoco_b = (Button) findViewById(R.id.button_4);


        amministratore_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent finestraLogin = new Intent(view.getContext(), LoginActivity.class);
                startActivity(finestraLogin);
            }
        });

        supervisore_b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent finestraLogin = new Intent(view.getContext(), LoginActivity.class);
                startActivity(finestraLogin);
            }
        });

        cameriere_b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent finestraLogin = new Intent(view.getContext(), LoginActivity.class);
                startActivity(finestraLogin);
            }
        });

        cuoco_b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent finestraLogin = new Intent(view.getContext(), LoginActivity.class);
                startActivity(finestraLogin);
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