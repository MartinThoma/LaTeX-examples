SOURCE = index

make:
	pdflatex $(SOURCE).tex -output-format=pdf # first run for the aux file
	makeindex $(SOURCE)                       # now the index is generated
	pdflatex $(SOURCE).tex -output-format=pdf # pdf with index :-)
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.ind *.idx *.ilg *.toc *.bbl *.blg *.pyg
