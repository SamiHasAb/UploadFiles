package org.study;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
      
      try {
		List<FileItem> images = upload.parseRequest(request);
		for(FileItem image: images) {
			String name = image.getName();
			try{
				// code for windows only 
				// no need for linux
				//get the full name and path
				//get the string after the last slash
				//+1 to get the string after the 1st char which is the slash
				
				name = name.substring(name.lastIndexOf("\\")+1);
				} catch(Exception e) {
					
				}
			System.out.println(name);
			//need to give read and write access in windows user
			image.write(new File("E:/JAVA Full stuck/imagesUploadTest/"+name));
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      
      
      
      
      
	}

}
