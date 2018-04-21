package miniprojet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniprojet.model.Person;
import miniprojet.model.Authentication;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = null;

		Authentication authentication = new Authentication();
		String decon = request.getParameter("deconnect");

		Person person1 = new Person("Ali", "ali");
		Person person2 = new Person("aaa", "aaaa");
		Person person3 = new Person("bbb", "bbbb");
		Person person4 = new Person("akour", "akali");
		Person person5 = new Person("Kiris", "kaki");
		//		try {
		//			System.out.println("ici");
		//
		//			authentication.register(person1);
		//			authentication.register(person2);
		//			authentication.register(person3);
		//			authentication.register(person4);
		//			authentication.register(person5);
		//			System.out.println("la");
		//
		//		}catch (ClassNotFoundException e) {
		//
		//			e.printStackTrace();
		//		}


		Person random = new Person(request.getParameter("username"),request.getParameter("password"));

		try {



			if(authentication.verify(random)) {
				System.out.println("Connexion validée");
				dis = getServletContext().getRequestDispatcher("/welcome.jsp");
			}
			else if (decon != null && decon.equals("Deconnecter")) {
				dis=getServletContext().getRequestDispatcher("/goodbye.jsp");

			}
			else {
				System.out.println("Connexion refusée");
				dis = getServletContext().getRequestDispatcher("/error.jsp");
			}


			dis.include(request, response);


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}





		doGet(request, response);
	}


}
