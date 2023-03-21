package com.example.ratatuille.Presenter;

import com.example.ratatuille.Model.Tavolo;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplTavoloService;

import java.util.List;

public class TavoloPresenter {
    private static TavoloPresenter tavoloPresenter = null;
    private ImplTavoloService implTavoloService;
    private List<Tavolo> tavoli;

    private TavoloPresenter(){implTavoloService = new ImplTavoloService();}

    public static TavoloPresenter getInstance(){
        if(tavoloPresenter == null) tavoloPresenter = new TavoloPresenter();

        return tavoloPresenter;
    }

    public void getAllTavoli(){
        implTavoloService.getTavoli(new Callback() {
            @Override
            public void returnResult(Object o) {
                tavoli = (List<Tavolo>) o;
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        });
    }

    public List<Tavolo> getTavoli() {
        return tavoli;
    }
}
