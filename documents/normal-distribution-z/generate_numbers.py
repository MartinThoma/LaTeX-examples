#!/usr/bin/env python

"""
Generate the LaTeX code for a table of the PPF of a normal distribution.

PPF stands for Percent point function (inverse of cdf - percentiles).
"""

from scipy.stats import norm
from numpy import arange

for x in arange(0.0, 1.0, 0.1):
    line = "\\textbf{%0.1f} & " % x
    values = [norm.ppf(x + dx) for dx in arange(0.00, 0.09 + 0.01, 0.01)]
    values = ["%0.4f" % el for el in values]
    line += " & ".join(values)
    print(line + "\\\\")
