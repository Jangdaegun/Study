package sa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet({"/JoinOk", "/JoinOK"})
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String strId = request.getParameter("id");
		String strPw = request.getParameter("pw");
		PasswordEncoder p = new BCryptPasswordEncoder();
		
		String cPassword = p.encode(strPw);
		System.out.println(p.matches(strPw, cPassword));
		
		Dao mydao = new Dao();
		int result = mydao.insertUser(strId, cPassword);
		if(result == 1) {
			response.sendRedirect("joinResult.jsp");
		}
		else {
			response.sendRedirect("join.html");
		}
	
}

}
