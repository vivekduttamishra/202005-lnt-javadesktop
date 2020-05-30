package swt22.jface.taskmanager.support;

import java.util.Collection;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import in.conceptarchitect.jface.viewers.AbstractTableDetailsProvider;
import in.conceptarchitect.taskmanager.Task;
import in.conceptarchitect.taskmanager.TaskStatus;

public class TaskTableDetailsProvider extends AbstractTableDetailsProvider {

	 
	Image imagePending,imageStarted,imageCompleted,imageCancled;
	
	LocalResourceManager  resourceManager=new LocalResourceManager(JFaceResources.getResources(), Display.getCurrent().getShells()[0]);
	
	Image getImage(String path) {
		ImageDescriptor descriptor= ImageDescriptor.createFromFile(getClass(), path);
		Image image=resourceManager.createImage(descriptor);
		return image;
	}
	
	
	public TaskTableDetailsProvider() {
		// TODO Auto-generated constructor stub
		Display display=Display.getDefault();
		
		
		
//		imagePending = new Image(display, getClass().getResourceAsStream("/images/pending.png"));
//		imageStarted = new Image(display, getClass().getResourceAsStream("/images/started.jpg"));
//		imageCompleted = new Image(display, getClass().getResourceAsStream("/images/completed.png"));
//		imageCancled = new Image(display, getClass().getResourceAsStream("/images/cancled.png"));
		
		imagePending = getImage("/images/pending.png");
		imageStarted = getImage("/images/started.png");
		imageCompleted = getImage("/images/completed.png");
		imageCancled = getImage("/images/cancled.png");
		
	}
	
	
	Image getStatusImage(TaskStatus status) {
		switch(status.toString().toLowerCase()) {
		case "started": return imageStarted;
		case "pending": return imagePending;
		case "completed": return imageCompleted;
		case "cancled": return imageCancled;
		}
		return imageStarted;
	}
	
	 
	
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
			case 2:  value=""; break; //value=task.getStatus(); break;
			case 3:  value=task.getSubTasks().size(); break;
			case 4:  value=task.getNotes().size(); break;
			default: return null;
		}
		return value.toString();		
	
	}
	
	@Override
	public Image getColumnImage(Object element, int column) {
		// TODO Auto-generated method stub
		Task task=(Task) element;
		if(column==2)
			return getStatusImage(task.getStatus());
		else
			return null; //no image required for this column
	}
	
	//How will TaskTablDetailsProvider know what is the actual	
	@Override
	public Object[] getElements(Object input) {
		// TODO Auto-generated method stub
		Collection<Task> tasks =  (Collection<Task>) input;
		return tasks.toArray();
	}
	
	
}
