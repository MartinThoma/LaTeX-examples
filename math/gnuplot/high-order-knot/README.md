Use gnuplot within latex
========================
* First make sure that you can use gnuplot:
  * Execute `gnuplot` in your command line
    * Doesn't work:
      * Look up where the binary is located (e.g. `C:\Programs\gnuplot\bin\gnuplot.exe`)
      * Add the binary directory to your path (Windows + Pause -> System variables -> Path)
      * Try executing `gnuplot` in terminal again
* It is a good idea to separate gnuplot-code from LaTeX-code! (see plot.gnuplot)
* `-shell-escape` or `enable-write18` is NOT needed for this solution!
* You have to create the plot-tmp.tex file first. Use `gnuplot plot.gnuplot` to do so.

GnuPlot Terminal types
----------------------
Available terminal types:

           aed512  AED 512 Terminal
           aed767  AED 767 Terminal
             aifm  Adobe Illustrator 3.0 Format
         bitgraph  BBN Bitgraph Terminal
              cgm  Computer Graphics Metafile
            corel  EPS format for CorelDRAW
             dumb  ascii art for anything that prints text
              dxf  dxf-file for AutoCad (default size 120x80)
            eepic  EEPIC -- extended LaTeX picture environment
              emf  Enhanced Metafile format
            emtex  LaTeX picture environment with emTeX specials
         epslatex  LaTeX picture environment using graphicx package
     epson_180dpi  Epson LQ-style 180-dot per inch (24 pin) printers
      epson_60dpi  Epson-style 60-dot per inch printers
      epson_lx800  Epson LX-800, Star NL-10, NX-1000, PROPRINTER ...
              fig  FIG graphics language for XFIG graphics editor
              gif  GIF images using libgd and TrueType fonts
             gpic  GPIC -- Produce graphs in groff using the gpic preprocessor
          hp2623A  HP2623A and maybe others
           hp2648  HP2648 and HP2647
           hp500c  HP DeskJet 500c, [75 100 150 300] [rle tiff]
             hpdj  HP DeskJet 500, [75 100 150 300]
             hpgl  HP7475 and relatives [number of pens] [eject]
           hpljii  HP Laserjet series II, [75 100 150 300]
             hppj  HP PaintJet and HP3630 [FNT5X9 FNT9X17 FNT13X25]
           imagen  Imagen laser printer
             jpeg  JPEG images using libgd and TrueType fonts
       kc_tek40xx  MS-DOS Kermit Tek4010 terminal emulator - color
       km_tek40xx  MS-DOS Kermit Tek4010 terminal emulator - monochrome
            latex  LaTeX picture environment
               mf  Metafont plotting standard
              mif  Frame maker MIF 3.00 format
               mp  MetaPost plotting standard
          nec_cp6  NEC printer CP6, Epson LQ-800 [monocrome color draft]
          okidata  OKIDATA 320/321 Standard
              pbm  Portable bitmap [small medium large] [monochrome gray color]
             pcl5  HP Designjet 750C, HP Laserjet III/IV, etc. (many options)
              png  PNG images using libgd and TrueType fonts
       postscript  PostScript graphics, including EPSF embedded files (*.eps)
          pslatex  LaTeX picture environment with PostScript \specials
            pstex  plain TeX with PostScript \specials
         pstricks  LaTeX picture environment with PSTricks macros
              qms  QMS/QUIC Laser printer (also Talaris 1200 and others)
            regis  REGIS graphics language
          selanar  Selanar
            starc  Star Color Printer
              svg  W3C Scalable Vector Graphics driver
      tandy_60dpi  Tandy DMP-130 series 60-dot per inch graphics
          tek40xx  Tektronix 4010 and others; most TEK emulators
          tek410x  Tektronix 4106, 4107, 4109 and 420X terminals
          texdraw  LaTeX texdraw environment
             tgif  TGIF X11 [mode] [x,y] [dashed] ["font" [fontsize]]
         tkcanvas  Tk/Tcl canvas widget [perltk] [interactive]
             tpic  TPIC -- LaTeX picture environment with tpic \specials
          unknown  Unknown terminal type - not a plotting device
            vttek  VT-like tek40xx terminal emulator
              wxt  wxWidgets cross-platform windowed terminal
              x11  X11 Window System
             xlib  X11 Window System (gnulib_x11 dump)
            xterm  Xterm Tektronix 4014 Mode

The following sound good:

            eepic  EEPIC -- extended LaTeX picture environment
            emtex  LaTeX picture environment with emTeX specials
         epslatex  LaTeX picture environment using graphicx package
            latex  LaTeX picture environment
          pslatex  LaTeX picture environment with PostScript \specials
         pstricks  LaTeX picture environment with PSTricks macros
          texdraw  LaTeX texdraw environment
             tpic  TPIC -- LaTeX picture environment with tpic \specials
              svg  W3C Scalable Vector Graphics driver
              png  PNG images using libgd and TrueType fonts

Sources
-------
* [konze.org](http://konze.org/?p=422): Thanks for mentioning the image source
* [soukoreff.com/gnuplot](http://soukoreff.com/gnuplot/): Thanks for this amazing knot
* [eelvex.net](http://www.eelvex.net/latex/graphs-and-diagrams-in-latex/): Thanks for the solution that actually worked
