package code;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import code.components.JRounded;

public class ProductivityTracker extends JPanel{

	ArrayList<JRounded> projectEntries = new ArrayList<JRounded>();
	
	JScrollPane projectListPane;
	JPanel projectEntriesPane;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Being Productive");
		frame.setSize(300,300);
		frame.setContentPane(new ProductivityTracker());
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public ProductivityTracker() {
		
		setLayout(new BorderLayout());
		initProjectPane();
		projectListPane = new JScrollPane(projectEntriesPane);
		add(projectListPane);
	}

	private void initProjectPane() {
		projectEntriesPane = new JPanel();
		projectEntriesPane.setLayout(new BoxLayout(projectEntriesPane,BoxLayout.Y_AXIS));
		for(int i = 0; i < 4; i++)
		{
			JLabel label = new JLabel();
			JRounded round = new JRounded(label);
			label.setText(round.getLocation().y+"");
			projectEntriesPane.add(round);
		}
		projectEntriesPane.repaint();
	}
	
}
