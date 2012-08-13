# CHANGELOG
# Version 1.0: Erstellung des Makefile

# Version des Makefile
fileinfo	:= LaTeX Makefile
author		:= Martin Thoma
version		:= 1.0

DATE=$(shell date +%Y-%m-%d)

make:
	mpost meta.mp
	pdflatex class-diagram.tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.1
