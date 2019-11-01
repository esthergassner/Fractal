import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class FractalComponent extends JComponent
{
    ArrayList<Vector2D> vectors = new ArrayList<Vector2D>();

    public FractalComponent()
    {
        vectors.add(new Vector2D(0, 999));
        vectors.add(new Vector2D(-120, 999));
        vectors.add(new Vector2D(120, 999));
    }

    public void reproduce()
    {
        ArrayList<Vector2D> newVectors = new ArrayList<>();
        for (Vector2D parent : vectors)
        {
            double newMagnitude = (parent.magnitude/3.0);
            Vector2D childA = new Vector2D(parent.direction, newMagnitude);
            Vector2D childB = new Vector2D(parent.direction + 60, newMagnitude);
            Vector2D childC = new Vector2D(parent.direction - 60, newMagnitude);
            Vector2D childD = new Vector2D(parent.direction, newMagnitude);
            newVectors.add(childA);
            newVectors.add(childB);
            newVectors.add(childC);
            newVectors.add(childD);
        }
        vectors = newVectors;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        graphics.translate(0, getHeight());
        super.paintComponent(graphics);

        double x1 = 50;
        double y1 = (getHeight()/3) * 2;
        double x2;
        double y2;

        for (Vector2D vector : vectors)
        {
            x2 = x1 + Math.cos(Math.toRadians(vector.direction)) * vector.magnitude;
            y2 = y1 + Math.sin(Math.toRadians(vector.direction)) * vector.magnitude;
            graphics.drawLine((int) x1, (int) -y1, (int) x2, (int) -y2);
            x1 = x2;
            y1 = y2;
        }

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                reproduce();
            }
        });
    }

}
