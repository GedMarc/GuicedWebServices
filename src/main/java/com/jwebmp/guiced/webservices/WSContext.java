package com.jwebmp.guiced.webservices;

public class WSContext
{
	/**
	 * Provides the url that the module will use to provide Web Services.
	 * Does not default to module name, default to WebServices
	 * <p>
	 *
	 * <p>
	 * e.g. http://localhost/WebServices/helloworld
	 */
	public static String baseWSUrl = "/WebServices";
	/**
	 * A separate port to run the Web Services on - The do not filter through the main handler
	 */
	public static Integer port = 6006;
	/**
	 * The protocol the WS is listening on
	 */
	public static String protocol = "http";
	/**
	 * The address that the server will respond to
	 */
	public static String listeningAddress = "localhost";
}
