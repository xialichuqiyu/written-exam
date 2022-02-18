package demo.lixia.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。
 * 例如，命令 expr 2 3 4 + *
 * @author lixia
 *
 */
public class Test2 {

	public static void main(String[] args) {
		int result = expr();
		System.out.println("计算结果为：" + result);
	}
	
	public static int expr() {
		// 栈存放表达式中的数字
		Stack<String> numStack = new Stack<>();
		
		// 将获取的输入转换为数组
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		List<String> inputStr = Arrays.asList(input.split(" "));
		
		for (String str : inputStr) {
			if (str.matches("\\d+")) {
				// 数字
				numStack.push(str);
			} else {
				// 运算符，取出栈顶前俩元素进行计算
				int temp1 = Integer.parseInt(numStack.pop());
				int temp2 = Integer.parseInt(numStack.pop());
				int resultTemp = 0;
				switch (str) {
				case "+":
					resultTemp = temp1 + temp2;
					break;
				case "-":
					resultTemp = temp1 - temp2;
					break;
				case "*":
					resultTemp = temp1 * temp2;
					break;
				case "/":
					resultTemp = temp1 / temp2;
					break;
				default:
					throw new RuntimeException("未知的运算符");
				}
				// 计算结果入栈
				numStack.push(String.valueOf(resultTemp));
			}
		}
		
		return Integer.valueOf(numStack.pop());
	}
}
