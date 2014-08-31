I think I may not add this to my repository. So please have a look at

* [www.math.kit.edu/...](http://www.math.kit.edu/lehre/seite/bachmastarbeiten/de#Latexvorlage%20f%C3%BCr%20Bachelorarbeit)

## Problems
There seems to be a problem that `\section` does not compile.

This seems to be a problem of the latest version of koma scripts.
It happens with `\pagestyle{headings}`.
You can eventually get rid of it by adding `\usepackage{scrpage2}` to 
your preamble and set `\pagestyle{scrheadings}`.