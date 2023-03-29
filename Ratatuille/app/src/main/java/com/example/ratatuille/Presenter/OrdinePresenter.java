package com.example.ratatuille.Presenter;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.ratatuille.Model.Ordine;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplOrdineService;
import com.example.ratatuille.View.CameriereAggiungiTavoloActivity;

public class OrdinePresenter {
    private static OrdinePresenter ordinePresenter = null;
    private ImplOrdineService implOrdineService;
    private CameriereAggiungiTavoloActivity cameriereAggiungiTavoloActivity;

    private Ordine ordine = null;

    private OrdinePresenter(){
        this.implOrdineService = new ImplOrdineService();
    }

    public static OrdinePresenter getInstance(){
        if (ordinePresenter == null) ordinePresenter = new OrdinePresenter();

        return ordinePresenter;
    }

    public void create(int id_tavolo){
        Ordine ordine = new Ordine();
        ordine.setId_Tavolo(id_tavolo);

        implOrdineService.create(new Callback() {
            @Override
            public void returnResult(Object o) {
                cameriereAggiungiTavoloActivity.chiamaOrdine();
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        }, ordine);
    }

    public void getGreatest(){
        implOrdineService.getGreatest(new Callback() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void returnResult(Object o) {
                ordine = (Ordine) o;

                cameriereAggiungiTavoloActivity.insertOrdine_piatto();
            }

            @Override
            public void returnError(Throwable e) {
                    System.out.println(e);
            }
        });
    }

    public void setCameriereAggiungiTavoloActivity(CameriereAggiungiTavoloActivity cameriereAggiungiTavoloActivity) {
        this.cameriereAggiungiTavoloActivity = cameriereAggiungiTavoloActivity;
    }

    public Ordine getOrdine() {
        return ordine;
    }
}
