package com.carol;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * <a href=
 * "https://jsoup.org/apidocs/org/jsoup/Jsoup.html#connect-java.lang.String-">Jsoup��api�ĵ�</a>
 * <p>
 * Jsoup �� һ�� Java��html������ , ����ֱ�ӽ���ĳ��URL��ַ , html�ı����� , ��ͨ������JS�Ĳ�����ʽ��ȥȡ���Ͳ�������.
 * </p>
 * 
 * @author Carol Tang
 * @date 2018��12��13�� ����1:29:23
 * @version v1.0
 * @Description ������ҳ ʹ�� Jsonp
 */
public class GetFilmReviewByJsoup {

	public static void main(String[] args) throws IOException {
		// ����url��ȡ�ͽ���HTMLҳ��
		Document document = Jsoup.connect("http://www.datawh.cn/zhanlang2.html").get();
		// ��ȡ��Ӱ����
		String movieTitle = document.getElementById("movieTitle").text();
		// ��ȡ��Ӱ����
		String rating_num = document.getElementById("rating_num").text();
		System.out.println("movieTitle:" + movieTitle);
		System.out.println("rating_num:" + rating_num);
		// ��ȡ��Ӱ����
		Elements container = document.getElementsByClass("article");
		//parse(String html)HTML����Ϊ�ĵ�
		Document containerDoo = Jsoup.parse(container.toString());
		Element comments = containerDoo.getElementById("comments-section");
		Document commentsDoo = Jsoup.parse(comments.toString());
		Elements itemList = commentsDoo.getElementsByClass("comment-item");

		for (Element item : itemList) {
			Document itemDoo = Jsoup.parse(item.toString());
			// ����Ա
			String discussant = itemDoo.getElementsByClass("comment-info").text();
			// ����ʱ��
			String comment_time = itemDoo.getElementsByClass("comment-time").text();
			// ������Ϣ
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
