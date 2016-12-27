package com.community.help.cook.service.impl;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.community.help.cook.dao.UserDao;
import com.community.help.cook.domain.CookUser;
import com.community.help.cook.service.FileUploadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ObjectMapper jacksonMapper;

	/*
	 * (non-Javadoc)
	 * @see com.community.cook.service.FileUploadService#uploadImage(org.springframework.web.multipart.MultipartHttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	@Transactional(readOnly = false)
	public ObjectNode uploadImage(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
		// Iterate over the request to check image
		Iterator<String> itr =  request.getFileNames();

		// Check if request has any files
		if(null != itr && itr.hasNext()){
			// TODO: Validation Pending && User Id Pending -- get User object from session

			MultipartFile mpf = request.getFile(itr.next());

			if(null != mpf){
				CookUser cookUser = userDao.getUserById(2l);
				// TODO: Handle Exception
				cookUser.setImageContent(mpf.getBytes());
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly= true)
	public ObjectNode getImageData(HttpServletResponse response, long userId) {
		CookUser cookUser = userDao.getUserById(userId);
		ObjectNode responseNode= jacksonMapper.createObjectNode();
		responseNode.put("imageData", cookUser.getImageContent());
		return responseNode;
	}

}