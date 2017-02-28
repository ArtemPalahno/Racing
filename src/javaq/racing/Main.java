package javaq.racing;
import javax.swing.*;

/**
 * Created by Артем Палагно on 19.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame(" Java Racing ");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(942 , 792 );
        jFrame.add(new Road());
        jFrame.setVisible(true );



    }
}
