package com.fsr.servlets.ContactGroup;

import com.fsr.services.ServiceContactGroup;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation class DeleteContactGroupServlet */
@WebServlet("/DeleteContactGroupServlet")
public class DeleteContactGroupGroupServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DeleteContactGroupGroupServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    long id = Long.parseLong(request.getParameter("id"));

    ServiceContactGroup src = new ServiceContactGroup();
    src.deleteContactGroup(id);

    RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
    rd.forward(request, response);
  }
}
