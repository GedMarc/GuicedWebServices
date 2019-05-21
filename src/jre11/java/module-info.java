module com.jwebmp.guiced.webservices {
	exports com.jwebmp.guiced.webservices;

	requires undertow.servlet;
	requires javax.servlet.api;
	requires com.jwebmp.guicedservlets;

	requires org.apache.cxf.core;
	requires org.apache.cxf.frontend.jaxws;
	requires org.apache.cxf.databinding.jaxb;
	requires org.apache.cxf.binding.soap;
	requires org.apache.cxf.binding.xml;
	requires org.apache.cxf.transport.http;
	requires org.apache.cxf.transport.http.jetty;
	requires org.apache.cxf.frontend.simple;
	requires org.apache.cxf.ws.addr;
	requires org.apache.cxf.ws.policy;
	requires org.apache.cxf.wsdl;

	requires java.activation;
	requires jakarta.activation;
	requires webservices.api;

	provides com.jwebmp.guicedservlets.services.IGuiceSiteBinder with com.jwebmp.guiced.webservices.implementations.WebServiceServletModule;
	provides com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder with com.jwebmp.guiced.webservices.implementations.GuicedWebServiceTypeBinder;
}
