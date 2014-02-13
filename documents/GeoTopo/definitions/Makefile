SOURCE = definitionen
make:
	./generateDefinitions.py
	pdflatex $(SOURCE).tex -interaction=batchmode -output-format=pdf
	pdflatex $(SOURCE).tex -interaction=batchmode -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm definitionen.tex
