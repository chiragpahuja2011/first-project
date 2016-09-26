package com.community.cook.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.community.cook.service.FileUploadService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping(value = "/fileUpload")
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping(value = "/image", method=RequestMethod.POST)
	@ResponseBody
	public ObjectNode uploadImage(MultipartHttpServletRequest request, HttpServletResponse response){
		return fileUploadService.uploadImage(request,response);
	}

}
