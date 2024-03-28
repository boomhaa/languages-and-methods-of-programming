import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

public class CanvasPanel extends JPanel {
    private int radius = 200;
    Random random = new Random();
    private int x = 10+radius/2;;
    private int y = 10+radius/2;;
    private int sectors = 0;
    public void setRadius(int r) {
        radius = r;
        x = 10+radius/2;
        y = 10+radius/2;
        repaint();
    }
    public void setSectors(int s){
        sectors = s;
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.RED);
        g2.drawOval(10,10,radius,radius);
        for(int i = 0;i<sectors;i++){
            Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(randomColor);
            int startAngle = i * 360 / sectors; // начальный угол текущего сектора
            int angle = 360 / sectors+1; // угол каждого сектора

            g.fillArc(x - radius/2, y - radius/2, radius, radius, startAngle, angle);
        }

        }
    }
