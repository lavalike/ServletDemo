package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/register")
public class RegServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		try {
			User user = new User();
			String userName = request.getParameter("input_name");
			String userSex = request.getParameter("input_sex");
			String userAge = request.getParameter("input_age");

			user.setName(userName);
			user.setSex(userSex);
			user.setAge(userAge);
			// 保存Session
			request.getSession().setAttribute("userinfo", user);
			// 跳转到用户信息页面
			request.getRequestDispatcher("user/UserInfo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
