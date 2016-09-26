package com.community.cook.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ObjectNode uploadImage(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException{
		return fileUploadService.uploadImage(request,response);
	}
	
	@RequestMapping(value = "/image/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public ObjectNode getImageData(HttpServletResponse response,@PathVariable long userId){
		return fileUploadService.getImageData(response,userId);
	}

}