package code.components;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.Goal;
import code.Project;

public class ProjectPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6773276344401107179L;
	Project project;
	
	public ProjectPanel(Project p) {
		project = p;
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(new JLabel(project.name));
		add(new JLabel(project.lastModified.toString()));
		add(Box.createVerticalStrut(5));
		for(Goal g : project.goals)
		{
			
		}
	}
	

	
}
