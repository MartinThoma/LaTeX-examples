SOURCE = torus-three-paths
DELAY = 80
DENSITY = 300
WIDTH = 512

make:
	make clean
	pdflatex $(SOURCE).tex -output-format=pdf
	asy $(SOURCE)-*.asy
	asy $(SOURCE)-*.asy
	pdflatex $(SOURCE).tex -output-format=pdf
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.data *.gnuplot *.out *.prc *.pre $(SOURCE)-1_0.pdf $(SOURCE)1+0_0.pdf $(SOURCE)-1.tex

gif:
	pdfcrop $(SOURCE).pdf
	convert -verbose -delay $(DELAY) -loop 0 -density $(DENSITY) $(SOURCE)-crop.pdf $(SOURCE).gif
	make clean

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
	inkscape $(SOURCE).svg --export-plain-svg=$(SOURCE).svg
