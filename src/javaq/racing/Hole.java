package javaq.racing;

import javax.swing.*;
import java.awt.*;

public class  Hole
{
    Image im = new ImageIcon("pictures/4.png").getImage();

    int x= 30;
    int y = 200 ;
    Road road ;
    public Hole(int x  ,int y ,   Road road)
    {
        this.x = x;
         this.y = y  ;
        this.road = road  ;
    }



    public Rectangle getRect()
    {
       // return  new Rectangle(x,y , 20, 1) ;
        return new Rectangle(x ,y , 1 , 1) ;
    }
    public  void move ()
    {

        x=x - road.player.speed  ;
    }

}
