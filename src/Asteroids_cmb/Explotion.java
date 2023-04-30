/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asteroids_cmb;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

/**
 *
 * @author RealProgramming4Kids
 */
public class Explotion extends VectorSprite
{
    double x, y;
    Color color;
    public Explotion(double x, double y, Color c)
    {
        color = c;
          Random r = new Random(System.nanoTime());
           shape = new Polygon(); 
           drawShape = new Polygon();
           shape.addPoint(0, 0);
           shape.addPoint(0, 0);
           shape.addPoint(0, 0);
           drawShape.addPoint(0, 0);
           drawShape.addPoint(0, 0);
           drawShape.addPoint(0, 0);
           xPosition = x;
           yPosition = y;
           THRUST = 5;
           angle = r.nextDouble()*360;
           xSpeed = Math.cos(angle*(Math.PI/180)-(Math.PI/2))*THRUST;
           ySpeed = Math.sin(angle*(Math.PI/180)-(Math.PI/2))*THRUST;
    }
    @Override
    public void paint(Graphics g)
    {
       g.setColor(color);
       g.drawPolygon(drawShape);
       
    }
}
