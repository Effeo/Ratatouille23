package com.example.ratatuille.Presenter;

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplOrdine_piattoService;
import com.example.ratatuille.Service.Implementation.ImplPiattoService;

import java.util.ArrayList;
import java.util.List;

public class Ordine_piattoPresenter {
    private static Ordine_piattoPresenter ordine_piattoPresenter = null;
    private ImplOrdine_piattoService implOrdine_piattoService;
    private PiattoPresenter piattoPresenter;
    private List<Ordine_piatto> ordini_piatti;
    private List<List<Piatto>> piatti;

    private Ordine_piattoPresenter(){
        implOrdine_piattoService = new ImplOrdine_piattoService();
    }

    public static Ordine_piattoPresenter getInstance(){
        if(ordine_piattoPresenter == null) ordine_piattoPresenter = new Ordine_piattoPresenter();

        return ordine_piattoPresenter;
    }

    public void getOrdiniPiatti(){
        implOrdine_piattoService.getOrdini_piatti(new Callback() {
            @Override
            public void returnResult(Object o) {
                ordini_piatti = (List<Ordine_piatto>) o;
                piatti = new ArrayList<>();
                piattoPresenter = PiattoPresenter.getInstance();
                int j = 0;
                int id_ordine = ordini_piatti.get(0).getId_ordine();

                for(int i = 0; i < ordini_piatti.size(); i++){
                    if(ordini_piatti.get(i).getId_ordine() != id_ordine){
                        j++;
                        id_ordine = ordini_piatti.get(i).getId_ordine();
                        piatti.add(new ArrayList<>());
                    }

                    piattoPresenter.findPiattoById(ordini_piatti.get(i).getId_piatto());
                    piatti.get(j).add(piattoPresenter.getPiatto());
                }

                for(int i = 0; i < piatti.size(); i++){
                    for(j = 0; j < piatti.get(i).size(); j++){
                        System.out.println(piatti.get(i).get(j).getNome());
                    }
                }

            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        });
    }

    public List<Ordine_piatto> getOrdini_piatti() {
        return ordini_piatti;
    }

    public List<List<Piatto>> getPiatti() {
        return piatti;
    }
}
