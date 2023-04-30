/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asteroids_cmb;

import java.awt.Polygon;
import java.util.Random;

/**
 *
 * @author RealProgramming4Kids
 */
public class Asteroid extends VectorSprite
{
    int size;
   static  Random rng = new Random(System.currentTimeMillis());
   public Asteroid(double x, double y, int s)
   {
       size = s;
       initAsteroid();
       xPosition = x;
       yPosition = y;
   }
    public Asteroid()
    {
        size = 6;
       initAsteroid();
    }
    public void initAsteroid()
    {
       int x,y;
       shape = new Polygon();
       drawShape = new Polygon();
       //1
       x = rng.nextInt(5);
       y = rng.nextInt(5) -10;
       shape.addPoint(x*size, y*size);
       drawShape.addPoint(x*size, y*size);
       //2
       x = rng.nextInt(5) +5;
       y = rng.nextInt(5) -5;
       shape.addPoint(x*size, y*size);
       drawShape.addPoint(x*size, y*size);
       //3
       x = rng.nextInt(5) +5;
       y = rng.nextInt(5);
       shape.addPoint(x*size, y*size);
       drawShape.addPoint(x*size, y*size);
       //4
       x = rng.nextInt(5);
       y = rng.nextInt(5)+ 5;
       shape.addPoint(x*size, y*size);
       drawShape.addPoint(x*size, y*size);
       //5
       x = rng.nextInt(5) -5;
       y = rng.nextInt(5)+ 5;
       shape.addPoint(x*size, y*size);
       drawShape.addPoint(x*size, y*size);
       //6
       x = rng.nextInt(5) -10;
       y = rng.nextInt(5);
       shape.addPoint(x*size, y*size);
       drawShape.addPoint(x*size, y*size);
       //7
       x = rng.nextInt(5) -10;
       y = rng.nextInt(5) -5;
       shape.addPoint(x*size, y*size);
       drawShape.addPoint(x*size, y*size);
       //8
       x = rng.nextInt(5) -5;
       y = rng.nextInt(5) -10;
       shape.addPoint(x*size, y*size);
       drawShape.addPoint(x*size, y*size);
       
       angle = rng.nextInt((int)Math.round(2*Math.PI));
       THRUST = rng.nextInt(4)+1;
       xSpeed =Math.cos(angle)*THRUST;
       ySpeed =Math.sin(angle)*THRUST;
       
       xPosition = 450 + Math.cos(angle)*(rng.nextInt(500)+500);
       yPosition = 300 + Math.sin(angle)*(rng.nextInt(500)+500);
       ROTATION = rng.nextInt(10) - 10;
       alive = true;
    }
    
    @Override
    public void updatePosition()
    {
        angle += ROTATION;
        super.updatePosition();
    }
}
