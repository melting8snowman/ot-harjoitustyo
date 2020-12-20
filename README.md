# Ohjelmistotekniikka syksy 2020
**Ohjelmistotekniikan harjoitustyö - Harri Nieminen**
# Jälkiruokareseptigeneraattori

## Päätoiminnallisuus ##
Ohjelman pääasiallinen tehtävä on tarjota käyttäjälle kyseiseen päivään sopiva jälkiruokaresepti. 
Reseptit jaetaan muutamaan luokkaan ja ohjelman tulee kysyä käyttäjältä päivän fiiliksen mukaista 
jälkiruokaryhmää. Tämän jälkeen ohjelma generoi/arpoo käyttäjälle oikeaan ryhmään kuuluvan 
jälkiruoan tehtäväksi ja nautittavaksi.

## Dokumentaatio ##
[Arkkitehtuurikuvaus](https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuurikuvaus.md)

[Testausdokumentti](https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Käyttöohje](https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Harjoitustyön määrittelydokumentti](https://www.github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/melting8snowman/ot-harjoitustyo/blob/master/tyoaikakirjanpito.txt)

## Reseptiryhmät ##
Jälkiruokaryhmiin kuuluvat ainakin seuraavat: 
-	marjaisat
-	suklaiset
- viileat

## Lisätoiminnot ##
Yllämainitun lisäksi käyttäjän tulee saada lisätietoa tallennetuista resepteistä, 
luoduista ryhmistä sekä reseptien lukumäärästä ryhmissä. Käyttäjän pitäisi saada kuva 
generaattorin arpomasta reseptistä. Olisi hyvä voida lisätä hyväksi havaitsemansa jälkiruoka 
ohjelman tietokantaan ryhmittelyineen, minkä jälkeen lisätyn jälkiruoka voisi olla jatkossa arvottavien 
reseptien joukossa. Lisätoiminnallisuuksia voisivat olla myös uuden ryhmän lisääminen sekä olemassa 
olevan reseptin muuttaminen toisene ryhmään.

## Releases ##
[Final](https://github.com/melting8snowman/ot-harjoitustyo/releases/tag/final)

[Week6](https://github.com/melting8snowman/ot-harjoitustyo/releases/tag/week6)

[Week5](https://github.com/melting8snowman/ot-harjoitustyo/releases/tag/Week5)

## Komentorivitoiminnot ##
# Testaus
Testit suoritetaan komennolla
<pre>
mvn test
</pre>
Testikattavuusraportti luodaan komennolla
<pre>
mvn jacoco:report
</pre>
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html

# Suoritettavan jarin generointi
Komento

mvn package
generoi hakemistoon target suoritettavan jar-tiedoston OtmTodoApp-1.0-SNAPSHOT.jar

# JavaDoc
JavaDoc generoidaan komennolla

mvn javadoc:javadoc
JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

# Checkstyle
Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla

 mvn jxr:jxr checkstyle:checkstyle
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html



