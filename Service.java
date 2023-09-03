import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Service {
    public static Person processInputData(String input, Person person) throws IOException {

        String[] data = input.split(" ");
        Validator.ValidatorInput(data);
        person.setLastName(data[0]);
        person.setFirstName(data[1]);
        person.setMiddleName(data[2]);
        person.setBirthDate(Validator.birthDay(data[3]));
        person.setPhoneNumber(Validator.stringToInt(data[4]));
        person.setGender(Validator.genderStatus(data[5]));



        return person;

    }

    public static String buildPersonString(Person person) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Фамилия: ").append(person.getLastName()).append(" ");
        stringBuilder.append("Имя: ").append(person.getFirstName()).append(" ");
        stringBuilder.append("Отчество: ").append(person.getMiddleName()).append(" ");
        stringBuilder.append("Дата рождения: ").append(person.getBirthDate()).append(" ");
        stringBuilder.append("Номер телефона: ").append(person.getPhoneNumber()).append(" ");
        stringBuilder.append("Пол: ").append(person.getGender()).append("\n");
        return stringBuilder.toString();
    }

    public static void writeToFile(String fileName, String fileContent) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(fileContent);
            writer.newLine();

        }
    }
}
