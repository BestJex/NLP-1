package org.fnlp.demo.ml;

import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.nlp.corpus.StopWords;
import org.fnlp.ml.types.Dictionary;

import java.util.List;

/**
 * Created by 魏伟 on 2017/11/6.
 */
public class excute {

    public static void main(String[] args) throws Exception {

        //待处理字符串
        String s = "微博上有两种比较明显的状态，一种是转发，让你为他人而分享，一种是原创，思想的释放。评论只是针对不适合扩散的内容。最深邃的莫过于点赞了，现在对它的看法有所改变，如果权重能像知乎里那样的话，相信微博质量会继续提高。";

        //特征提取
        //分词工厂
        CNFactory factory = CNFactory.getInstance("models/", CNFactory.Models.ALL);

        // 使用分词器对中文句子进行分词，得到分词结果
        String[] words = factory.seg(s);
        // 打印分词结果
        for(String word : words)  {
            System.out.print(word + " ");
        }
        System.out.println();

        StopWords stopWords = new StopWords("models/stopwords/StopWords.txt");
        // 对分词的结果去除停用词
        List<String> baseWords = stopWords.phraseDel(words);

        for(String word : baseWords)  {
            System.out.print(word + " ");
        }
        System.out.println();
        // 评论长度,其中包含的停用词和标点符号
        int length = words.length;
        System.out.println("未消除停用词之前length:"+length);
      //  System.out.println("消除停用词之后length:"+baseWords.size());

        //词性标注工厂

        // 使用标注器对中文句子进行标注，得到标注结果
        String[] result1 = factory.tag(words);

        String[] result = factory.tag(List2Arry(baseWords));


        for(String word : result)  {
            System.out.print(word + " ");
        }
        System.out.println();

    }
    public static String [] List2Arry(List <String> a){
        String [] b = new String[a.size()];
        for(int i=0;i<a.size();i++){
            b[i]=a.get(i);
        }
        return b;
    }

}
