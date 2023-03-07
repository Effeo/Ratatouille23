package com.example.ratatuille.Presenter;

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplOrdine_piattoService;
import com.example.ratatuille.Service.Implementation.ImplPiattoService;
import com.example.ratatuille.View.CuocoOrdinazioniActivity;

import java.util.ArrayList;
import java.util.List;

public class Ordine_piattoPresenter {
    private static Ordine_piattoPresenter ordine_piattoPresenter = null;
    private ImplOrdine_piattoService implOrdine_piattoService;
    private List<Ordine_piatto> ordini_piatti;
    private CuocoOrdinazioniActivity cuocoOrdinazioniActivity;

    public void setCuocoOrdinazioniActivity(CuocoOrdinazioniActivity cuocoOrdinazioniActivity) {
        this.cuocoOrdinazioniActivity = cuocoOrdinazioniActivity;
    }

    private Ordine_piattoPresenter(){
        implOrdine_piattoService = new ImplOrdine_piattoService();
    }

    public static Ordine_piattoPresenter getInstance(){
        if(ordine_piattoPresenter == null) ordine_piattoPresenter = new Ordine_piattoPresenter();

        return ordine_piattoPresenter;
    }

    public void findAllOrdiniPiatti(){
        implOrdine_piattoService.getOrdini_piatti(new Callback() {
            @Override
            public void returnResult(Object o) {
                ordini_piatti = (List<Ordine_piatto>) o;
                cuocoOrdinazioniActivity.stampaOrdiniPiatti();
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
}
