import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    //Генерация рандомного числа
    public float generateRandomPrice() {
        return (float) faker.number().randomDouble(2, 100, 50000);
    }

    //Генерация рандомной строки
    public String generateRandomName() {
        return faker.name().lastName();
    }
}
