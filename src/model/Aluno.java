package model;

public class Aluno {
	
	private String id;
	private String name;
	private String email;
	private int age;
	private String gender;
	private String comp;
	private String city;
	
	public Aluno(String id, String name, String email, String age, String gender, String comp, String city) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = Integer.parseInt(age);
		this.gender = gender;
		this.comp = comp;
		this.city = city;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public Aluno(String name, String email, int age, String city) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.city = city;
	}


	@Override
	public String toString() {
		return "Aluno:\n id: " + id + ", name: " + name + ", email: " + email + ", age: " + age + ", gender: " + gender
				+ ", comp: " + comp + ", city: " + city;
	}

}