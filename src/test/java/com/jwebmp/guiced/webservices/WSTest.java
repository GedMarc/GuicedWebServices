package com.jwebmp.guiced.webservices;

import com.jwebmp.logger.LogFactory;
import com.jwebmp.undertow.JWebMPUndertow;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

class WSTest
{
	public static void main(String[] args) throws Exception
	{
		LogFactory.configureConsoleColourOutput(Level.FINE);
		JWebMPUndertow.boot("localhost", 6004);
	}

	@Test
	void testMe() throws Exception
	{
		LogFactory.configureConsoleColourOutput(Level.FINE);
		JWebMPUndertow.boot("localhost", 6004);
	}
}
