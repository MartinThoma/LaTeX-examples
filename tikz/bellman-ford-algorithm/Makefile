SOURCE = bellman-ford-algorithm
 
DELAY = 80
DENSITY = 300
 
make:
	pdflatex $(SOURCE).tex -output-format=pdf
	make clean
 
clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.toc *.snm *.out *.nav
 
animatedGif:
	pdfcrop $(SOURCE).pdf
	convert -verbose -delay $(DELAY) -loop 0 -density $(DENSITY) $(SOURCE)-crop.pdf $(SOURCE).gif
	make clean
 
transparentGif:
	convert $(SOURCE).pdf -transparent white result.gif
	make clean
 
svg:
	pdf2svg $(SOURCE).pdf $(SOURCE).svg
	# Necessary, as pdf2svg does not always create valid svgs:
	inkscape $(SOURCE).svg --export-plain-svg=$(SOURCE).svg
	# Alternatively, only this one (produces worse results):
	#inkscape $(SOURCE).pdf --export-plain-svg=$(SOURCE).svg
