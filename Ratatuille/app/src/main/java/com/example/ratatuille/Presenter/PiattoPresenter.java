package com.example.ratatuille.Presenter;

import android.os.health.SystemHealthManager;

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplPiattoService;
import com.example.ratatuille.View.CuocoOrdinazioniActivity;

import java.util.ArrayList;
import java.util.List;

public class PiattoPresenter {
    private static PiattoPresenter piattoPresenter = null;
    private ImplPiattoService implPiattoService;
    private Piatto piatto;
    private CuocoOrdinazioniActivity cuocoOrdinazioniActivity;

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


    public Piatto getPiatto() {
        return piatto;
    }
}

