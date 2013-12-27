settings.outformat="pdf";

import graph3;
import contour;

// A bunch of auxiliary functions.

real fuzz = .001;

real umin(surface s) { return 0; }
real vmin(surface s) { return 0; }
pair uvmin(surface s) { return (umin(s), vmin(s)); }
real umax(surface s, real fuzz=fuzz) {
  if (s.ucyclic()) return s.index.length;
  else return s.index.length - fuzz;
}
real vmax(surface s, real fuzz=fuzz) {
  if (s.vcyclic()) return s.index[0].length;
  return s.index[0].length - fuzz;
}
pair uvmax(surface s, real fuzz=fuzz) { return (umax(s,fuzz), vmax(s,fuzz)); }

typedef real function(real, real);

function normalDot(surface s, triple eyedir(triple)) {
  real toreturn(real u, real v) {
    return dot(s.normal(u, v), eyedir(s.point(u,v)));
  }
  return toreturn;
}

struct patchWithCoords {
  patch p;
  real u;
  real v;
  void operator init(patch p, real u, real v) {
    this.p = p;
    this.u = u;
    this.v = v;
  }
  void operator init(surface s, real u, real v) {
    int U=floor(u);
    int V=floor(v);
    int index = (s.index.length == 0 ? U+V : s.index[U][V]);

    this.p = s.s[index];
    this.u = u-U;
    this.v = v-V;
  }
  triple partialu() {
    return p.partialu(u,v);
  }
  triple partialv() {
    return p.partialv(u,v);
  }
}

typedef triple paramsurface(pair);

paramsurface tangentplane(surface s, pair pt) {
  patchWithCoords thepatch = patchWithCoords(s, pt.x, pt.y);
  triple partialu = thepatch.partialu();
  triple partialv = thepatch.partialv();
  return new triple(pair tangentvector) {
    return s.point(pt.x, pt.y) + (tangentvector.x * partialu) + (tangentvector.y * partialv);
  };
}

guide[] normalpathuv(surface s, projection P = currentprojection, int n = ngraph) {
  triple eyedir(triple a);
  if (P.infinity) eyedir = new triple(triple) { return P.camera; };
  else eyedir = new triple(triple pt) { return P.camera - pt; };
  return contour(normalDot(s, eyedir), uvmin(s), uvmax(s), new real[] {0}, nx=n)[0];
}

path3 onSurface(surface s, path p) {
  triple f(int t) {
    pair point = point(p,t);
    return s.point(point.x, point.y);
  }

  guide3 toreturn = f(0);
  paramsurface thetangentplane = tangentplane(s, point(p,0));
  triple oldcontrol, newcontrol;
  int size = length(p);
  for (int i = 1; i <= size; ++i) {
    oldcontrol = thetangentplane(postcontrol(p,i-1) - point(p,i-1));
    thetangentplane = tangentplane(s, point(p,i));
    newcontrol = thetangentplane(precontrol(p, i) - point(p,i));
    toreturn = toreturn .. controls oldcontrol and newcontrol .. f(i);
  }

  if (cyclic(p)) toreturn = toreturn & cycle;

  return toreturn;

}

/*
 * This method returns an array of paths that trace out all the
 * points on s at which s is parallel to eyedir.
 */

path[] paramSilhouetteNoEdges(surface s, projection P = currentprojection, int n = ngraph) {
   guide[] uvpaths = normalpathuv(s, P, n);
  //Reduce the number of segments to conserve memory
  for (int i = 0; i < uvpaths.length; ++i) {
    real len = length(uvpaths[i]);
    uvpaths[i] = graph(new pair(real t) {return point(uvpaths[i],t);}, 0, len, n=n);
  }
  return uvpaths;
}   

private typedef real function2(real, real);
private typedef real function3(triple);

triple[] normalVectors(triple dir, triple surfacen) {
  dir = unit(dir);
  surfacen = unit(surfacen);
  triple v1, v2;
  int i = 0;
  do {
    v1 = unit(cross(dir, (unitrand(), unitrand(), unitrand())));
    v2 = unit(cross(dir, (unitrand(), unitrand(), unitrand())));
    ++i;
  } while ((abs(dot(v1,v2)) > Cos(10) || abs(dot(v1,surfacen)) > Cos(5) || abs(dot(v2,surfacen)) > Cos(5)) && i < 1000);
  if (i >= 1000) {
    write("problem: Unable to comply.");
    write(" dir = " + (string)dir);
    write(" surface normal = " + (string)surfacen);
  }
  return new triple[] {v1, v2};
}

function3 planeEqn(triple pt, triple normal) {
  return new real(triple r) {
    return dot(normal, r - pt);
  };
}

