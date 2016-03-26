package stuff.Graphing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
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


public class createGraph extends JPanel
{
	private int width = 450;
	private int height = 450;
	private Color ADColor = new Color(255,0,0);
	private Color LRASColor = new Color(0,0,255);
	private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
	List<Point> graphPoints = new ArrayList<>();

	public void getPoints(List<Point> input)
	{
//		graphPoints = getPoints;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D) g;
	     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			 g2.setColor(ADColor);
			 g2.setStroke(GRAPH_STROKE);
			 for (int i = 0; i < graphPoints.size() - 1; i++)
			 {
					 int x1 = graphPoints.get(i).x;
					 int y1 = graphPoints.get(i).y;
					 int x2 = graphPoints.get(i + 1).x;
					 int y2 = graphPoints.get(i + 1).y;
					 g2.drawLine(x1, y1, x2, y2);
			 }
	}

}
