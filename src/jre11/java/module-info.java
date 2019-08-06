module com.jwebmp.guiced.webservices {
	exports com.jwebmp.guiced.webservices;

	requires undertow.servlet;
	requires javax.servlet.api;
	requires com.jwebmp.guicedservlets;

	requires jakarta.activation;

	requires webservices.api;
	requires org.apache.cxf.core;
	requires org.apache.cxf.transport.http;
	requires org.apache.cxf.frontend.simple;

	provides com.jwebmp.guicedservlets.services.IGuiceSiteBinder with com.jwebmp.guiced.webservices.implementations.WebServiceServletModule;
	provides com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder with com.jwebmp.guiced.webservices.implementations.GuicedWebServiceTypeBinder;
}
