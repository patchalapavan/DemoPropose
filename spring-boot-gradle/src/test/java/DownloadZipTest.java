

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import org.junit.Test;

import com.javainuse.model.ZipTar;
import com.javainuse.service.ZipService;

import junit.framework.Assert;

public class DownloadZipTest {

	@Test
	public void test() {
		ZipService zs = new ZipService();
		ZipTar zt = zs.downloadZipTar("pavan1", 1234023);
		Assert.assertNotNull(zt);
		if(zt != null) {
			try (FileOutputStream fileOuputStream = new FileOutputStream("C:\\Users\\pavan\\Desktop\\pavan\\download_"+zt.getFileName())) {
	            fileOuputStream.write(zt.getFileData());
	            fileOuputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}

	
}
