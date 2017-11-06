package org.fnlp.demo.ml;

import org.fnlp.nlp.cn.CNFactory;

/**
 * Created by 魏伟 on 2017/11/6.
 */
public class mydemo {

    public static void main(String[] args) throws Exception {

        //待处理字符串
        String s = "关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。";

        //分词工厂
        CNFactory factory = CNFactory.getInstance("models/", CNFactory.Models.ALL);

        // 使用分词器对中文句子进行分词，得到分词结果
        String[] words = factory.seg(s);

        //词性标注工厂

        // 使用标注器对中文句子进行标注，得到标注结果
        String[] result = factory.tag(words);
        String str = factory.tag2String(s);


        // 打印分词结果
        for(String word : words)  {
            System.out.print(word + " ");
        }

        System.out.println();
        //打印词性标注结果
     /*   for(String word : result)  {
            System.out.print(word + " ");
        } */
        System.out.print(str);



    }
}
