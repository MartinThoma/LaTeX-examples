DOKUMENT = Einnahmenueberschussrechnung

make:
	pdflatex EUR.tex -output-format=pdf
	pdflatex $(DOKUMENT).tex -output-format=pdf
	make clean

clean:
	rm -rf  *.aux *.log EUR.pdf
