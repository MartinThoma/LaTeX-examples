#!/usr/bin/env python

import os
from os import listdir
from os.path import isfile, join

import logging
import sys

logging.basicConfig(format='%(asctime)s %(levelname)s %(message)s',
                    level=logging.DEBUG,
                    stream=sys.stdout)


def create_readme(directory):
    project_name = os.path.basename(directory)
    onlyfiles = [f.lower()
                 for f in listdir(directory)
                 if isfile(join(directory, f))]
    if ('%s.tex' % project_name) not in onlyfiles:
        logging.warning("Dir '%s' has no standard .tex filename.", directory)
        return
    text = "Compiled example\n"
    text += "----------------\n"
    text += "![Example](%s.png)\n" % project_name
    with open(os.path.join(directory, "README.md"), 'w') as f:
        f.write(text)
    os.system("make png -C %s" % directory)

subdirs = [x[0] for x in os.walk('.')]
subdirs = [f for f in subdirs
           if not any([True for e in f.split('/')
                       if e.startswith('.') and len(e) > 1])]
for subdir in subdirs:
    onlyfiles = [f.lower() for f in listdir(subdir) if isfile(join(subdir, f))]
    if 'readme.md' not in onlyfiles:
        create_readme(subdir)
