**Arkkitehtuurikuvaus**

# Jälkiruokareseptigeneraattori

# Rakenne #
Ohjelman rakenne on seuraava:

<img src="https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/rakenne.png" width="560">

Sovelluksen käynnistyessä luodaan tarvittavat luokat Recipe ja RecipeBook sekä alustetaan niiden alkutiedot erillisestä alustustiedostosta recipes.txt. Ensisijainen Main käynnistää graafisen käyttöliittymän, vanhempi tekstipohjainen käyttöliittymä voidaan halutessa käynnistää erillistä MainOldTextUi:tä käyttämällä.

# Käyttöliittymä #
Ohjelmaa voidaan käyttää sekä vanhemmalla tekstikäyttöliittymällä että graafisella käyttöliittymällä. Nämä eroavat siten, että graafisessa liittymässä näytetään reseptien kuvat kun taas tekstikäyttöliittymässa on myös mahdollisuus lisätä reseptejä. 
Tekstikäyttöliittymä toimii tekstiperiaatteella Javan Scanner-luokkaa hyödyntäen kun taas graafinen käyttöliittymä on rakennettu JavaFX:n pohjalle. Graafisen luokan perusnäkymä on BorderPane, joka sisältää toimintaa ohjaavat napit Panen vasemmalla puoliskolla, tekstikentän Panen keskellä sekä kuvanäytön Panen alareunan tilassa. Käyttöliittymä on eristetty sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan metodeja.

# Sovelluslogiikka #
Sovelluksen tiedon tallentamisesta ja -käsittelystä vastaavat luokat Recipe ja Recipebook. Näistä edellinen sisältää yksittäisen reseptin tiedot ja niiden luomiseen, muokkaamiseen ja hakemiseen tarvittavat metodit. Jokaiselle reseptille luodaan automaattisesti uniikki ID. Jälkimmäinen taas sisältää reseptikokoelman, niiden ryhmittelyn tallentamisen sekä logiikan satunnaisen reseptin arpomiseen sekä ryhmäkohtaisesti että kaikista kokoelman resepteistä.  

<img src="https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/storing_classes.png" width="560">

Kuvataan seuraavaksi sekvenssikaaviona sovelluksen toimintalogiikka Recipe-luokkaan liittyvän GroupID:n päätoiminnallisuuden osalta. Luotaessa Recipe-olio tallennetaan kyseiseen reseptiin liittyvä GroupName tekstimuodossa. Kun tämä Recipe lisätään Recipebookiin, tarkastetaan kyseiseen GroupNamen olemassa olo ja tarvittaessa luodaan sille uusi ryhmä. Tämän jälkeen Recipelle palautetaan sen GroupID. Käyttöliittymän kysyessä tiettyyn ryhmään liittyviä reseptejä, tiedustelun avain on GroupID jonka avulla RecipeBook tietää mitkä Recipe ID:t kuuluvat kyseiseen ryhmään ja pystyy palauttamaan oikean Recipen tiedot käyttäliittymälle.

<img src="https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/recipeID_groupID_handling.png" width="760">

# Pysyväistallennus/Ohjelman alustus #
Sovellus hyödyntää yksinkertaista tekstitiedostoa josta luetaan alustuksessa sen perusluokkien objektien alustuksessa tarvittavat tiedot. Tekstikäyttöliittymällä lisättyjä reseptejä ei tallenneta alustustiedostolle vaan se sisältää ainoastaan ohjelmiston alkuperäiset reseptit. 
Alustustiedoston rakenne on seuraava
https://github.com/melting8snowman/ot-harjoitustyo/blob/master/Jalkiruokareseptigeneraattori/recipes.txt

name|group|ingredients|preparation|image
Marjarahka|marjaisat|maitorahka, sokeri, marjat, kermavaahto|10|https:...ginal.jpg
Suklaakeksi|rapeat|jauhot, sokeri, sulkaa, kananmuna, ruokasooda|45|https:..keksi.jpg

Ensimmäinen rivi sisältää kenttänimet ja järjestyksen. Kentät on eroteltu | merkillä.

# Ohjelmaan jääneet heikkoudet ja puutteet #
uis-pakkauksessa sijaitsevat käyttöliittymämetodit ylittävät checkstylessa määritetyn 20-rivin maksimipituuden. Koodien muokkaaminen tältä osin erillisiin metodeihin ei ollut kuitenkaan nykyisellään järkevää, tulevissa versioissa tätä voitaisiin kehittää. Nykyisellään tekstikäyttöliittymä mahdollistaa uusien reseptien luomisen käyttöliittymän kautta, mutta tätä toiminnallisuutta ei rakennettu graafiseen käyttöliittymään. Käyttöliittymän kautta luotuja reseptejä ei tietoturvan takia haluttu tallentaa ohjelman alustustiedostoon, mutta tulevaisuudessa tämä voitaisiin halutessa varsin helposti toteuttaa.









