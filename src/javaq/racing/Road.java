package javaq.racing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.List ;
import java.util.Iterator ;
import  java.util.Date ;

/**
 * Created by Артем Палагно on 27.10.2016.
 */
public class Road extends JPanel  implements ActionListener , Runnable  {
    Timer mainTimer = new Timer(20, this);
    Image img = new ImageIcon("pictures/Road.jpg").getImage();
    Player player  = new Player();
    Thread enemiesFactory = new Thread(this) ;
    List<Hole> holes = new ArrayList<Hole>();
    List<Enemy> enemy = new ArrayList<Enemy>() ;
    public int score=0 ;
 //  Timer scoreTimer = new Timer() ;



    public void paint(Graphics g )
    {
             g =(Graphics2D) g ;
        ((Graphics2D) g).drawImage(img ,player.layer1 ,0 , null );
        ((Graphics2D) g).drawImage(img ,player.layer2 ,  0 , null );
        ((Graphics2D) g).drawImage(player.im , player.x ,player.y ,null);
score+=player.speed*0.1;
                Font font = new Font("Arial",Font.ITALIC,20 );
        g.setFont(font);
        ((Graphics2D) g).drawString("SCORE : " + score,100,30);

        Iterator<Enemy> i;  Iterator<Hole>  j ;
        i = enemy.iterator(); j = holes.iterator() ;
              while (i.hasNext()|| j.hasNext()) {
           if(i.hasNext()){
            Enemy e = i.next();
            if ((e.x >= 2400 || e.x <= -2400)) {
                i.remove();
            } else {
                e.move();
                ((Graphics2D) g).drawImage(e.im, e.x, e.y, null);
            }}
            if (j.hasNext())
            {
                Hole h = j.next();
                if(h.x>=2400 || h.x<=-2400)
                {
                    j.remove();
                }
                else{
                      h.move();
                ((Graphics2D) g).drawImage(h.im ,h.x+15,h.y+100,null);
                    }
            }

        }
    }
    public Road()
    {
        mainTimer.start();
        enemiesFactory.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.move();
        repaint();
        testCollisionWithEnemies();
        testHole();


    }
    private void testHole()
    {
        Iterator<Hole> j = holes.iterator() ;
while(j.hasNext()) {
    Hole h = j.next();
    if (player.getRect().intersects(h.getRect())) {
        JOptionPane.showMessageDialog(null, "You lose!!!");
        System.exit(1);

    }

}
    }

    private void testCollisionWithEnemies() {
        Iterator<Enemy> i;
        i = enemy.iterator();
        while(i.hasNext())
        {
            Enemy e = i.next()  ;
            if(player.getRect().intersects(e.getRect())){
                JOptionPane.showMessageDialog(null,"You lose!!!");
            System.exit(1);
            }
        }
    }

    @Override
    public void run() {
        while(true)
        {
            Random rand = new Random() ;
            holes.add(new Hole(1200 ,rand.nextInt(480),this )) ;
            enemy.add(new Enemy(1200 , rand.nextInt(480)-80,rand.nextInt(40) , this));
         try{
             Thread.sleep(rand.nextInt(6000));



         }
         catch(InterruptedException e){e .printStackTrace();}
        }
    }

    private class  MyKeyAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e) {
          //  super.keyPressed(e);
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //super.keyReleased(e);
            player.keyReleased(e);
        }
    }
}
