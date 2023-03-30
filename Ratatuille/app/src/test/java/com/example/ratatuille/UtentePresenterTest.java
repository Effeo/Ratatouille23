package com.example.ratatuille;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.ratatuille.Presenter.UtentePresenter;

import org.junit.Test;

public class UtentePresenterTest {

    private UtentePresenter utentePresenter = UtentePresenter.getInstance();

    @Test
    public void Mese_di_inizio_e_giorno_di_inizio_rispettano_il_requisito(){
        boolean result1 = utentePresenter.check30(true, "11", "30", "12", "31");
        assertTrue(result1);
    }


    @Test
    public void Mese_di_fine_e_giorno_di_fine_rispettano_il_requisito(){
        boolean result2 = utentePresenter.check30(false, "10", "15", "11", "30");
        assertTrue(result2);
    }


    @Test
    public void Mese_di_inizio_rispetta_il_requisito_ma_il_giorno_di_inizio_no(){
        boolean result3 = utentePresenter.check30(true, "06", "31", "07", "31");
        assertFalse(result3);
    }


    @Test
    public void Mese_di_fine_rispetta_il_requisito_ma_il_giorno_di_fine_no(){
        boolean result4 = utentePresenter.check30(false, "09", "01", "09", "31");
        assertFalse(result4);
    }

}
