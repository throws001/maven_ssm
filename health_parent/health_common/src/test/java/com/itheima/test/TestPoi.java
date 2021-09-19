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
        XSSFWorkbook WK = new XSSFWorkbook("C:\\Users\\86176\\Desktop\\资料");
        //获取工作表
        Sheet sht = WK.getSheetAt(0);

        for (Row cells : sht) { //遍历行对象获取单元格
            for (Cell cell : cells) {
                int cellType = cell.getCellType();
                if (cellType==Cell.CELL_TYPE_NUMERIC){
                    System.out.println(cell.getNumericCellValue());
                }else {
                    System.out.println(cell.getStringCellValue());
                } System.out.println(",");
                System.out.println();
            }
        }

        //获取单元格的类型
        //不同类型读取
    }

}
