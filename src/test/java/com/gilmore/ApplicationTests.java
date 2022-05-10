package com.gilmore;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

	@Test
	void testCsvParse() throws Exception {
		//Test that we've set up the gradle project properly and can use the CSV library
		File testCSVFile = new ClassPathResource("test.csv").getFile();
		Reader in = new FileReader(testCSVFile);
		int totalRecords = 0;
		CSVFormat format = CSVFormat.DEFAULT.builder()
				.setHeader("GPA","Gender","breakfast","coffee","exercise","drink","comfort_food","sports","weight")
				.setSkipHeaderRecord(true)
				.build();
		for (CSVRecord record : format.parse(in)) {
			String gpa = record.get("GPA");
			totalRecords++;
		}
		Assertions.assertEquals(124, totalRecords);
	}

	@Test
	void testJsonParse() throws Exception {
		//Test that we've set up the gradle project properly and can use the Jackson library
		File testJSONFile = new ClassPathResource("test.json").getFile();
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> data = mapper.readValue(testJSONFile, new TypeReference<List<Map<String, Object>>>(){});
		Assertions.assertEquals(3, data.size());
		Assertions.assertEquals("3.654", data.get(1).get("GPA"));
		Assertions.assertEquals("1", data.get(1).get("Gender"));
		Assertions.assertEquals("1", data.get(1).get("breakfast"));
		Assertions.assertEquals("2", data.get(1).get("coffee"));
		Assertions.assertEquals("1", data.get(1).get("exercise"));
		Assertions.assertEquals("2", data.get(1).get("drink"));
		Assertions.assertEquals("chocolate, chips, ice cream", data.get(1).get("comfort_food"));
		Assertions.assertEquals("1", data.get(1).get("sports"));
		Assertions.assertEquals("155", data.get(1).get("weight"));
	}


}
