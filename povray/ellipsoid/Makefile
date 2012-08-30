SOURCE = ellipsoid
DELAY = 80
DENSITY = 300
HEIGHT = 600
WIDTH = 800

make:
	povray $(SOURCE).pov Width=$(WIDTH) HEIGHT=$(HEIGHT) +O$(SOURCE).png +Q9 +A
	make clean

clean:
	rm -rf  $(TARGET) *.class *.html *.log *.aux *.data *.gnuplot

png:
	make
