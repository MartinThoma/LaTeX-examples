DOKUMENT = GeoTopo

make:
	sketch figures/torus.sketch > figures/torus.tex
	pdflatex $(DOKUMENT).tex -output-format=pdf # aux-Dateien für makeindex / makeglossaries
	makeindex $(DOKUMENT)
	makeglossaries $(DOKUMENT)
	pdflatex $(DOKUMENT).tex -output-format=pdf # Stichwortverzeichnis einbinden
	pdflatex $(DOKUMENT).tex -output-format=pdf # Symbolverzeichnis einbinden
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc *.ind *.ilg figures/torus.tex *.glg *.glo *.gls *.ist *.xdy
