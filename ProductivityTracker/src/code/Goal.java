package code;

import java.io.Serializable;
import java.util.Date;

public class Goal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean isCompleted;
	public Date creationDate, completionDate;
	public String goalDescription;
	public String completionDescription;
}
