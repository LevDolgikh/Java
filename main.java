import java.io.PrintStream;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;

/**
 * Created by Admin on 12.08.14.
 */
public class main {
    public static void main (String[] args )throws UnsupportedEncodingException{
        PrintStream printThis = new PrintStream(System.out, true, "cp866");
        boolean exit = false; // Переменная, что бы закрыть цикл
        printThis.println("Введите выражение формата 4 + 7 или 2*4");
        printThis.println("Доступны следующие функции: + / - * %\nДля выхода введите exit\nТак же значение 0 является неккоректным,будет писать ошибку! Это можно исправить, но мне чет лень ;D"  );

        while (!exit) {
            Scanner in = new Scanner(System.in);
            String theString = in.nextLine();
            if (theString.equals("exit")) {
                exit = true; // Изменяем переменную
                break; // Выходим из цикла
            }
            theCalculator calc1 = new theCalculator();
        //String theString = String.valueOf(args);
            calc1.getValue(theString); // Данная функция получает значения и математический символ
            calc1.calculate(); // Считает
        }
    }
}
