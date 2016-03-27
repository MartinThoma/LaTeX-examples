#!/usr/bin/env python

"""Generate the LaTeX code for a table of the CDF of a normal distribution."""

from scipy.stats import norm
from numpy import arange

for x in arange(0.0, 4.0, 0.1):
    line = "\\textbf{%0.1f} & " % x
    values = [norm.cdf(x+dx) for dx in arange(0.00, 0.09 + 0.01, 0.01)]
    values = ["%0.4f" % el for el in values]
    line += " & ".join(values)
    print(line + "\\\\")
