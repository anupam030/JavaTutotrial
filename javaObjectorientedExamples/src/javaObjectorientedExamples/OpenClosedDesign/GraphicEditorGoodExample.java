package javaObjectorientedExamples.OpenClosedDesign;

// Open-Close Principle - Good example
 class GraphicEditorGoodExample {
 	public void drawShape(Shape s) {
 		s.draw();
 	}
 }
 
 abstract class Shape {
 	abstract void draw();
 }
 
 class Rectangle extends Shape  {
 	public void draw() {
 		// draw the rectangle
 	}
 } 