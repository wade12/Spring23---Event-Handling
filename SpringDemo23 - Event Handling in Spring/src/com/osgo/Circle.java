package com.osgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
// @Service
// @Repository
// @Controller
public class Circle implements Shape, ApplicationEventPublisherAware
{
	private Point centre;
	@Autowired
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;
	
	public void draw()
	{
		// System.out.println("Drawing Circle.");
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
		// System.out.println("Circle with centre point at:" +"(" + centre.getX() + ", " + centre.getY() + ")" );
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {centre.getX(), centre.getY()}, "Default Point Message", null));
		
		System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		
	} // end method draw

	public MessageSource getMessageSource()
	{
		return messageSource;
	} // end method getMessageSource

	public void setMessageSource(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	} // end method setMessageSource

	public Point getCentre()
	{
		return centre;
	} // end method getCentre

	@Resource
	public void setCentre(Point centre)
	{
		this.centre = centre;
	} // end method setCentre

	@PostConstruct
	public void initialiseCircle()
	{
		System.out.println("Initialisation of Circle");
	} // end method initialiseCircle
	
	@PreDestroy
	public void destroyCircle()
	{
		System.out.println("Destroy of Circle");
	} // end method destroyCircle

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher)
	{
		this.publisher = publisher;
	} // end method  setApplicationEventPublisher
	
} // end Class Circle
