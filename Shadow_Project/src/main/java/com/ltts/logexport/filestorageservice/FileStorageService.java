package com.ltts.logexport.filestorageservice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.ltts.logexport.fileproperties.Properties;

public class FileStorageService {
	
	public static boolean saveFile(HttpServletResponse res) throws IOException, Exception {
		File file = new File(Properties.zipFilepath);
		res.setContentType("application/octet-stream");
		String headerKey ="Content-Disposition";
		String headerValue="attachment;filename="+file.getName();
		res.setHeader(headerKey, headerValue);
		ServletOutputStream outputStream = res.getOutputStream();
		BufferedInputStream inputStream =new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[8192];
		int bytesRead=-1;
		while((bytesRead=inputStream.read(buffer))!=-1)
		{
			outputStream.write(buffer,0,bytesRead);
			
		}
		inputStream.close();
		outputStream.close();
		return false;

	}

}
