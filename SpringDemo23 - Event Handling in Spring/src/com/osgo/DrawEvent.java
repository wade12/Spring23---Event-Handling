package com.osgo;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent
{
	public DrawEvent(Object source)
	{
		super(source);
	} // end constructor
	
	public String toString()
	{
		return "Draw Event Occurred.";
	} // end method toString

} // end Class DrawEvent
