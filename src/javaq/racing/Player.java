package javaq.racing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Артем Палагно on 27.10.2016.
 */
public class Player
{
    public  static final int Max_Speed = 50 ;
    public  static final int Max_Top = -80 ;
    public  static final int Max_Down = 400 ;

    Image im = new ImageIcon("pictures/1.png").getImage();
    int speed = 0 ;
    int nitro = 0 ;
    int way = 0 ;
    int layer1 = 0;
    int layer2 = 792;
    int x= 30;
    int y = 200 ;
    int dy = 0 ;

    public int getWay() {
        return way;
    }

    public Rectangle getRect()
    {
        return  new Rectangle(x,y , 250 , 95) ;
    }

    public  void move ()
    {
        way+=speed;
        speed+=nitro;
        if(speed<=0)speed = 0  ;
        if(speed >= Max_Speed)speed = Max_Speed;
        y-=dy;
        if(y<=Max_Top) y= Max_Top;
        if(y>=Max_Down) y= Max_Down;
        if(layer2 - speed<= 0 )
        {
            layer1 = 0 ;
            layer2 = 792;
        }
        else {
            layer1 -= speed;
            layer2 -= speed;
        }
    }public void keyPressed(KeyEvent e)
{
//JOptionPane.showMessageDialog(null , "");
int key = e.getKeyCode();
    if(key == KeyEvent.VK_RIGHT)
    {
nitro=1;
    }
    if(key == KeyEvent.VK_LEFT)
    {
nitro=-1;
    } if(key == KeyEvent.VK_UP)
{
    dy = 3;
} if(key == KeyEvent.VK_DOWN)
{
    dy = -3;
}

}  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_RIGHT) {
        nitro = 0;
    }
    if (key == KeyEvent.VK_LEFT) {
        nitro = 0;
    }
    if(key == KeyEvent.VK_UP)
    {
        dy = 0;
    } if(key == KeyEvent.VK_DOWN)
    {
        dy = 0;
    }
}}
