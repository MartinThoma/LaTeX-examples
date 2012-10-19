SOURCE = report-template

make:
	pdflatex $(SOURCE).tex -output-format=pdf
	pdflatex $(SOURCE).tex -output-format=pdf # re-processing is necessary for table of contents
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.toc
