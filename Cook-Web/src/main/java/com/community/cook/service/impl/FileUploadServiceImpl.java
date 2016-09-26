package com.community.cook.service.impl;

import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.community.cook.dao.UserDao;
import com.community.cook.service.FileUploadService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	
	@Autowired
	private UserDao userDao;

	/*
	 * (non-Javadoc)
	 * @see com.community.cook.service.FileUploadService#uploadImage(org.springframework.web.multipart.MultipartHttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ObjectNode uploadImage(MultipartHttpServletRequest request, HttpServletResponse response) {
		// Iterate over the request to check image
		Iterator<String> itr =  request.getFileNames();
		 
		 // Check if request has any files
		 if(null != itr && itr.hasNext()){
			 // TODO: Validation Pending && User Id Pending -- get User object from session
			 MultipartFile mpf = request.getFile(itr.next());
			 
			 if(null != mpf){
				 userDao.getUserById(6l);
			 }
			 
		 }
		 
		 
		return null;
	}

}
