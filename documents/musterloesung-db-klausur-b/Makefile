SOURCE = musterloesung-db-klausur-b
make:
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf
	pdfcrop --margins '5 10 20 30' d3.pdf d3.pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.pyg
