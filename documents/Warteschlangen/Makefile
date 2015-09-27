DOKUMENT = warteschlangen

make:
	pdflatex $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # aux-files for makeindex / makeglossaries
	pdflatex $(DOKUMENT).tex -interaction=batchmode -output-format=pdf # include symbol table
	make clean # remove intermediate files like *.log and *.aux

ebook:
	latexml --dest=$(DOKUMENT).xml $(DOKUMENT).tex
	latexmlpost -dest=$(DOKUMENT).html $(DOKUMENT).xml
	ebook-convert $(DOKUMENT).html $(DOKUMENT).epub --language de --no-default-epub-cover

all:
	cd definitions;make
	sed -i 's/\\newif\\ifAFive\\AFivefalse/\\newif\\ifAFive\\AFivetrue/' GeoTopo.tex
	make
	mv GeoTopo.pdf other-formats/GeoTopo-A5.pdf
	sed -i 's/\\newif\\ifAFive\\AFivetrue/\\newif\\ifAFive\\AFivefalse/' GeoTopo.tex
	make


clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.out *.thm *.idx *.toc *.ind *.ilg *.glg *.glo *.gls *.ist *.xdy *.fdb_latexmk *.bak *.ilg
