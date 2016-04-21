package com.cetrinw.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装对文件操作工具类
 * @author Cetrin Wang
 *
 */
public class FileUtil {
	
	/**
	 * 将List -> file
	 * 
	 * @param list
	 * @param filePath
	 */
	public static void write2Txt(List<String> list, String filePath) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(filePath);
			for (String strs : list) {
				writer.write(strs);
				writer.write("\r\n");
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将List[] -> file
	 *
	 * @param list
	 * @param filePath
	 */
	public static void write2TxtNew(List<String[]> list, String filePath) {

		FileWriter writer = null;
		try {
			writer = new FileWriter(filePath);
			for (String[] strs : list) {
				for (String str : strs){
					writer.write(str+"\t");
				}

				writer.write("\r\n");
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将String -> file
	 *
	 * @param str String字符串
	 * @param filePath
	 */
	public static void write2Txt(String str, String filePath) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(filePath);
				writer.write(str);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * reader text content
	 */
	 public static List<Object> readTransData(String... filenames) {
		 List<Object> list = new ArrayList<Object>();
	      
	        // 从文件读入
	        if (filenames.length > 0) {
	            for (String filename : filenames) {
	                try {
	                   // FileReader fr = new FileReader(new File(filename));
	                	InputStreamReader fr=new InputStreamReader(new FileInputStream(filename),"UTF-8");
	                    BufferedReader br = new BufferedReader(fr);
	                    String line = null;
	                    while ((line = br.readLine()) != null) {
	                        list.add(line);
	                    }
	                } catch (IOException e) {
	                    System.out.println("读取事务数据库失败。");
	                    System.exit(-2);
	                }
	            }
	        }
			return list;
	}
	
	/**
	 * Delete file
	 * @param sPath
	 */
	public static void deleteFile(String sPath) {
		File file = new File(sPath);

		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

	/**
	 * Delete file
	 * @param filePaths 文件路径
	 */
	public static void deleteFiles(String[] filePaths) {
		for (String filePath : filePaths) {
			File file = new File(filePath);

			if (file.isFile() && file.exists()) {
				file.delete();
			}
		}
	}
}
