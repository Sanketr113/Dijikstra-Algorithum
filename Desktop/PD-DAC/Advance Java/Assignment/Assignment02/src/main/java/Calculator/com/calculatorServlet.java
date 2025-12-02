package Calculator.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class calculatorServlet
 */
@WebServlet("/calculate")
public class calculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
	    int num1 = Integer.parseInt(request.getParameter("num1"));
	    int num2 = Integer.parseInt(request.getParameter("num2"));
	    String op = request.getParameter("action");
	    int res = 0;
	    switch (op) {
		case "add": {
			 res = num1 + num2;
			 pw.write("<h5> "+num1+" +"+" "+num2+" = " + res );
		}
		break;
		case "subtract": {
			 res = num1 - num2;
			 pw.write("<h5> "+num1+" -"+" "+num2+" = " + res );
		}
		break;
		case "multiply": {
			 res = num1 * num2;
			 pw.write("<h5> "+num1+" *"+" "+num2+" = " + res );
		}
		break;
		case "divide": {
			 res = num1 / num2;
			 pw.write("<h5> "+num1+"/"+" "+num2+" = " + res );
		}
		break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
		}
	}

}
