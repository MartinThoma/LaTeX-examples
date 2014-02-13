SOURCE = definitionen
make:
	./generateDefinitions.py
	pdflatex $(SOURCE).tex -interaction=batchmode -output-format=pdf 1>/dev/null
	pdflatex $(SOURCE).tex -interaction=batchmode -output-format=pdf 1>/dev/null
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm definitionen.tex
