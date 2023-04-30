/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asteroids_cmb;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

/**
 *
 * @author RealProgramming4Kids
 */
public class Main extends JPanel implements KeyListener, ActionListener, MouseListener 
{
    Space_Ship ship;
    Space_Ship2 ship2;
    EnemyShip bad;
    Timer timer;
    Cursor pointer;
    Image offScreen;
    Graphics offG;
    boolean upKey, leftKey, rightKey, spaceKey, reload, ya, paused, gameStart,turtorial,Word1,word2,word3,word4,word5,word6,word7,word8,word9 ,upKey2, leftKey2, rightKey2, spaceKey2, multi, h1, h2, green, sh1,sh2,mH, hx, gameOver, xHover, scoreHover,showHighscores,PVP, ctrl,alt,s,r,l,sn,snakeBrake;
    boolean rifle, shotgun, snake, lazer;
    ArrayList<Asteroid> rockList; 
    ArrayList<Bullet> bList;
    ArrayList<Bullet> bsList;
    ArrayList<Explotion> eList;
    ArrayList<Integer> highscore;
    Font font, sFont;
    int score, level ,extraLife;
    BufferedImage bg,bg2, ply1, ply2, ply1H, ply2H,gr,b,gh,bh,bs,gs,gameover, main, mainH, pause, cursor,x,xH, scores, scoresH,pvp,pvpH, marker;
    int mouseX, mouseY;
    int widthB,heightB, widthS, heightS, widthM, heightM,width;
    int bX1,bY1,bX2,bY2, sX1,sX2,sY1,sY2, mX1,mY1,mX2,mY2, xX1,xX2,xY1,xY2,scX1,scX2,scY1,scY2, hX,hY, hOffset;
    String fileHS = "Images/Background.jpg";
    final char[] numbers = {'0', '1', '2','3','4','5','6','7','8','9'};
    
