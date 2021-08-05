package co.k.prj.comm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DownloadFile {
	private String path; // 파일이 실제 들어 있는 물질적 공간 주소
	private String orgFileName; // 원본 파일명
	private String downFileName; // 실제 다운로드될 파일명
	
	
	public DownloadFile(String path, String orgFileName, String downFileName) {
		super();
		this.path = path;
		this.orgFileName = orgFileName;
		this.downFileName = downFileName;
	}
	
	public boolean isFileDown() { // 다운로드가 성공하면 false, 실패하면 true
		boolean bool = true;
		File file = new File(path + File.separator + downFileName); // d:/temp/파일명
		FileInputStream in; // 이 코드를 따로 안 써주고 try 안에 FileInputStream in = new FileInputStream(file); 라고 한번에 쓰니까 java.io.FileNotFoundException: (액세스가 거부되었습니다) 예외가 발생했다.
		try {
			in = new FileInputStream(file); // 이 파일을 읽어서
			FileOutputStream outFile = new FileOutputStream("d://download//" + orgFileName); // 파일 다운로드 받을 경로 지정
			
			byte b[] = new byte[4096];
			int data = 0;
			while((data = in.read(b, 0, b.length)) != -1) {
				outFile.write(b, 0, data);
			}
			outFile.flush();
			outFile.close();
			in.close();
			bool = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}
}
