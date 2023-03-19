package com.example.ratatuille.Presenter;

import android.widget.Toast;

import com.example.ratatuille.Model.Messaggio;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplMessaggioService;
import com.example.ratatuille.View.AdminScriviMessaggioActivity;

public class MessaggioPresenter {
    private static MessaggioPresenter messaggioPresenter = null;
    private ImplMessaggioService implMessaggioService;
    private AdminScriviMessaggioActivity adminScriviMessaggioActivity;

    private MessaggioPresenter(){
        implMessaggioService = new ImplMessaggioService();
    }

    public static MessaggioPresenter getInstance(){
        if(messaggioPresenter == null) messaggioPresenter = new MessaggioPresenter();

        return messaggioPresenter;
    }

    public void create(String corpo){
        Messaggio messaggio = new Messaggio();
        messaggio.setCorpo(corpo);

        implMessaggioService.create(new Callback() {
            @Override
            public void returnResult(Object o) {
                Toast.makeText(adminScriviMessaggioActivity.getApplicationContext(), "Messaggio inviato", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void returnError(Throwable e) {
                Toast.makeText(adminScriviMessaggioActivity.getApplicationContext(), "Errore nell'invio", Toast.LENGTH_SHORT).show();
            }
        }, messaggio);
    }

    public void setAdminScriviMessaggioActivity(AdminScriviMessaggioActivity adminScriviMessaggioActivity) {
        this.adminScriviMessaggioActivity = adminScriviMessaggioActivity;
    }
}
