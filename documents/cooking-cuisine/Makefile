SOURCE = cooking-cuisine
DELAY = 80
DENSITY = 300
WIDTH = 512

make:
	pdflatex $(SOURCE).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out

png:
	make
	make svg
	inkscape $(SOURCE).svg -w $(WIDTH) --export-png=$(SOURCE).png

transparentGif:
	convert $(SOURCE).pdf -transparent white result.gif
	make clean

svg:
	#inkscape $(SOURCE).pdf --export-plain-svg=$(SOURCE).svg
	pdf2svg $(SOURCE).pdf $(SOURCE).svg
	# Necessary, as pdf2svg does not always create valid svgs:
	inkscape $(SOURCE).svg --export-width=$(WIDTH) --export-plain-svg=$(SOURCE)1.svg
	rsvg-convert -a -w 720 -f svg $(SOURCE)1.svg -o $(SOURCE).svg
	rm $(SOURCE)1.svg