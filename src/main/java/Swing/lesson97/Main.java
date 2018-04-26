package Swing.lesson97;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());
        /*
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String s : fonts) {
            System.out.println(s);
        }
        */
    }

    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Font font = new Font("Arial", Font.BOLD, 20);
            Graphics2D g2 = (Graphics2D)g;
            g2.setFont(font);
            g2.drawString("Hello world!", 20, 20);
            Point2D p1 = new Point2D.Double(70, 70);
            Point2D p2 = new Point2D.Double(260, 260);
            Line2D l2 = new Line2D.Double(p1, p2);
            g2.draw(l2);
            //Ellipse2D el = new Ellipse2D.Double(70,70, 190,190);
            Ellipse2D el = new Ellipse2D.Double();
            el.setFrameFromDiagonal(p1, p2);
            g2.setPaint(Color.red);
            g2.fill(el);
            Rectangle2D r2 = new Rectangle2D.Double(70, 70, 190,190);
            g2.draw(r2);
            try {
                URL url = new URL("https://download.schneider-electric.com/files?p_Doc_Ref=PB104434&p_File_Type=rendition_288_png&default_image=DefaultProductImage.png");
                Image image = new ImageIcon(url).getImage();
                g2.drawImage(image, 200, 50, null);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 300, dimension.height/2 - 200,600,400);
        jFrame.setTitle("this is my app");
        return jFrame;
    }
}
