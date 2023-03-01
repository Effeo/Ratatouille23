package com.example.ratatuille.Presenter;

import android.app.Activity;
import android.content.Intent;

import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplUtenteService;
import com.example.ratatuille.View.LoginActivity;
import com.example.ratatuille.View.MainActivity;

public class UtentePresenter {

    private MainActivity mainActivity;
    private LoginActivity loginActivity;

    private ImplUtenteService implUtenteService;

    public UtentePresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.implUtenteService = new ImplUtenteService();
    }

    public UtentePresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        this.implUtenteService = new ImplUtenteService();
    }

    public void goLogin(){
        Intent finestraLogin = new Intent(mainActivity.getApplicationContext(), LoginActivity.class);
        mainActivity.startActivity(finestraLogin);
    }

    public void login(String userName, String password){

        implUtenteService.findUtenteByUser_nameAndPassword(new Callback(){
            @Override
            public void returnResult(Object o) {
                Utente utente = (Utente) o;

                if(utente != null){
                    System.out.println(utente);
                }
                else{
                    System.out.println("Errore");
                }
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
     },userName,password);

    }

}
