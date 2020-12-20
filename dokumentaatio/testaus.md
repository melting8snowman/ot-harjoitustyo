# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkötestein JUnitilla sekä manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkötestaus

### Sovelluslogiikka

Automatisoitujen testien ytimen moudostavat sovelluslogiikkaa, eli pakkauksen [jalkiruokareseptigeneraattori.blogic](https://github.com/melting8snowman/ot-harjoitustyo/tree/master/Jalkiruokareseptigeneraattori/src/main/java/jalkiruokareseptigeneraattori/blogic) sisältämien luokkien Recipe ja Recipebook kohdistuvat testit.
Näihin kohdistuvat testit on eritelty testausluokkiin [RecipeTest](https://github.com/melting8snowman/ot-harjoitustyo/blob/master/Jalkiruokareseptigeneraattori/src/test/java/Jalkiruokareseptigeneraattori/RecipeTest.java) ja [RecipebookTest](https://github.com/melting8snowman/ot-harjoitustyo/blob/master/Jalkiruokareseptigeneraattori/src/test/java/Jalkiruokareseptigeneraattori/RecipebookTest.java).

### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 94% ja haarautumakattavuus 93%

<img src="https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/testit.png" width="800">


## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on haettu ja sitä on testattu [käyttöohjeen](https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md) kuvaamalla tavalla.


### Toiminnallisuudet

Kaikki [vaatimusmäärittelyn](https://github.com/melting8snowman/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Syötteitä on täytetty sekä asianmukaisesti että tietoisesti virheellisillä arvoilla kuten tyhjillä.
