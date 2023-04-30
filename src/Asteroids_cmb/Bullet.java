/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asteroids_cmb;

import java.awt.Polygon;

/**
 *
 * @author RealProgramming4Kids
 */
public class Bullet extends VectorSprite
{
    public Bullet(double x,double y, double a, double t)
       {
           shape = new Polygon(); 
           drawShape = new Polygon();
           shape.addPoint(3, 0);
           shape.addPoint(0, 3);
           shape.addPoint(-3, 0);
           shape.addPoint(0, -7);
           drawShape.addPoint(3, 0);
           drawShape.addPoint(0, 3);
           drawShape.addPoint(-3, 0);
           drawShape.addPoint(0, -7);
           xPosition = x;
           yPosition = y;
           angle = a;
           THRUST = t;
           ROTATION =99999;
           xSpeed = Math.cos(angle*(Math.PI/180)-(Math.PI/2))*THRUST;
           ySpeed = Math.sin(angle*(Math.PI/180)-(Math.PI/2))*THRUST;
           xPosition += xSpeed;
           yPosition += ySpeed;
           drawShape.translate((int)xPosition, (int)yPosition);
       }     
           
}
