package cn.chineseall.utils.dams;


import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 加解密工具类
 * 
 * @author luoxl
 *
 */
public class SecurityUtils {
	private static final String DEFAULT_ALGORITHM="DSA";
	private static final String RAND_SEED="cri.dams.chineseall";
	private static final String CHARSET = "UTF-8";
	
	//测试使用公钥
	private static String tmpPubKeyStr = "MIIBuDCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYUAAoGBAKBxjk1kHqhX1DewGse5H/CRDHQu7b43x7MkRd7MNsCjcQax/NKP7kR6UUq7AZyWpSYWHjpX3vAh2/PCDrvrY/M4VZs60ht8Ee0cdfepxN1pAhjDi6lfIUR/cxSyEQlpSNe99oDLiZeFrroKhNdKp9VBsCvmEOWeFPILbCMnkSwo";
	//测试使用私钥
	private static String tmpPriKeyStr = "MIIBSwIBADCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoEFgIULJH4eClmLLjOnjORQwatSeA0otA=";
	
	private static final int keySize = 1024;
	/**
	 * 生成DSA签名的密钥对
	 * @throws Exception
	 */
	private static void generateKeyPair() throws Exception {
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance(DEFAULT_ALGORITHM);
		SecureRandom secRandom = new SecureRandom();
		secRandom.setSeed(RAND_SEED.getBytes());
		kpGen.initialize(keySize, secRandom);
		KeyPair kp = kpGen.generateKeyPair();
		PublicKey publicKey = kp.getPublic();
		PrivateKey privateKey = kp.getPrivate();
		String publicKeyStr = StringUtils.encodeBASE64(publicKey.getEncoded(), CHARSET);
		String privateKeyStr = StringUtils.encodeBASE64(privateKey.getEncoded(), CHARSET);
		System.out.println("public key is:  " + publicKeyStr);
		System.out.println("private key is: " + privateKeyStr);
	}
	
	/**
	 * 将字符串进行签名，并将签名结果转换成BASE64编码的字符串，再做URLEncode
	 * 
	 * @param source
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	public static String signAndURLEncode(String source, String privateKeyStr) throws Exception {
		String signRet = sign(source, privateKeyStr);
		return URLEncoder.encode(signRet, CHARSET);
	}
	/**
	 * 将字符串进行签名，并将签名结果转换成BASE64编码的字符串
	 * 
	 * @param source
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	public static String sign(String source, String privateKeyStr) throws Exception {
		byte[] data = source.getBytes(CHARSET);
		byte[] bytes = sign(data, privateKeyStr);
		return StringUtils.encodeBASE64(bytes, CHARSET);
	}
	
	/**
	 * 对数据进行签名
	 * @param data
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] sign(byte[] data, String privateKeyStr) throws Exception {
		Signature signature = Signature.getInstance(DEFAULT_ALGORITHM);
		signature.initSign(getPrivateKeyFromPKC8(privateKeyStr));
		signature.update(data);
		return signature.sign();
	}
	
	
	/**
	 * 将结果进行URLDecode之后再进行验签
	 * @param source
	 * @param sign
	 * @param publicKeyStr
	 * @return
	 * @throws Exception
	 */
	public static boolean verifyAndURLDecode(String source, String sign, String publicKeyStr) throws Exception{
		String signRet = URLDecoder.decode(sign, CHARSET);
		return verify(source, signRet, publicKeyStr);
	}
	
	/**
	 * 验签结果
	 * 
	 * @param source
	 * @param sign
	 * @param publicKeyStr
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(String source, String sign, String publicKeyStr) throws Exception {
		byte[] data = source.getBytes(CHARSET);
		byte[] bytes = StringUtils.decodeBASE64(sign, CHARSET);
		return verify(data, bytes, publicKeyStr);
	}
	
	/**
	 * 验签是否正确
	 * @param data 待验证数据
	 * @param bytes 签名的结果
	 * @param publicKeyStr
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(byte[] data, byte[] bytes, String publicKeyStr) throws Exception {
		Signature signature = Signature.getInstance(DEFAULT_ALGORITHM);
		signature.initVerify(getPublicKeyFromX509(publicKeyStr));
		signature.update(data);
		return signature.verify(bytes);
	}
	
	
	/**
	 * 将BASE64字符串格式的公钥转换成公钥对象
	 * @param base64Str
	 * @return
	 * @throws Exception
	 */
	private static PublicKey getPublicKeyFromX509(String base64Str) throws Exception {
		byte[] data = StringUtils.decodeBASE64(base64Str, CHARSET);
		X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(data);
		return getDefaultKeyFactory().generatePublic(pubX509);
	}
	
	/**
	 * 将BASE64字符串格式的私钥转换成私钥对象
	 * @param base64Str
	 * @return
	 * @throws Exception
	 */
	private static PrivateKey getPrivateKeyFromPKC8(String base64Str) throws Exception {
		byte[] data = StringUtils.decodeBASE64(base64Str, CHARSET);
		PKCS8EncodedKeySpec pkcs8 = new PKCS8EncodedKeySpec(data);
		return getDefaultKeyFactory().generatePrivate(pkcs8);
	}
	
	private static KeyFactory getDefaultKeyFactory() throws Exception{
		return KeyFactory.getInstance(DEFAULT_ALGORITHM);
	}
	
	public static void main(String[] args) throws Exception {
		//生成公私钥对
//		generateKeyPair();
		//待签名字符串
		String s = "bookid=123456";
		String mac = "dams.and.17k.interface";
		
		String source = s + mac;
		String signResult = signAndURLEncode(source, tmpPriKeyStr);
		System.out.println("对原签名的结果为: " + signResult);

		boolean b = verifyAndURLDecode(source, signResult, tmpPubKeyStr);
		System.out.println("对签名的验证结果为: " + b);
	}
}
