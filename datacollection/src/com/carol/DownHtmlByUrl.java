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
 * @date 2018��12��6�� ����11:42:16 
 * @version v1.0
 * @Description ʹ��url��ʽ��ȡ��ҳ��Ϣ
 */
public class DownHtmlByUrl {
	/**
	 * ʹ��URL���openConnection()������ȡ��ҳ����
	 * @param address ��ҳ��ַ
	 * @param encoding ����
	 * @return ��ҳ����
	 */
	public static String downHtmlByUrl(String address,String encoding) {
		StringBuffer sb = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			//������������
			URL url = new URL(address);
			//����������
			URLConnection uc = url.openConnection();
			//��ȡ��ҳ������
			InputStream inputStream = uc.getInputStream();
			//ʹ�û���BufferedReader��װInputStreamReader����߶�ȡЧ��
			isr = new InputStreamReader(inputStream,encoding);
			br = new BufferedReader(isr);
			String line;
		    sb = new StringBuffer();
			//ѭ����ȡÿһ���ı�
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
			//�ر���
			if (isr!=null) {
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				isr = null;//GC���Ȼ���	
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
	 * ʹ��ʹ��URL���openStream()������ȡ��ҳ����
	 * @param address ��ҳ��ַ
	 * @param encoding ����
	 * @return ��ҳ����
	 */
	public static String downHtmlByStream(String address,String encoding) {
		StringBuffer sb = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			//������������
			URL url = new URL(address);
			//��ָ����URL�������Ӳ�����InputStream��Ķ����Դ���һ�����ж�ȡ���ݣ�
			//�ײ�Դ�룺 return openConnection().getInputStream();
			//openStream()����ֻ�ܶ�ȡ������Դ��
			InputStream inputStream = url.openStream();
			
			//ʹ�û���BufferedReader��װInputStreamReader����߶�ȡЧ��
			isr = new InputStreamReader(inputStream,encoding);
			br = new BufferedReader(isr);
			String line;
		    sb = new StringBuffer();
			//ѭ����ȡÿһ���ı�
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
			//�ر���
			if (isr!=null) {
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				isr = null;//GC���Ȼ���	
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
		String address = "http://www.datawh.cn/zhanlang2.html";//��ҳ��ַ
		String encoding = "utf-8";//���뼯
		downHtmlByUrl(address, encoding);
		//downHtmlByStream(address, encoding);
	}
}
