DOKUMENT = pdfa-paper
make:
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc *.ind *.ilg figures/torus.tex *.glg *.glo *.gls *.ist *.xdy *.fdb_latexmk *.bak *.blg *.bbl *.glsdefs *.acn *.acr *.alg *.nls *.nlo *.bak *.pyg *.lot *.lof *.xmpi *.xmpdata
