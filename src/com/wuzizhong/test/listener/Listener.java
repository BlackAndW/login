package com.wuzizhong.test.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */


public class Listener implements HttpSessionListener {

	public int count = 0;

	public void sessionCreated(HttpSessionEvent hse) {
		count++;
		hse.getSession().setAttribute("OnLineNum", count);
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		count--;
		hse.getSession().setAttribute("OnLineNum", count);
	}

}
