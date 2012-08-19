SOURCE = book

make:
	pdflatex $(SOURCE).tex -output-format=pdf
	pdflatex $(SOURCE).tex -output-format=pdf
	makeindex $(SOURCE)
	bibtex $(SOURCE)
	pdflatex $(SOURCE).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.ind *.idx *.ilg *.toc *.bbl *.blg
