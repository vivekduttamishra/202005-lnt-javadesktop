package swt22.jface.taskmanager.support;

import in.conceptarchitect.taskmanager.DummyProjectSource;
import in.conceptarchitect.taskmanager.ProjectManager;

public class ProjectManagerBuilder {
	
	public static ProjectManager getProjectManager() {
		ProjectManager manager=new ProjectManager();
		manager.createProject("Vivek", "password",false);
		
		DummyProjectSource source=new DummyProjectSource();
		source.addTasks(manager);
		return manager;
	}

}
