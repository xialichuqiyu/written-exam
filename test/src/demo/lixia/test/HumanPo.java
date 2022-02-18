package demo.lixia.test;

/**
 * 题4中的po类
 * @author lixia
 *
 */
public class HumanPo {

	private String name;
	private String serial;
	
	@Override
	public int hashCode() {
		return serial.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		HumanPo humanPo = (HumanPo) obj;
		return serial.equals(humanPo.getSerial());
	}
	@Override
	public String toString() {
		return "HumanPo [name=" + name + ", serial=" + serial + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
}
