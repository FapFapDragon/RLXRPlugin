#version 330

layout(location = 0) in vec3 vertexPosition_modelspace;
uniform mat4 projectionMatrix;
uniform mat4 model;

void main(){
  gl_Position = projectionMatrix * model * vec4(vertexPosition_modelspace, 1.f);
  gl_Position.w = 1.0;
}