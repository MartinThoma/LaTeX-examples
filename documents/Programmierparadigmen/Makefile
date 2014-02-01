DOKUMENT = Programmierparadigmen

make:
	pdflatex -shell-escape $(DOKUMENT).tex -output-format=pdf # aux-Dateien für makeindex / makeglossaries
	makeindex $(DOKUMENT)
	pdflatex -shell-escape $(DOKUMENT).tex -output-format=pdf # Stichwortverzeichnis einbinden
	pdflatex -shell-escape $(DOKUMENT).tex -output-format=pdf # Symbolverzeichnis einbinden
	make clean

ebook:
	latexml --dest=$(DOKUMENT).xml $(DOKUMENT).tex
	latexmlpost -dest=$(DOKUMENT).html $(DOKUMENT).xml
	ebook-convert $(DOKUMENT).html $(DOKUMENT).epub --language de --no-default-epub-cover

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc *.ind *.ilg figures/torus.tex *.glg *.glo *.gls *.ist *.xdy *.pyg
