package test.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class CopyFileToEnywhere {

	private static final String PATH_FILE_ORI = "C:/Users/user/Desktop/Test.txt";
	private static final String PATH_ROOT_AIM = "C:/Users/user/Desktop/copy_Test.txt";

	public static void main(String[] args) {
		try {
			List<String> readFileContent = readFile(PATH_FILE_ORI);
			writeFile(readFileContent, PATH_ROOT_AIM);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Java IO讀取檔案 (java io read file)
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static List<String> readFile(String fileName) throws IOException {
		List<String> rst = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String in = null;
			while ((in = br.readLine()) != null) {
				rst.add(in);
			}
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			br.close();
		}
		return rst;
	}

	/**
	 * Java IO寫入檔案 (java io write file)
	 * 
	 * @param data
	 * @param fileName
	 * @throws IOException
	 */
	public static void writeFile(List<String> data, String fileName) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		try {
			for (String d : data) {
				bw.write(d);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			bw.close();
		}
	}

	/**
	 * Java IO拷貝檔案 (java io copy file)
	 * 
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	public static void copyFile(File source, File dest) throws IOException {
		InputStream fis = null;
		OutputStream fos = null;
		try {
			fos = new FileOutputStream(dest);
			fis = new FileInputStream(source);
			byte[] b = new byte[1024];
			int off = 0;
			int len = 0;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, off, len);
			}
			fos.flush();
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			fos.close();
			fis.close();
		}
	}
}
