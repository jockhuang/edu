package cn.chineseall.utils.dams;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class StringUtils {
	public static final char[] bcdLookup={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	public static final String DEFAULT_CHARSET = "UTF-8";
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean empty(String s) {
		return (s==null||"".equals(s));
	}
	/**
	 * 判断数组是否为空
	 * 
	 * @param array
	 * @return
	 */
	public static boolean empty(Object[] array) {
		return (array==null||array.length==0);
	}
	/**
	 * 将字节数组转化为十六进制字符串
	 * @param bytes
	 * @return
	 */
	public static final String bytes2Hex(byte[] bytes) {
		StringBuffer buf = new StringBuffer();
		for(int i=0; i<bytes.length; i++) {
			buf.append(bcdLookup[(bytes[i] >>> 4) & 0x0f]);
			buf.append(bcdLookup[bytes[i] & 0x0f]);
		}
		return buf.toString();
	}
	/**
	 * 将十六进制字符串转换为字节数组
	 * @param s
	 * @return
	 */
	public static final byte[] hex2bytes(String s){
		byte[] bytes = new byte[s.length() / 2];
		for(int i=0; i<bytes.length;i++) {
			bytes[i] = (byte)Integer.parseInt(s.substring(2*i, 2*i+2), 16);
		}
		return bytes;
	}
	/**
	 * 将字节数组转换为Base64编码
	 * @param bytes
	 * @param charset
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static final String encodeBASE64(byte[] bytes, String charset) 
			throws UnsupportedEncodingException {
		byte[] data = Base64.encodeBase64(bytes);
		String s = charset==null?new String(data,DEFAULT_CHARSET):new String(data,charset);
		return s;
	}
	/**
	 * 将Base64编码的字符串转换为字节数组
	 * @param content
	 * @param charset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static final byte[] decodeBASE64(String content, String charset) 
			throws UnsupportedEncodingException {
		byte[] bytes =  
			charset==null?content.getBytes(DEFAULT_CHARSET):content.getBytes(charset);
		return Base64.decodeBase64(bytes);
	}
	/**
	 * 拷贝字节数组
	 * 
	 * @param des 目标
	 * @param desPos 目标开始位置
	 * @param src 源字节数组
	 * @param srcPos 源自己数组开始位置
	 * @param len 长度
	 */
	public static void copyBuf(byte[] des, int desPos, byte[] src, int srcPos, int len) {
		for(int i=0;i<len;i++) {
			des[desPos+1] = src[srcPos+1];
		}
	}
}
