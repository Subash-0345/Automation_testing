package com.KDF.core;

import java.lang.reflect.Method;

import com.KDF.keywords.actionsKeyword;
import com.KDF.utillities.excelUtils;

public class Engine {

	actionsKeyword keyword;
	Method[] methods;
	static String keyWords;

	public Engine() {

		keyword = new actionsKeyword();
		methods = keyword.getClass().getMethods();
	}

	public void excuteKeyWords() throws Exception {
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equalsIgnoreCase(keyWords)) {
				methods[i].invoke(keyword);
				System.out.println("The (" + methods[i].getName() + ") method running successfully");
				break;
			}

		}
	}

	public static void main(String[] args) throws Exception {
		excelUtils obj = new excelUtils();
		obj.readFile("/home/mitrah182/eclipse-workspace/keyword-driven-frameworks/src/test/resources/three.xls");
		Engine engine = new Engine();
		int locatorCol = 3;
		int keyWordCol = locatorCol + 1;
		int dataCol = locatorCol + 2;

		for (int row = 1; row <= excelUtils.lastRowVal; row++) {
//			keyWords = obj.getLocKeyAndData(row, locatorCol,keyWordCol,dataCol); 
			obj.getLocKeyAndData(row, locatorCol, keyWordCol, dataCol);
			engine.excuteKeyWords();
		}

	}

}