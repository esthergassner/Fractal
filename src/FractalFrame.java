import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FractalFrame extends JFrame
{
    private FractalComponent component = new FractalComponent();

    public FractalFrame()
    {
        setTitle("Koch Snowflake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200,1000);
        setVisible(true);

        setLayout(new BorderLayout());

        add(component, BorderLayout.CENTER);

    }
}
