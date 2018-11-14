package com.sxb.demo.lucene;

import com.sxb.demo.entity.Article;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.surround.parser.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张元亮 on 2018/11/2.
 * 搜索索引库
 */
public class Searcher {

    public static void main(String[] args) throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException {
        // 搜索条件(不区分大小写)
        String queryString = "lucene";
        // 索引库目录
        Directory directory = FSDirectory.open(new File("./indexDir/"));
        Analyzer analyzer = new StandardAnalyzer();

        // 1、把查询字符串转为查询对象(存储的都是二进制文件，普通的String肯定无法查询，因此需要转换)
        // 只在标题里面查询
        QueryParser queryParser = new QueryParser("title",analyzer);
        Query query = queryParser.parse(queryString);

        // 2、查询得到中间结果
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        // 根据指定查询条件，只返回前n条结果
        TopDocs topDocs = indexSearcher.search(query, 100);
        // 总结果数
        int count = topDocs.totalHits;
        // 按照得分进行排序后的前n条结果的信息
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        List<Article> articleList = new ArrayList<Article>();

        for (ScoreDoc scoreDoc : scoreDocs) {
            // 相关度得分
            float score = scoreDoc.score;
            // Document在数据库的内部编号(是唯一的，由lucene自动生成)
            int docId = scoreDoc.doc;
            // 根据编号取出真正的Document数据
            Document doc = indexSearcher.doc(docId);

            // 把Document转换成Article
            Article article = new Article(Integer.parseInt(doc.getField("id").stringValue()),
                    doc.getField("title").stringValue(),
                    null,
                    doc.getField("author").stringValue());

            articleList.add(article);
        }

        // 显示结果
        System.out.print("显示结果总数为: " +articleList.size());

        for (Article article : articleList) {
            System.out.println("id: " +article.getId());
            System.out.println("title: " +article.getTitle());
            System.out.println("author: " +article.getAuthor());
        }

    }
}
