#declare M_Glass=    // Glass material
material {
  texture {
    pigment {rgbt 1}
    finish {
      ambient 0.0
      diffuse 0.05
      specular 0.6
      roughness 0.005
      reflection {
        0.1, 1.0
        fresnel on
      }
      conserve_energy
    }
  }
  interior {
    ior 1.5 // Glass refraction
    fade_power 1000
    fade_distance 0.9
    fade_color <0.1,0.1,0.9>
  }
}
