package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate paate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(10);
    }

    //@AfterClass
    //public static void tearDownClass() {
    //}
    //@Before
    //public void setUp() {
    //}
    //@After
    ///public void tearDown() {
    //}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void luotuPaateOlemassa() {
        assertTrue(paate != null);
    }

    @Test
    public void alkuLounaat() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void alkusaldo() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void ostettuMaukasLounas() {
        assertEquals(100, paate.syoMaukkaasti(100));
        assertEquals(100, paate.syoMaukkaasti(500));
        assertEquals(100400, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void ostettuEdullinenLounas() {
        assertEquals(1, paate.syoEdullisesti(1));
        assertEquals(260, paate.syoEdullisesti(500));
        assertEquals(100240, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kortillaOstettuMaukasLounas() {
        kortti.lataaRahaa(5990);
        assertEquals(true, paate.syoMaukkaasti(kortti));
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
        //kortti.otaRahaa(5990);
        //assertFalse(paate.syoMaukkaasti(kortti));
        //assertEquals("saldo: 0.10", kortti.toString());
        //assertEquals(100400, paate.kassassaRahaa());
    }

    @Test
    public void kortillaOstettuEdullinenLounas() {
        assertEquals(false, paate.syoEdullisesti(kortti));
        //assertEquals(1, paate.edullisiaLounaitaMyyty());
        //kortti.otaRahaa(7000);
        //assertFalse(false == paate.syoEdullisesti(kortti));
        //assertEquals("saldo: 0.60", kortti.toString());
        //assertEquals(100240, paate.kassassaRahaa());
    }
    
        @Test
    public void kortillaEdullinenLounas() {
        //boolean ret = paate.syoEdullisesti(kortti);
        kortti.otaRahaa(7000);
        assertEquals(false, paate.syoEdullisesti(kortti));
        //assertEquals(1, paate.edullisiaLounaitaMyyty());
        //kortti.otaRahaa(7000);
        //assertFalse(false == paate.syoEdullisesti(kortti));
        //assertEquals("saldo: 0.60", kortti.toString());
        //assertEquals(100240, paate.kassassaRahaa());
    }

    @Test
    public void kortillaEdullinenLounas2() {
        kortti.lataaRahaa(6000);
        paate.syoEdullisesti(kortti);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void lataus() {
        paate.lataaRahaaKortille(kortti, 6000);
        assertEquals(6010, kortti.saldo());
        assertEquals(106000, paate.kassassaRahaa());
    }

    @Test
    public void eiLataus() {
        paate.lataaRahaaKortille(kortti, -6000);
        assertEquals(100000, paate.kassassaRahaa());

    }
}
