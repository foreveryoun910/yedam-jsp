package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.common.Command;

public class Home implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO home
		return "home/home";
	}

}
