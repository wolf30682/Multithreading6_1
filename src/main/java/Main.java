import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Collection<String> localText = new ArrayList<>();
        getTextFromUser(localText);
        sortedWords(localText);
    }

    public static void getTextFromUser(Collection<String> localText) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полученный от местных жителей текст и нажмите 'enter'");
        String aborigenText = scanner.nextLine();
        localText.add(aborigenText);
        scanner.close();
    }

    public static void sortedWords(Collection<String> localText) {
        System.out.println("Наш итоговый словарь:");
        localText.stream()
                .flatMap(value -> Arrays.stream(value.split(" "))) //
                .distinct() // Удалим дубликаты
                .sorted(Comparator.naturalOrder())// Отсортируем в естественном порядке
                .forEach(System.err::println); // вывод
    }
}