package com.estilvivant.application.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.estilvivant.application.Answer;
import com.estilvivant.application.AnswerBuilder;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		final String query = req.getParameter("q");
		final AnswerBuilder ansBuilder = AnswerBuilder.INSTANCE;
		final Answer answer = ansBuilder.buildAnswer(query);
		req.setAttribute("ans", answer);
		req.setAttribute("q", query);
		req.getRequestDispatcher("/WEB-INF/jsp/persona.jsp").forward(req, resp);
	}
}
