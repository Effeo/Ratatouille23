package com.example.ratatuille;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.ratatuille.View.AdminStatisticheActivity;


public class AdminStatisticheActivityTest {

    @Test
    public void testAnnoNonBisestile() {
        assertFalse(new AdminStatisticheActivity().checkBisestile(2001));
    }

    @Test
    public void testAnnoBisestileDivisibilePer4() {
        assertTrue(new AdminStatisticheActivity().checkBisestile(2020));
    }

    @Test
    public void testAnnoNonBisestileDivisibilePer100() {
        assertFalse(new AdminStatisticheActivity().checkBisestile(1900));
    }

    @Test
    public void testAnnoBisestileDivisibilePer400() {
        assertTrue(new AdminStatisticheActivity().checkBisestile(2000));
    }
}
