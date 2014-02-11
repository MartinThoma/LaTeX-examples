DOKUMENT = GeoTopo

make:
	sketch figures/torus.sketch > figures/torus.tex
	pdflatex $(DOKUMENT).tex -output-format=pdf # aux-files for makeindex / makeglossaries
	makeindex $(DOKUMENT)
	pdflatex $(DOKUMENT).tex -output-format=pdf # include index
	pdflatex $(DOKUMENT).tex -output-format=pdf # include symbol table
	make clean # remove intermediate files like *.log and *.aux

ebook:
	latexml --dest=$(DOKUMENT).xml $(DOKUMENT).tex
	latexmlpost -dest=$(DOKUMENT).html $(DOKUMENT).xml
	ebook-convert $(DOKUMENT).html $(DOKUMENT).epub --language de --no-default-epub-cover

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc *.ind *.ilg figures/torus.tex *.glg *.glo *.gls *.ist *.xdy *.fdb_latexmk
