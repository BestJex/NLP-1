package org.fnlp.demo;

import static org.junit.Assert.*;

import org.fnlp.demo.ml.HierClassifierUsage1;
import org.fnlp.demo.ml.HierClassifierUsage2;
import org.fnlp.demo.ml.SequenceLabeling;
import org.fnlp.demo.ml.SimpleClassifier2;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.fnlp.nlp.cn.CNFactory;

public class MLTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() throws Exception {
		
		SequenceLabeling.main(null);
		SimpleClassifier2.main(null);
		HierClassifierUsage1.main(null);
		HierClassifierUsage2.main(null);
		
	}

	@Test
	public void test1() throws Exception {
		CNFactory factory = CNFactory.getInstance("../models/", CNFactory.Models.SEG);
		// 使用分词器对中文句子进行分词，得到分词结果
		String[] words = factory.seg("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");
		// 打印分词结果
		for(String word : words) {
			System.out.print(word + " ");
		}
		System.out.println();

	}

}
