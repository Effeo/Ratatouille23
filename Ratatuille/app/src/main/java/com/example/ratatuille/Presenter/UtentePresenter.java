package com.example.ratatuille.Presenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplUtenteService;
import com.example.ratatuille.View.AdminAggiungiPiattoActivity;
import com.example.ratatuille.View.AdminCambiaPasswordUtenteActivity;
import com.example.ratatuille.View.AdminCreaUtenteActivity;
import com.example.ratatuille.View.AdminModificaMenuActivity;
import com.example.ratatuille.View.AdminScriviMessaggioActivity;
import com.example.ratatuille.View.AdminStatisticheActivity;
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
import com.example.ratatuille.View.SupervisoreModificaMenuActivity;
import com.example.ratatuille.View.SupervisoreScriviMessaggioActivity;

import java.util.List;

public class UtentePresenter {
    private Utente utente;
    private List<Utente> utenti;
    private static UtentePresenter utentePresenter = null;
    private int utente_clicked;

    private MainActivity mainActivity;
    private LoginActivity loginActivity;
    private CambioPasswordActivity cambioPasswordActivity;
    private AdminCambiaPasswordUtenteActivity adminCambiaPasswordUtenteActivity;

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

    public void goAdminStatistiche(Activity activity){
        Intent finestraAdminStatistiche = new Intent(activity.getApplicationContext(), AdminStatisticheActivity.class);
        activity.startActivity(finestraAdminStatistiche);
    }

    public void goAdminAddUtente(Activity activity){
        Intent finestraAdminAddUtente = new Intent(activity.getApplicationContext(), AdminCreaUtenteActivity.class);
        activity.startActivity(finestraAdminAddUtente);
    }

    public void goAdminAggiungiPiatto(Activity activity){
        Intent finestraAdminAggiungiPiatto = new Intent(activity.getApplicationContext(), AdminAggiungiPiattoActivity.class);
        activity.startActivity(finestraAdminAggiungiPiatto);
    }

    public void goAdminModificaMenu(Activity activity){
        Intent finestraAdminModificaMenu = new Intent(activity.getApplicationContext(), AdminModificaMenuActivity.class);
        activity.startActivity(finestraAdminModificaMenu);
    }

    public void goAdminMessaggi(Activity activity){
        Intent finestraAdminMessaggi = new Intent(activity.getApplicationContext(), AdminScriviMessaggioActivity.class);
        activity.startActivity(finestraAdminMessaggi);
    }

    public void goCambiaPasswordAdmin(Activity activity){
        Intent finestraCambiaPasswordAdmin = new Intent(activity.getApplicationContext(), AdminCambiaPasswordUtenteActivity.class);
        activity.startActivity(finestraCambiaPasswordAdmin);
    }

    public void creaUtente(AdminCreaUtenteActivity adminCreaUtenteActivity){
        String userName = adminCreaUtenteActivity.editUserName.getText().toString();
        String password = adminCreaUtenteActivity.editPassword.getText().toString();
        String ruolo = adminCreaUtenteActivity.spinnerRuoli.getSelectedItem().toString();
        Utente utente = new Utente();

        if(!userName.equals("") && !password.equals("")){
            utente.setPassword(password);
            utente.setUser_name(userName);
            utente.setRuolo(ruolo);
            utente.setCheck_change_password(0);

            implUtenteService.create(new Callback() {
                @Override
                public void returnResult(Object o) {
                    Toast.makeText(adminCreaUtenteActivity.getApplicationContext(), "Utente creato" , Toast.LENGTH_SHORT).show();
                }

                @Override
                public void returnError(Throwable e) {
                    System.out.println(e);
                    Toast.makeText(adminCreaUtenteActivity.getApplicationContext(), "Errore nella creazione dell'utente" , Toast.LENGTH_SHORT).show();
                }
            }, utente);
        }
        else Toast.makeText(adminCreaUtenteActivity.getApplicationContext(), "Uno o più campi non sono compilati" , Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(loginActivity.getApplicationContext(), "User name o password errata", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
     },userName,password);

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

    public void cambiaPasswordAdmin(String password){
        utenti.get(utente_clicked).setPassword(password);

        implUtenteService.update(new Callback() {
            @Override
            public void returnResult(Object o) {
                Toast.makeText(adminCambiaPasswordUtenteActivity.getApplicationContext(), "Password cambiata", Toast.LENGTH_SHORT).show();

                Intent finestraAddUtente = new Intent(adminCambiaPasswordUtenteActivity, AdminCreaUtenteActivity.class);
                adminCambiaPasswordUtenteActivity.startActivity(finestraAddUtente);
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
                Toast.makeText(adminCambiaPasswordUtenteActivity.getApplicationContext(), "Errore nell'aggiornamento", Toast.LENGTH_SHORT).show();
            }
        }, utenti.get(utente_clicked));
    }

    public void cambiaPassword(String password){
        utente.setPassword(password);
        utente.setCheck_change_password(1);
        update(utente);
    }

    public void getAllUser(){
        implUtenteService.getAll(new Callback() {
            @Override
            public void returnResult(Object o) {
                utenti = (List<Utente>) o;
                adminCambiaPasswordUtenteActivity.stampaUteni();
            }

            @Override
            public void returnError(Throwable e) {

            }
        });
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

    public void setAdminCambiaPasswordUtenteActivity(AdminCambiaPasswordUtenteActivity adminCambiaPasswordUtenteActivity) {
        this.adminCambiaPasswordUtenteActivity = adminCambiaPasswordUtenteActivity;
    }

    public void setUtente_clicked(int utente_clicked) {
        this.utente_clicked = utente_clicked;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public boolean check30(boolean flag2, String mese_inizio, String giorno_inizio, String mese_fine, String giorno_fine){
        boolean flag = true;

        if(flag2){
            if(mese_inizio.equals("11") || mese_inizio.equals("04") || mese_inizio.equals("06") || mese_inizio.equals("09")) {
                if(giorno_inizio.equals("31")) flag = false;
            }
        }
        else{
            if(mese_fine.equals("11") || mese_fine.equals("04") || mese_fine.equals("06") || mese_fine.equals("09")) {
                if(giorno_fine.equals("31")) flag = false;
            }
        }

        return flag;
    }
}
