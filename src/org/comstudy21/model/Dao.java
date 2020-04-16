package org.comstudy21.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Dao {

	private String filePath = "src/org/comstudy21/model/students.json";
	private FileReader fileReader;
	private FileWriter fileWriter;
	private int index = 0;

	private JSONObject getJsonObject() {
		try {
			File dataFile = new File(filePath);
			fileReader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(fileReader);
			return new JSONObject(tokener);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Vector<Vector<Object>> selectAll() {

		JSONObject jsonObject = getJsonObject();
		JSONArray studentArr = jsonObject.getJSONArray("studentArray");
		Vector<Vector<Object>> studentsInfoList = new Vector<Vector<Object>>();

		for (int i = 0; i < studentArr.length(); i++) {
			JSONObject studentInfo = studentArr.getJSONObject(i);
			Vector<Object> valueOfStudentInfoKeys = new Vector<Object>();
			valueOfStudentInfoKeys.add(studentInfo.get("no"));
			valueOfStudentInfoKeys.add(studentInfo.get("name"));
			valueOfStudentInfoKeys.add(studentInfo.get("phone"));
			valueOfStudentInfoKeys.add(studentInfo.get("email"));
			studentsInfoList.add(valueOfStudentInfoKeys);
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		return studentsInfoList;

	}

	public void insert(Customer customer) {
		
		int idx;
		
			if (getJsonObject() == null) {
				JSONObject jsonObject = new JSONObject();
				idx = 1;
				jsonObject.put("no", idx);
				jsonObject.put("name", customer.getName());
				jsonObject.put("email", customer.getEmail());
				jsonObject.put("phone", customer.getPhone());
				JSONArray studentArr = new JSONArray();
				studentArr.put(jsonObject);
				JSONObject studentJsonFile = new JSONObject();
				studentJsonFile.put("studentArray", studentArr);
				studentJsonFile.put("sequence", ++idx);

				return;
				
			} else {
				JSONObject jsonObject = getJsonObject();
				JSONArray studentArr = jsonObject.getJSONArray("studentArray");
				jsonObject.put("no", getJsonObject().get("sequence"));
				jsonObject.put("name", customer.getName());
				jsonObject.put("email", customer.getEmail());
				jsonObject.put("phone", customer.getPhone());
				studentArr.put(jsonObject);

				JSONObject studentJsonFile = new JSONObject();
				studentJsonFile.put("studentArray", studentArr);
				studentJsonFile.put("sequence", getJsonObject().get("sequence"));
				
				try {
					fileWriter= new FileWriter(filePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					fileWriter.write(studentJsonFile.toString(2));
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		
				if(fileWriter !=null) {
					try {
						fileWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		

	}

}
