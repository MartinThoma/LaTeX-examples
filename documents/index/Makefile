SOURCE = index

make:
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf
	makeindex $(SOURCE)
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.ind *.idx *.ilg *.toc *.bbl *.blg *.pyg
