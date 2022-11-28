/* Первый семинар.
1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
Пункты реализовать в методе main
*Пункты реализовать в разных методах
int i = new Random().nextInt(k); //это кидалка случайных чисел!)
 */

import java.util.Arrays;
import java.util.Random;

public class homework_1 {
    public static void main(String[] args){
        // Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
        int i = new Random().nextInt(-1000, 1000);
//        System.out.println(Integer.toBinaryString(i));
//        System.out.println(high_bit_line(i)); // не получается для отрицательных чисел
        int n = new Random().nextInt(0, 128);
        System.out.printf("n = " + n + "; i = " + i + '\n');

        // находим кратные числа
        int count = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                count++;
            }
        }
        // создаем массив из кратных чисел
        int[] m1 = new int[count];
        count = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1[count] = j;
                count += 1;
            }
        }
        System.out.println(Arrays.toString(m1) + "\n");

        // находим некратные числа
        count = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                count++;
            }
        }
        int[] m2 = new int[count];
        count = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                m2[count] = j;
                count += 1;
            }
        }
        System.out.println(Arrays.toString(m2));

    }
    public static int high_bit_line (int n) {
        int res = 0;
        while (n != 1) {
            n >>= 1;
            res++;
        }
        return res;
    }
}
