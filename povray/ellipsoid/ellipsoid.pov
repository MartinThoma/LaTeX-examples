#include "colors.inc"
#include "stones.inc" // needed for texture T_Stone1

camera {
  location <10, 10, 0>
  look_at <0, 0, 0>
}

plane {
  y, 0
  pigment { checker color Gray color White  }
}

sphere {
  <0, 0, 0>, 4  // center and radius
  scale<1,1,1.4> 
  pigment { color Green transmit 0.5 }
  finish {
    reflection 0.1
    phong 0.3
  }
}
light_source { <5, 10, 10> color White }
light_source { <10, 10, 5> color White }
