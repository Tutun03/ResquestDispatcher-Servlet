package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String myemail=req.getParameter("email");
		String mypass=req.getParameter("pass1");
		
		PrintWriter out=resp.getWriter();
		if(myemail.equals("aniketacharya30@gmail.com")&& mypass.equals("Tutun1@03092000"))
		{
			req.setAttribute("name_key", "Aniket Acharya");//basically show data on profile page.
			RequestDispatcher rd= req.getRequestDispatcher("/profile.jsp");
		    rd.forward(req,resp);
		}
		else
		{
			
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>enter email id and password not matched");
			RequestDispatcher rd= req.getRequestDispatcher("/index4.html");
//		    rd.forward(req,resp);//to include addition text we have to use rd.include 
//		    rd.include(req, resp);//merge but in html format,to print entire in html we have to use resp.setContentType("text/html");
			rd.include(req, resp);
		}
	}

}
//url is not changed after redirection of both cases
