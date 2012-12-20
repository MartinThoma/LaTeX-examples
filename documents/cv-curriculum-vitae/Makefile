SOURCE = cv-curriculum-vitae

make:
	#convert -page A4 zeugnis-1-improved.jpg zeugnis-2-improved.jpg -format pdf zeugnis.pdf
	xelatex $(SOURCE).tex
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out
