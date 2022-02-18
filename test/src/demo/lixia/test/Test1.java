package demo.lixia.test;

/**
 * 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
 * @author lixia
 *
 */
public class Test1 {

	public static void main(String[] args) {
		String s = "abcd";
		String reverseString = reverse(s);
		System.out.println(reverseString);
	}
	
	public static String reverse(String s) {
		// 单字或空串直接返回
	    if (s == null || s == "" || s.length() <= 1) {
	      return s;
	    }
	    int length = s.length();
	    // 递归逆转字符
	    return s.charAt(length -1) + reverse(s.substring(0,length-1));	 
	}
}
