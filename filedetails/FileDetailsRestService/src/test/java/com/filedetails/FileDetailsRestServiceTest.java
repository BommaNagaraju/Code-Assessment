package com.filedetails;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.filedetails.controller.FileDetailsController;

/**
 * Test
 * @author BommaNagaraju
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = FileDetailsController.class)
public class FileDetailsRestServiceTest {

	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	public void fileDetailsTest() throws Exception {
		String path = "C:\\MyDocs\\samples";
		String url = "/FileDetails/listFilesAndDirectories?filePath="+path;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
		
		mockMvc.perform(requestBuilder)
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn();
	}

	
	@Test
	public void fileDetailsExceptiontest() throws Exception {
		String path = "C:\\MyDocs\\ path does not exists";
		String url = "/FileDetails/listFilesAndDirectories?filePath="+path;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
		MvcResult mvcResult =mockMvc.perform(requestBuilder)
		.andDo(print())
		.andReturn();
		System.out.println("response is::"+mvcResult.getResponse().getContentAsString());
		assertTrue(mvcResult.getResponse().getContentAsString().contains("errorType"));
	}
	
	@Test
	public void fileDescriptionTest() throws Exception {
		String filePath = "C:\\MyDocs\\sampes\\05_11_Core_Java\\SRS_AyushGoyal.doc";
		String url = "/FileDetails/listFileProperties?filePath="+filePath;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
		
		mockMvc.perform(requestBuilder)
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn();
	}
	
	@Test
	public void fileDescriptionExceptiontest() throws Exception {
		String path = "C:\\MyDocs\\ path does not exists";
		String url = "/FileDetails/listFileProperties?filePath="+path;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
		MvcResult mvcResult =mockMvc.perform(requestBuilder)
		.andDo(print())
		.andReturn();
		System.out.println("response is::"+mvcResult.getResponse().getContentAsString());
		assertTrue(mvcResult.getResponse().getContentAsString().contains("errorType"));
	}
}
