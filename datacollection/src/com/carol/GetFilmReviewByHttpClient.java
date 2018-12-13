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
 * �������������Ŀ��ٷ�չ,��Ӱҵ��չ����һ���µĸ߶� ,�����ڿ���Ӱ֮ǰ���ע��Ӱ���� , ��Ӱ�ۺ�Ҳ��Ե�Ӱ���� ��
 * </p>
 * <a href="http://www.datawh.cn">���ŵ�Ӱ��վ(http://www.datawh.cn)����һ���ռ���Ӱ���۵���վ
 * ��</a>
 * <p>
 * ����ĳӰ�ӹ�˾Ϊ��ӭ��Ӱ��ƫ��,��Ҫ�ɼ�����վ��Ӱ����������,���ڷ�������Ӱ�Եİ��á�
 * </p>
 * <a href="http://hc.apache.org/downloads.cgi">Դ�����ص�ַ</a> <a
 * href="https://mvnrepository.com/artifact/org.apache.httpcomponents>jar�����ص�ַ</a>
 * 
 * @author Carol Tang
 * @date 2018��12��12�� ����12:43:02
 * @version v1.0
 * @Description ��ȡ��Ӱ����
 */
public class GetFilmReviewByHttpClient {

	public static void main(String[] args) throws Exception {
		// ץȡ��ҳԴ���� ʹ�� HttpClient
		// HttpClient ���������ṩ��Ч�ġ����µġ����ܷḻ��֧�� HTTP Э��Ŀͻ��˱�̹��߰���������֧�� HTTP Э�����µİ汾�ͽ��顣
		// 1.�����ͻ���
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 2.ʹ��get��ʽ��������
		HttpGet httpGet = new HttpGet("http://www.datawh.cn/zhanlang2.html");
		// 3.ִ������
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		try {
			// �鿴��Ӧ״̬
			int statusCode = response1.getStatusLine().getStatusCode();
			// System.out.println(statusCode);
			if (statusCode == 200) {
				// 4.�鿴���ص���Ӧ����
				HttpEntity entity1 = response1.getEntity();
				String content = EntityUtils.toString(entity1, "utf-8");
				System.out.println(content);
			} else {
				System.out.println("����ʧ��");
			}

		} finally {
			// 5.�ͷ���Դ
			response1.close();
		}

	}

}
