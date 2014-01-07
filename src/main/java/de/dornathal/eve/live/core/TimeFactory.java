package de.dornathal.eve.live.core;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

public class TimeFactory {
	public static Duration getDuration(final int seconds) {
		try{
			return DatatypeFactory.newInstance().newDuration(true, 0, 0, 0, 0, 0, seconds);
		}catch( DatatypeConfigurationException e ){
			e.printStackTrace();
		}
		return null;
	}
}
