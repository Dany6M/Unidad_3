package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoatDAO;
import dao.BoatDAOImpl;
import model.Boat;


/**
 * Servlet implementation class BoatController
 */
@WebServlet("/BoatController")
public class BoatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Boat boat;
	private List<Boat> boats;
	private BoatDAOImpl boatDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoatController() {
        super();
       boat = new Boat();
       boats = new ArrayList<Boat>();
       boatDAO = new BoatDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn_save")!=null) {
			
			boat.setName(request.getParameter("name"));
			boat.setOrigin(request.getParameter("origin"));
			boat.setRoute(request.getParameter("route"));
			
			if(boat.getId()==0L) {
				boatDAO.createBoat(boat);
			}else {
				boatDAO.updateBoat(boat);
			}
			
			boats=boatDAO.readAllBoats();
			request.setAttribute("boats", boats);
			request.getRequestDispatcher("boat_list.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_new")!=null) {
			boat = new Boat();
			request.getRequestDispatcher("boat_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_edit")!=null) {
			try{
				Long id = Long.parseLong(request.getParameter("id"));
				boat = boatDAO.readBoat(id);
				
			}catch(Exception e) {
				boat = new Boat();
			}
			
			request.setAttribute("boat", boat);
			request.getRequestDispatcher("boat_form.jsp").forward(request,response);	
			
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				boatDAO.deleteBoat(id);
				boats = boatDAO.readAllBoats();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("boats", boats);
			request.getRequestDispatcher("boat_list.jsp").forward(request, response);
			
		}else {
			boats = boatDAO.readAllBoats();
			System.out.println(boats);
			request.setAttribute("boats", boats);
			request.getRequestDispatcher("boat_list.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
