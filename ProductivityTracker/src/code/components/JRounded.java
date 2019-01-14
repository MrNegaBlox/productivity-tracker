package code.components;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JRounded extends JPanel{

	
	
	public JRounded(Component contained) {
		setLayout(new BorderLayout());
		setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
		add(contained, BorderLayout.CENTER);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.LIGHT_GRAY);
        g2.setStroke(new BasicStroke(2.0f));

        Rectangle position = getBounds();
        g2.fillRoundRect(5, 0, getWidth()-10, getHeight(), 5, 5);
	}
	
}
