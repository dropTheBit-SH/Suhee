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
		File dataFile = new File(filePath);
		try {
			fileReader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(fileReader);
			return new JSONObject(tokener);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
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

		File file = new File(filePath);
		int seq = 1;
		if(getJsonObject() == null) {
			JSONObject newObj = new JSONObject();
			newObj.put("no", seq++);
			newObj.put("name", customer.getName());
			newObj.put("email", customer.getEmail());
			newObj.put("phone", customer.getPhone());
			
			JSONArray newArray = new JSONArray();
			newArray.put(newObj);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sequence", seq);
			jsonObject.put("studentArray", newArray);
			
			try {
				fileWriter = new FileWriter(file);
				fileWriter.write(jsonObject.toString(2));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(fileReader != null) fileReader.close();
					if(fileWriter != null) fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			return;
		}
		
		JSONObject jsonObject = getJsonObject();
		JSONArray jsonArray = jsonObject.getJSONArray("studentArray");
		JSONObject obj = new JSONObject();
		seq = jsonObject.getInt("sequence");
		obj.put("no", seq++);
		obj.put("name", customer.getName());
		obj.put("email", customer.getEmail());
		obj.put("phone", customer.getPhone());
		jsonArray.put(obj);
		
		JSONObject newObj = new JSONObject();
		newObj.put("studentArray", jsonArray);
		newObj.put("sequence", seq);
		
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(newObj.toString(2));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileReader != null) fileReader.close();
				if(fileWriter != null) fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
