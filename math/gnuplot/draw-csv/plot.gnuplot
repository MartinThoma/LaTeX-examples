set terminal latex
set output "plot-tmp.tex"
set datafile separator "," 
plot 'data.csv' every::1::7  using 1:2:3:4 with vectors head size 0.1,20,60 filled lc palette
