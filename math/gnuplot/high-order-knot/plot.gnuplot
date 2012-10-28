set terminal latex
set output "plot-tmp.tex"
set nokey
set parametric
set hidden3d
set view 45,60
set isosamples 200,15
splot [-3*pi:3*pi][-pi:pi] cos(u)*cos(v)+3*cos(u)*(1.5+sin(u*5/3)/2),\
sin(u)*cos(v)+3*sin(u)*(1.5+sin(u*5/3)/2), sin(v)+2*cos(u*5/3)
