make:
	pdflatex book.tex -output-format=pdf
	pdflatex book.tex -output-format=pdf
	makeindex book
	bibtex book
	pdflatex book.tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.ind *.idx *.ilg *.toc *.bbl *.blg
