SOURCE = Minted-Haskell

make:
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.glo *.glg *.gls *.ist *.xdy *.1 *.toc *.pyg
