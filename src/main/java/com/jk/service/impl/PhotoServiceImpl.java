package com.jk.service.impl;

import com.jk.dao.PhotoDao;
import com.jk.model.Photo;
import com.jk.service.PhotoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
	@Resource
	private PhotoDao photoDao;
	public void insertphoto(Photo photo) {
		photoDao.insertphoto(photo);

	}

	public List<Photo> selectphoto() {
		return photoDao.selectphoto();
	}

}