    public Main(JFrame frame)//Contructor:new object
    {
        this.setFocusable(true);
        this.setSize(Window.width, Window.height);
        this.addKeyListener(this); 
        addMouseListener(this);
        green =true;
        ship = new Space_Ship();
        ship2 = new Space_Ship2();
        bad = new EnemyShip(ship);
        timer = new Timer(20, this);
        offScreen = frame.createImage(Window.width, Window.height);
        offG = offScreen.getGraphics();
        score = 0;
        level =1;
        ctrl=false;
        alt=false;
        rifle =true;
        turtorial =true;
        shotgun =false;
        lazer=false;
        snake=false;
        gameOver = false;
        gameStart=false;
        rockList = new ArrayList();
        bList = new ArrayList();
        bsList = new ArrayList();
        eList = new ArrayList();
        Asteroid a = new Asteroid();
        for(int i=0; i < 5; i++)
        {
            rockList.add(new Asteroid());
        }
        try
        {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf"));
            font = font.deriveFont(Font.PLAIN, 48);
            sFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf"));
            sFont = font.deriveFont(Font.PLAIN, 20);
            offG.setFont(font);
            marker = ImageIO.read(new File ("Images/Marker.png"));
            bg = ImageIO.read(new File("Images/Background2.jpg"));
            bg2 = ImageIO.read(new File("Images/Background2.jpg"));
            ply1 = ImageIO.read(new File("Images/Player 1.png"));
            ply2 = ImageIO.read(new File("Images/Player 2.png"));
            ply1H = ImageIO.read(new File("Images/Player 1 Hover.png"));
            ply2H = ImageIO.read(new File("Images/Player 2 Hover.png"));
            b = ImageIO.read(new File("Images/Blue Square.png"));
            gr = ImageIO.read(new File("Images/Green Square.png"));
            gh = ImageIO.read(new File("Images/Blue Square Hover.png"));
            bh = ImageIO.read(new File("Images/Green Square Hover.png"));
            gs = ImageIO.read(new File("Images/Blue Square Select.png"));
            bs = ImageIO.read(new File("Images/Green Square Select.png"));
           gameover = ImageIO.read(new File("Images/Gameover.png"));
            main = ImageIO.read(new File("Images/Main Menu.png"));
           mainH = ImageIO.read(new File("Images/Main Menu Hover.png"));
           pause = ImageIO.read(new File("Images/Paused.png"));
           cursor = ImageIO.read(new File("Images/cursor.png"));
           x = ImageIO.read(new File("Images/X.png"));
           xH=ImageIO.read(new File("Images/X Hover.png"));
           scores=ImageIO.read(new File("Images/Highscore.png"));
           scoresH=ImageIO.read(new File("Images/Highscore Hover.png"));
           pvp=ImageIO.read(new File("Images/PVP.png"));
           pvpH=ImageIO.read(new File("Images/PVP Hover.png"));
        }catch(Exception e){e.printStackTrace();}
        
        pointer = Toolkit.getDefaultToolkit().createCustomCursor(cursor, new Point(0,0), "Cursor");
        setCursor(pointer);
        bX1 = Window.width/2 -256;
        bX2 = Window.width/2 - 256;
        bY1 = 200;
        bY2 = 400;
        xX1 = Window.width;
        xX2 = Window.width;
        widthB = 512;
        heightB = 64;
        widthS = 64;
        heightS = 64;
        widthM = 312;
        heightM = 64;
        mY1 = 475;
        mY2 = 475;
        hX = Window.width/2 - Window.width/4;
        hY = 0 + Window.width/8;
        hOffset = 75;
        mX1 = Window.width/2 - 156;
        mX2 = 525;
        sY1 = 600;
        sY2 = 600;
        sX1 = Window.width/2 - 64;
        sX2 = Window.width/2 +64;
        scX1 = Window.width - 512;
        scY1 = Window.height - 64;
        FileReader r = null;
        BufferedReader br = null;
        highscore = new ArrayList<Integer>();
        try {
            r = new FileReader(fileHS);
            br = new  BufferedReader(r);
            String line;
            while ((line = br.readLine()) != null)
            {
                String numLine = "";
                for (int i = 0; i < line.length(); i++)
                {
                    for (int j = 0; j < numbers.length; j++)
                    {
                        if (line.charAt(i) == numbers[j])
                        {
                            numLine += numbers[j];
                            break;
                        }
                    }
                }
                if(!numLine.isEmpty())
                    highscore.add(Integer.parseInt(numLine));
            }
            Collections.sort(highscore);
            br.close();
        }
        catch (IOException e)
        {
        }
        timer.start();
        
    }
    public void gainLife()
    {
        if(extraLife > 5000)
        {
            extraLife -= 5000;
            ship.lives++;
            if(multi)
            {
            ship2.lives++;
            }
        }
    }
    public void resetGame()
    {
        rockList.clear();
        eList.clear();
        bList.clear();
        bsList.clear();
        ship.lives =3;
        ship.ammo =10;
        ship2.lives =3;
        ship2.ammo =10;
        level = 1;
        ya = false;
        multi = false;
        gameStart = false;
        gameOver =false;
        score =0;
        extraLife = 0;
        ship = new Space_Ship();
        ship2 = new Space_Ship2();
        ship2 = new Space_Ship2();
        bad = new EnemyShip(ship);
        for(int i=0; i < 5; i++)
        {
            rockList.add(new Asteroid());
            if(turtorial)
        {
            rockList.remove(i);
            rockList.remove(i);
        }
        }
    }
    @Override
    public void update(Graphics g)//update
    {
        this.paint(g);
    }
    @Override
    public void paint(Graphics g)//paint
    {
        offG.setColor(Color.BLACK);
        offG.fillRect(0, 0, Window.width, Window.height);
        if(gameStart)
         {
             if (turtorial==false)
             {
        offG.drawImage(bg, 0, 0, this);
        if(Window.width ==2560 &&Window.height == 1080)
        {
        offG.drawImage(bg, 1920, 0, this);
        }
         }
        if(green ==true)
        {
        offG.setColor(Color.GREEN);
        }
        else
        {
           offG.setColor(Color.BLUE); 
        }
        if(ship.alive)
        {
            if(ship.respawnDelay < 100 && ship.respawnDelay% 20 < 10)
            {
                 ship.paint(offG);
            }
            if(ship.respawnDelay > 100)
            {
                ship.paint(offG);
            }
        }
        offG.setColor(Color.ORANGE); 
        if(turtorial)
        {
            offG.setColor(Color.WHITE);
            if (Word1)
            {
                offG.setFont(sFont);
                offG.drawString("Welcome to Asteroids (Click to Continue)",Window.width/2 - Window.width/4, 450);
            }
            if (word2)
            {
                offG.setFont(sFont);
                offG.drawString("Press W to move forword",Window.width/2 - Window.width/4, 450);
            }
            if (word3)
            {
                offG.setFont(sFont);
                offG.drawString("Press A and D to turn",Window.width/2 - Window.width/4, 450);
            }
            if (word4)
            {
                offG.setFont(sFont);
                offG.drawString("Good job (Click to Continue)",Window.width/2 - Window.width/4, 450);
            }
            if (word8)
            {
                offG.setFont(sFont);
                offG.drawString("Don't worry if you go of the screen,",Window.width/2 - Window.width/4, 450);
                offG.drawString("you will come back on the other side try it",Window.width/2 - Window.width/4, 475); 
            }
            if (word5)
            {
                offG.setFont(sFont);
                offG.drawString("Press SPACE to shoot bullets",Window.width/2 - Window.width/4, 450);
            }
            if (word6)
            {
                offG.setFont(sFont);
                offG.drawString("Destroy the asteroid",Window.width/2 - Window.width/4, 450);
            }
            if (word6)
            {
                offG.setFont(sFont);
                offG.drawString("Destroy the asteroid",Window.width/2 - Window.width/4, 450);
            }
            if (word7)
            {
                offG.setFont(sFont);
                offG.drawString("You have completed the turtorial (Click to Continue)",Window.width/2 - Window.width/4, 450);
            }
               if (word9)
            {
                offG.setFont(sFont);
                offG.drawImage(marker, Window.width/2 + Window.width/4, 700, this);
                offG.drawString("Move to the marker",Window.width/2 - Window.width/4, 450);
            }       
        }
        if(bad.alive)
        {
                // bad.paint(offG);
        }
        if(multi)
        {
        offG.setColor(Color.BLUE);
        if(green ==false)
        {
          offG.setColor(Color.GREEN);  
        }
        if(turtorial)
        {
            offG.setColor(Color.WHITE);
        }
        if(ship2.alive)
        {
            if(ship2.respawnDelay < 100 && ship2.respawnDelay% 20 < 10)
            {
                 ship2.paint(offG);
            }
            if(ship2.respawnDelay > 100)
            {
                ship2.paint(offG);
            }
        }
        }
        offG.setColor(Color.DARK_GRAY);
        for(int i=0; i< rockList.size(); i++)
        {
            rockList.get(i).paint(offG);
        }
        offG.setColor(Color.RED);
        for(int i=0; i< bList.size(); i++)
        {
            bList.get(i).paint(offG);
        }
        for(int i=0; i< bsList.size(); i++)
        {
            bsList.get(i).paint(offG);
        }
        offG.setColor(Color.GREEN);
        for(int i=0; i<eList.size(); i++)
        {
            eList.get(i).paint(offG);
        }
        offG.setColor(Color.WHITE);
        offG.setFont(font);
        offG.setFont(sFont);
        offG.drawString("Lives:" + ship.lives, Window.width/32 + Window.width/64, 150);
        offG.setColor(Color.RED);
        offG.drawString("PLAYER 1", Window.width/32 + Window.width/64, 100);
        offG.setColor(Color.WHITE);
        if(multi)
        {
        offG.drawString("Lives:" + ship2.lives, Window.width - Window.width/8, 150);
        offG.setColor(Color.RED);
        offG.drawString("PLAYER 2", Window.width - Window.width/8, 100);
        }
        offG.setColor(Color.WHITE);
        offG.drawString("Asteroids Left:" + rockList.size(), Window.width/2 - Window.width/8, 150);
        offG.drawString("Ammo:" + ship.ammo, Window.width/32 + Window.width/64, 200);
        if(multi)
        {
        offG.drawString("Ammo:" + ship2.ammo, Window.width - Window.width/8, 200);
        }if(turtorial ==false)
        {
                    offG.drawString("Score:" + score, Window.width/2 - Window.width/16, 200);
        }
        offG.setFont(font);
        offG.setColor(Color.GREEN);
        if(level >4)
        {
           offG.setColor(Color.yellow); 
        }
        if(level >9)
        {
           offG.setColor(Color.orange); 
        }
        if(level >19)
        {
           offG.setColor(Color.RED); 
        }
        if(turtorial==false)
        {
                    offG.drawString("LEVEL:" + level, Window.width/2 - Window.width/8, 100);
        }
        offG.setFont(font);
        }
        else
        {
           offG.setColor(Color.WHITE);
           offG.setFont(font);
           if(showHighscores == false)
            {
           offG.drawString(" ASTEROIDS", Window.width/2 - 256, 50);
           offG.setFont(sFont);
           offG.setColor(Color.ORANGE);
           offG.drawString("  Single Player Only", Window.width - 512, Window.height - 75);
           offG.drawImage(gr, sX1, sY1, this);
           offG.drawImage(b, sX2, sY2, this);
            }
           
           if(scoreHover ==false)
           {
           offG.drawImage(scores, scX1, scY1, this);
           }
           else
           {
               offG.setFont(font);
                offG.setColor(Color.WHITE);
               offG.drawString("HIGHSCORES", Window.width/2 - 256, 50);
                offG.setFont(sFont);
           offG.setColor(Color.ORANGE);
           offG.drawString("  Single Player Only", Window.width - 512, Window.height - 75);
           offG.drawImage(scoresH, scX1, scY1, this);
           if (xHover==false)
           {
                offG.drawImage(x, Window.width - 45, 0, this);
           }
           else
           {
           offG.drawImage(xH, Window.width - 45, 0, this);
           }
             }
           if(showHighscores == false)
           {
           if(PVP)
           {
               offG.drawImage(pvp, 0, 0, this);
           }
           if (xHover==false)
           {
                offG.drawImage(x, Window.width - 45, 0, this);
           }
           else
           {
           offG.drawImage(xH, Window.width - 45, 0, this);
           }
            if(h1 ==true)
            {
                offG.drawImage(ply1H, bX1, bY1, this);
            }
            else
            {
                offG.drawImage(ply1, bX1, bY1, this);
            }
            if(h2 ==true)
            {
                offG.drawImage(ply2H, bX2, bY2, this);
            }
            else
            {
                offG.drawImage(ply2, bX2, bY2, this);
            }
            
            if(sh1 ==true)
            {
                offG.drawImage(bh, sX1, sY1, this);
            }
            else
            {
                offG.drawImage(gr, sX1, sY1, this);
            }
            if(sh2 ==true)
            {
                offG.drawImage(gh, sX2, sY2, this);
            }
            else
            {
                offG.drawImage(b, sX2, sY2, this);
            }
            if(green == true)
            {
                offG.drawImage(bs, sX1, sY1, this);
            }
            else
            {
              offG.drawImage(gs, sX2, sY2, this);  
            }
           }
           else
           {
               offG.setFont(font);
               offG.setColor(Color.white);
              for(int i= highscore.size()-1;i>=0;i--)
              {
                 offG.drawString("" + highscore.get(i),hX,hY+(hOffset*(highscore.size()-i)) );
               }
           }
        }
        if(paused ==true)
        {
          offG.drawImage(pause, Window.width/2 - 256 , 300, this);
          if(mH == true)
        {
        offG.drawImage(mainH, mX1, mY1, this);
        }
        else
        {
        offG.drawImage(main, mX1, mY1, this);
        }
        if(ship.counter > 10 )
        {
        ya = true;
        }
        }
        if(gameOver ==true)
        {
        offG.drawImage(gameover, Window.width/2 -256 , 300, this);
        if(mH == true)
        {
        offG.drawImage(mainH, mX1, mY1, this);
        }
        else
        {
        offG.drawImage(main, mX1, mY1, this);
        }
        if(ship.counter > 10 )
        {
        ya = true;
        }
        }
        g.drawImage(offScreen,0,0,this);
    }
    public boolean collision(VectorSprite obj1, VectorSprite obj2)
    {
        int x,y;
        for(int i =0; i < obj1.drawShape.npoints; i++)
        {
            x = obj1.drawShape.xpoints[i];
            y = obj1.drawShape.ypoints[i];
            if(obj2.drawShape.contains(x, y))
            {
                return true;
            }
        }
         for(int i =0; i < obj2.drawShape.npoints; i++)
        {
            x = obj2.drawShape.xpoints[i];
            y = obj2.drawShape.ypoints[i];
            if(obj1.drawShape.contains(x, y))
            {
                return true;
            }
        }
        return false;
    }
    public void checkCollisions()
    {
        for(int i=0; i< rockList.size(); i++)
        {
            if(collision(ship, rockList.get(i) )) 
            {
                if(ship.alive ==true)
                {
                   ship.hit(); 
                   if(ship.respawnDelay>100)
                   {
                        for(int k=0; k< 1000; k++)
                        {
                            if(green ==true)
                            {
                            eList.add(new Explotion(ship.xPosition, ship.yPosition, Color.GREEN));
                            }
                            else
                            eList.add(new Explotion(ship.xPosition, ship.yPosition, Color.BLUE));
                        }
                   }
                }
            }
            if(multi)
            {
            if(collision(ship2, rockList.get(i) )) 
            {
                if(ship2.alive ==true)
                {
                   ship2.hit(); 
                   if(ship2.respawnDelay>100)
                   {
                        for(int k=0; k< 1000; k++)
                        {
                            if(green ==false)
                            {
                            eList.add(new Explotion(ship2.xPosition, ship2.yPosition, Color.GREEN));
                            }
                            else
                            eList.add(new Explotion(ship2.xPosition, ship2.yPosition, Color.BLUE));
                        }
                   }
                }
            }
            }
            for(int j=0; j< bList.size(); j++)
            {
                if(collision(bList.get(j), rockList.get(i) )) 
                {
                     bList.get(j).alive = false;
                     rockList.get(i).alive = false;
                     for(int k=0; k< 1000; k++)
                        {
                            offG.setColor(Color.WHITE);
                            eList.add(new Explotion(rockList.get(i).xPosition, rockList.get(i).yPosition, Color.WHITE));
                        }
                }  
            }
            for(int j=0; j< bsList.size(); j++)
            {
                if(collision(bsList.get(j), rockList.get(i) )) 
                {
                     bsList.get(j).alive = false;
                     rockList.get(i).alive = false;
                     for(int k=0; k< 1000; k++)
                        {
                            offG.setColor(Color.WHITE);
                            eList.add(new Explotion(rockList.get(i).xPosition, rockList.get(i).yPosition, Color.WHITE));
                        }
                }  
            }
        }
        if(PVP)
        {
        for(int j=0; j< bsList.size(); j++)
        {
           if(collision(bsList.get(j), ship ))  
           {
               if(ship.alive ==true)
                { 
                   if(ship.respawnDelay>100)
                   {
                    bsList.get(j).alive = false;
                    ship.hit();
                   {
                        for(int k=0; k< 1000; k++)
                        {
                            if(green ==true)
                            {
                            eList.add(new Explotion(ship.xPosition, ship.yPosition, Color.GREEN));
                            }
                            else
                            eList.add(new Explotion(ship.xPosition, ship.yPosition, Color.BLUE));
                        }
                   }
                   }
           }
       
        }}
           
     }
        if(PVP)
        {
        for(int j=0; j< bList.size(); j++)
           if(collision(bList.get(j), ship2 ))  
           {
               if(ship2.alive ==true && multi == true)
                {
                   if(ship2.respawnDelay>100)
                   {
                   bList.get(j).alive = false;
                       ship2.hit(); 
                        for(int k=0; k< 1000; k++)
                        {
                            if(green ==false)
                            {
                            eList.add(new Explotion(ship2.xPosition, ship2.yPosition, Color.GREEN));
                            }
                            else
                            eList.add(new Explotion(ship2.xPosition, ship2.yPosition, Color.BLUE));
                        }
                   }
                }
         
           }}
    }
    
