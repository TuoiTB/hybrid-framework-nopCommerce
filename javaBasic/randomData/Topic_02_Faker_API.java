package randomData;

import com.github.javafaker.Faker;

public class Topic_02_Faker_API {
	public static void main(String[] args) {
		//Basic infor
		Faker faker = new Faker();
		System.out.println(faker.address().city());
	}
}
