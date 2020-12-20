# Käyttöohje

Lataa tiedosto [Jalkiruokareseptigeneraattori.jar](https://github.com/melting8snowman/ot-harjoitustyo/releases/download/final/Jalkiruokareseptigeneraattori.jar)

## Konfigurointi
Sovellus on rakennettu ja todettu toimivaksi Javan versiolla 8.
Sovellus odottaa että suoritushakemistossa on alustustiedosto recipes.txt, joka siis sisältyy ladattavaan jar-tiedostoon. Kyseinen tiedosto määrittelee alustettavat reseptit. Tiedoston rakenne on seuraava

name|group|ingredients|preparation|image Marjarahka|marjaisat|maitorahka, sokeri, marjat, kermavaahto|10|https:...ginal.jpg Suklaakeksi|rapeat|jauhot, sokeri, sulkaa, kananmuna, ruokasooda|45|https:..keksi.jpg

Ensimmäinen rivi sisältää kenttänimet ja järjestyksen. Kentät on eroteltu | merkillä.

## Käyttöliittymä
Sovelluksen oletuskäyttöliittymä on graafinen käyttöliittymä joka käynnistyy automaattisesti sen Main:sta. Graafinen käyttäliittymä toimii painamalla haluamaasi toimintoa vastaavaa nappia.

<img src="https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/gui.png" width="560">

Halutessasi voit käyttää myös vanhempaa tekstikäyttöliittymää, sen saa käynnistettyä MainOldTextUi:sta. Tekstikäyttöliittymässä tulee haluttu toiminto valita valitsemalla sitä vastaava numero valikosta.

<img src="https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/textui.png" width="560">

Nämä kaksi käyttöliittymää eroavat ulkoasunsa lisäksi siten, että graafisessa liittymässä näytetään reseptien kuvat kun taas tekstikäyttöliittymässa on myös mahdollisuus lisätä reseptejä. Tekstikäyttöliittymä toimii tekstiperiaatteella Javan Scanner-luokkaa hyödyntäen kun taas graafinen käyttöliittymä on rakennettu JavaFX:n pohjalle.

Nautinnollisia käyttöhetkiä jälkiruokien parissa!



