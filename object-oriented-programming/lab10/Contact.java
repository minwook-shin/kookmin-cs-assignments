package lab10;

public class Contact implements Comparable {
	String name;
	String email;
	String phone;
	String address;
	String major;
	
	Contact( String name, String email, String phone, String address, String major) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.major = major;		
	}
	
	public String toString() {
		return "\n\t\t\t[" + name + ",\t" + email + ",\t" + phone + ",\t" + address + ",\t" + major + "]" ;
	}

	@Override
	public int compareTo(Object arg0) {
		return this.name.compareTo(((Contact)arg0).name);
	}
}
