package com.community.help.cook.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface FileUploadService {

	ObjectNode uploadImage(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException;

	ObjectNode getImageData(HttpServletResponse response, long userId);

}