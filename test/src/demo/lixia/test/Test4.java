package demo.lixia.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;

/**
 * 对下面的 json 字符串 serial 相同的进行去重。
 * @author lixia
 *
 */
public class Test4 {

	public static void main(String[] args) {
		String jsonString = "[{\"name\": \"张三\",\"serial\": \"0001\"},"
				+ "{\"name\": \"李四\",\"serial\": \"0002\"},"
				+ "{\"name\": \"王五\",\"serial\": \"0003\"},"
				+ "{\"name\": \"王五2\",\"serial\": \"0003\"},"
				+ "{\"name\": \"赵四\",\"serial\": \"0004\"},"
				+ "{\"name\": \"小明\",\"serial\": \"005\"},"
				+ "{\"name\": \"小张\",\"serial\": \"006\"},"
				+ "{\"name\": \"小李\",\"serial\": \"006\"},"
				+ "{\"name\": \"小李2\",\"serial\": \"006\"},"
				+ "{\"name\": \"赵四2\",\"serial\": \"0004\"}]";
		
		List<HumanPo> jsonList = JSONArray.parseArray(jsonString, HumanPo.class);

		// 将数组放到set中去重，重写humanpo的equals和hashcode方法
		Set<HumanPo> jsonSet = new HashSet<>(jsonList);
		
		String resultJsonStr = jsonSet.toString();
		System.out.println(resultJsonStr);
	}

}

