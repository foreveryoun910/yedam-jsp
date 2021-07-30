package co.k.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.myHomePage.common.Command;

public class Home implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "home/home"; // tiles로 보내기 위해 앞에 tiles: 붙임 나중에 자른다?
	}

}
