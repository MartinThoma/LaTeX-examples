#!/usr/bin/env python
# -*- coding: utf-8 -*-

import re, glob

def get_definitions(filename):
    with open(filename) as f:
        content = f.read()

    pattern = re.compile(r"\\begin{definition}.*?\\end{definition}", re.DOTALL)
    m = re.findall(pattern, content)
    return "\\vspace*{\\fill}"+("\n\\vspace*{\\fill}\\clearpage\\vspace*{\\fill}\n".join(m))

def write_definitions_to_template(definitions, template="mathe-vorlage.tex", target="definitionen.tex"):
    with open(template) as f:
        content = f.read()
    content = content.replace('%CONTENT%', definitions)

    with open(target, 'w') as f:
        f.write(content)

if __name__ == "__main__":
    definitions = []
    for texsource in sorted(glob.glob("../Kapitel*.tex")):
        definitions.append(get_definitions(texsource))
    write_definitions_to_template("\n\n\n".join(definitions))
