package com.guicedee.guicedservlets.webservices.implementations;

import io.github.classgraph.ClassInfo;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedinjection.interfaces.IGuicePostStartup;
import com.guicedee.guicedservlets.webservices.WSContext;
import com.guicedee.logger.LogFactory;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.logging.Level;

public class WebServiceStarterPostLoad implements IGuicePostStartup<WebServiceStarterPostLoad> {

	@SuppressWarnings("unchecked")
	@Override
	public void postLoad() {


		//To load a custom one e.g. ssl stuffs also later on at any point bla bla bla :
		/*ServerFactoryBean factory = new ServerFactoryBean();
		factory.setServiceClass(CalculatorServiceImpl.class);
		factory.setAddress("/calcService");
		factory.create();*/

		for (ClassInfo classInfo : GuiceContext.instance()
											   .getScanResult()
											   .getClassesWithAnnotation(WebService.class.getCanonicalName())) {
			Class calledType = classInfo.loadClass();
			WebService anno = (WebService) calledType.getAnnotation(WebService.class);
			try
			{
				if(classInfo.isInterface() || classInfo.isAbstract())
				{
					LogFactory.getLog(WebServiceStarterPostLoad.class).log(Level.WARNING,"Not creating web service for [" + calledType.getCanonicalName() + "]. Interface/Abstract.");
					continue;
				}

				Object o = GuiceContext.get(calledType);
				Endpoint endpoint = Endpoint.create(o);
				String path = (anno.name()
								   .isEmpty() ? "/" + calledType.getSimpleName() : anno.name());
				path = WebServiceServletModule.cleanPath(WSContext.baseWSUrl) + path;
				String endpointPath = WSContext.protocol + "://" + WSContext.listeningAddress + ":" +
						WSContext.port + path;
				endpoint.publish(endpointPath, o);
				LogFactory.getLog(WebServiceStarterPostLoad.class)
						  .info("WS Endpoint Active on Default WSContext Settings : " + path);
			}
			catch (Exception e)
			{
				LogFactory.getLog(WebServiceStarterPostLoad.class).log(Level.WARNING,"Not creating web service for [" + calledType.getCanonicalName() + "]. Check finer logs for details");
				LogFactory.getLog(WebServiceStarterPostLoad.class)
						  .log(Level.FINER, "Unable to bind Web Service for [" + calledType.getCanonicalName() + "]. This is usually  because it is an internal one", e);
			}
		}
	}
}