    @Override
    public void keyTyped(KeyEvent ke) 
    {
        
    }
    
    private void checkKeys()
    {
        if(upKey && ship.alive == true)
        {
            ship.acceletate();
        }
        else
        {
            ship.brake();
        }
        if(leftKey && ship.alive == true)
        {
            ship.rotateLeft();
        }
        if(rightKey && ship.alive == true)
        {
            ship.rotateRight();
        }
        if(spaceKey && ship.alive == true)
        {
            if(ship.ammo <100)
            {
            if(lazer)
                {
                    upKey =false;
                    leftKey = false;
                    rightKey = false;
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle, 10));
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle, 9));
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle, 8));
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle, 7));
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle, 6));
                    ship.ammo ++;
                    ship.counter =0;
                }
            }
            if(ship.ammo <=100 &&lazer==true && ship.counter >100)
            {
                ship.ammo =0;
                ship.counter =0;
            }
            if(ship.counter > 3 && ship.ammo > 0)
            {
                if(rifle || snake)
                {
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle, 10));
                    ship.ammo --;
                    ship.counter = 0;
                }
                if(shotgun)
                {
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle, 10));
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle +1, 9));
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle -1, 9));
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle +3, 8));
                    bList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle -3, 8));
                    ship.ammo -=5;
                    ship.counter = -25;
                }
            }
        }
            if(ship.ammo < 1 && ship.counter ==25 &&lazer==false)
            {   
                ship.ammo = 10;
                ship.counter =0;
            } 
            if(upKey2 && ship2.alive == true)
        {
            ship2.acceletate();
        }
        else
        {
            ship2.brake();
        }
        
        if(leftKey2 && ship2.alive == true)
        {
            ship2.rotateLeft();
        }
        if(rightKey2 && ship2.alive == true)
        {
            ship2.rotateRight();
        }
        if(spaceKey2 && ship2.alive == true)
        {
            if(ship2.counter > 3 && ship2.ammo > 0)
            {
            bsList.add(new Bullet(ship2.drawShape.xpoints[0], ship2.drawShape.ypoints[0], ship2.angle, 10));
            ship2.ammo --;
            ship2.counter = 0;
            }
        }
            if(ship2.ammo < 1 && ship2.counter ==25)
            {   
                ship2.ammo = 10;
                ship2.counter =0;
            } 
    }
    

    public void respawnShip()
    {
        if (ship.alive == false && ship.counter >50)
        {
              ship.reset(); 
        }
        if (ship2.alive == false && ship2.counter >50)
        {
              ship2.reset(); 
        }
    }
    public void nextLevel()
    {
        if(turtorial==false)
        {
        if(rockList.isEmpty())
        {
            level ++;
            ship.ammo =10;
            ship2.ammo =10;
            for(int i=0; i < level +4; i++)
            {
                rockList.add(new Asteroid());
            }
        }
    }
    }
    @Override
    public void keyPressed(KeyEvent ke) 
    {    
        if(ke.getKeyCode()==KeyEvent.VK_D)
        {
            if(!(lazer && spaceKey))
                rightKey = true;
            
        }
        if(ke.getKeyCode()==KeyEvent.VK_T)
        {
            turtorial=true;
            word2=false;
            word3=false;
            word4=false;
            word5=false;
            word6=false;
            word7=false;
            word8=false;
            word9=false;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W&& word2)
        {
            word3=true;
            word2=false;
        } 
        if( ke.getKeyCode() == KeyEvent.VK_D && word3|| ke.getKeyCode() == KeyEvent.VK_A && word3)
        {
            word9=true;
            word3=false;
        }   
        if (ke.getKeyCode() == KeyEvent.VK_SPACE && word5)
        {
            rockList.add(new Asteroid());
            word6=true;
            word5=false;
        }   
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT )
        {
                rightKey2 = true;
        }
        if(ke.getKeyCode()==KeyEvent.VK_A)
        {
            if(!(lazer && spaceKey))
                leftKey = true;
            
        }
        if(ke.getKeyCode()==KeyEvent.VK_LEFT )
        {
            leftKey2 = true;
        }
        if(ke.getKeyCode()==KeyEvent.VK_W || snake)
        {
            if(!(lazer && spaceKey))
                upKey = true;
        }
        if(ke.getKeyCode()==KeyEvent.VK_UP )
        {
            upKey2 = true;
        }
        if(ke.getKeyCode()==KeyEvent.VK_SPACE)
        {
            spaceKey = true;
        }
        if(ke.getKeyCode()==KeyEvent.VK_ENTER )
        {
            if(multi){
            spaceKey2 = true;
            }
        }
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
            if(gameStart)
            {
            if(paused == false)
            {
                paused = true;
            }
            else
            {
                paused = false;
            }
            }
        }
        if(ke.getKeyCode()==KeyEvent.VK_CONTROL)
        {
            ctrl = true;
        }
        if(ke.getKeyCode()==KeyEvent.VK_ALT && ctrl)
        {
            alt = true;
        }
        if(ke.getKeyCode()==KeyEvent.VK_SLASH && alt){
            rifle =false;
            snake =false;
            lazer =false;
            shotgun=true;
            ship.brake();
        }
        if(ke.getKeyCode()==KeyEvent.VK_PERIOD && alt){
            rifle =true;
            snake =false;
            lazer =false;
            shotgun=false;
            ship.brake();
        }
        if(ke.getKeyCode()==KeyEvent.VK_SEMICOLON && alt){
            {
            rifle =false;
            snake =true;
            lazer =false;
            shotgun=false;
            ship.acceletate();
            }
        }
        if(ke.getKeyCode()==KeyEvent.VK_QUOTE && alt){
            {
            rifle =false;
            snake =false;
            lazer =true;
            shotgun=false;
            ship.brake();
            }
        }
        if(ke.getKeyCode()==KeyEvent.VK_P && alt)
        {
            if(gameStart ==false)
            {
            if(PVP==false)
            {
            PVP =true;
            }
            else
            {
                PVP=false;
            }
        }}
    }

    @Override
    public void keyReleased(KeyEvent ke) 
    {
        if(ke.getKeyCode()==KeyEvent.VK_CONTROL)
        {
            ctrl = false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_ALT)
        {
            alt = false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_D)
        {
            rightKey = false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_A)
        {
            leftKey = false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_W)
        {
            upKey = false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_SPACE)
        {
            spaceKey = false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT )
        {
            rightKey2 = false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_LEFT)
        {
            leftKey2 = false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_UP)
        {
            upKey2 = false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_ENTER)
        {
            spaceKey2 = false;
        }
    }
    public void checkRDeath()
    {
        for(int i=0; i<rockList.size(); i++)
        {
            if(rockList.get(i).alive == false)
            {
                if(rockList.get(i).size >2)
                {
                    rockList.add(new Asteroid(rockList.get(i).xPosition, rockList.get(i).yPosition, rockList.get(i).size -2));
                    rockList.add(new Asteroid(rockList.get(i).xPosition, rockList.get(i).yPosition, rockList.get(i).size -2));
                }
                if (rockList.get(i).size == 6)
                    {
                        score += 20;
                        extraLife += 20;
                    }
                    if (rockList.get(i).size == 4)
                    {
                        score += 50;
                        extraLife += 50;
                    }
                    if (rockList.get(i).size == 2)
                    {
                        score += 100;
                        extraLife += 100;
                    }
                rockList.remove(i);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) //Timer Tick
    {
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mousePos, this);
        mouseX =mousePos.x;
        mouseY =mousePos.y;
       if(turtorial && score > 750)
       {
           multi=true;
       }
        if(ship.xPosition > Window.width/2 + Window.width/4 && ship.xPosition < Window.width/2 + Window.width/4 +64 && ship.yPosition > 700 && ship.yPosition < 764 && word9)
            {
                word9=false;
                word8=true;    
            }
        if(mouseX > bX1 && mouseX < bX1 + widthB && mouseY > bY1 && mouseY < bY1 + heightB )
        {
           h1 =true;
        }
        else
        {
            h1 = false;
        }
        if(mouseX > bX2 && mouseX < bX2 + widthB && mouseY > bY2 && mouseY < bY2 + heightB )
        {
           h2 =true;
        }
        else
        {
            h2 = false;
        }
        if( mouseX > sX2 && mouseX < sX2 + widthS && mouseY > sY2 && mouseY < sY2 + heightS )
        {
           if(gameStart==false)
            {
            sh2 = true;
            } 
        }
        else
        {
            sh2 =false;
        }
        if( mouseX > sX1 && mouseX < sX1 + widthS && mouseY > sY1 && mouseY < sY1 + heightS )
        {
           if(gameStart==false)
            {
            sh1 =true;
            } 
        }
        else
        {
            sh1 = false;
        }
        if(mouseX > mX1 && mouseX < mX1 + widthM && mouseY > mY1 && mouseY < mY1 + heightM )
        {
            if(gameOver ==true|| paused==true)
            {
                mH =true;
            }
        }
        else
        {
            mH = false;
        }
        if(mouseX > Window.width - 45 && mouseX < Window.width&& mouseY >0 && mouseY < 0 + 29  )
        {
            if(gameStart==false)
            {
                xHover =true;
            }
        }
        else 
        {
            xHover =false;
        }
        if(mouseX > scX1 && mouseX < Window.width&& mouseY >scY1 && mouseY < Window.height  )
        {
            if(gameStart==false)
            {
                scoreHover =true;
                showHighscores = true;
            }
        }
        else
        {
           scoreHover =false; 
           showHighscores = false;
        }
        if(gameStart && paused ==false)
        {
            if(!gameOver && ((ship.lives <= 0 && ship.alive == false && ship2.lives <= 0 && ship2.alive == false) || (ship.lives <= 0 && ship.alive == false && multi ==false)))
            {
              gameOver =true;
              if (multi ==false || turtorial==false)
              {
                  FileWriter w;
              BufferedWriter bw;
              try
              {
                  w = new FileWriter(fileHS,true);
                  bw = new BufferedWriter(w);
                  highscore.add(score);
                  bw.write("\r\n");
                  bw.write(score + "\r\n");
                  System.out.println("adding score");
                  
                  bw.close();
              } catch (IOException e) {e.printStackTrace();}
                          Collections.sort(highscore);
              }
            }
        checkCollisions();
        checkRDeath();
        respawnShip();
        nextLevel();
        gainLife();
        ship.updatePosition();
        ship2.updatePosition();
        if(word6 && rockList.isEmpty())
                {
                   word6=false;
                   word7=true;
                }
        if(word8)
        {
            if(ship.xPosition < 0 || ship.xPosition > Window.width || ship.yPosition < 0 ||ship.yPosition > Window.height)
                {
                   word8=false;
                   word4=true;
                }
        }
        if(word9)
        {
            if(rockList.size() == 2)
            {
                word9 = true;
            }
        }
        if(multi)
        {
            rifle =true;
            lazer = false;
            snake = false;
            shotgun = false;           
        }
        if(snake && ship.alive)
                {
                    bList.add(new Bullet(ship.drawShape.xpoints[2], ship.drawShape.ypoints[2], ship.angle +180, 3));
                    ship.acceletate();
                    snakeBrake = false;
                }
        if(snake ==false && snakeBrake == false)
        {
            snakeBrake = true;
          upKey =false;
        }
        bad.updatePosition();
        if(multi ==true)
        {
            green = true;
        }
        if(score == 10000)
        {
            ship.lives++;
            ship2.lives++;
        }
        for(int i=0; i< rockList.size(); i++)
        {
            rockList.get(i).updatePosition();
            
        }
        for(int i=0; i< bList.size(); i++)
        {
            bList.get(i).updatePosition();
            if(rifle ==false || snake ==false)
            {
                if(bList.get(i).counter>25 || (bList.get(i).alive == false))
                {
                    bList.remove(i);
                }
            }
            else if(rifle)
            {
                if(bList.get(i).counter>50 || (bList.get(i).alive == false))
                {
                    bList.remove(i);
                }
            }
            else if (snake)
            {
                if(bList.get(i).counter>100 || (bList.get(i).alive == false))
                    bList.remove(i);
            }
        }
        for(int i=0; i< bsList.size(); i++)
        {
            bsList.get(i).updatePosition();
            if(rifle ==false)
            {
                if(bsList.get(i).counter>25 || (bsList.get(i).alive == false))
                {
                    bsList.remove(i);
                }
            }
            else
            {
                if(bsList.get(i).counter>50 || (bsList.get(i).alive == false))
                {
                    bsList.remove(i);
                }
            }
        }
        for(int i=0; i< eList.size(); i++)
        {
            eList.get(i).updatePosition();
            if(eList.get(i).counter>=20)
            {
                eList.remove(i);
            }
        }
        checkKeys();
        }
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) 
    {
    }

    @Override
    public void mousePressed(MouseEvent me) 
    {
        if(SwingUtilities.isLeftMouseButton(me) && Word1)
        {
            word2=true;
            Word1=false;
        }    
       else if(SwingUtilities.isLeftMouseButton(me) && word4)
        {
            word5=true;
            word4=false;
        }   
        else if(SwingUtilities.isLeftMouseButton(me) && word7)
        {
            score=0;
            ship.ammo=10;
            ship.lives=3;
            ship.angle =0;
            ship.xPosition = Window.width/2 - Window.width/16;
            ship.yPosition = Window.height/2;
            rockList.add(new Asteroid());
            rockList.add(new Asteroid());
            rockList.add(new Asteroid());
            rockList.add(new Asteroid());
            rockList.add(new Asteroid());
            turtorial=false;
            word7=false;
        }   
        if(SwingUtilities.isLeftMouseButton(me)&& mouseX > bX1 && mouseX < bX1 + widthB && mouseY > bY1 && mouseY < bY1 + heightB )
        {
           if(gameStart==false)
            {
            gameStart =true;
            multi = false;
            for(int i=0; i < 20; i++)
        {
            if(turtorial)
        {
            Word1=true;
            rockList.remove(i);
            rockList.remove(i);
            rockList.remove(i);
            rockList.remove(i);
            rockList.remove(i);
        }
            } 
        }
        }
        if(SwingUtilities.isLeftMouseButton(me)&& mouseX > bX1 && mouseX < bX1 + widthB && mouseY > bY1 && mouseY < bY1 + heightB )
        {
           if(gameStart==false && turtorial==false)
            {
            gameStart =true;
            multi = false;
            turtorial=false;
        }
        }
        if(SwingUtilities.isLeftMouseButton(me)&& mouseX > bX2 && mouseX < bX2 + widthB && mouseY > bY2 && mouseY < bY2 + heightB )
        {
           if(gameStart==false)
            {
            turtorial = false;
            gameStart =true;
            multi = true;
            } 
        }
        if(SwingUtilities.isLeftMouseButton(me)&& mouseX > sX2 && mouseX < sX2 + widthS && mouseY > sY2 && mouseY < sY2 + heightS )
        {
           if(gameStart==false)
            {
            green =false;
            } 
        }
        if(SwingUtilities.isLeftMouseButton(me)&& mouseX > sX1 && mouseX < sX1 + widthS && mouseY > sY1 && mouseY < sY1 + heightS )
        {
           if(gameStart==false)
            {
            green =true;
            } 
        }
        if(SwingUtilities.isLeftMouseButton(me)&& mouseX > mX1 && mouseX < mX1 + widthM && mouseY > mY1 && mouseY < mY1 + heightM  )
        {
            if(gameOver ==true|| paused == true)
            {
                paused = false;
                resetGame();
            }
        }
        if(SwingUtilities.isLeftMouseButton(me)&& mouseX > Window.width - 45 && mouseX < Window.width&& mouseY >0 && mouseY < 0 + 29  )
        {
            if(gameStart==false)
            {
                System.exit(0);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
        
        //for(int i=0; i< rockList.size(); i++)
        //{
            //for(int j=0; j< rockList.size(); j++)
            //{
            //if(collision(rockList.get(j), rockList.get(i) )) 
            //{
               //rockList.get(i).alive = false;
               //rockList.get(j).alive = false;
            //}
            //}
        //}
