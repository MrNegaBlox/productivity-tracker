package code;

import java.io.Serializable;
import java.time.LocalDate;

public class Goal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean isCompleted = false;
	public LocalDate creationDate, completionDate, dueDate;
	public String goalDescription;
	public String completionDescription;
	
	public Goal() { //TODO add arguments to constructor
		
	}
	

}
