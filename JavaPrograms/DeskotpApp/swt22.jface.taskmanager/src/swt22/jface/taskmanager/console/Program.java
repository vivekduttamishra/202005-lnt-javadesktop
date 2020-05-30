package swt22.jface.taskmanager.console;

import java.util.Collection;

import in.conceptarchitect.taskmanager.DummyProjectSource;
import in.conceptarchitect.taskmanager.ProjectManager;
import in.conceptarchitect.taskmanager.Task;
import swt22.jface.taskmanager.support.ProjectManagerBuilder;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProjectManager manager= ProjectManagerBuilder.getProjectManager();
				
		showTasks(manager.getTasks(),"");
		
	}
	
	static void showTasks(Collection<Task> tasks, String indent) {
		if(tasks==null || tasks.size()==0)
			return ;
		for(Task task : tasks) {
			Collection<Task> subTasks=task.getSubTasks();
			System.out.printf("%s %s, %s, %d, %d\n",indent, task.getTitle(),task.getStatus(),subTasks.size(), task.getNotes().size() );
			showTasks(subTasks,indent+"\t");
		}
		
	}

}
