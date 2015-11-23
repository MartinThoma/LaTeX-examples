SOURCE = Ausarbeitung-Thoma

make:
	pdflatex $(SOURCE).tex -output-format=pdf # Referenzen erstellen
	bibtex $(SOURCE)
	pdflatex $(SOURCE).tex -output-format=pdf # Referenzen einbinden
	pdflatex $(SOURCE).tex -output-format=pdf # Referenzen einbinden
	make clean

ebook:
	latexml --dest=$(SOURCE).xml $(SOURCE).tex
	latexmlpost -dest=$(SOURCE).html $(SOURCE).xml
	ebook-convert $(SOURCE).html $(SOURCE).epub --language de --no-default-epub-cover

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc *.ind *.ilg *.glg *.glo *.gls *.ist *.xdy *.blg *.bak
