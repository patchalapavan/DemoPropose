package org.learn.jackson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJsontoObj {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\pavan\\Downloads\\barCodes.json");
			String jsonStr = "";
			String st;
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (( st = br.readLine()) != null) {
				jsonStr = jsonStr + st;
			}
			ObjectMapper objectMapper = new ObjectMapper();
			List<BarCodeReadResults> barCodesList = objectMapper.readValue(jsonStr, objectMapper.getTypeFactory().constructCollectionType(List.class, BarCodeReadResults.class));
			System.out.println(barCodesList.size());
			br.close();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
