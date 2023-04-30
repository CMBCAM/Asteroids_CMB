/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asteroids_cmb;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author RealProgramming4Kids
 */
public class Window 
{
public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Asteroids");// JFrame is the WIndow || You Put the object or variable first then the name of it then to save it put = then put the object or variable but with a () ate the end and since this is a Frame we but it's name
        frame.setUndecorated(true);
        frame.pack();
        frame.setSize(Window.width,Window.height);
        frame.add(new Main(frame));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    
}
