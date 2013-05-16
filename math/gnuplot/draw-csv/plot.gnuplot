set terminal latex
set output "plot-tmp.tex"
set datafile separator "," 
plot 'data.csv' every::1::7  using 1:2:3:4 with vectors
