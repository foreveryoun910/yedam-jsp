package co.k.prj.image.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.k.prj.comm.DataSource;
import co.k.prj.image.vo.FileInfoVO;

public class FileInfoService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private FileInfoMapper map = sqlSession.getMapper(FileInfoMapper.class);
	
	public List<FileInfoVO> fileSelectList() {
		return map.fileSelectList();
	}
	
	public FileInfoVO fileSelect(int key) {
		return map.fileSelect(key);
	}
	
	public int fileInsert(FileInfoVO vo) {
		return map.fileInsert(vo);
	}
	
	public int fileUpdate(FileInfoVO vo) {
		return map.fileUpdate(vo);
	}
	
	public int fileDelete(int key) {
		return map.fileDelete(key);
	}
	
}
