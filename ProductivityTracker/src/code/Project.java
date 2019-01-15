package code;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public boolean isComplete;
	public Date startDate;
	public Date lastModified;
	public ArrayList<Goal> goals = new ArrayList<Goal>();
}
