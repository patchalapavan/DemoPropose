package com.javainuse.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.javainuse.dao.ZipDao;
import com.javainuse.model.ZipTar;

@Service("zipService")
public class ZipService {
	
	ZipDao zipDao = null; 
	
	public String addFileInfo(ZipTar zipTar) throws IOException, NoSuchAlgorithmException {
		zipDao = new ZipDao();
		//Use SHA-1 algorithm
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
		 
		//SHA-1 checksum
		String shaChecksum = getFileChecksum(shaDigest, zipTar.getFile());
		if(shaChecksum != null && !shaChecksum.equals(""))
			zipTar.setCheckSum(shaChecksum);
		zipDao.addFileInfo(zipTar);
		
		return "SUCCESS";
	}
	
	public ZipTar downloadZipTar(String userId, int downlodedPosition) {
		zipDao = new ZipDao();
		ZipTar zt = zipDao.downloadZipTar(userId);
		if(downlodedPosition > 0) {
			zt.setFileData(Arrays.copyOfRange(zt.getFileData(), downlodedPosition, zt.getFileData().length));
		}
		return zt;
	}
	
	public String getFileChecksum(MessageDigest digest, File file) throws IOException
	{
	    //Get file input stream for reading the file content
	    FileInputStream fis = new FileInputStream(file);
	     
	    //Create byte array to read data in chunks
	    byte[] byteArray = new byte[1024];
	    int bytesCount = 0;
	      
	    //Read file data and update in message digest
	    while ((bytesCount = fis.read(byteArray)) != -1) {
	        digest.update(byteArray, 0, bytesCount);
	    };
	     
	    //close the stream; We don't need it now.
	    fis.close();
	     
	    //Get the hash's bytes
	    byte[] bytes = digest.digest();
	     
	    //This bytes[] has bytes in decimal format;
	    //Convert it to hexadecimal format
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i< bytes.length ;i++)
	    {
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	     
	    //return complete hash
	   return sb.toString();
	}

}
