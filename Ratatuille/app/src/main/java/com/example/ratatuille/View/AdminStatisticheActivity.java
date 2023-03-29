package com.example.ratatuille.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ratatuille.Presenter.ContoPresenter;
import com.example.ratatuille.Presenter.UtentePresenter;
import com.example.ratatuille.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdminStatisticheActivity extends AppCompatActivity {
    private UtentePresenter utentePresenter;
    private ContoPresenter contoPresenter = ContoPresenter.getInstance();

    private AdminStatisticheActivity adminStatisticheActivity;

    public TextView textIncassoMedio;
    public TextView textValoreMedioConto;
    public TextView textIncassoComplessivo;

    public Spinner spinnerAnnoInizio;
    public Spinner spinnerMeseInizio;
    public Spinner spinnerGiornoInizio;

    public Spinner spinnerAnnoFine;
    public Spinner spinnerMeseFine;
    public Spinner spinnerGiornoFine;

    public String anno_inizio;
    public String mese_inizio;
    public String giorno_inizio;

    public String anno_fine;
    public String mese_fine;
    public String giorno_fine;

    public BarChart barChart;

    private ArrayList<BarEntry> barArraylist;

    private BarDataSet barDataSet;
    private BarData barData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_statistiche);

        utentePresenter = UtentePresenter.getInstance();

        ImageButton btn_admin_logout = (ImageButton)  findViewById(R.id.admin_logout);
        ImageButton btn_admin_aggiungi_piatto = (ImageButton) findViewById(R.id.admin_aggiungi_piatto);
        ImageButton btn_admin_modifica_menu = (ImageButton) findViewById(R.id.admin_modifica_menu);
        ImageButton btn_admin_messaggi = (ImageButton) findViewById(R.id.admin_messaggi);
        ImageButton btn_admin_statistiche = (ImageButton) findViewById(R.id.admin_statistiche);
        ImageButton btn_admin_add_utente = (ImageButton) findViewById(R.id.admin_add_utente);

        Button btn_calcola = (Button) findViewById(R.id.button_calcola);

        textIncassoMedio = (TextView) findViewById(R.id.incasso_medio);
        textValoreMedioConto = (TextView) findViewById(R.id.incasso_medio);
        textIncassoComplessivo = (TextView) findViewById(R.id.incasso_complessivo);

        spinnerAnnoInizio = (Spinner) findViewById(R.id.spinner_anno_di_inizio);
        spinnerMeseInizio = (Spinner) findViewById(R.id.spinner_mese_di_inizio);
        spinnerGiornoInizio = (Spinner) findViewById(R.id.spinner_giorno_di_inizio);

        spinnerAnnoFine = (Spinner) findViewById(R.id.spinner_anno_di_fine);
        spinnerMeseFine = (Spinner) findViewById(R.id.spinner_mese_di_fine);
        spinnerGiornoFine = (Spinner) findViewById(R.id.spinner_giorno_di_fine);

        barChart = (BarChart) findViewById(R.id.mostra_grafica_statistiche);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.anni_inizio, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAnnoInizio.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.mesi_inizio, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMeseInizio.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.giorni_inizio, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGiornoInizio.setAdapter(adapter3);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.anni_fine, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAnnoFine.setAdapter(adapter4);

        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.mesi_fine, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMeseFine.setAdapter(adapter5);

        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this,
                R.array.giorni_fine, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGiornoFine.setAdapter(adapter6);

        adminStatisticheActivity = this;
        contoPresenter.setAdminStatisticheActivity(this);

        this.barArraylist = new ArrayList<BarEntry>();

        btn_admin_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.logOut(adminStatisticheActivity);
            }
        });

        btn_admin_aggiungi_piatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAggiungiPiatto(adminStatisticheActivity);
            }
        });

        btn_admin_modifica_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminModificaMenu(adminStatisticheActivity);
            }
        });

        btn_admin_messaggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminMessaggi(adminStatisticheActivity);
            }
        });

        btn_admin_statistiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminStatistiche(adminStatisticheActivity);
            }
        });

        btn_admin_add_utente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utentePresenter.goAdminAddUtente(adminStatisticheActivity);
            }
        });

        btn_calcola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkDate()){
                    contoPresenter.getAllContiBeetween(anno_inizio + "-" + mese_inizio + "-" + giorno_inizio,anno_fine + "-" + mese_fine + "-" + giorno_fine );
                }
                else
                    Toast.makeText(adminStatisticheActivity.getApplicationContext(), "Le date non sono valide", Toast.LENGTH_SHORT).show();
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

    public boolean checkDate(){
        boolean flag = false;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new
                SimpleDateFormat("yyyy-MM-dd");

        anno_inizio = spinnerAnnoInizio.getSelectedItem().toString();
        mese_inizio = spinnerMeseInizio.getSelectedItem().toString();
        giorno_inizio = spinnerGiornoInizio.getSelectedItem().toString();

        anno_fine = spinnerAnnoFine.getSelectedItem().toString();
        mese_fine = spinnerMeseFine.getSelectedItem().toString();
        giorno_fine = spinnerGiornoFine.getSelectedItem().toString();

        try {
            Date dataInizio = dateFormat.parse(anno_inizio + "-" + mese_inizio + "-" + giorno_inizio);
            Date dataFine = dateFormat.parse(anno_fine + "-" + mese_fine + "-" + giorno_fine);

            if(dataInizio.before(dataFine) || dataInizio.equals(dataFine)){
                if(check30(1) && check30(0) && checkFebbraio(1) && checkFebbraio(0)){
                    flag = true;
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean check30(int i){
        boolean flag = true;

        if(i == 1){
            if(mese_inizio.equals("11") || mese_inizio.equals("04") || mese_inizio.equals("06") || mese_inizio.equals("09")) {
                if(giorno_inizio.equals("31")) flag = false;
            }
        }
        else{
            if(mese_fine.equals("11") || mese_fine.equals("04") || mese_fine.equals("06") || mese_fine.equals("09")) {
                if(giorno_fine.equals("31")) flag = false;
            }
        }

        return flag;
    }

    public boolean checkFebbraio(int i){
        boolean flag = true;

        if(i == 1){
            if(mese_inizio.equals("02")){
                if(giorno_inizio.equals("30") || giorno_inizio.equals("31") || (!checkBisestile(Integer.parseInt(anno_inizio)) && giorno_inizio.equals("29"))){
                    flag = false;
                }
            }
        }
        else{
            if(mese_fine.equals("02")){
                if(giorno_fine.equals("30") || giorno_fine.equals("31") || (!checkBisestile(Integer.parseInt(anno_fine)) && giorno_fine.equals("29"))){
                    flag = false;
                }
            }
        }

        return flag;
    }

    public boolean checkBisestile(int anno){
        return (anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0);
    }

    public void stampaConti(){
        float tot = 0;
        float incasso_medio;

        DecimalFormat df = new DecimalFormat("#####.##");
        df.setRoundingMode(RoundingMode.DOWN);

        contoPresenter.setDate(new ArrayList<>());
        contoPresenter.setGuadagni(new ArrayList<>());

        for(int i = 0; i < contoPresenter.getConti().size(); i++){
            tot += contoPresenter.getConti().get(i).getCosto();

            if(!isPresenteData(contoPresenter.getConti().get(i).getData()))
                contoPresenter.getDate().add(contoPresenter.getConti().get(i).getData());
        }

        setGuadagni();

        incasso_medio = tot / contoPresenter.getConti().size();

        String totale = "Totale: " + df.format(tot) + "€";
        String incasso_medioString = "Incasso medio: " + df.format(incasso_medio) + "€";

        for(int i = 0; i < contoPresenter.getDate().size(); i++)
            System.out.println(contoPresenter.getDate().get(i));

        for(int i = 0; i < contoPresenter.getGuadagni().size(); i++)
            System.out.println(contoPresenter.getGuadagni().get(i));

        textIncassoComplessivo.setText(totale);
        textIncassoMedio.setText(incasso_medioString);

        makeChart();

    }

    private boolean isPresenteData(String data){
        boolean trovato = false;
        int i = 0;

        while(i < contoPresenter.getDate().size() && !trovato){
            if(contoPresenter.getDate().get(i).equals(data))
                trovato = true;

            i++;
        }

        return trovato;
    }

    private void setGuadagni(){
        float tot = 0;
        DecimalFormat df = new DecimalFormat("#####.##");
        df.setRoundingMode(RoundingMode.DOWN);

        for(String data : contoPresenter.getDate()){
            for(int i = 0; i < contoPresenter.getConti().size(); i++){
                if(contoPresenter.getConti().get(i).getData().equals(data))
                    tot += contoPresenter.getConti().get(i).getCosto();
            }

            contoPresenter.getGuadagni().add(Float.valueOf(df.format(tot)));
            tot = 0;
        }
    }

    public void makeChart() {
        barArraylist.clear();

        for(int i=0; i < contoPresenter.getGuadagni().size(); i++)
            barArraylist.add(new BarEntry(i, contoPresenter.getGuadagni().get(i), contoPresenter.getGuadagni().get(i)));

        barDataSet = new BarDataSet(barArraylist, "");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(20f);
        barDataSet.setValueFormatter(new DefaultValueFormatter(0));

        barData = new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.animateY(2000);
        barChart.animateY(2000);
        barChart.getDescription().setText("");

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(2);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(contoPresenter.getDate()));
        xAxis.setCenterAxisLabels(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        xAxis.setDrawGridLines(false);

        barDataSet.notifyDataSetChanged();
        barData.notifyDataChanged();
        barChart.notifyDataSetChanged();
        barChart.invalidate();

    }
}