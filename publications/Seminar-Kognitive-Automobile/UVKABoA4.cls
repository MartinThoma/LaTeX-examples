%%%%%%%%%%%%%%%%%%%%%%%%%%%%Dokumentklasse UVKABook für A4%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{UVKABoA4}

\DeclareOption{twoside}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{parindent}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{11pt}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{liststotocnumbered}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{idxtotoc}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{bibtotocnumbered}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{idxtotocnumbered}{
	\AtEndOfClass{
		\renewcommand*\idx@heading{
			\if@openright\cleardoublepage\else\clearpage\fi
			\twocolumn[\chapter{\indexname}]
			\@mkboth{\indexname}{\indexname}
		}
	}
} \DeclareOption*{\PassOptionsToClass{\CurrentOption}{scrbook}}
\ExecuteOptions{parindent,twoside,11pt,liststotocnumbered,idxtotocnumbered,bibtotocnumbered}
\ProcessOptions\relax
\LoadClass{scrbook}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\let\switcht@@therlang\relax
\let\svlanginfo\relax
\def\ds@deutsch{\def\switcht@@therlang{\switcht@deutsch}
\gdef\svlanginfo{\typeout{Deutsche Sprache}\global\let\svlanginfo\relax}}

\AtBeginDocument{\@ifpackageloaded{babel}{
\@ifundefined{extrasgerman}{}{\addto\extrasgerman{\switcht@deutsch}}
\@ifundefined{extrasngerman}{}{\addto\extrasngerman{\switcht@deutsch}}
}{\switcht@@therlang}
}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\RequirePackage[T1]{fontenc}
\RequirePackage[utf8]{inputenc}
\RequirePackage[titles]{tocloft}
\RequirePackage{makeidx}
\RequirePackage{mathptmx}
\RequirePackage{natbib}
\RequirePackage{color}
\RequirePackage{scrpage2}
\RequirePackage[inner=3cm,%
								outer=2cm,%
								top=2.7cm,%
								bottom=3.2cm]{geometry}
\RequirePackage[onehalfspacing]{setspace}
%\clubpenalty = 10000 
%\widowpenalty = 10000
%\displaywidowpenalty = 10000

\bibliographystyle{abbrv}

\setheadsepline{.4pt}

\addtokomafont{chapter}{\fontfamily{phv}\fontsize{14}{14}\bfseries}
\addtokomafont{section}{\fontfamily{phv}\normalsize\bfseries}
\addtokomafont{subsection}{\fontfamily{phv}\normalsize\bfseries}
\addtokomafont{subsubsection}{\fontfamily{phv}\normalsize\bfseries}
\addtokomafont{caption}{\small}
\setkomafont{captionlabel}{\small}
\setkomafont{pagehead}{\small} 



\color[cmyk]{0,0,0,1}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

\deffootnote[1.5em]{2em}{1.5em}{\textsuperscript{\thefootnotemark}}

\renewcommand{\cftchappagefont}{\fontfamily{phv}\bfseries}
\renewcommand{\cftchapfont}{\fontfamily{phv}\bfseries}
\renewcommand{\cftsecpagefont}{\fontfamily{phv}}
\renewcommand{\cftsubsecpagefont}{\fontfamily{phv}}
\renewcommand{\cftsecfont}{\fontfamily{phv}}
\renewcommand{\cftsubsecfont}{\fontfamily{phv}}

\newcommand{\affirmation}[1][\affirmationname]{\chapter*{#1}}
\newcommand{\Affirmation}[1][\affirmationname]{\chapter*{#1}\addcontentsline{toc}{chapter}{#1}} 

\newcommand{\preface}[1][\prefacename]{\chapter*{#1}}
\newcommand{\Preface}[1][\prefacename]{\chapter*{#1}\addcontentsline{toc}{chapter}{#1}} 

\newcommand{\ack}[1][\ackname]{\chapter*{#1}}
\newcommand{\Ack}[1][\ackname]{\chapter*{#1}\addcontentsline{toc}{chapter}{#1}} 

\newcommand{\abstract}[1][\abstractname]{\chapter*{#1}}
\newcommand{\Abstract}[1][\abstractname]{\chapter*{#1}\addcontentsline{toc}{chapter}{#1}} 

\newcommand{\changefont}[3]{\fontfamily{#1} \fontseries{#2} \fontshape{#3} \selectfont}

\def\ackname{Acknowledgment}
\def\abstractname{Abstract}
\def\affirmationname{Affirmation}
\renewcommand{\figurename}{Fig.}
\renewcommand{\tablename}{Tab.}
\def\switcht@deutsch{\svlanginfo
	\def\ackname{Danksagung}
	\def\abstractname{Kurzfassung}
	\def\affirmationname{Erklärung}
	\renewcommand{\figurename}{Abb.}
  \renewcommand{\tablename}{Tab.}
}

\renewcommand*{\chapterpagestyle}{headings}
%\renewcommand{\baselinestretch}{1.33}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%