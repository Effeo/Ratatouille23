package com.example.ratatuille.Presenter;

import android.app.Activity;
import android.content.Intent;

import com.example.ratatuille.Api.UtenteApi;
import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplUtenteService;
import com.example.ratatuille.Service.Interface.IUtenteService;
import com.example.ratatuille.View.CambioPasswordActivity;
import com.example.ratatuille.View.CuocoOrdinazioniActivity;
import com.example.ratatuille.View.LoginActivity;
import com.example.ratatuille.View.MainActivity;

public class UtentePresenter {
    private Utente utente;
    private static UtentePresenter utentePresenter = null;
    private MainActivity mainActivity;
    private LoginActivity loginActivity;
    private CambioPasswordActivity cambioPasswordActivity;

    private ImplUtenteService implUtenteService;

    public static UtentePresenter getInstance(){
        if (utentePresenter == null) utentePresenter = new UtentePresenter();

        return utentePresenter;
    }

    private UtentePresenter(){
        implUtenteService = new ImplUtenteService();
    }

    public void logOut(Activity activity){
        Intent finestraWelcome = new Intent(activity.getApplicationContext(), MainActivity.class);
        activity.startActivity(finestraWelcome);
    }

    public void goLogin(){
        Intent finestraLogin = new Intent(mainActivity.getApplicationContext(), LoginActivity.class);
        mainActivity.startActivity(finestraLogin);
    }

    public void login(String userName, String password){
        implUtenteService.findUtenteByUser_nameAndPassword(new Callback(){
            @Override
            public void returnResult(Object o) {
                utente = (Utente) o;

                if(utente != null){
                    System.out.println(utente.getUser_name());
                    if(utente.getRuolo().equals("admin")){
                        //non ho ancora la schermata

                    }else if(utente.getRuolo().equals("supervisore")){
                        if(utente.getCheck_change_password() == 0){
                            Intent finestraCambioPassword = new Intent(loginActivity.getApplicationContext(), CambioPasswordActivity.class);
                            loginActivity.startActivity(finestraCambioPassword);
                        }else{
                            //non ho ancora la schermata
                        }

                    }else if(utente.getRuolo().equals("cameriere")){
                        if(utente.getCheck_change_password() == 0){
                            Intent finestraCambioPassword = new Intent(loginActivity.getApplicationContext(), CambioPasswordActivity.class);
                            loginActivity.startActivity(finestraCambioPassword);
                        }else{
                            //non ho ancora la schermata
                        }

                    }else if(utente.getRuolo().equals("cuoco")){
                        if(utente.getCheck_change_password() == 0){
                            Intent finestraCambioPassword = new Intent(loginActivity.getApplicationContext(), CambioPasswordActivity.class);
                            loginActivity.startActivity(finestraCambioPassword);
                        }else{
                            Intent finestraCuocoOrdinazioni = new Intent(loginActivity.getApplicationContext(), CuocoOrdinazioniActivity.class);
                            loginActivity.startActivity(finestraCuocoOrdinazioni);
                        }
                    }
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

    public Utente getUtente() {
        return utente;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void setLoginActivity(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    public void setCambioPasswordActivity(CambioPasswordActivity cambioPasswordActivity) {
        this.cambioPasswordActivity = cambioPasswordActivity;
    }

    public void update(Utente utente){
        implUtenteService.update(new Callback() {
            @Override
            public void returnResult(Object o) {
                System.out.println("password cambiata");
                if(utente.getRuolo().equals("supervisore")){
                    //non ho ancora la schermata

                }else if(utente.getRuolo().equals("cameriere")){
                    //non ho ancora la schermata

                }else if(utente.getRuolo().equals("cuoco")){
                    Intent finestraCuocoOrdinazioni = new Intent(cambioPasswordActivity.getApplicationContext(), CuocoOrdinazioniActivity.class);
                    cambioPasswordActivity.startActivity(finestraCuocoOrdinazioni);
                }
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
      },utente);
    }

    public void cambiaPassword(String password){
        utente.setPassword(password);
        utente.setCheck_change_password(1);
        update(utente);
    }


}
