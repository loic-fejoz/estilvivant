/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.application.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estilvivant.application.Answer;
import com.estilvivant.application.AnswerBuilder;
import com.estilvivant.application.router.URLMapper;
import com.estilvivant.domain.persona.Persona;

/**
 * @author Loïc Fejoz
 * 
 */
public class PersonaServlet extends HttpServlet {

	private static final long serialVersionUID = 8436458542185940949L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		final Persona thePersona = URLMapper.INSTANCE.asPersona(req);
		if (thePersona == null) {
			resp.sendError(404, "Not found");
			return;
		}
		final AnswerBuilder ansBuilder = AnswerBuilder.INSTANCE;	
		final Answer answer = ansBuilder.buildAnswer(thePersona);
		req.setAttribute("ans", answer);
		req.setAttribute("q", thePersona.getFullName());
		req.getRequestDispatcher("/WEB-INF/jsp/persona.jsp").forward(req, resp);
	}
}
