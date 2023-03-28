package com.example.ratatuille;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.ratatuille.Presenter.ContoPresenter;

public class ContoPresenterTest {

    private ContoPresenter contoPresenter = ContoPresenter.getInstance();

    @Test
    public void testAnnoNonBisestile() {
        assertFalse(contoPresenter.checkBisestile(2001));
    }

    @Test
    public void testAnnoBisestileDivisibilePer4() {
        assertTrue(contoPresenter.checkBisestile(2020));
    }

    @Test
    public void testAnnoNonBisestileDivisibilePer100() {
        assertFalse(contoPresenter.checkBisestile(1900));
    }

    @Test
    public void testAnnoBisestileDivisibilePer400() {
        assertTrue(contoPresenter.checkBisestile(2000));
    }
}
