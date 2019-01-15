package code.components;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JRounded extends JPanel implements MouseListener{

	Color currentColor = normalColor;
	private static Color hoverColor = Color.LIGHT_GRAY.brighter();
	private static Color normalColor = Color.LIGHT_GRAY;
	private static Color clickColor = Color.DARK_GRAY;
	
	public Component inside;
	
	public JRounded(Component contained) {
		inside = contained;
		inside.setBackground(currentColor);
		addMouseListener(this);
		setLayout(new BorderLayout());
		setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
		add(contained, BorderLayout.CENTER);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(currentColor);
        g2.setStroke(new BasicStroke(2.0f));

        g2.fillRoundRect(5, 0, getWidth()-10, getHeight(), 5, 5);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		currentColor = hoverColor;
		inside.setBackground(currentColor);
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		currentColor = normalColor;
		inside.setBackground(currentColor);
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		currentColor = clickColor;
		inside.setBackground(currentColor);
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		currentColor = normalColor;
		inside.setBackground(currentColor);
		repaint();
		
	}
	
}
