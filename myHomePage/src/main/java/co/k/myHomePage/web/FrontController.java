package co.k.myHomePage.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.myHomePage.command.Home;
import co.k.myHomePage.common.Command;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.execute(request, response);
		
//		if(viewPage.startsWith("tiles:")) { // 타일즈를 태울 거야!
//			viewPage = viewPage.substring(6) + ".tiles"; // substring(6): 6부터 출력하라(0~5까지 잘라내고)
//		} else if(viewPage.endsWith(".jsp")) { // 타일즈를 안 태울 거야!
//			viewPage = "/WEB-INF/views/" + viewPage;
//		}
//		// 이렇게 쓰면 "tiles:home/home" 이런 식으로 써야 함
		
		
		if(!viewPage.endsWith(".do")) { // "home.do"
			if(!viewPage.endsWith(".jsp")) {				
				viewPage = viewPage + ".tiles"; // "home/home"
			}
		} else {
			viewPage = "/WEB-INF/views/" + viewPage; // "home/home.jsp"
		}
		// 이렇게 쓰면 tiles: 안 써도 됨 "home/home"만 써도 tiles로 간다.
		// tiles 태우기 싫으면: "home/home.jsp"
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
