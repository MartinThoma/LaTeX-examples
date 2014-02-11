#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import re, glob

def get_definitions(filename):
    with open(filename) as f:
        content = f.read()

    pattern = re.compile(r"^\\begin{definition}(.*?)\\end{definition}", re.DOTALL | re.UNICODE)
    index_pattern = re.compile(r"\\xindex{(?:.*?@)?(.*?)(?:\|.*?)?}", re.UNICODE)
    todo_pattern = re.compile(r"\\todo{.*?}", re.UNICODE)
    definitions = re.findall(pattern, content)
    def_dict_list = []
    for definition in definitions:
        names = re.findall(index_pattern, definition)
        names = map(lambda s: s.replace("!", ", "), names)
        name = "\\\\".join(names)
        definition = re.sub(todo_pattern, "", definition)
        def_dict_list.append({"name":name, "definition":definition})
    #return "\n\n".join('\\vspace*{{\\fill}}\n{0}\n\\vspace*{{\\fill}}\\clearpage'.format(definition["definition"]) for definition in def_dict_list)
    return "\n\n".join('\\begin{{flashcard}}{{ {1} }}\n{{ {0} }}\n\\end{{flashcard}}'.format(definition["definition"], definition["name"]) for definition in def_dict_list)

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
    write_definitions_to_template("\n\n\n".join(definitions), "flashcards-try.tex")
