\documentclass{article}
\usepackage[pdftex,active,tightpage]{preview}
\setlength\PreviewBorder{2mm}

\usepackage{pgfplots}

\begin{document}
\begin{preview}
\begin{tikzpicture}
    \begin{axis}[
    view = {120}{35},% important to draw x,y in increasing order
    xmin = 0,
    ymin = 0,
    xmax = [XMAX],
    ymax = [YMAX],
    zmin = 0,
    unbounded coords = jump,
    colormap={pos}{color(0cm)=(white); color(6cm)=(blue)}
    ]
    \addplot3[surf,mark=none] coordinates {
        [PLACE_PLOT_HERE]
    };
    \end{axis}
\end{tikzpicture}
\end{preview}
\end{document}
