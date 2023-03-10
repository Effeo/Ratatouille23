package com.example.ratatuille.Presenter;

import android.app.Activity;
import android.content.Intent;

import com.example.ratatuille.Api.UtenteApi;
import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplUtenteService;
import com.example.ratatuille.Service.Interface.IUtenteService;
import com.example.ratatuille.View.AdminAggiungiPiattoActivity;
import com.example.ratatuille.View.CambioPasswordActivity;
import com.example.ratatuille.View.CameriereAggiungiTavoloActivity;
import com.example.ratatuille.View.CameriereComandaActivity;
import com.example.ratatuille.View.CameriereMessaggiActivity;
import com.example.ratatuille.View.CameriereOrdinazioniActivity;
import com.example.ratatuille.View.CuocoMessaggiActivity;
import com.example.ratatuille.View.CuocoOrdinazioniActivity;
import com.example.ratatuille.View.LoginActivity;
import com.example.ratatuille.View.MainActivity;
import com.example.ratatuille.View.SupervisoreAggiungiPiattoActivity;
import com.example.ratatuille.View.SupervisoreContoActivity;
import com.example.ratatuille.View.SupervisoreLeggeMessaggiActivity;
import com.example.ratatuille.View.SupervisoreModificaMenuActivity;
import com.example.ratatuille.View.SupervisoreScriviMessaggioActivity;

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

    public void goOrdinazioniCuoco(Activity activity){
        Intent finestraOrdinazioniCuoco = new Intent(activity.getApplicationContext(), CuocoOrdinazioniActivity.class);
        activity.startActivity(finestraOrdinazioniCuoco);
    }

    public void goMessaggiCuoco(Activity activity){
        Intent finestraMessaggiCuoco = new Intent(activity.getApplicationContext(), CuocoMessaggiActivity.class);
        activity.startActivity(finestraMessaggiCuoco);
    }

    public void goCameriereAggiungiTavolo(Activity activity){
        Intent finestraCameriereAggiungiTavolo = new Intent(activity.getApplicationContext(), CameriereAggiungiTavoloActivity.class);
        activity.startActivity(finestraCameriereAggiungiTavolo);
    }

    public void goCameriereComanda(Activity activity){
        Intent finestraCameriereComanda = new Intent(activity.getApplicationContext(), CameriereComandaActivity.class);
        activity.startActivity(finestraCameriereComanda);
    }

    public void goCameriereMessaggi(Activity activity){
        Intent finestraCameriereMessaggi = new Intent(activity.getApplicationContext(), CameriereMessaggiActivity.class);
        activity.startActivity(finestraCameriereMessaggi);
    }

    public void goCameriereOrdinazioni(Activity activity){
        Intent finestraCameriereOrdinazioni = new Intent(activity.getApplicationContext(), CameriereOrdinazioniActivity.class);
        activity.startActivity(finestraCameriereOrdinazioni);
    }

    public void goSupervisoreModificaMenu(Activity activity){
        Intent finestraSupervisoreOrdinazioni = new Intent(activity.getApplicationContext(), SupervisoreModificaMenuActivity.class);
        activity.startActivity(finestraSupervisoreOrdinazioni);
    }

    public void goSupervisoreConto(Activity activity){
        Intent finestraSupervisoreConto = new Intent(activity.getApplicationContext(), SupervisoreContoActivity.class);
        activity.startActivity(finestraSupervisoreConto);
    }

    public void goSupervisoreMessaggi(Activity activity){
        Intent finestraSupervisoreMessaggi = new Intent(activity.getApplicationContext(), SupervisoreScriviMessaggioActivity.class);
        activity.startActivity(finestraSupervisoreMessaggi);
    }

    public void goSupervisoreAggiungiPiatto(Activity activity){
        Intent finestraSupervisoreAggiungiPiatto = new Intent(activity.getApplicationContext(), SupervisoreAggiungiPiattoActivity.class);
        activity.startActivity(finestraSupervisoreAggiungiPiatto);
    }

    public void login(String userName, String password){
        implUtenteService.findUtenteByUser_nameAndPassword(new Callback(){
            @Override
            public void returnResult(Object o) {
                utente = (Utente) o;

                if(utente != null){
                    System.out.println(utente.getUser_name());
                    if(utente.getRuolo().equals("admin")){
                        Intent finestraAdminAggiungiPiatto = new Intent(loginActivity.getApplicationContext(), AdminAggiungiPiattoActivity.class);
                        loginActivity.startActivity(finestraAdminAggiungiPiatto);

                    }else if(utente.getRuolo().equals("supervisore")){
                        if(utente.getCheck_change_password() == 0){
                            Intent finestraCambioPassword = new Intent(loginActivity.getApplicationContext(), CambioPasswordActivity.class);
                            loginActivity.startActivity(finestraCambioPassword);
                        }else{
                            Intent finestraSupervisoreAggiungiPiatto = new Intent(loginActivity.getApplicationContext(), SupervisoreAggiungiPiattoActivity.class);
                            loginActivity.startActivity(finestraSupervisoreAggiungiPiatto);
                        }

                    }else if(utente.getRuolo().equals("cameriere")){
                        if(utente.getCheck_change_password() == 0){
                            Intent finestraCambioPassword = new Intent(loginActivity.getApplicationContext(), CambioPasswordActivity.class);
                            loginActivity.startActivity(finestraCambioPassword);
                        }else{
                            Intent finestraCameriereOrdinazioni = new Intent(loginActivity.getApplicationContext(), CameriereOrdinazioniActivity.class);
                            loginActivity.startActivity(finestraCameriereOrdinazioni);
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
                    Intent finestraSupervisoreAggiungiPiatto = new Intent(cambioPasswordActivity.getApplicationContext(), SupervisoreAggiungiPiattoActivity.class);
                    cambioPasswordActivity.startActivity(finestraSupervisoreAggiungiPiatto);

                }else if(utente.getRuolo().equals("cameriere")) {
                    Intent finestraCameriereOrdinazioni = new Intent(cambioPasswordActivity.getApplicationContext(), CameriereOrdinazioniActivity.class);
                    cambioPasswordActivity.startActivity(finestraCameriereOrdinazioni);

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
