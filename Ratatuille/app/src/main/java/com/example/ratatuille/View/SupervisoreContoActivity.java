package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ratatuille.Presenter.ContoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SupervisoreContoActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private ContoPresenter contoPresenter;

    private SupervisoreContoActivity supervisoreContoActivity;

    int pageHeight = 1120;
    int pagewidth = 792;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisore_conto);

        utentePresenter = UtentePresenter.getInstance();
        contoPresenter = ContoPresenter.getInstance();

        Button btn_scarica = (Button) findViewById(R.id.btn_scarica);
        Button btn_chiudi = (Button) findViewById(R.id.btn_chiudi);

        ImageButton btn_supervisore_logout = (ImageButton)  findViewById(R.id.supervisore_logout);
        ImageButton btn_supervisore_aggiungi_piatto = (ImageButton) findViewById(R.id.supervisore_aggiungi_piatto);
        ImageButton btn_supervisore_modifica_menu = (ImageButton) findViewById(R.id.supervisore_modifica_menu);
        ImageButton btn_supervisore_conto = (ImageButton) findViewById(R.id.supervisore_conto);
        ImageButton btn_supervisore_messaggi = (ImageButton) findViewById(R.id.supervisore_messaggi);

        supervisoreContoActivity = this;
        contoPresenter.setSupervisoreContoActivity(this);
        contoPresenter.getAllConti();


        btn_supervisore_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(supervisoreContoActivity);
            }
        });

        btn_supervisore_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreAggiungiPiatto(supervisoreContoActivity);
            }
        });

        btn_supervisore_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreModificaMenu(supervisoreContoActivity);
            }
        });

        btn_supervisore_conto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreConto(supervisoreContoActivity);
            }
        });

        btn_supervisore_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goSupervisoreMessaggi(supervisoreContoActivity);
            }
        });

        btn_scarica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inserire il conto da prendere per ora per i test è 0
                //contoPresenter.scarica(contoPresenter.getConti().get(0));
                prova();
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

    public void stampaConti(){
        for(int i = 0; i < contoPresenter.getConti().size(); i++){
            System.out.println("id_conto:" + contoPresenter.getConti().get(i).getId_conto());
            System.out.println("chiuso:" + contoPresenter.getConti().get(i).getChiuso());
            System.out.println("costo:" + contoPresenter.getConti().get(i).getCosto());
            System.out.println("data:" + contoPresenter.getConti().get(i).getData());
            System.out.println("id_tavolo:" + contoPresenter.getConti().get(i).getId_tavolo());
        }
    }

    private void prova(){
        Document document = new Document();

        String fileName = "conto.pdf";

        try {
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            if (!dir.exists()) {
                dir.mkdir();
            }

            File file = new File(dir, fileName);

            PdfWriter.getInstance(document, new FileOutputStream(file));

            document.open();

            Paragraph paragraph = new Paragraph("Hello, world!");
            document.add(paragraph);

            document.close();

            Toast.makeText(this, "File pdf creato con successo", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}