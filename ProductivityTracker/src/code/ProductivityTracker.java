package code;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import code.components.JRounded;
import code.components.ProjectPanel;

public class ProductivityTracker extends JPanel{

	Goal testGoal;
	Project testProject;
	
	ArrayList<JRounded> projectEntries = new ArrayList<JRounded>();
	
	JScrollPane projectListPane;
	JPanel projectEntriesPane;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Being Productive");
		//frame.setSize(300,300);
		frame.setContentPane(new ProductivityTracker());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public ProductivityTracker() {
		testGoal = new Goal();
		
		testGoal.goalDescription = "This is a test description";
		testGoal.creationDate = LocalDate.now();
		testGoal.dueDate = null;
		
		testProject = new Project();
		testProject.name = "This is a test project";
		testProject.startDate = LocalDate.now();
		testProject.goals.add(testGoal);
		testProject.goals.add(testGoal);
		testProject.goals.add(testGoal);
		testProject.lastModified = LocalDate.now();
		
		setLayout(new BorderLayout());
		setBorder( new EmptyBorder( 3, 3, 3, 3 ) );
		//getInsets().set(30, 30, 30, 30);
		initProjectPane();
		
		projectListPane = new JScrollPane(projectEntriesPane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
		//projectListPane.getViewport().setBorder( border );
		projectListPane.setViewportBorder( border );
		projectListPane.setBorder( border );
		projectListPane.setPreferredSize(new Dimension(200,400));
		add(projectListPane);
	}

	private void initProjectPane() {
		projectEntriesPane = new JPanel();
		projectEntriesPane.setLayout(new BoxLayout(projectEntriesPane,BoxLayout.Y_AXIS));
		for(int i = 1; i <= 100; i++)
		{
			ProjectPanel label = new ProjectPanel(testProject);
			JRounded round = new JRounded(label);
			projectEntriesPane.add(round);
			projectEntriesPane.add(Box.createVerticalStrut(10));
		}
		
	}
	
}
