package com.lip6.servlets.address;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.daos.DAOContactGroup;
import com.lip6.daos.IDAOContactGroup;
import com.lip6.services.ServiceContactGroup;

@WebServlet("/AddContactGroupServlet")
public class AddContactGroupGroupServlet extends HttpServlet{

	public AddContactGroupGroupServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

		/*String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName + "******************");
        }
    	IDAOContactGroup dao = (IDAOContactGroup)context.getBean("cdao");*/
		//DAOAddress dao = new DAOContactGroup();
    	//dao.addContactGroup("firstname", "lastname", "email");

		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");


		ServiceAddress src=new ServiceAddress();
		src.createAddress(street, city, zip,country);

		RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		}

}
