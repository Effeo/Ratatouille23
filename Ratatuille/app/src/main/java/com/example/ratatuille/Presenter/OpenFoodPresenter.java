package com.example.ratatuille.Presenter;

import android.widget.Toast;

import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Implementation.ImplOpenFoodService;
import com.example.ratatuille.View.AdminAggiungiPiattoActivity;
import com.example.ratatuille.View.SupervisoreAggiungiPiattoActivity;


public class OpenFoodPresenter {
    private static OpenFoodPresenter openFoodPresenter = null;

    private ImplOpenFoodService implOpenFoodService;

    private SupervisoreAggiungiPiattoActivity supervisoreAggiungiPiattoActivity;
    private AdminAggiungiPiattoActivity adminAggiungiPiattoActivity;

    private String descrizione;
    private String allergeni;

    public String getDescrizione() {
        return descrizione;
    }

    public String getAllergeni() {
        return allergeni;
    }

    public void setSupervisoreAggiungiPiattoActivity(SupervisoreAggiungiPiattoActivity supervisoreAggiungiPiattoActivity) {
        this.supervisoreAggiungiPiattoActivity = supervisoreAggiungiPiattoActivity;
    }

    public void setAdminAggiungiPiattoActivity(AdminAggiungiPiattoActivity adminAggiungiPiattoActivity) {
        this.adminAggiungiPiattoActivity = adminAggiungiPiattoActivity;
    }

    private OpenFoodPresenter() {
        this.implOpenFoodService = new ImplOpenFoodService();
    }

    public static OpenFoodPresenter getInstance(){
        if(openFoodPresenter == null) openFoodPresenter = new OpenFoodPresenter();

        return openFoodPresenter;
    }

    public void getDescrizione(String nome, String ruolo){
        implOpenFoodService.getDescrizione(new Callback() {
            @Override
            public void returnResult(Object o) {
                String descrizione = (String) o;
                System.out.println(descrizione);
                try{
                    String descrizione2 = descrizione.substring(descrizione.indexOf('['), descrizione.indexOf(']'));
                    String descrizione3 = descrizione2.substring(descrizione2.indexOf(':') + 2);
                    String descrizone4 = descrizione3.substring(0, descrizione3.indexOf('"'));
                    System.out.println(descrizone4);
                    openFoodPresenter.descrizione = descrizone4;

                    if(ruolo.equals("supervisore")){
                        supervisoreAggiungiPiattoActivity.setDescrizione();
                        if(descrizone4.equals(""))
                            Toast.makeText(supervisoreAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente la descrizione", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(supervisoreAggiungiPiattoActivity.getApplicationContext(), "Clicca aggiungi per confermare", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        adminAggiungiPiattoActivity.setDescrizione();
                        if(descrizone4.equals(""))
                            Toast.makeText(adminAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente la descrizione", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(adminAggiungiPiattoActivity.getApplicationContext(), "Clicca aggiungi per confermare", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    System.out.println(e);
                    if(ruolo.equals("supervisore"))
                        Toast.makeText(supervisoreAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente la descrizione", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(adminAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente la descrizione", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
                if(ruolo.equals("supervisore"))
                    Toast.makeText(supervisoreAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente la descrizione", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(adminAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente la descrizione", Toast.LENGTH_SHORT).show();
            }
        },nome);
    }

    public void getAllergeni(String nome, String ruolo){
        implOpenFoodService.getAllergeni(new Callback() {
            @Override
            public void returnResult(Object o) {
                String allergeni = (String) o;
                try{
                    String allergeni2 = allergeni.substring(allergeni.indexOf('['), allergeni.indexOf(']'));
                    String allergeni3 = allergeni2.substring(allergeni2.indexOf(':') + 2);
                    String allergeni4 = allergeni3.substring(0, allergeni3.indexOf('"'));
                    System.out.println(allergeni4);
                    openFoodPresenter.allergeni = allergeni4;

                    if(ruolo.equals("supervisore")){
                        supervisoreAggiungiPiattoActivity.setAllergeni();

                        if(allergeni4.equals(""))
                            Toast.makeText(supervisoreAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente gli allergeni", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(supervisoreAggiungiPiattoActivity.getApplicationContext(), "Clicca aggiungi per confermare", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        adminAggiungiPiattoActivity.setAllergeni();

                        if(allergeni4.equals(""))
                            Toast.makeText(adminAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente gli allergeni", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(adminAggiungiPiattoActivity.getApplicationContext(), "Clicca aggiungi per confermare", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    System.out.println(e);
                    if(ruolo.equals("supervisore"))
                        Toast.makeText(supervisoreAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente gli allergeni", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(adminAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente gli allergeni", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void returnError(Throwable e) {
                System.out.println(e);
                if(ruolo.equals("supervisore"))
                    Toast.makeText(supervisoreAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente gli allergeni", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(adminAggiungiPiattoActivity.getApplicationContext(), "Inserire manualmente gli allergeni", Toast.LENGTH_SHORT).show();
            }
        },nome);
    }
}
