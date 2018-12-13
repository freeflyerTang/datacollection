package com.carol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author Carol Tang
 * @date 2018年12月6日 上午11:42:16 
 * @version v1.0
 * @Description 使用url方式获取网页信息
 */
public class DownHtmlByUrl {
	/**
	 * 使用URL类的openConnection()方法获取网页内容
	 * @param address 网页地址
	 * @param encoding 编码
	 * @return 网页内容
	 */
	public static String downHtmlByUrl(String address,String encoding) {
		StringBuffer sb = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			//建立网络链接
			URL url = new URL(address);
			//打开网络链接
			URLConnection uc = url.openConnection();
			//获取网页输入流
			InputStream inputStream = uc.getInputStream();
			//使用缓冲BufferedReader包装InputStreamReader，提高读取效率
			isr = new InputStreamReader(inputStream,encoding);
			br = new BufferedReader(isr);
			String line;
		    sb = new StringBuffer();
			//循环读取每一行文本
			while((line=br.readLine())!=null) {
				sb.append(line+"\n");
			}
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭流
			if (isr!=null) {
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				isr = null;//GC优先回收	
			}
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				br = null;
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * 使用使用URL类的openStream()方法获取网页内容
	 * @param address 网页地址
	 * @param encoding 编码
	 * @return 网页内容
	 */
	public static String downHtmlByStream(String address,String encoding) {
		StringBuffer sb = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			//建立网络链接
			URL url = new URL(address);
			//与指定的URL建立连接并返回InputStream类的对象，以从这一连接中读取数据；
			//底层源码： return openConnection().getInputStream();
			//openStream()方法只能读取网络资源。
			InputStream inputStream = url.openStream();
			
			//使用缓冲BufferedReader包装InputStreamReader，提高读取效率
			isr = new InputStreamReader(inputStream,encoding);
			br = new BufferedReader(isr);
			String line;
		    sb = new StringBuffer();
			//循环读取每一行文本
			while((line=br.readLine())!=null) {
				sb.append(line+"\n");
			}
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭流
			if (isr!=null) {
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				isr = null;//GC优先回收	
			}
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				br = null;
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String address = "http://www.datawh.cn/zhanlang2.html";//网页地址
		String encoding = "utf-8";//编码集
		downHtmlByUrl(address, encoding);
		//downHtmlByStream(address, encoding);
	}
}
