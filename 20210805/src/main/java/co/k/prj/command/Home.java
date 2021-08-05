package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.comm.Command;

public class Home implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "home/home";
	}

}
