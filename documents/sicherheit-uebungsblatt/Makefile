SOURCE = sicherheit-uebungsblatt

make:
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf # shellescape wird für minted benötigt
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf # zweites kompilieren für Seitenzahlen
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.pyg
