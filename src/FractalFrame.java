import javax.swing.*;
import java.awt.*;

public class FractalFrame extends JFrame
{
    private FractalComponent component = new FractalComponent();

    public FractalFrame()
    {
        setTitle("Koch Snowflake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);

        setLayout(new BorderLayout());

        add(component, BorderLayout.CENTER);
    }
}
