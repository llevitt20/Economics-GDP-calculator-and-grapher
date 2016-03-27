package econPkg;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class CreateGraph extends JPanel
{
	private Color ADColor = new Color(255,0,0);
	private Color LRASColor = new Color(0,0,255);
	private static final Stroke GRAPH_STROKE = new BasicStroke(2f, 1, 1);
	public static double x1;
	public static double y1;

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D) g;
	     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		 g2.setStroke(GRAPH_STROKE);

		 /* GRAPH AD */
		 g2.setColor(ADColor);

		 y1 = (int) 150.0 - (x1/2000)* 200;
		 x1 = (int) x1;

		 g2.draw(new Line2D.Double(x1, y1, x1 + 400, y1 + 400));

		 /* GRAPH LRAS */
		 g2.setColor(LRASColor);

		 CubicCurve2D q = new CubicCurve2D.Float();
		 q.setCurve(0, 450,  800, 450,  750, 500,  750, 0);
		 g2.draw(q);
	}

	private static void createAndShowGui()
    {
        CreateGraph mainPanel = new CreateGraph();
        mainPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame("Generated Graph");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            createAndShowGui();
         }
      });
   }

}
