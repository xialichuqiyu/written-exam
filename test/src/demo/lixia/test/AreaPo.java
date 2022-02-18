package demo.lixia.test;

import java.util.List;

/**
 * 题5的po类
 * @author 夏笠
 *
 */
public class AreaPo {

	private String id;
	private String name;
	private String code;
	private String parent;
	private List<AreaPo> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public List<AreaPo> getChildren() {
		return children;
	}
	public void setChildren(List<AreaPo> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "AreaPo [id=" + id + ", name=" + name + ", code=" + code + ", parent=" + parent + ", children="
				+ children + "]";
	}
	
}
