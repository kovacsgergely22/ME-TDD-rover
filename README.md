# Mars Rover - Test-Driven Development (TDD) Project

Ez a projekt a klasszikus **Mars Rover** implementációja, amely a **Software Driven Development** szemléletmód és a **Test-Driven Development (TDD)** szigorú betartásával készült. A cél egy robusztus, jól tesztelt navigációs modul létrehozása volt, amely képes egy járművet irányítani egy rácsos szerkezetű bolygón.

## 🚀 A Projekt Célja

A fejlesztés során a **Clean Code** és a **SOLID** elvek gyakorlati alkalmazása volt a fókuszban. A kód nem egyszerre íródott meg, hanem iteratív módon, a **Red-Green-Refactor** ciklusokat követve, biztosítva, hogy minden üzleti logika tesztekkel fedett legyen.

## 🛠️ Funkcionalitás

A Rover a következő képességekkel rendelkezik:

- **Inicializálás:** Kezdő pozíció (x, y) és irány (N, S, E, W) megadása.
- **Mozgás:** Előre (`f`) és hátra (`b`) lépés a rácson.
- **Forgás:** 90 fokos fordulás balra (`l`) és jobbra (`r`) az irányváltáshoz.
- **Pálya széle (Wrapping):** A bolygó gömbölyű (vagy tórusz) jellegéből adódóan, ha a Rover elhagyja a térkép szélét, a túloldalon bukkan fel.
- **Akadály detektálás:** Ha a Rover útjába akadály kerül, a mozgás megszakad, és a rendszer jelzi az akadály pontos koordinátáit.

## 💻 Technológiai Háttér

- **Nyelv:** [Java]
- **Tesztkörnyezet:** [JUnit]
- **Verziókezelés:** Git

## 🧪 Tesztelési Stratégia (TDD)

A projekt fejlesztése lépésről lépésre történt unit tesztek írásával:

1.  **Üres teszt:** Rover inicializálása.
2.  **Mozgás tesztek:** Egyszerű koordináta-változások (pl. Északra lépés növeli az Y-t).
3.  **Forgás tesztek:** Irányváltások ellenőrzése (pl. Északról Jobbra -> Kelet).
4.  **Komplex parancsok:** Parancssorozatok feldolgozása (pl. `ffrfflbb`).
5.  **Határérték tesztek:** "Világvége" kezelése (Grid wrapping).
6.  **Kivételkezelés:** Ütközés detektálás.

## 📂 Telepítés és Futtatás

A projekt klónozása és a tesztek futtatása:

```bash
# Repo klónozása
git clone [https://github.com/kovacsgergely22/ME-TDD-rover.git](https://github.com/kovacsgergely22/ME-TDD-rover.git)

# Könyvtárba lépés
cd ME-TDD-rover

# Tesztek futtatása
