import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FractalComponent extends JComponent
{
    ArrayList<Vector2D> vectors = new ArrayList<Vector2D>();

    public FractalComponent()
    {
        vectors.add(new Vector2D(0, 700));
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        double x1 = 50;
        double y1 = getHeight()/2;
        double x2;
        double y2;

        for (Vector2D vector : vectors)
        {
            x2 = x1 + Math.cos(Math.toRadians(vector.direction)) * vector.magnitude;
            y2 = y1 + Math.sin(Math.toRadians(vector.direction)) * vector.magnitude;
            graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }

       // graphics.drawLine(0,0, getWidth(), getHeight());
    }
}
