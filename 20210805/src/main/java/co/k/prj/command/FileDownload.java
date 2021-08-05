package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.comm.Command;
import co.k.prj.comm.DownloadFile;

public class FileDownload implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 파일 다운로드
//		System.out.println(request.getParameter("orgFile"));
//		System.out.println(request.getParameter("downFile"));
		
		String path = "d://temp"; // 물리적 경로 path, 슬래시 두개 하는 거 잊지 마
		String orgFileName = request.getParameter("orgFile"); // 폼에서 받은 이름(id, name)
		String downFileName = request.getParameter("downFile");
		DownloadFile downloadFile = new DownloadFile(path, orgFileName, downFileName);
		boolean b = downloadFile.isFileDown();
		if(!b) {
			request.setAttribute("message", "파일 다운로드 성공!");
		} else {
			request.setAttribute("message", "파일 다운로드 실패;");
		}
		return "fileList.do";
	}

}
