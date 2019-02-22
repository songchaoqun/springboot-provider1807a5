package com.jk.service;

import com.jk.model.Photo;

import java.util.List;

public interface PhotoService {
	public void insertphoto(Photo photo);
	public List<Photo> selectphoto();
}
