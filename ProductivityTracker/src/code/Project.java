package code;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public boolean isComplete;
	public LocalDate startDate;
	public LocalDate lastModified;
	public ArrayList<Goal> goals = new ArrayList<Goal>();
	
	@Override
	public String toString() {
		return "Project "+name;
	}
}
