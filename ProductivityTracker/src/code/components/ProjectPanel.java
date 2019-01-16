package code.components;

import java.awt.Color;

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
		JLabel projectDateLabel = new JLabel("   "+project.lastModified.toString());
		projectDateLabel.setFont(projectDateLabel.getFont().deriveFont(10.0f));	
		add(projectDateLabel);
		add(Box.createVerticalStrut(5));
		for(Goal g : project.goals)
		{
			if(g.isCompleted)continue;
			add(new JLabel("- " + g.goalDescription));
			JLabel dateLabel = new JLabel("VOID");
			dateLabel.setFont(dateLabel.getFont().deriveFont(10.0f));
			if(g.dueDate != null)
			{
				dateLabel.setText("   " + g.dueDate.toString());
				dateLabel.setForeground(Color.red);
			}
			else
			{
				dateLabel.setText("   " + g.creationDate.toString());
				dateLabel.setForeground(Color.GRAY);
			}
			add(dateLabel);
		}
	}
	

	
}
