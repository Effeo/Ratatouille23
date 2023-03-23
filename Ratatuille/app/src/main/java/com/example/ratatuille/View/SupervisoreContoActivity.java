package com.example.ratatuille.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ratatuille.Adapter.ListaOrdiniAdapter;
import com.example.ratatuille.Adapter.ListaTavoliContoAdapter;
import com.example.ratatuille.Model.Conto;
import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Presenter.ContoPresenter;
import com.example.ratatuille.Presenter.Ordine_piattoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SupervisoreContoActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private ContoPresenter contoPresenter;
    private Ordine_piattoPresenter ordine_piattoPresenter;

    private SupervisoreContoActivity supervisoreContoActivity;
    private Button btn_scarica;
    private Button btn_chiudi;
    private RecyclerView recyclerView_tavoli;
    private RecyclerView recyclerView_conti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisore_conto);

        utentePresenter = UtentePresenter.getInstance();
        contoPresenter = ContoPresenter.getInstance();
        ordine_piattoPresenter = Ordine_piattoPresenter.getInstance();

        ordine_piattoPresenter.findAllOrdiniPiatti(utentePresenter.getUtente().getRuolo());

        btn_scarica = (Button) findViewById(R.id.btn_scarica);
        btn_chiudi = (Button) findViewById(R.id.btn_chiudi);

        ImageButton btn_supervisore_logout = (ImageButton)  findViewById(R.id.supervisore_logout);
        ImageButton btn_supervisore_aggiungi_piatto = (ImageButton) findViewById(R.id.supervisore_aggiungi_piatto);
        ImageButton btn_supervisore_modifica_menu = (ImageButton) findViewById(R.id.supervisore_modifica_menu);
        ImageButton btn_supervisore_conto = (ImageButton) findViewById(R.id.supervisore_conto);
        ImageButton btn_supervisore_messaggi = (ImageButton) findViewById(R.id.supervisore_messaggi);

        recyclerView_conti = findViewById(R.id.supervisore_conto_del_tavolo);
        recyclerView_tavoli = findViewById(R.id.supervisore_lista_tavoli_conto);

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
                System.out.println("Scarica");
                scaricaConto();
            }
        });

        btn_chiudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inserire il conto giusto
                System.out.println("Chiudi");
                contoPresenter.update(contoPresenter.getPosizione_conto());
                utentePresenter.goSupervisoreConto(supervisoreContoActivity);
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
        if(contoPresenter.getConti().size() != 0){
            List<Conto> conto_tavoli = contoPresenter.getConti();

            ListaTavoliContoAdapter listaTavoliContoAdapter = new ListaTavoliContoAdapter(supervisoreContoActivity.getApplicationContext(), conto_tavoli, recyclerView_conti);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView_tavoli.setLayoutManager(linearLayoutManager);
            recyclerView_tavoli.setAdapter(listaTavoliContoAdapter);
        }
        else{
            btn_chiudi.setEnabled(false);
            btn_scarica.setEnabled(false);
        }


    }

    public void scaricaConto(){
        Document document = new Document();
        String fileName = null;
        String folder = "PdfIngsw";

        if(contoPresenter.getConti().get(contoPresenter.getPosizione_conto()).getChiuso() == 0)
            fileName = "ContoScaricato.pdf";
        else{
            fileName = "ContoChiusoScaricato.pdf";
            contoPresenter.setOrdini_piatti(new ArrayList<>());
        }

       try {
            System.out.println("crea il file");
            File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), folder);
            if (!dir.exists()) {
                dir.mkdir();
            }

           File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);

            if(file.exists()){
                System.out.println("Il file esiste lo elimino");
                file.delete();
            }

            PdfWriter.getInstance(document, new FileOutputStream(file));

            document.open();

            Paragraph paragraph = new Paragraph("Conto tavolo: " + contoPresenter.getConti().get(contoPresenter.getPosizione_conto()).getId_tavolo() + "\n\n");
            writePiatti(paragraph, contoPresenter.getPosizione_conto());
            paragraph.add("\n");
            paragraph.add("Costo totale: " +  contoPresenter.getConti().get(contoPresenter.getPosizione_conto()).getCosto() + "\n");
            paragraph.add("Data: " +  contoPresenter.getConti().get(contoPresenter.getPosizione_conto()).getData() + "\n");

            if(contoPresenter.getConti().get(contoPresenter.getPosizione_conto()).getChiuso() == 0){
                paragraph.add("Il conto non e' chiuso" + "\n");
                System.out.println("file non chiuso scaricato");
            }
            else{
                paragraph.add("Il conto e' chiuso" + "\n");
                System.out.println("file chiuso scaricato");
                removeOrdine_piatto();
            }

            document.add(paragraph);

            document.close();

            Toast.makeText(this, "File pdf creato con successo", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Errore nella creazione del file pdf", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void writePiatti(Paragraph paragraph, int i){
        for(int j = 0; j < ordine_piattoPresenter.getOrdini_piatti().size(); j++){
            if(ordine_piattoPresenter.getOrdini_piatti().get(j).getOrdine().getIdTavolo() == contoPresenter.getConti().get(i).getId_tavolo()){
                contoPresenter.getOrdini_piatti().add(ordine_piattoPresenter.getOrdini_piatti().get(j));

                paragraph.add(ordine_piattoPresenter.getOrdini_piatti().get(j).getPiatto().getNome() + " " +
                        ordine_piattoPresenter.getOrdini_piatti().get(j).getPiatto().getCosto() + "€ x " +
                        ordine_piattoPresenter.getOrdini_piatti().get(j).getQta() + "\n");
            }
        }
    }

    private void removeOrdine_piatto(){
        for(int i = 0; i < contoPresenter.getOrdini_piatti().size(); i++){
            System.out.println(contoPresenter.getOrdini_piatti().get(i).getId_ordine_piatto());
            ordine_piattoPresenter.delete(contoPresenter.getOrdini_piatti().get(i));
        }
    }
}