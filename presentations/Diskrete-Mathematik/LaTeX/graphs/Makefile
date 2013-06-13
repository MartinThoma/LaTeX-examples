SOURCE = euler-nicht-eindeutig

make:
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf # shellescape wird fürs logo benötigt
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.glo *.glg *.gls *.ist *.xdy *.1 *.toc *.snm *.nav *.vrb *.fls *.fdb_latexmk *.pyg
