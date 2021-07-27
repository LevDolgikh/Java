import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
/**
 * Created by Admin on 12.08.14.
 */
public class theCalculator {
    private int count = 0; // Счетчик количесва чисел подряд
    private int n1 = 0; // Первое число в строке
    private int n2 = 0; // Второе число в строке
    private char theSymbol = ' '; // Символ вычитания / сложения / разности / деления

    void getValue(String theString)throws UnsupportedEncodingException{
        PrintStream printThis = new PrintStream(System.out, true, "cp866");
        boolean[] didYouFindSomething = new boolean[theString.length()]; // массив для определения число ли это или какой-либо другой символ
        boolean endThis = false; // Переменная, что бы заполнение массива didYouFindSomething вызывалось только один раз

        for (int i = 0; i <= (theString.length()-1) ; i++) {

            if (!endThis){
                for ( int k = 0; k <= theString.length()-1; k++ ){
                    for ( int j = 0; j < 9; j++ ) {
                        if (Character.getNumericValue(theString.charAt(k)) == j){
                            didYouFindSomething[k] = true; // если это число, то получаем значение true
                            break;
                        }
                        else {
                            didYouFindSomething[k] = false; // если нет, то идет значение false
                        }
                        if (k == theString.length()-1) endThis = true;
                    }
                }
            }

            if (didYouFindSomething[i]) {
                count++; // Если это число, то увеличивает значение count
            }
            else if
                ((theString.charAt(i) == '+') ||
                (theString.charAt(i) == '-') ||
                (theString.charAt(i) == '%') ||
                (theString.charAt(i) == '/') ||
                (theString.charAt(i) == '*')) {
                theSymbol = theString.charAt(i); // Проверка на математический символ, если его нашли, то переменная theSymbol забирает его себе
            }

            if ( n1 == 0 && !(didYouFindSomething[i]) && !(count == 0)) {
                for (int j = count; j > 0 ; j = j - 1 )
                    n1 += (int) (Character.getNumericValue(theString.charAt(i-j)) * Math.pow(10, j - 1)) ; // использование count и воспроизведение числа из символов
                count = 0; // зануление count, так как одно число уже заполнено.
            }
            else if ( n2 == 0 && !(didYouFindSomething[i]) && !(count == 0)) {
                for (int g = count; g > 0 ; g = g - 1 )
                    n2 += (int) (Character.getNumericValue(theString.charAt(i-g)) * Math.pow(10, g - 1)) ; // использование count и воспроизведение числа из символов
                count = 0;
            }

            if ( !(count ==0) && (i == theString.length()-1) && n2 == 0) {
                for (int g = count; g > 0 ; g = g - 1 )
                    n2 += (int) (Character.getNumericValue(theString.charAt(i+1-g)) * Math.pow(10, g - 1)) ; // При завершении строки, при отсутствии значения в n2, попробует записать его еще раз.
                count = 0;
            }
        }
        if (n1 == 0 || n2 == 0 || theSymbol == ' ' ) printThis.println("Неверный формат введенных данных. Получить верные значения не удалось. Попробуйте еще раз."); // Вывод ошибки при отсутствии какого либо параметра
    }

    void calculate()throws UnsupportedEncodingException{
        PrintStream printThis = new PrintStream(System.out, true, "cp866");
        if (theSymbol == '+') printThis.println("Сумма чисел "+ n1 + " и " + n2 + " равна: " + (n1+n2));
        else if (theSymbol == '-')  printThis.println("Разность чисел "+ n1 + " и " + n2 + " равна: " + (n1-n2));
        else if (theSymbol == '*')  printThis.println("Произведение чисел "+ n1 + " и " + n2 + " равно: " + n1*n2);
        else if (theSymbol == '/')  printThis.println("Часное чисел "+ n1 + " и " + n2 + " равно: " + n1/n2);
        else if (theSymbol == '%')  printThis.println("Остаток деления чисел "+ n1 + " и " + n2 + " равен: " + n1%n2);
        else  printThis.println("Невозможно сосчитать :("); // Тут все предельно просто
    }

}

