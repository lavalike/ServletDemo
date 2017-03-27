package servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("input_account");
		String password = request.getParameter("input_password");
		System.out.println(account + ":" + password);
		if (account.equals("admin") && password.equals("admin")) {
			request.setAttribute("account", account);
			request.setAttribute("password", password);
			request.getRequestDispatcher("login/LoginSuccess.jsp").forward(request, response);
//			response.sendRedirect("login/LoginSuccess.jsp");
		} else {
			response.sendRedirect("login/LoginFailure.jsp");
		}
	}

}
