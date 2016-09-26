package com.community.cook.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface FileUploadService {

	ObjectNode uploadImage(MultipartHttpServletRequest request, HttpServletResponse response);

}
