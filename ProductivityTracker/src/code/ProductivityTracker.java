package code;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import code.components.JRounded;
import code.components.ProjectPanel;

public class ProductivityTracker extends JPanel implements ActionListener{

	Goal testGoal;
	Project testProject;
	
	ArrayList<JRounded> projectEntries = new ArrayList<JRounded>();
	
	ArrayList<Project> projects;
	
	JScrollPane projectListPane;
	JPanel projectEntriesPane;
	JPanel toolbar;
	JButton backButton;
	JButton addButton;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Being Productive");
		//frame.setSize(300,300);
		frame.setContentPane(new ProductivityTracker());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public ProductivityTracker() {
		projects = IOSerialization.readProjects();
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
		
		
		System.out.println(IOSerialization.readProjects());
		
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder( 3, 3, 3, 3 ));
		initProjectPane();
		
		projectListPane = new JScrollPane(projectEntriesPane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
		//projectListPane.getViewport().setBorder( border );
		projectListPane.setViewportBorder( border );
		projectListPane.setBorder( border );
		projectListPane.setPreferredSize(new Dimension(200,400));
		add(projectListPane,BorderLayout.CENTER);
		
		initToolbar();
		add(toolbar,BorderLayout.NORTH);
		
	}

	private void initToolbar() {
		Insets buttonInsets = new Insets(1,10,1,10);
		toolbar = new JPanel();
		toolbar.setBorder(new EmptyBorder( 0, 0, 5, 0 ));
		toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.X_AXIS));
		backButton = new JButton("<");
		backButton.setActionCommand("back");
		backButton.addActionListener(this);
		backButton.setFont(backButton.getFont().deriveFont(20.0f));	
		backButton.setMargin(buttonInsets);
		addButton = new JButton("+");
		addButton.setActionCommand("add");
		addButton.addActionListener(this);
		addButton.setFont(backButton.getFont());
		addButton.setMargin(buttonInsets);
		toolbar.add(backButton);
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(addButton);
		
	}

	private void initProjectPane() {
		projectEntriesPane = new JPanel();
		projectEntriesPane.setLayout(new BoxLayout(projectEntriesPane,BoxLayout.Y_AXIS));
//		for(int i = 0; i < 5; i++)
//		{
//			ProjectPanel label = new ProjectPanel(testProject);
//			JRounded round = new JRounded(label);
//			projectEntriesPane.add(round);
//			projectEntriesPane.add(Box.createVerticalStrut(10));
//		}
		for(Project p : projects)
		{
			ProjectPanel label = new ProjectPanel(p);
			JRounded round = new JRounded(label);
			projectEntriesPane.add(round);
			projectEntriesPane.add(Box.createVerticalStrut(10));
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
		case "back": break;
		case "add": break;
		}
		
	}
	
}
