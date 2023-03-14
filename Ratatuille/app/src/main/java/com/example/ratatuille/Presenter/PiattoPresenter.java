package com.example.ratatuille.Presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.health.SystemHealthManager;
import android.widget.Toast;

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplPiattoService;
import com.example.ratatuille.View.AdminAggiungiPiattoActivity;
import com.example.ratatuille.View.CameriereOrdinazioniActivity;
import com.example.ratatuille.View.CuocoOrdinazioniActivity;
import com.example.ratatuille.View.SupervisoreAggiungiPiattoActivity;
import com.example.ratatuille.View.SupervisoreModificaMenuActivity;

import java.util.ArrayList;
import java.util.List;

public class PiattoPresenter {
    private static PiattoPresenter piattoPresenter = null;
    private ImplPiattoService implPiattoService;
    private Piatto piatto;
    private List<Piatto> piatti;
    private CuocoOrdinazioniActivity cuocoOrdinazioniActivity;
    private CameriereOrdinazioniActivity cameriereOrdinazioniActivity;
    private SupervisoreModificaMenuActivity supervisoreModificaMenuActivity;

    public void setCameriereOrdinazioniActivity(CameriereOrdinazioniActivity cameriereOrdinazioniActivity) {
        this.cameriereOrdinazioniActivity = cameriereOrdinazioniActivity;
    }

    public void setCuocoOrdinazioniActivity(CuocoOrdinazioniActivity cuocoOrdinazioniActivity) {
        this.cuocoOrdinazioniActivity = cuocoOrdinazioniActivity;
    }

    public void setSupervisoreModificaMenuActivity(SupervisoreModificaMenuActivity supervisoreModificaMenuActivity){
        this.supervisoreModificaMenuActivity = supervisoreModificaMenuActivity;
    }

    private PiattoPresenter(){
        implPiattoService = new ImplPiattoService();
    }

    public static PiattoPresenter getInstance(){
        if(piattoPresenter == null) piattoPresenter = new PiattoPresenter();

        return piattoPresenter;
    }

    public void findPiattoById(int id_piatto){
        implPiattoService.findPiattoById(new Callback() {
            @Override
            public void returnResult(Object o) {
                piatto = (Piatto) o;

                if(piatto == null){
                    System.out.println("Errore");
                }
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        }, id_piatto);
    }

    public void getAllPiatti(String ruolo){
        implPiattoService.getAllPiatti(new Callback() {
            @Override
            public void returnResult(Object o) {
                piatti = (List<Piatto>) o;
                if(ruolo.equals("cameriere")) cameriereOrdinazioniActivity.stampaPiatti();
                else if(ruolo.equals("supervisore")) supervisoreModificaMenuActivity.stampaPiatti();
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        });
    }

    public void create(Activity activity, String ruolo) {
        SupervisoreAggiungiPiattoActivity activitySup = null;
        AdminAggiungiPiattoActivity activityAdmin = null;

        String nome = null;
        String descrizione = null;
        String allergeni = null;
        Integer posizione = -1;
        Float costo = Float.valueOf(-1);
        String categoria = null;

        if (ruolo.equals("supervisore")) {
            activitySup = (SupervisoreAggiungiPiattoActivity) activity;

            nome = activitySup.editNome.getText().toString();
            descrizione = activitySup.editDescrizione.getText().toString();
            allergeni = activitySup.editAllergeni.getText().toString();
            categoria = activitySup.spinnerCategoria.getSelectedItem().toString();
            if(!activitySup.editCosto.getText().toString().equals("")) costo = Float.parseFloat(activitySup.editCosto.getText().toString());
            if(!activitySup.editPosizione.getText().toString().equals("")) posizione = Integer.parseInt(activitySup.editPosizione.getText().toString());
        }else{
            /*activityAdmin = (AdminAggiungiPiattoActivity) activity;

            nome = activityAdmin.editNome.getText().toString();
            descrizione = activityAdmin.editDescrizione.getText().toString();
            allergeni = activityAdmin.editAllergeni.getText().toString();
            String categoria = activityAdmin.spinnerCategoria.getSelectedItem().toString();
            costo = Float.parseFloat(activityAdmin.editCosto.getText().toString());
            posizione = Integer.parseInt(activityAdmin.editPosizione.getText().toString());*/
        }


        if (!nome.equals("") || !descrizione.equals("") || !allergeni.equals("") || posizione >= 1 || costo >= 0) {
            Piatto piatto = new Piatto();

            piatto.setNome(nome);
            piatto.setDescrizione(descrizione);
            piatto.setCosto(costo);
            piatto.setAllergeni(allergeni);
            piatto.setCategoria(categoria);
            piatto.setPosto(posizione);

            implPiattoService.create(new Callback() {
                @Override
                public void returnResult(Object o) {
                    System.out.println("piatto aggiunto");
                }

                @Override
                public void returnError(Throwable e) {
                    System.out.println(e);
                }
            }, piatto);
        } else
            Toast.makeText(activity.getApplicationContext(), "Uno o più campi non sono compilati" , Toast.LENGTH_SHORT).show();
    }

    public Piatto getPiatto() {
        return piatto;
    }

    public List<Piatto> getPiatti() {
        return piatti;
    }
}

