DOKUMENT = booka4

make:
	pdflatex $(DOKUMENT).tex -output-format=pdf # Referenzen erstellen
	bibtex $(DOKUMENT)
	pdflatex $(DOKUMENT).tex -output-format=pdf # Referenzen einbinden
	pdflatex $(DOKUMENT).tex -output-format=pdf # Referenzen einbinden
	make clean

ebook:
	latexml --dest=$(DOKUMENT).xml $(DOKUMENT).tex
	latexmlpost -dest=$(DOKUMENT).html $(DOKUMENT).xml
	ebook-convert $(DOKUMENT).html $(DOKUMENT).epub --language de --no-default-epub-cover

clean:
	rm -rf $(TARGET) *.class *.html *.aux *.out *.thm *.idx *.toc *.ilg *.glg *.glo *.gls *.ist *.xdy *.fdb_latexmk *.bak *.blg *.glsdefs *.acn *.acr *.alg *.nls *.nlo *.bak *.pyg *.lot *.lof *.xmpdata *.xmpi
	rm -rf _minted-booka4
	rm -rf *.log  # Analyze this for errors
	# rm -rf *.bbl *.ind  # Needed for arxiv