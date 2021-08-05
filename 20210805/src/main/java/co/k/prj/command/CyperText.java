package co.k.prj.command;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.comm.Command;
import co.k.prj.comm.SHA_256;

public class CyperText implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 비밀번호 암호화
		SHA_256 cyper = new SHA_256();
		String str = "Hellow1234"; // 이런 패스워드를 만들었다고 가정하고
		try {
			String cyperText = cyper.encrypt(str); // 암호문이 db에 저장된다.
			// ex) 얘를 vo에 vo.setPassword(cyperText)로 담아서 db에 저장하고, 불러와서 비교할 때도 암호문으로 비교한다.
			System.out.println("원문: " + str);
			System.out.println("암호문: " + cyperText); // 암호문이 db에 저장된다.
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
