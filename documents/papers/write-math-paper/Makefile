DOKUMENT = write-math-ba-paper
make:
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # aux-files for makeindex / makeglossaries
	makeglossaries $(DOKUMENT)
	bibtex $(DOKUMENT)
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # include index
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # include symbol table
	pdflatex -shell-escape $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # include symbol table
	make clean

combine:
	pdftk Dok1-open-kit.pdf KIT_SWP_Vorlage_Impressum_en_2015.pdf write-math-ba-paper.pdf KIT-WSP_RS_en.pdf cat output single-symbol-classification-paper.pdf

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc *.ind *.ilg figures/torus.tex *.glg *.glo *.gls *.ist *.xdy *.fdb_latexmk *.bak *.blg *.bbl *.glsdefs *.acn *.acr *.alg *.nls *.nlo *.bak *.pyg *.lot *.lof