function2 pullback(function3 eqn, surface s) {
  return new real(real u, real v) {
    return eqn(s.point(u,v));
  };
}

/*
 * returns the distinct points in which the surface intersects
 * the line through the point pt in the direction dir
 */

triple[] intersectionPoints(surface s, pair parampt, triple dir) {
  triple pt = s.point(parampt.x, parampt.y);
  triple[] lineNormals = normalVectors(dir, s.normal(parampt.x, parampt.y));
  path[][] curves;
  for (triple n : lineNormals) {
    function3 planeEn = planeEqn(pt, n);
    function2 pullback = pullback(planeEn, s);
    guide[] contour = contour(pullback, uvmin(s), uvmax(s), new real[]{0})[0];

    curves.push(contour);
  }
  pair[] intersectionPoints;
  for (path c1 : curves[0])
    for (path c2 : curves[1])
      intersectionPoints.append(intersectionpoints(c1, c2));
  triple[] toreturn;
  for (pair P : intersectionPoints)
    toreturn.push(s.point(P.x, P.y));
  return toreturn;
}



/*
 * Returns those intersection points for which the vector from pt forms an
 * acute angle with dir.
 */
 int numPointsInDirection(surface s, pair parampt, triple dir, real fuzz=.05) {
  triple pt = s.point(parampt.x, parampt.y);
  dir = unit(dir);
  triple[] intersections = intersectionPoints(s, parampt, dir);
  int num = 0;
  for (triple isection: intersections)
    if (dot(isection - pt, dir) > fuzz) ++num;
  return num;
}

bool3 increasing(real t0, real t1) {
  if (t0 < t1) return true;
  if (t0 > t1) return false;
  return default;
}

int[] extremes(real[] f, bool cyclic = f.cyclic) {
  bool3 lastIncreasing;
  bool3 nextIncreasing;
  int max;
  if (cyclic) {
    lastIncreasing = increasing(f[-1], f[0]);
    max = f.length - 1;
  } else {
    max = f.length - 2;
    if (increasing(f[0], f[1])) lastIncreasing = false;
    else lastIncreasing = true;
  }
  int[] toreturn;
  for (int i = 0; i <= max; ++i) {
    nextIncreasing = increasing(f[i], f[i+1]);
    if (lastIncreasing != nextIncreasing) {
      toreturn.push(i);
    }
    lastIncreasing = nextIncreasing;
  }
  if (!cyclic) toreturn.push(f.length - 1);
  toreturn.cyclic = cyclic;
  return toreturn;
}

int[] extremes(path path, real f(pair) = new real(pair P) {return P.x;})
{
  real[] fvalues = new real[size(path)];
  for (int i = 0; i < fvalues.length; ++i) {
    fvalues[i] = f(point(path, i));
  }
  fvalues.cyclic = cyclic(path);
  int[] toreturn = extremes(fvalues);
  fvalues.delete();
  return toreturn;
}

path[] splitAtExtremes(path path, real f(pair) = new real(pair P) {return P.x;})
{
  int[] splittingTimes = extremes(path, f);
  path[] toreturn;
  if (cyclic(path)) toreturn.push(subpath(path, splittingTimes[-1], splittingTimes[0]));
  for (int i = 0; i+1 < splittingTimes.length; ++i) {
    toreturn.push(subpath(path, splittingTimes[i], splittingTimes[i+1]));
  }
  return toreturn;
}

path[] splitAtExtremes(path[] paths, real f(pair P) = new real(pair P) {return P.x;})
{
  path[] toreturn;
  for (path path : paths) {
    toreturn.append(splitAtExtremes(path, f));
  }
  return toreturn;
}

path3 toCamera(triple p, projection P=currentprojection, real fuzz = .01, real upperLimit = 100) {
  if (!P.infinity) {
    triple directionToCamera = unit(P.camera - p);
    triple startingPoint = p + fuzz*directionToCamera;
    return startingPoint -- P.camera;
  }
  else {
    triple directionToCamera = unit(P.camera);
    triple startingPoint = p + fuzz*directionToCamera;

    return startingPoint -- (p + upperLimit*directionToCamera);
  }
}

int numSheetsHiding(surface s, pair parampt, projection P = currentprojection) {
  triple p = s.point(parampt.x, parampt.y);
  path3 tocamera = toCamera(p, P);
  triple pt = beginpoint(tocamera);
  triple dir = endpoint(tocamera) - pt;
  return numPointsInDirection(s, parampt, dir);
}

struct coloredPath {
  path path;
  pen pen;
  void operator init(path path, pen p=currentpen) {
    this.path = path;
    this.pen = p;
  }
  /* draws the path with the pen having the specified weight (using colors)*/
  void draw(real weight) {
    draw(path, p=weight*pen + (1-weight)*white);
  }
}
coloredPath[][] layeredPaths;
// onTop indicates whether the path should be added at the top or bottom of the specified layer
void addPath(path path, pen p=currentpen, int layer, bool onTop=true) {
  coloredPath toAdd = coloredPath(path, p);
  if (layer >= layeredPaths.length) {
    layeredPaths[layer] = new coloredPath[] {toAdd};
  } else if (onTop) {
    layeredPaths[layer].push(toAdd);
  } else layeredPaths[layer].insert(0, toAdd);
}

void drawLayeredPaths() {
  for (int layer = layeredPaths.length - 1; layer >= 0; --layer) {
    real layerfactor = (1/3)^layer;
    for (coloredPath toDraw : layeredPaths[layer]) {
      toDraw.draw(layerfactor);
    }
  }
}

real[] cutTimes(path tocut, path[] knives) {
  real[] intersectionTimes = new real[] {0, length(tocut)};
  for (path knife : knives) {
    real[][] complexIntersections = intersections(tocut, knife);
    for (real[] times : complexIntersections) {
      intersectionTimes.push(times[0]);
    }
  }
  return sort(intersectionTimes);
}

path[] cut(path tocut, path[] knives) {
  real[] cutTimes = cutTimes(tocut, knives);
  path[] toreturn;
  for (int i = 0; i + 1 < cutTimes.length; ++i) {
    toreturn.push(subpath(tocut,cutTimes[i], cutTimes[i+1]));
  }
  return toreturn;
}

real[] condense(real[] values, real fuzz=.001) {
  values = sort(values);
  values.push(infinity);
  real previous = -infinity;
  real lastMin;
  real[] toReturn;
  for (real t : values) {
    if (t - fuzz > previous) {
      if (previous > -infinity) toReturn.push((lastMin + previous) / 2);
      lastMin = t;
    }
    previous = t;
  }
  return toReturn;
}

/*
 * A smooth surface parametrized by the domain [0,1] x [0,1]
 */
struct SmoothSurface {
  surface s;
  private real sumax;
  private real svmax;
  path[] paramSilhouette;
  path[] projectedSilhouette;
  projection theProjection;

  path3 onSurface(path paramPath) {
    return onSurface(s, scale(sumax,svmax)*paramPath);
  }

  triple point(real u, real v) { return s.point(sumax*u, svmax*v); }
  triple point(pair uv) { return point(uv.x, uv.y); }
  triple normal(real u, real v) { return s.normal(sumax*u, svmax*v); }
  triple normal(pair uv) { return normal(uv.x, uv.y); }

  void operator init(surface s, projection P=currentprojection) {
    this.s = s;
    this.sumax = umax(s);
    this.svmax = vmax(s);
    this.theProjection = P;
    this.paramSilhouette = scale(1/sumax, 1/svmax) * paramSilhouetteNoEdges(s,P);
    this.projectedSilhouette = sequence(new path(int i) {
    path3 truePath = onSurface(paramSilhouette[i]);
    path projectedPath = project(truePath, theProjection, ninterpolate=1);
    return projectedPath;
      }, paramSilhouette.length);
  }

  int numSheetsHiding(pair parampt) {
    return numSheetsHiding(s, scale(sumax,svmax)*parampt);
  }

  void drawSilhouette(pen p=currentpen, bool includePathsBehind=false, bool onTop = true) {
    int[][] extremes;
    for (path path : projectedSilhouette) {
      extremes.push(extremes(path));
    }

    path[] splitSilhouette;
    path[] paramSplitSilhouette;

    /*
     * First, split at extremes to ensure that there are no
     * self-intersections of any one subpath in the projected silhouette.
     */

    for (int j = 0; j < paramSilhouette.length; ++j) {
      path current = projectedSilhouette[j];

      path currentParam = paramSilhouette[j];

      int[] dividers = extremes[j];
      for (int i = 0; i + 1 < dividers.length; ++i) {
    int start = dividers[i];
    int end = dividers[i+1];
    splitSilhouette.push(subpath(current,start,end));
    paramSplitSilhouette.push(subpath(currentParam, start, end));
      }
    }

    /*
     * Now, split at intersections of distinct subpaths.
     */

    for (int j = 0; j < splitSilhouette.length; ++j) {
      path current = splitSilhouette[j];
      path currentParam = paramSplitSilhouette[j];

      real[] splittingTimes = new real[] {0,length(current)};
      for (int k = 0; k < splitSilhouette.length; ++k) {
    if (j == k) continue;
    real[][] times = intersections(current, splitSilhouette[k]);
    for (real[] time : times) {
      real relevantTime = time[0];
      if (.01 < relevantTime && relevantTime < length(current) - .01) splittingTimes.push(relevantTime);
    }
      }
      splittingTimes = sort(splittingTimes);
      for (int i = 0; i + 1 < splittingTimes.length; ++i) {
    real start = splittingTimes[i];
    real end = splittingTimes[i+1];
    real mid = start + ((end-start) / (2+0.1*unitrand()));
    pair theparampoint = point(currentParam, mid);
    int sheets = numSheetsHiding(theparampoint);

    if (sheets == 0 || includePathsBehind) {
      path currentSubpath = subpath(current, start, end);
      addPath(currentSubpath, p=p, onTop=onTop, layer=sheets);
    }

      }
    }
  }

  /*
    Splits a parametrized path along the parametrized silhouette,
    taking [0,1] x [0,1] as the
    fundamental domain.  Could be implemented more efficiently.
  */
  private real[] splitTimes(path thepath) {
    pair min = min(thepath);
    pair max = max(thepath);
    path[] baseknives = paramSilhouette;
    path[] knives;
    for (int u = floor(min.x); u < max.x + .001; ++u) {
      for (int v = floor(min.y); v < max.y + .001; ++v) {
    knives.append(shift(u,v)*baseknives);
      }
    }
    return cutTimes(thepath, knives);
  }

  /*
    Returns the times at which the projection of the given path3 intersects
    the projection of the surface silhouette. This may miss unstable
    intersections that can be detected by the previous method.
  */
  private real[] silhouetteCrossingTimes(path3 thepath, real fuzz = .01) {
    path projectedpath = project(thepath, theProjection, ninterpolate=1);
    real[] crossingTimes = cutTimes(projectedpath, projectedSilhouette);
    if (crossingTimes.length == 0) return crossingTimes;
    real current = 0;
    real[] toReturn = new real[] {0};
    for (real prospective : crossingTimes) {
      if (prospective > current + fuzz
      && prospective < length(thepath) - fuzz) {
    toReturn.push(prospective);
    current = prospective;
      }
    }
    toReturn.push(length(thepath));
    return toReturn;
  }

  void drawSurfacePath(path parampath, pen p=currentpen, bool onTop=true) {
    path[] toDraw;
    real[] crossingTimes = splitTimes(parampath);
    crossingTimes.append(silhouetteCrossingTimes(onSurface(parampath)));
    crossingTimes = condense(crossingTimes);
    for (int i = 0; i+1 < crossingTimes.length; ++i) {
      toDraw.push(subpath(parampath, crossingTimes[i], crossingTimes[i+1]));
    }
    for (path thepath : toDraw) {
      pair midpoint = point(thepath, length(thepath) / (2+.1*unitrand()));
      int sheets = numSheetsHiding(midpoint);
      path path3d = project(onSurface(thepath), theProjection, ninterpolate = 1);
      addPath(path3d, p=p, onTop=onTop, layer=sheets);
    }
  }
}

real unit = 4cm;
unitsize(unit);
triple eye = (10,1,4);
//currentprojection=perspective(2*eye);
currentprojection=orthographic(eye);

surface torus = surface(Circle(c=2Y, r=0.6, normal=X, n=32), c=O, axis=Z, n=32);
torus.ucyclic(true);
torus.vcyclic(true);

SmoothSurface Torus = SmoothSurface(torus);

Torus.drawSilhouette(p=black, includePathsBehind=true);

pair a = (22/40, 3/40);
pair b = (5/40, .5);

path abpathparam(int ucycles, int vcycles) {
  pair bshift = (ucycles, vcycles);
  pair f(real t) {
    return (1-t)*a + t*(b+bshift);
  }
  return graph(f, 0, 1);
}

real linewidth = 0.8pt;

Torus.drawSurfacePath(abpathparam(0,0), p=linewidth + orange);
Torus.drawSurfacePath(abpathparam(1,0), p=linewidth + red);
Torus.drawSurfacePath(abpathparam(1,-1), p=linewidth + (darkgreen + 0.2blue));

pen meshpen = gray(0.6);
for (real u = 0; u < 1; u += 1/10) {
  Torus.drawSurfacePath(graph(new pair(real v) {return (u,v);}, 0,1,n=10), p=meshpen, onTop=false);
}
for (real v = 0; v < 1; v += 1/10) {
  Torus.drawSurfacePath(graph(new pair(real u) {return (u,v);}, 0, 1, n=10), p=meshpen, onTop=false);
}

drawLayeredPaths();

dot(project(Torus.point(a.x,a.y)), L="$a$", align=W);
dot(project(Torus.point(b.x,b.y)), L="$b$", align=N);
