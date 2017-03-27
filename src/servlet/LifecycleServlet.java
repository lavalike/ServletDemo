package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet
 */
@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifecycleServlet() {
		System.out.println(getClass().getSimpleName() + "�Ĺ��췽����ִ��");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(getClass().getSimpleName() + "��doGet������ִ��");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.print("Servlet Demo");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.print("Current page is " + getClass().getSimpleName() + ".class");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		System.out.println(getClass().getSimpleName() + "��init������ִ��");
	}
	
	@Override
	public void destroy() {
		System.out.println(getClass().getSimpleName() + "��destroy������ִ��");
	}
}
