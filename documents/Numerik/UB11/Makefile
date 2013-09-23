SOURCE = UB11
make:
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf
	pdflatex -shell-escape $(SOURCE).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.pyg
