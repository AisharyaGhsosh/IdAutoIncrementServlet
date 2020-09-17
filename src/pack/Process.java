package pack;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Process
 */
public class Process extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		try{
			Connection conn=DbConnection.getConnection();
			int rollno=0;
			String uname=request.getParameter("uname");
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String addrs=request.getParameter("addrs");
			String cont=request.getParameter("cont");
			PreparedStatement ps=conn.prepareStatement("select max(rollno) from stu456");
			ResultSet rs=ps.executeQuery();
			 
			if(rs.next()){
				rollno=rs.getInt(1);
				rollno++;
				
				PreparedStatement p=conn.prepareStatement("insert into stu456 values(?,?,?,?,?,?)");
				p.setInt(1, rollno);
				p.setString(2, uname );
				p.setString(3, fname);
				p.setString(4, lname);
				p.setString(5, addrs);
				p.setString(6, cont);
				
				int i=p.executeUpdate();
				if(i>0){
					response.sendRedirect("welcome.jsp");
				}
				else{
					response.sendRedirect("error.jsp");
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
