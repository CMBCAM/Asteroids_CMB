/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asteroids_cmb;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author RealProgramming4Kids
 */
public class VectorSprite 
{
    Polygon shape, drawShape;
    double xSpeed, ySpeed;
    double xPosition, yPosition;
    double angle;
    double ROTATION;
    double THRUST;
    boolean alive;
    int counter;
    
    public VectorSprite()
    {
        xPosition = 450;
        yPosition = 300;
        ROTATION = 10;
        THRUST = 5;
        alive = true;
        counter = 0;
    }
    
    public void paint(Graphics g)//Paint
    {
        g.fillPolygon(drawShape);//fillPolygon to fill it instead
    }       
    
    public void updatePosition()//Update
    {
        counter ++;
        xPosition += xSpeed;
        yPosition += ySpeed;
        for(int i=0; i < shape.npoints; i++)
        {
            int x,y;
            x = (int) Math.round(shape.xpoints[i]*Math.cos(angle*(Math.PI/180)) - shape.ypoints[i]*Math.sin(angle*(Math.PI/180)));
            y = (int) Math.round(shape.xpoints[i]*Math.sin(angle*(Math.PI/180)) + shape.ypoints[i]*Math.cos(angle*(Math.PI/180)));
            drawShape.xpoints[i] = x;
            drawShape.ypoints[i] = y;
        }
        drawShape.translate((int)xPosition, (int)yPosition);
        drawShape.invalidate();
        wrapAround();
    }
    public void wrapAround()
    {
        if(xPosition > Window.width + 50)
        {
            xPosition = 0;     
        }
        if(xPosition < -50)
        {
            xPosition = Window.width;
        }
        if(yPosition > Window.height +50)
        {
            yPosition = 0;
        }
        if(yPosition < -50)
        {
            yPosition = Window.height;
        }
        
    }
}
