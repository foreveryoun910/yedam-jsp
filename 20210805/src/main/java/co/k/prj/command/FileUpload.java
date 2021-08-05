package co.k.prj.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.k.prj.comm.Command;
import co.k.prj.image.service.FileInfoService;
import co.k.prj.image.vo.FileInfoVO;

public class FileUpload implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 파일업로드
		FileInfoService fileDao = new FileInfoService();
		FileInfoVO vo = new FileInfoVO();
		int maxFileSize = 1024 * 1024 * 100;
		
		try {
			// 업로드할 파일에 대한 정보를 던져준다. (request, "실제로 파일이 들어가는 경로", "파일사이즈", "인코딩타입", 중복 파일 처리(동일한 파일명이 업로드 되면 파일명 뒤에 숫자 붙이는 처리))
			MultipartRequest part = new MultipartRequest(request, "d:/temp/", maxFileSize, "utf-8", new DefaultFileRenamePolicy());
			// 넘어온 파일시스템을 가져온다. 업로드 된 시스템파일명을 구함. (중복 파일이 있으면, 중복 처리 후 이름)
			@SuppressWarnings("unused")
			String upfileName = part.getFilesystemName("fileName");
			// 업로드 된 원본파일의 이름을 구함. (중복 처리 전 이름)
			String orgfileName = part.getOriginalFileName("fileName"); // 얘가 원본을 가져오는 것
		
			vo.setSubject(part.getParameter("subject")); // 내용 받기
			vo.setFileName(orgfileName); // 여기에 orgfileName를 넣었기 때문에 DB에는 원본 파일 이름이 등록된다. 여기에 file1을 넣으면 중복 파일명 처리된 이름으로 DB에 저장된다.
			vo.setDownFile(upfileName);
			
			// DB에 처리
			int n = fileDao.fileInsert(vo);
			if(n != 0) {
				request.setAttribute("message", vo.getFileName() + " 파일 업로드 성공!");
			} else {
				request.setAttribute("message", orgfileName + " 파일 업로드 실패;");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "file/fileUploadResult";
	}

}
