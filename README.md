LaTeX-examples
==============

More than 200 examples for the usage of LaTeX 
(you can check that with the following command: `find . -type d | sort | awk '$0 !~ last "/" {print last} {last=$0} END {print last}' | grep -v .git | wc -l`)

Most examples can be found on [my Wikpedia Commons user page](http://commons.wikimedia.org/wiki/User:MartinThoma#Galerie)

You might also be interested in [my Blog](http://martin-thoma.com/tag/tikz/)

Usage
=====

Every LaTeX file is in a seperate folder and has its own Makefile.
So you can simply generate the PDF by typing "make" in the terminal.

Requirements
============

* You should have the latest LaTeX version. Here are
  [LaTeX installation instructions](http://martin-thoma.com/how-to-install-the-latest-latex-version/)
* If you want to use the Makefiles, you have to have make

POV-Ray
=======
Although POV-Ray has nothing to do with LaTeX, I decided to add
some images here

* [POV-Ray Documentation](http://www.povray.org/documentation/)
* [Ubuntuusers.de](http://wiki.ubuntuusers.de/POV-Ray) - German installation instructions
* [Many examples](http://www.f-lohmueller.de/)
* [More examples with complete sources](http://www.ms.uky.edu/~lee/visual05/povray/povray.html)
* [High quality examples](http://hof.povray.org/)

Contact
=======
If you have examples or suggestions for improving given examples, 
you send them to info@martin-thoma.de

Re-use
=======
Feel free to use and modify the examples of this repository.
But please add a link to this repository or martin-thoma.com
