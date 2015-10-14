Dies ist ein **inoffizielles, von Studenten erstelltes Skript**
zur Vorlesung "Einführung in Geometrie und Topologie" am KIT bei
Herrn Prof. Dr. Herrlich (WS 2013/2014). Da es von Studenten erstellt
wird, die die Inhalte noch lernen, sind sehr wahrscheinlich einige
Fehler im Skript. Das können Übertragungsfehler, Tippfehler oder
Verständnisprobleme sein.

Verbesserungsvorschläge (auch wenn es nur einzelne Textsetzungsprobleme oder
Rechtschreibfehler sind) bitte immer direkt melden oder verbessern!

Den Verbesserungsvorschlag kann man
* entweder direkt selbst umsetzen und einen pull request machen oder
* mir per Email (info@martin-thoma.de) schicken.

Ich werde dann versuchen die Verbesserungsvorschläge zeitnah einzuarbeiten.

Zeichnungen
===========
Das erstellen der Zeichnungen ist sehr zeitaufwendig. Das ist der
Grund, warum manchmal nur ein "TODO" im Dokument steht.

Ihr könnt mir gerne Zeichnungen schicken (entweder schön auf Papier
Zeichnen und abfotographieren / einscannen oder schon mit Inscape /
Gimp / ... oder sogar mit TikZ erstellen).

Akzeptable Formate sind: .jpg, .pdf, .svg, .png, .gif, .tex, .sketch
Alles andere kann ich vermutlich nicht einbinden.


Dokument erzeugen
=================
Zum erzeugen des Dokuments wird `sketch` und LaTeX benötigt.

LaTeX installiert man so: [Link](http://martin-thoma.com/how-to-install-the-latest-latex-version/)

Rechtliches
===========
Die Autoren kann man über Git ermitteln. Ich schreibe meist nur den
Tafelanschrieb der Vorlesung ab; eventuell noch mit ein paar
Notizen meinerseits. Wenn mir Verbesserungsvorschläge per Email
geschickt werden, ist der Autor sowie das Datum der Email in der
Commit-Nachricht von Git zu sehen.

Bilder habe ich entweder selbst erstellt oder von tex.stackexchange.com.
Bei Bildern von tex.stackexchange.com steht der Link auf die Quelle
im Quelltext des Bildes (siehe Ordner `figures`).

Was noch kommen soll
====================

1. Alle `TODOS` auflösen
  * "Punkt" suchen
  * Checken, ob alle Seitenumbrüche / Bildgrößen stimmen
2. Reviews (Mathematik, LaTeX und Bilder)
3. A5-Version drucken
  * In `GeoTopo.tex`: `\AFivefalse` → `\AFivetrue`
  * Momentan sind es ca. 100 Seiten in A4. In A5 sind es ca. 159 Seiten.
  * Druckereien
    * An der Uni (ca. 8.50 Euro, SW, Spiralbindung)
    * http://www.epubli.de/ (ca. 9.23 Euro SW + 2.95 Euro Versand, 26.99 Euro farbig)
    * https://www.viaprinto.de/ (ca. 15 Euro SW, 35 Euro farbig)
    * http://shop.kopie.de/article/show/diplomarbeit
    * http://www.drucksofa.com/
    * http://www.mein-druck.de/category.htm?c=15510
    * http://www.1buch.de/preisuebersicht/
4. Version für Sehgeschädigte:
  * min `12pt`, besser `14pt`
  * nicht `article`, `book`, `report` sondern `extarticle`
  * Sans serif: Arial, Helvetica (`\usepackage{cmbright}`)
