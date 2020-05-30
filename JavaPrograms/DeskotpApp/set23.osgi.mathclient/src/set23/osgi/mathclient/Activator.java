package set23.osgi.mathclient;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import set23.osgi.matchservice.contract.MathService;
import set23.osgi.matchservice.external.MinusService;
//import set23.osgi.matchservice.internal.PlusService; //Access Restriction

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Math Client Starting..");
		//TODO:You application Task comes here...
		
		//Option #1. Can access class from any exported Bundle
		MinusService minus=new MinusService();
		System.out.println("Minus Service :"+minus.solve(20, 4));
		
		//Option #2. can access the rgistered Service based on internal implementation
		ServiceReference<MathService> serviceReference= bundleContext.getServiceReference(MathService.class);
		MathService service=(MathService) bundleContext.getService(serviceReference);

		System.out.println("Service Result: "+ service.solve(20, 4));
		
		
		//Important. While you can access PlusService as registered Service
		//You can't access it directly
		//Access Resitrcition.
		//PlusService service;
		
		
		
		
		
		System.out.println("Math Client Started...");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Math Client Stopped");
	}

}
