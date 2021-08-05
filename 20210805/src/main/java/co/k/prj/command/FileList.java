package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.comm.Command;
import co.k.prj.image.service.FileInfoService;

public class FileList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 파일목록보기
		FileInfoService fileDao = new FileInfoService();
		request.setAttribute("files", fileDao.fileSelectList());
		
		return "file/fileList";
	}

}
