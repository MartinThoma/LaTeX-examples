DOKUMENT = tutorenschulung-abschlussreflexion
 
make:
	pdflatex -shell-escape $(DOKUMENT).tex -output-format=pdf
	pdflatex -shell-escape $(DOKUMENT).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.pyg *.ist *.glo *.toc
