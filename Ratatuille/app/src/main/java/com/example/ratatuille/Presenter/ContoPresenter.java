package com.example.ratatuille.Presenter;

import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.ratatuille.Model.Conto;
import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplContoService;
import com.example.ratatuille.View.AdminStatisticheActivity;
import com.example.ratatuille.View.CameriereAggiungiTavoloActivity;
import com.example.ratatuille.View.CameriereOrdinazioniActivity;
import com.example.ratatuille.View.SupervisoreContoActivity;

import java.util.ArrayList;
import java.util.List;

public class ContoPresenter {
    private static ContoPresenter contoPresenter = null;
    private Ordine_piattoPresenter ordine_piattoPresenter = Ordine_piattoPresenter.getInstance();

    private ImplContoService implContoService;
    private List<Conto> conti;
    private Conto conto;
    private List<Ordine_piatto> ordini_piatti = new ArrayList<>();

    private SupervisoreContoActivity supervisoreContoActivity;
    private CameriereAggiungiTavoloActivity cameriereAggiungiTavoloActivity;
    private AdminStatisticheActivity adminStatisticheActivity;

    private int posizione_conto;

    public void setAdminStatisticheActivity(AdminStatisticheActivity adminStatisticheActivity) {
        this.adminStatisticheActivity = adminStatisticheActivity;
    }

    public void setConti(List<Conto> conti) {
        this.conti = conti;
    }

    public void setPosizione_conto(int posizione_conto) {
        this.posizione_conto = posizione_conto;
    }

    public int getPosizione_conto() {
        return posizione_conto;
    }

    private ContoPresenter(){
        implContoService = new ImplContoService();
    }

    public static ContoPresenter getInstance(){
        if (contoPresenter == null) contoPresenter = new ContoPresenter();

        return contoPresenter;
    }

    public void getAllConti(){
        implContoService.getAllConti(new Callback() {
            @Override
            public void returnResult(Object o) {
                conti = (List<Conto>) o;
                supervisoreContoActivity.stampaConti();
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        });
    }

    public void getAllContiBeetween(String dataInizio, String dataFine){
        implContoService.getAllBeetween(new Callback() {
            @Override
            public void returnResult(Object o) {
                conti = (List<Conto>) o;

                adminStatisticheActivity.stampaConti();
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
                Toast.makeText(adminStatisticheActivity.getApplicationContext(), "Errore nel recupero dei dati", Toast.LENGTH_SHORT).show();
            }
        }, dataInizio, dataFine);
    }

    public void update(int i){
        System.out.println("Update chiuso");
        conti.get(i).setChiuso(1);

        implContoService.update(new Callback() {
            @Override
            public void returnResult(Object o) {
                supervisoreContoActivity.scaricaConto();
            }

            @Override
            public void returnError(Throwable e) {

            }
        }, conti.get(i));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void create(float tot, int id_tavolo){
        Conto conto = new Conto();

        conto.setId_tavolo(id_tavolo);
        conto.setCosto(tot);
        conto.setChiuso(0);
        conto.setData(java.time.LocalDate.now().toString());

        implContoService.create(new Callback() {
            @Override
            public void returnResult(Object o) {
                System.out.println("Creato");
                Toast.makeText(cameriereAggiungiTavoloActivity.getApplicationContext(), "Comanda inviata", Toast.LENGTH_SHORT).show();

                ordine_piattoPresenter.setOrdini_piatti(new ArrayList<>());

                Intent finestraCameriereOrdinazioni = new Intent(cameriereAggiungiTavoloActivity, CameriereOrdinazioniActivity.class);
                cameriereAggiungiTavoloActivity.startActivity(finestraCameriereOrdinazioni);
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        }, conto);
    }

    public void setSupervisoreContoActivity(SupervisoreContoActivity supervisoreContoActivity) {
        this.supervisoreContoActivity = supervisoreContoActivity;
    }

    public void setCameriereAggiungiTavoloActivity(CameriereAggiungiTavoloActivity cameriereAggiungiTavoloActivity) {
        this.cameriereAggiungiTavoloActivity = cameriereAggiungiTavoloActivity;
    }

    public List<Conto> getConti() {
        return conti;
    }

    public List<Ordine_piatto> getOrdini_piatti(){return ordini_piatti;}

    public void setConto(Conto conto){this.conto = conto;}


    public void setOrdini_piatti (List<Ordine_piatto> ordini_piatti){this.ordini_piatti = ordini_piatti;}


}
