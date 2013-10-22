DOKUMENT = GeoTopo

make:
	pdflatex $(DOKUMENT).tex -output-format=pdf
	makeindex $(DOKUMENT)
	pdflatex $(DOKUMENT).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc *.ind *.ilg
