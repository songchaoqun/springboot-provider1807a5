package com.jk.dao;

import com.jk.model.Photo;

import java.util.List;

public interface PhotoDao {
	public void insertphoto(Photo photo);
	public List<Photo> selectphoto();
	
}
