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
public class EnemyShip extends VectorSprite {
    Random r;
    public EnemyShip(Space_Ship ship){
        r = new Random(System.currentTimeMillis());// generates random number baised on seed seed is crent system time
        float size = (float) (r.nextFloat()*0.25 + 0.25);
        shape = new Polygon();// call on a constructor constructor 
        shape.addPoint((int) (73*size),(int) (22*size));// add x and y cordanates 
        shape.addPoint((int)(66*size),(int)(22*size));  // apears in center of origin at 0,0
        shape.addPoint((int)(51*size),(int) (41*size));  
        shape.addPoint((int)(22*size),(int) (59*size));
        shape.addPoint((int)(49*size),(int)(77*size));  
        shape.addPoint((int)(99*size),(int) (77*size));
        shape.addPoint((int)(128*size),(int) (59*size));
        shape.addPoint((int)(22*size),(int)(59*size));  
        shape.addPoint((int)(128*size),(int)(59*size));
        shape.addPoint((int)(97*size),(int) (41*size));
        shape.addPoint((int)(51*size),(int)(41*size));  
        shape.addPoint((int)(97*size),(int) (41*size));
        shape.addPoint((int)(86*size),(int) (22*size));
        
        drawShape = new Polygon();// call on a constructor constructor 
        drawShape.addPoint((int) (73*size),(int) (22*size));// add x and y cordanates 
        drawShape.addPoint((int)(66*size),(int)(22*size));  // apears in center of origin at 0,0
        drawShape.addPoint((int)(51*size),(int) (41*size));  
        drawShape.addPoint((int)(22*size),(int) (59*size));
        drawShape.addPoint((int)(49*size),(int)(77*size));  
        drawShape.addPoint((int)(99*size),(int) (77*size));
        drawShape.addPoint((int)(128*size),(int) (59*size));
        drawShape.addPoint((int)(22*size),(int)(59*size));  
        drawShape.addPoint((int)(128*size),(int)(59*size));
        drawShape.addPoint((int)(97*size),(int) (41*size));
        drawShape.addPoint((int)(51*size),(int)(41*size));  
        drawShape.addPoint((int)(97*size),(int) (41*size));
        drawShape.addPoint((int)(86*size),(int) (22*size));            
      
        
        int rnd;
        
        rnd = r.nextInt(900);// returns a random number between zero and random number specified
        xPosition = rnd+ship.xPosition;
        rnd = r.nextInt(450)+50;
        yPosition = rnd+ship.yPosition;
        THRUST = 1;
        alive = true;
        rnd = r.nextInt(9)+1;
        if(rnd < 5){
            xSpeed = - rnd -5;
        }else
            xSpeed = rnd;
        
    }

    void hit() {
        counter = 0;
        alive =false; // ship to false
    }
public void updatePosition(){
     if(counter%100 == 0){// mod is the percent sign
         ySpeed = -(r.nextInt(4)+1);// when using random class diffrence must be placed in brackets or it will break it 
     }else if(counter%100 == 50){
         ySpeed = r.nextInt(4)+1;     
     }
     super.updatePosition();
 }
}
