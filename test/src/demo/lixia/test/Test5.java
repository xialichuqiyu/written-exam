package demo.lixia.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

/**
 * 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
 * @author lixia
 *
 */
public class Test5 {

	public static void main(String[] args) {
		String jsonStr = "[{\"id\": \"1\",\"name\": \"中国\",\"code\": \"110\",\"parent\": \"\"},"
				+ "{\"id\": \"2\",\"name\": \"北京市\",\"code\": \"110000\",\"parent\": \"110\"},"
				+ "{\"id\": \"3\",\"name\": \"河北省\",\"code\": \"130000\",\"parent\": \"110\"},"
				+ "{\"id\": \"4\",\"name\": \"四川省\",\"code\": \"510000\",\"parent\": \"110\"},"
				+ "{\"id\": \"5\",\"name\": \"石家庄市\",\"code\": \"130001\",\"parent\": \"130000\"},"
				+ "{\"id\": \"6\",\"name\": \"唐山市\",\"code\": \"130002\",\"parent\": \"130000\"},"
				+ "{\"id\": \"7\",\"name\": \"邢台市\",\"code\": \"130003\",\"parent\": \"130000\"},"
				+ "{\"id\": \"8\",\"name\": \"成都市\",\"code\": \"510001\",\"parent\": \"510000\"},"
				+ "{\"id\": \"9\",\"name\": \"简阳市\",\"code\": \"510002\",\"parent\": \"510000\"},"
				+ "{\"id\": \"10\",\"name\": \"武侯区\",\"code\": \"51000101\",\"parent\": \"510001\"},"
				+ "{\"id\": \"11\",\"name\": \"金牛区\",\"code\": \"51000102\",\"parent\": \"510001\"}]";
		
		List<AreaPo> jsonList = JSONArray.parseArray(jsonStr, AreaPo.class);
		
		List<AreaPo> treeList = toTree(jsonList);
		System.out.println(treeList);
	}
	
	public static List<AreaPo> toTree(List<AreaPo> areaPos) {
		List<AreaPo> resultAreaPos = new ArrayList<AreaPo>();
		for (AreaPo areaPo : areaPos) {
			if ("".equals(areaPo.getParent()) || areaPo.getParent() == null) {
				resultAreaPos.add(findChildren(areaPo, areaPos));
			}
		}
		return resultAreaPos;
	}
	
	public static AreaPo findChildren(AreaPo parentAreaPo, List<AreaPo> childrenAreaPos) {
		for (AreaPo areaPo : childrenAreaPos) {
			if (parentAreaPo.getCode().equals(areaPo.getParent())) {
				if (parentAreaPo.getChildren() == null) {
					parentAreaPo.setChildren(new ArrayList<>());
				}
				parentAreaPo.getChildren().add(findChildren(areaPo, childrenAreaPos));
			}
		}
		return parentAreaPo;
	}
}
