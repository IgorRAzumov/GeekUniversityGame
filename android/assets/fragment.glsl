#version 100

varying mediump vec2 v_texCoords;
uniform sampler2D u_texture;
uniform mediump float damageAlarm;

void main() {
  gl_FragColor = texture2D(u_texture, v_texCoords);
  if(v_texCoords.y > 0.8 ) {
    gl_FragColor.r += damageAlarm * (v_texCoords.y - 0.8) * 2.0;
  }
  if(v_texCoords.y < 0.2 ) {
    gl_FragColor.r +=damageAlarm * (0.2 - v_texCoords.y) * 2.0;
  }

}