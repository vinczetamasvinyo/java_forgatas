package teszt1;

 
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
 
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
/**
 * This program demonstrates how to draw text vertically
 * on a graphics context.
 * @author www.codejava.net
 *
 */
public class VerticalTextDrawingExample extends JFrame {
     
    public VerticalTextDrawingExample() {
        super("Vertical Text Drawing Example");
         
        setSize(320, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
     
    public static void drawRotate(Graphics2D g2d, double x, double y, int angle, String text) 
    {    
        // https://stackoverflow.com/questions/10083913/how-to-rotate-text-with-graphics2d-in-java
    	g2d.translate((float)x,(float)y);
        g2d.rotate(Math.toRadians(angle));
        g2d.drawString(text,0,0);
        g2d.rotate(-Math.toRadians(angle));
        g2d.translate(-(float)x,-(float)y);
    } 
    
    public void paint(Graphics g) {
        super.paint(g);
        
        Font f = new Font("Arial", Font.BOLD, 16);       
        //g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setFont(f);
        g.setColor(Color.BLUE);
        int origin_x;
        int origin_y;
        int angle;
        origin_x=50;
        origin_y=100;
        angle=45;
        double new_x=((origin_x+origin_y)/90.0)*angle;
        System.out.println(new_x);
        System.out.println(origin_x-new_x);
        g.drawString("Hello World1", origin_x, origin_y);
        FontMetrics fm = getFontMetrics(f);
        System.out.println(fm.getAscent());
        System.out.println(fm.getDescent());
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform defaultAt = g2d.getTransform();
         
        // rotates the coordinate by 90 degree counterclockwise
        AffineTransform at = new AffineTransform();
        	
        at.rotate(-Math.toRadians(angle));
        //at.rotate(- Math.PI / 4);
        g2d.setTransform(at);
        g2d.drawString("Hello World2", (int)(origin_x-new_x),origin_y+(fm.getAscent()-fm.getDescent()) );
        //g2d.drawString("Hello World2", (int)(origin_x-new_x), 115);
        //g2d.drawString("Hello World3", (int)(origin_x-new_x), 130); 
         
        AffineTransform at2 = AffineTransform.getQuadrantRotateInstance(1);
        g2d.setTransform(at2);
         
        g2d.drawString("Hello World", 100, -250);
         
        g2d.setTransform(defaultAt);
         
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
             
            @Override
            public void run() {
                new VerticalTextDrawingExample().setVisible(true);
            }
        });
    }
 
}