SOURCE = bachelor-proposal-latex-writing-recognition
make:
	pdflatex $(SOURCE).tex -output-format=pdf
	bibtex $(SOURCE)
	pdflatex $(SOURCE).tex -output-format=pdf # Referenzen einbinden
	pdflatex $(SOURCE).tex -output-format=pdf # Referenzen einbinden
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.bcf *.bbl *.blg
