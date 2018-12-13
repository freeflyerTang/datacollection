package com.carol;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * <p>
 * 背景：互联网的快速发展,电影业发展到了一个新的高度 ,人们在看电影之前会关注电影评价 , 电影观后也会对电影评价 。
 * </p>
 * <a href="http://www.datawh.cn">热门电影网站(http://www.datawh.cn)就是一个收集电影评价的网站
 * 。</a>
 * <p>
 * 需求：某影视公司为了迎合影迷偏好,需要采集该网站的影视评价数据,便于分析大众影迷的爱好。
 * </p>
 * <a href="http://hc.apache.org/downloads.cgi">源码下载地址</a> <a
 * href="https://mvnrepository.com/artifact/org.apache.httpcomponents>jar包下载地址</a>
 * 
 * @author Carol Tang
 * @date 2018年12月12日 下午12:43:02
 * @version v1.0
 * @Description 获取电影评论
 */
public class GetFilmReviewByHttpClient {

	public static void main(String[] args) throws Exception {
		// 抓取网页源代码 使用 HttpClient
		// HttpClient 可以用来提供高效的、最新的、功能丰富的支持 HTTP 协议的客户端编程工具包，并且它支持 HTTP 协议最新的版本和建议。
		// 1.创建客户端
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 2.使用get方式创建请求
		HttpGet httpGet = new HttpGet("http://www.datawh.cn/zhanlang2.html");
		// 3.执行请求
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		try {
			// 查看响应状态
			int statusCode = response1.getStatusLine().getStatusCode();
			// System.out.println(statusCode);
			if (statusCode == 200) {
				// 4.查看返回的响应内容
				HttpEntity entity1 = response1.getEntity();
				String content = EntityUtils.toString(entity1, "utf-8");
				System.out.println(content);
			} else {
				System.out.println("调用失败");
			}

		} finally {
			// 5.释放资源
			response1.close();
		}

	}

}
