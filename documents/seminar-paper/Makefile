DOKUMENT = main

make:
	pdflatex $(DOKUMENT).tex -output-format=pdf
	biber $(DOKUMENT)
	pdflatex $(DOKUMENT).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc
