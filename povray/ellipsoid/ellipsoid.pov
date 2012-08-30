#version 3.5;
#include "colors.inc"
#include "glass.inc" 

camera {
  location <14, 8, 0>
  look_at <0, 0, 0>
}

plane {
  y, -4
  pigment { checker color Gray color White  }
}

sphere {
  <0, 0, 0>, // center of the spehre
  4          // radius
  scale<1,1,1.4> 
  material { M_Glass }
  photons {  // photon block for an object
    target 1.0
    refraction on
    reflection on
  }
  finish {
    reflection 0.2 // glass reflects a bit
    phong 0.9 phong_size 40 // a highlight
  }
}

#declare Axis_texture = //
pigment {
  gradient <1,0,0>
  color_map {[0.0 color <1,1,1>]
    [0.5 color <1,1,1>]
    [0.5 color <1,0,0>] 
    [1.0 color <1,0,0>]
  }
    scale 2 
}


#declare Diameter = 0.1;
#declare LengthX = 5;
#declare LengthY = 8;
#declare LengthZ = 5;
#declare axisY = //
union {
  cylinder { 
    <0, 0, 0>, <LengthY, 0, 0>, Diameter
  }
  cone { <LengthY, 0, 0>, Diameter * 2, <LengthY + Diameter * 5 , 0, 0>, 0 }
  texture { Axis_texture}
  finish {ambient 0.1 diffuse 0.9 phong 1}
}
#declare axis = //
union {
  cylinder { 
    <0, 0, 0>, <LengthX, 0, 0>, Diameter
  }
  cone { <LengthX, 0, 0>, Diameter * 2, <LengthX + Diameter * 5 , 0, 0>, 0 }
  texture { Axis_texture}
  finish {ambient 0.1 diffuse 0.9 phong 1}
}

declare XYZ_axis = //
union {
  text {
    ttf "crystal.ttf",
    "0",
    .1,
    0 scale 0.5 
    pigment{color<1,1,0>}
  }
  union {
    object {axis}
    text {
        ttf "crystal.ttf",
        "X",
        .1,
        0 scale 0.5 
        pigment{color<1,1,0> }
        translate <LengthX, Diameter*2,Diameter*2>
    }
  }
  union {
    object {axisY}
    text {
        ttf "crystal.ttf",
        "Y",
        .1,
        0 scale 0.5
        pigment{color<1,1,0>}
        translate <LengthY, Diameter*2,Diameter*2>
    }
    rotate <0,90,0>
  }
  union {
    object {axis }
    text {  ttf   "crystal.ttf",  "Z",  .1,   0
    rotate <0,0,-90>
    scale 0.5 
    pigment{color<1,1,0>}
    translate <LengthZ,Diameter*2,Diameter*2> 
    }
    rotate <0,0,90>
  }
}

object {XYZ_axis}

// this should surround the elipsoid: box {<-1, -1, -1> < 1, 1, 1>}

light_source { <5, 10, 10> color White }
light_source { <10, 10, 5> color White }
