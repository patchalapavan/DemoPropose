

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.javainuse.model.ZipTar;
import com.javainuse.service.ZipService;

import junit.framework.Assert;

public class ZipTarTest {
	
	@Autowired
	private ZipService zipService;
	
	@Test
	public void testZipTar() throws NoSuchAlgorithmException, IOException {
		System.out.println("zipService : "+zipService);
		ZipService zs = new ZipService();
		ZipTar zipTar = iputZipTar();
		zs.addFileInfo(zipTar);
		Assert.assertEquals("SUCCESS", "SUCCESS");
	}
	
	public ZipTar iputZipTar() {
		String filePath = "C:\\Users\\pavan\\Desktop\\pavan\\Income tax savings.zip";
		ZipTar zt = new ZipTar();
		try {
			File resume = new File(filePath);
			
			byte[] bFile = Files.readAllBytes(new File(filePath).toPath());
			zt.setFile(resume);
			zt.setUserId("checksum1");
			zt.setFileName(resume.getName());
			zt.setFileData(bFile);
	      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return zt;
	}

}
