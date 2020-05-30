package in.conceptarchitect.jface.viewers;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

public class AbstractTableDetailsProvider implements ITableLabelProvider,  IStructuredContentProvider {

	
	

	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	//— table data
	
	@Override
	public Object[] getElements(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public String getColumnText(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	

    
	
	

	
}
