package controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

import dao.CreatorDAOImpl;
import model.Creator;

/**
 * Servlet implementation class CreatorController
 */
@WebServlet("/CreatorController")
public class CreatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Creator creator;
	private List<Creator> creators;
	private CreatorDAOImpl creatorDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatorController() {
        super();
        creator = new Creator();
        creators = new ArrayList<Creator>();
        creatorDAO = new CreatorDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn_save") != null) {
			
			creator.setName(request.getParameter("name"));
			creator.setLastName(request.getParameter("lastName"));
			creator.setFiliation(request.getParameter("filiation"));
			creator.setArea(request.getParameter("area"));
			
			if(creator.getId()==0L) {
				creatorDAO.createCreator(creator);
			}else {
				creatorDAO.updateCreator(creator);
			}
			
			creators=creatorDAO.readAllCreators();
			request.setAttribute("creators", creators);
			request.getRequestDispatcher("creator_list.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_new") != null) {
			
			creator = new Creator();
			request.getRequestDispatcher("creator_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_edit") != null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				creator = creatorDAO.readCreator(id);
				
			}catch(Exception e) {
				creator = new Creator();
			}
			
			request.setAttribute("creator", creator);
			request.getRequestDispatcher("creator_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
			
			try{
				Long id = Long.parseLong(request.getParameter("id"));
				creatorDAO.deleteCreator(id);
				creators = creatorDAO.readAllCreators();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			request.setAttribute("creators", creators);
			request.getRequestDispatcher("creator_list.jsp").forward(request, response);
			
		}else {
			
			creators = creatorDAO.readAllCreators();
			request.setAttribute("creators", creators);
			request.getRequestDispatcher("creator_list.jsp").forward(request, response);
			
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
