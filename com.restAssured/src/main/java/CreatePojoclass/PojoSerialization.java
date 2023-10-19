package CreatePojoclass;

public class PojoSerialization {
	
	String name;
	long phoneNo;
	int age;
	 
	public PojoSerialization() {
		
	}
	//Constructor
	public PojoSerialization(String name, long phoneNo, int age) {
		super();
		this.name= name;
		this.phoneNo = phoneNo;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
