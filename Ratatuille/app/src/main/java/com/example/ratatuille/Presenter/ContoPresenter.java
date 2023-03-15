package com.example.ratatuille.Presenter;

import android.widget.Toast;

import com.example.ratatuille.Model.Conto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplContoService;
import com.example.ratatuille.View.SupervisoreContoActivity;

import java.util.List;

public class ContoPresenter {
    private static ContoPresenter contoPresenter = null;

    private ImplContoService implContoService;
    private List<Conto> conti;
    private SupervisoreContoActivity supervisoreContoActivity;

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

    public void update(int i){
        conti.get(i).setChiuso(1);

        implContoService.update(new Callback() {
            @Override
            public void returnResult(Object o) {
                supervisoreContoActivity.scaricaConto(i);
            }

            @Override
            public void returnError(Throwable e) {

            }
        }, conti.get(i));
    }

    public void setSupervisoreContoActivity(SupervisoreContoActivity supervisoreContoActivity) {
        this.supervisoreContoActivity = supervisoreContoActivity;
    }

    public List<Conto> getConti() {
        return conti;
    }
}
