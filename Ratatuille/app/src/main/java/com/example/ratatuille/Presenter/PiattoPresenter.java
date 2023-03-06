package com.example.ratatuille.Presenter;

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplPiattoService;

import java.util.ArrayList;
import java.util.List;

public class PiattoPresenter {
    private static PiattoPresenter piattoPresenter = null;
    private ImplPiattoService implPiattoService;
    private Piatto piatto;
    private List<List<Piatto>> piatti;

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
                System.out.println(piatto.getNome());
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

    public void initializePiattiFromOridniPiatti(List<Ordine_piatto> ordini_piatti){
        piatti = new ArrayList<>();
        int j = 0;
        piatti.add(new ArrayList<>());
        int id_ordine = ordini_piatti.get(0).getId_ordine();

        for(int i = 0; i < ordini_piatti.size(); i++){
            if(ordini_piatti.get(i).getId_ordine() != id_ordine){
                j++;
                id_ordine = ordini_piatti.get(i).getId_ordine();
                piatti.add(new ArrayList<>());
            }

            findPiattoById(ordini_piatti.get(i).getId_piatto());
            System.out.println(getPiatto().getNome());
            piatti.get(j).add(getPiatto());
        }

        /*for(int i = 0; i < piatti.size(); i++){
            for(j = 0; j < piatti.get(i).size(); j++){
                System.out.println(piatti.get(i).get(j).getNome());
            }
        }*/
    }

    public List<List<Piatto>> getPiatti() {
        return piatti;
    }

    public Piatto getPiatto() {
        return piatto;
    }
}

