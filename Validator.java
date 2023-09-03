import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validator {
    public static int stringToInt(String value){
        int valueInt=-1;
        try {
            valueInt = Integer.parseInt(value);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона. Ожидается целое число без знака.");
        }
        return valueInt;
    }
    public static char genderStatus(String gender){
        if (!gender.matches("[fm]")) {
            throw new IllegalArgumentException("Неверный пол. Ожидаемое «f» или «m».");
        }
        else {
            return gender.charAt(0);
        }
    }

    public static LocalDate birthDay(String birthDate){
        // Проверка формата даты рождения(dd.mm.yyyy)
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IllegalArgumentException("Неверный формат даты рождения. Ожидаемый формат: dd.mm.yyyy");
        }

        // Проверка даты рождения
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDateObj = null;
        try {
            birthDateObj = LocalDate.parse(birthDate, formatter);
        }
        catch (DateTimeParseException e){
            throw  new IllegalArgumentException("Даты рождения");
//
        }

        if (birthDateObj.isAfter(currentDate)) {
            throw new IllegalArgumentException("Дата рождения не может быть в будущем.");
        }
        return birthDateObj;
    }

    public  static void ValidatorInput(String[] data) {
        if (data.length != 6) {
            throw new IllegalArgumentException("Недопустимое количество входных значений. Ожидается 6 значений.");
        }
    }

}
