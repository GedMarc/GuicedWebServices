package com.jwebmp.guiced.webservices.implementations;

import com.google.inject.Singleton;

import static com.jwebmp.guiced.webservices.WSContext.*;

public class WebServiceServletModule
		implements com.jwebmp.guicedservlets.services.IGuiceSiteBinder<com.jwebmp.guicedservlets.services.GuiceSiteInjectorModule>
{


	@Override
	public void onBind(com.jwebmp.guicedservlets.services.GuiceSiteInjectorModule module)
	{
		StringBuilder url = new StringBuilder(baseWSUrl + "*");

/*		module.bind(WebServiceContext.class)
		    .toInstance(GuiceManagedInstanceResolver.webServiceContext);*/


		module.bind(com.sun.xml.ws.transport.http.servlet.WSServlet.class)
		      .in(Singleton.class);
		module.serve$(url.toString())
		      .with(com.sun.xml.ws.transport.http.servlet.WSServlet.class);
	}
}
