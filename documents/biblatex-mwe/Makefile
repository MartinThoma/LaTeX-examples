SOURCE = biblatex-mwe
make:
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf
	biber $(SOURCE).tex
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.toc *.bbl *.blg *.pyg *.bcf *.run.xml
