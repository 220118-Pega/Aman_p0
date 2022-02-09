package com.revature.p0.controller;

import io.javalin.http.Handler;

/**
 * ----------------------------------------- contain methods that when implemented would define how controllers handle http requests
 * @author vergi
 *
 */
public interface Icontroller {
	Handler getAll();
	Handler getbyId();
	Handler add();
	Handler update();
}
