package com.carol;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * <a href=
 * "https://jsoup.org/apidocs/org/jsoup/Jsoup.html#connect-java.lang.String-">Jsoup的api文档</a>
 * <p>
 * Jsoup 是 一款 Java的html解析器 , 可以直接解析某个URL地址 , html文本内容 , 可通过类似JS的操作方式来去取出和操作数据.
 * </p>
 * 
 * @author Carol Tang
 * @date 2018年12月13日 下午1:29:23
 * @version v1.0
 * @Description 解析网页 使用 Jsonp
 */
public class GetFilmReviewByJsoup {

	public static void main(String[] args) throws IOException {
		// 根据url获取和解析HTML页面
		Document document = Jsoup.connect("http://www.datawh.cn/zhanlang2.html").get();
		// 获取电影名称
		String movieTitle = document.getElementById("movieTitle").text();
		// 获取电影评分
		String rating_num = document.getElementById("rating_num").text();
		System.out.println("movieTitle:" + movieTitle);
		System.out.println("rating_num:" + rating_num);
		// 获取电影评价
		Elements container = document.getElementsByClass("article");
		//parse(String html)HTML解析为文档
		Document containerDoo = Jsoup.parse(container.toString());
		Element comments = containerDoo.getElementById("comments-section");
		Document commentsDoo = Jsoup.parse(comments.toString());
		Elements itemList = commentsDoo.getElementsByClass("comment-item");

		for (Element item : itemList) {
			Document itemDoo = Jsoup.parse(item.toString());
			// 评论员
			String discussant = itemDoo.getElementsByClass("comment-info").text();
			// 评论时间
			String comment_time = itemDoo.getElementsByClass("comment-time").text();
			// 评论信息
			String comment_content = itemDoo.getElementsByTag("p").html();
			System.out.println("============================================================");
			System.out.println("discussant:" + discussant);
			System.out.println("comment-time:" + comment_time);
			System.out.println("comment-content:" + comment_content);
			System.out.println("============================================================");
			System.out.println();
		}
	}
}
