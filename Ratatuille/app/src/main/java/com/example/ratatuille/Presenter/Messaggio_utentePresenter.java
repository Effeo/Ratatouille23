package com.example.ratatuille.Presenter;

import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplMessaggio_utenteService;
import com.example.ratatuille.View.CameriereMessaggiActivity;
import com.example.ratatuille.View.CuocoMessaggiActivity;
import com.example.ratatuille.View.SupervisoreLeggeMessaggiActivity;
import com.example.ratatuille.View.SupervisoreScriviMessaggioActivity;

import java.util.List;

public class Messaggio_utentePresenter {
    public static Messaggio_utentePresenter messaggio_utentePresenter = null;
    private ImplMessaggio_utenteService implMessaggio_utenteService;

    private List<Messaggio_utente> messaggi_utenti;
    private CuocoMessaggiActivity cuocoMessaggiActivity;
    private CameriereMessaggiActivity cameriereMessaggiActivity;
    private SupervisoreLeggeMessaggiActivity supervisoreLeggeMessaggiActivity;

    public SupervisoreScriviMessaggioActivity getSupervisoreScriviMessaggioActivity() {
        return supervisoreScriviMessaggioActivity;
    }

    public void setSupervisoreScriviMessaggioActivity(SupervisoreScriviMessaggioActivity supervisoreScriviMessaggioActivity) {
        this.supervisoreScriviMessaggioActivity = supervisoreScriviMessaggioActivity;
    }

    private SupervisoreScriviMessaggioActivity supervisoreScriviMessaggioActivity;

    public void setCuocoMessaggiActivity(CuocoMessaggiActivity cuocoMessaggiActivity) {
        this.cuocoMessaggiActivity = cuocoMessaggiActivity;
    }

    public void setCameriereMessaggiActivity(CameriereMessaggiActivity cameriereMessaggiActivity) {
        this.cameriereMessaggiActivity = cameriereMessaggiActivity;
    }

    public void setSupervisoreLeggeMessaggiActivity(SupervisoreLeggeMessaggiActivity supervisoreLeggeMessaggiActivity) {
        this.supervisoreLeggeMessaggiActivity = supervisoreLeggeMessaggiActivity;
    }

    private Messaggio_utentePresenter(){implMessaggio_utenteService = new ImplMessaggio_utenteService();}

    public static Messaggio_utentePresenter getInstance(){
        if(messaggio_utentePresenter == null) messaggio_utentePresenter = new Messaggio_utentePresenter();

        return messaggio_utentePresenter;
    }

    public void getAllMessaggioUtente(String ruolo, String user_name, SupervisoreLeggeMessaggiActivity supervisoreLeggeMessaggiActivity){
        implMessaggio_utenteService.getAllMessaggioUtente(new Callback() {
            @Override
            public void returnResult(Object o) {
                messaggi_utenti = (List<Messaggio_utente>) o;

                if(ruolo.equals("cuoco")) cuocoMessaggiActivity.stampaMessaggi();
                else if(ruolo.equals("supervisore")){
                    if(supervisoreLeggeMessaggiActivity != null)
                        supervisoreLeggeMessaggiActivity.stampaMessaggi();
                    else
                        supervisoreScriviMessaggioActivity.stampaMessaggi();
                }
                else if(ruolo.equals("cameriere")) cameriereMessaggiActivity.stampaMessaggi();
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        }, user_name);
    }

    public List<Messaggio_utente> getMessaggi_utenti() {
        return messaggi_utenti;
    }

    private void update(Messaggio_utente messaggio_utente){
        implMessaggio_utenteService.update(new Callback() {
            @Override
            public void returnResult(Object o) {
                System.out.println("Messaggio letto");
                //ricaricare la pagina
            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
            }
        }, messaggio_utente);
    }

    public void setLetto(int id_messaggio_utente){
        //prendere il messaggio giusto con l'id (vedere come organizzarlo)
        messaggi_utenti.get(0).setLetto(true);
        update(messaggi_utenti.get(0));
    }
}
