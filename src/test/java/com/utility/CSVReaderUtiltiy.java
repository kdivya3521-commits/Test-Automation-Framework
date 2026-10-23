package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtiltiy {

	public static Iterator<User> readCSVFile(String fileName) {
		File csvFile = new File(System.getProperty("user.dir") + "/testData/" + fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList = null;
		User userData;

		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext(); // get immediate row in string formate - ROW1 we need this as wee need skip this
			// csvReader.readNext(); // ROW2
			// data = csvReader.readNext(); // ROW3 (if there is no row data it will give
			// you null)
			// System.out.println(Arrays.toString(data));

			userList = new ArrayList<User>();
			while ((line = csvReader.readNext()) != null) // Intializing and checking reached end of the file
			{
				userData = new User(line[0], line[1]);
				userList.add(userData);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}

		return userList.iterator();

	}

}
