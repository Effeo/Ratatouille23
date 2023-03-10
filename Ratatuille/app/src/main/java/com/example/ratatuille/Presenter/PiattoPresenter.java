package com.example.ratatuille.Presenter;

import android.content.Intent;
import android.os.health.SystemHealthManager;

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplPiattoService;
import com.example.ratatuille.View.CameriereOrdinazioniActivity;
import com.example.ratatuille.View.CuocoOrdinazioniActivity;
import com.example.ratatuille.View.SupervisoreAggiungiPiattoActivity;

import java.util.ArrayList;
import java.util.List;

public class PiattoPresenter {
    private static PiattoPresenter piattoPresenter = null;
    private ImplPiattoService implPiattoService;
    private Piatto piatto;
    private List<Piatto> piatti;
    private CuocoOrdinazioniActivity cuocoOrdinazioniActivity;
    private CameriereOrdinazioniActivity cameriereOrdinazioniActivity;

    public void setCameriereOrdinazioniActivity(CameriereOrdinazioniActivity cameriereOrdinazioniActivity) {
        this.cameriereOrdinazioniActivity = cameriereOrdinazioniActivity;
    }

    public void setCuocoOrdinazioniActivity(CuocoOrdinazioniActivity cuocoOrdinazioniActivity) {
        this.cuocoOrdinazioniActivity = cuocoOrdinazioniActivity;
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

    public void getAllPiatti(){
        implPiattoService.getAllPiatti(new Callback() {
            @Override
            public void returnResult(Object o) {
                piatti = (List<Piatto>) o;
                cameriereOrdinazioniActivity.stampaPiatti();
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        });
    }

    public void create(SupervisoreAggiungiPiattoActivity activity){
        String nome = activity.editNome.getText().toString();
        String descrizione = activity.editDescrizione.getText().toString();
        String allergeni = activity.editAllergeni.getText().toString();
        String categoria = activity.spinnerCategoria.getSelectedItem().toString();
        Float costo = Float.parseFloat(activity.editCosto.getText().toString());
        Integer posizione = Integer.parseInt(activity.editPosizione.getText().toString());

        if(nome.equals("") || descrizione.equals("") || allergeni.equals("") || posizione < 1 || costo < 0) return;

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
        },piatto);
    }

    public Piatto getPiatto() {
        return piatto;
    }

    public List<Piatto> getPiatti() {
        return piatti;
    }
}

