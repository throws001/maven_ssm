package com.itheima.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class TestPoi {
    @Test
    public void show() throws IOException {
        //创建工作薄
        XSSFWorkbook WK = new XSSFWorkbook("C:\\Users\\86176\\Desktop\\资料\\read.xlsx");
        //获取工作表
        Sheet sht = WK.getSheetAt(0);
        //遍历行对象获取单元格
        for (Row cells : sht) {
            for (Cell cell : cells) {
                int cellType = cell.getCellType();
                if (cellType==Cell.CELL_TYPE_NUMERIC){
                    System.out.print(cell.getNumericCellValue());
                }else {
                    System.out.print(cell.getStringCellValue());
                }
                System.out.print(",");
            }
            System.out.println("");
        }
        //关流
        WK.close();
    }

}
