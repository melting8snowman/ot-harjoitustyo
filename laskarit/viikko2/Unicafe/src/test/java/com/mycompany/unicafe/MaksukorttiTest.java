package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void alkusaldo() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void lataa() {
        kortti.lataaRahaa(200);
        assertEquals("saldo: 2.10", kortti.toString());
    }

    @Test
    public void liianVahan() {
        kortti.otaRahaa(6000);
        //assertTrue(kortti.saldo() ==  0.10);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void otetaanPois() {
        kortti.lataaRahaa(2000);
        kortti.otaRahaa(1010);
        //assertTrue(kortti.saldo() ==  0.10);
        assertEquals("saldo: 10.0", kortti.toString());
    }

    @Test
    public void saldo() {
        assertTrue(kortti.saldo() > 0);
    }

    //@Test
    // public void rahaaPois() {
    //     kortti.lataaRahaa(2000);
    //     kortti.otaRahaa(1010);
    //     assertTrue(kortti.saldo() == 100);
    // }
}
