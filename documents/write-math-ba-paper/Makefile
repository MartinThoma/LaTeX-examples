DOKUMENT = write-math-ba-paper
make:
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # aux-files for makeindex / makeglossaries
	makeglossaries $(DOKUMENT)
	bibtex $(DOKUMENT)
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # include index
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # include symbol table
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # include symbol table
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc *.ind *.ilg figures/torus.tex *.glg *.glo *.gls *.ist *.xdy *.fdb_latexmk *.bak *.blg *.bbl *.glsdefs *.acn *.acr *.alg *.nls *.nlo *.bak *.pyg *.lot *.lof
