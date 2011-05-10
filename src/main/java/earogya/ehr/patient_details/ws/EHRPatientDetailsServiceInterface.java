package main.java.earogya.ehr.patient_details.ws;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EHRPatientDetailsServiceInterface {

	public String getName(java.lang.String name){
		File file=new File("C:/Users/Chamendri/Desktop/test.txt");
		try {
			FileWriter writer=new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(writer);
			bw.write(name);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
