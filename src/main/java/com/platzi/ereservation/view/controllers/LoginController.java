package com.platzi.ereservation.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador personalizado para el login para validar las peticiones relacionadas con la autentificación
 * En este controlador se validará dos peticiones la de login y la home a través de la 
 * ruta /app/login y /app/home respectivamente
 * @author josemolina
 *
 */
@Controller
@RequestMapping("app")
public class LoginController {
	
	@GetMapping(value= {"/login", "/"})
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		String errroMessage="Usuario no autorizado, debe autenticarse.";
		mav.addObject("errorMsg", errroMessage);
		mav.setViewName("login");
		return mav;
	}
		
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}

}
