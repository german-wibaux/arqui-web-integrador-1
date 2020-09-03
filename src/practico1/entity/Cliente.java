package practico1.entity;


public class Cliente {
	
	
	private int id;
	
	private String name;
	
	private int age;
	
	
	public Cliente() {
		super();
	}


	public Cliente(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
