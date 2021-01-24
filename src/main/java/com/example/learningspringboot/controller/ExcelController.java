package com.example.learningspringboot.controller;

import org.json.simple.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/excel")

public class ExcelController {
  @PostMapping("/import")
  public String excelToJSON(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
    XSSFSheet worksheet = workbook.getSheetAt(0);
    int numberOfRows = worksheet.getPhysicalNumberOfRows();
    JSONObject jsonObject = new JSONObject();
    for(int i = 1; i < numberOfRows; i++) {
      XSSFRow row = worksheet.getRow(i);
      jsonObject.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
    }
    return jsonObject.toJSONString();
  }
}
