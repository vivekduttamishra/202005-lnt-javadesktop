package swt22.jface.taskmanager.support;

import java.util.Collection;

import in.conceptarchitect.jface.viewers.AbstractTableDetailsProvider;
import in.conceptarchitect.taskmanager.Task;

public class TaskTableDetailsProvider extends AbstractTableDetailsProvider {

	 
	 
	
	//Get the text for current Object from the given column
	//Object will be your Task Object
	
	@Override
	public String getColumnText(Object element, int column) {
		// TODO Auto-generated method stub
		Task task=(Task) element;
		
		Object value=null;
		switch(column) {
			case 0:  value=task.getId(); break;
			case 1:  value=task.getTitle(); break;
			case 2:  value=task.getStatus(); break;
			case 3:  value=task.getSubTasks().size(); break;
			case 4:  value=task.getNotes().size(); break;
			default: return null;
		}
		return value.toString();		
	
	}
	
	//How will TaskTablDetailsProvider know what is the actual	
	@Override
	public Object[] getElements(Object input) {
		// TODO Auto-generated method stub
		Collection<Task> tasks =  (Collection<Task>) input;
		return tasks.toArray();
	}
	
	
}
