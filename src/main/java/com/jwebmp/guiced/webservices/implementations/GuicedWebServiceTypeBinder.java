package com.jwebmp.guiced.webservices.implementations;

import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.jwebmp.guiced.webservices.WSContext;
import com.jwebmp.guicedinjection.abstractions.GuiceInjectorModule;
import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;
import com.jwebmp.logger.LogFactory;
import org.apache.cxf.BusFactory;
import org.apache.cxf.frontend.ServerFactoryBean;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.logging.Level;

public class GuicedWebServiceTypeBinder
		implements IGuiceDefaultBinder<GuicedWebServiceTypeBinder, GuiceInjectorModule>
{
	@Override
	public void onBind(GuiceInjectorModule module)
	{
		module.bindListener(Matchers.any(), new TypeListener()
		{
			@Override
			public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter)
			{
				Class calledType = type.getRawType();
				if (calledType.isAnnotationPresent(WebService.class))
				{
					WebService anno = (WebService) calledType.getAnnotation(WebService.class);
					try
					{
						Object o = calledType.getDeclaredConstructor()
						                     .newInstance();
						Endpoint endpoint = Endpoint.create(o);

						String path = WSContext.baseWSUrl + "" + (anno.name()
						                                              .isEmpty() ? "/" + calledType.getSimpleName() : anno.name());

						if(WSContext.port != null)
						{
							String endpointPath = WSContext.protocol + "://" + WSContext.listeningAddress + ":" +
							                      WSContext.port  + path;

							endpoint.publish(endpointPath, o);
						}
						else
						{
							// You can als use the simple frontend API to do this
							ServerFactoryBean factory = new ServerFactoryBean();
							factory.setBus(BusFactory.getDefaultBus());
							factory.setServiceClass(o.getClass());
							factory.setAddress(WSContext.baseWSUrl + path);
							factory.create();
						}

						LogFactory.getLog(GuicedWebServiceTypeBinder.class)
						          .info("WS Endpoint Active : " + path);
					}
					catch (Exception e)
					{
						LogFactory.getLog(GuicedWebServiceTypeBinder.class)
						          .log(Level.SEVERE, "Unable to bind Web Service for [" + calledType.getCanonicalName() + "]", e);
					}
				}
			}
		});
	}
}
