package co.k.prj.image.service;

import java.util.List;

import co.k.prj.image.vo.FileInfoVO;

public interface FileInfoMapper {
	List<FileInfoVO> fileSelectList();
	FileInfoVO fileSelect(int key);
	int fileInsert(FileInfoVO vo);
	int fileUpdate(FileInfoVO vo);
	int fileDelete(int key);
}
