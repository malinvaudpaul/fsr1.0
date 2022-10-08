package com.lip6.servlets.adress;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.daos.DAOAdress;
import com.lip6.daos.IDAOAdress;
import com.lip6.services.ServiceAdress;

@WebServlet("/AddAdressServlet")
public class AddAdressServlet extends HttpServlet{
	
	public AddAdressServlet() {
		
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
    	IDAOAdress dao = (IDAOAdress)context.getBean("cdao");*/
		//DAOAdress dao = new DAOAdress();
    	//dao.addAdress("firstname", "lastname", "email");
		
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip"); 
		String country=request.getParameter("country"); 

		
		ServiceAdress src=new ServiceAdress();
		src.createAdress(street, city, zip,country);
		
		RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		}

}
