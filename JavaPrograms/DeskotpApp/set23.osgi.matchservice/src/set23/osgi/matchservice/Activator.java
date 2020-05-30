package set23.osgi.matchservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import set23.osgi.matchservice.contract.MathService;
import set23.osgi.matchservice.internal.PlusService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.print("Math Service Starting...");
		MathService service=new PlusService(); //Remeber Plus Service is in internal package
		
		//register PlusService with OSGi
		bundleContext.registerService(MathService.class, service, null);
		
		System.out.println("Done");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Math Service Stopped.");
	}

}
