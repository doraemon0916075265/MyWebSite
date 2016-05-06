package test.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		long startTime = new Date().getTime();
		
		//doSomeThing();
		executionTime(startTime);
	}

	private static void doSomeThing() {
		try {
			String line = "";
			FileReader fr = new FileReader(READ_TEXT);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				//CopyFileToEnywhere(ROOT_ORI_PATH + line, findDESKTOP(ROOTPATH));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void CopyFileToEnywhere(String string, String findDESKTOP) {

	}

	private static String findDESKTOP(String rootPath) {
		// 抓桌面位置
		String desktop = "";
		return desktop;
	}

	private static void findFile(File rootPathFile, BufferedWriter br) {
		if (rootPathFile.exists()) {
			if (rootPathFile.isFile()) {
				// 檔案
			} else if (rootPathFile.isDirectory()) {
				// 資料夾
			} else {

			}
		} else {

		}
	}

	private static void executionTime(long startTime) {
		// 顯示執行時間
		System.out.println(WORD_EXECUTIONTIME + (new Date().getTime() - startTime) + WORD_MILLISECONDS);
	}

	private static final String WORD_EXECUTIONTIME = "執行時間：";
	private static final String WORD_MILLISECONDS = "毫秒";
	private static final String READ_TEXT = "毫秒";
	private static final String ROOT_ORI_PATH = "毫秒";
	private static final String ROOT_ORI_PATH1 = "毫秒";
	
}
