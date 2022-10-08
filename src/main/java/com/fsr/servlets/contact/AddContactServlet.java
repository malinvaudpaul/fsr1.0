package com.fsr.servlets.contact;

import com.fsr.daos.DAOContact;
import com.fsr.daos.IDAOContact;
import com.fsr.services.ServiceContact;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/** Servlet implementation class AddContactServlet */
@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AddContactServlet() {}

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

    ApplicationContext context =
        WebApplicationContextUtils.getWebApplicationContext(getServletContext());

    /*String[] allBeanNames = context.getBeanDefinitionNames();
       for(String beanName : allBeanNames) {
           System.out.println(beanName + "******************");
       }
    IDAOContact dao = (IDAOContact)context.getBean("cdao");*/
    IDAOContact dao = new DAOContact();
    dao.addContact("firstname", "lastname", "email");

    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");

    ServiceContact src = new ServiceContact();
    src.createContact(fname, lname, email);

    RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
    rd.forward(request, response);
  }
}
