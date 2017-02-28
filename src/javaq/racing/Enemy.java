package javaq.racing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Артем Палагно on 07.11.2016.
 */
public class Enemy {
    Image im = new ImageIcon("pictures/2.png").getImage();
    int speed = 20 ;

    int x= 30;
    int y = 200 ;
    Road road ;



    public Rectangle getRect()
    {
        return  new Rectangle(x,y , 250, 95) ;
   }

    public Enemy( int x  ,int y , int speed , Road road)
    {
        this.x=x ;
        this.y = y ;
        this.speed=speed;
        this.road = road ;

    }
    public  void move ()
    {

        x=x - road.player.speed + speed ;
    }
}
