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
public class Space_Ship2 extends VectorSprite
{
    int respawnDelay, lives, ammo, speed;
    
    public Space_Ship2()
    {
        shape = new Polygon();
        shape.addPoint(0,-25);
        shape.addPoint(15, 10);
        shape.addPoint(0,0);
        shape.addPoint(-15, 10);
        drawShape = new Polygon();
        drawShape.addPoint(0,-25);
        drawShape.addPoint(15, 10);
        drawShape.addPoint(0,0);
        drawShape.addPoint(-15, 10);
        xPosition = Window.width/2 + Window.width/16;
        yPosition = Window.height/2;
        drawShape.translate((int)xPosition, (int)yPosition);
        alive = true;
        lives = 3;
        THRUST = 1;
        ammo = 10;
        speed = 7;
    }
    public void acceletate()
    {
       xSpeed += Math.cos(angle*(Math.PI/180)-(Math.PI/2))*THRUST;
        
       ySpeed += Math.sin(angle*(Math.PI/180)-(Math.PI/2))*THRUST;
            
        if(ySpeed <= -speed)
            ySpeed = -speed;
        if(ySpeed >= speed)
            ySpeed = speed;
        if(xSpeed <=- speed)
           xSpeed = -speed;
         if(xSpeed >=  speed)
           xSpeed = speed;
        
    }
    
    public void brake()
    {
        xSpeed /= 1.05;
        ySpeed /= 1.05;
    }
    public void rotateLeft()
    {
        angle += -ROTATION;
    }
    public void rotateRight()
    {
        angle += ROTATION;
    }
    public void hit()
    {
        if(respawnDelay >100)
        {
        alive = false;
        counter = 0;
        }
    }
    public void reset()
    {
        if(lives > 0)
        {
        lives --;
        xPosition = Window.width/2 + Window.width/16;
        yPosition = Window.height/2;
        xSpeed = 0;
        ySpeed = 0;
        angle = 0;
        alive = true;
        ammo = 10;
        respawnDelay = 0;
        }
    }
    @Override
    public void updatePosition()
    {
        super.updatePosition();
        respawnDelay ++;
        
    }
}
