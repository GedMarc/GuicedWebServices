package com.jwebmp.guiced.webservices.implementations;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletConfig;

public class CxfNonSpring extends CXFNonSpringServlet
{
	@Override
	public void loadBus(ServletConfig servletConfig)
	{
		super.loadBus(servletConfig);
		// You could add the endpoint publish codes here
		Bus bus = getBus();
		BusFactory.setDefaultBus(bus);
	}
}
