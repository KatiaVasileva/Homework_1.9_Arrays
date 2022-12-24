public class Main {
    public static void main(String[] args) {
/*  Задачи 1-3
Каждый день месяца, включая выходные, компания тратит средства — некую сумму, причем в бухгалтерской книге хранится
сумма затрат по дням (а не каждая сумма отдельно). То есть в книге 30 записей разных сумм. Эти суммы разнятся от 100 000
до 200 000.
Для получения массива случайных чисел достаточно объявить массив и вызвать указанный ранее метод. Метод инициализирует
ваш массив и заполнит его случайными значениями от 100_000 до 200_000.
*/
//  Задача 1
//  Первым делом бухгалтеры попросили посчитать сумму всех выплат за месяц. Нужно написать программу, которая решит
//  эту задачу, и вывести в консоль результат в формате: «Сумма трат за месяц составила … рублей».
        System.out.println("Задача 1");
        int[] arr = generateRandomArray();
        int totalAmountPerMonth = 0;
        for (int i : arr) {
            totalAmountPerMonth += i;
        }
        System.out.printf("Сумма трат за месяц составила %d руб.", totalAmountPerMonth);
        System.out.println("\n");

//  Задача 2
//  Следующая задача — найти минимальную и максимальную трату за день.
//  Нужно написать программу, которая решит эту задачу, и вывести в консоль результат в формате:
//  «Минимальная сумма трат за день составила … рублей. Максимальная сумма трат за день составила … рублей».
        System.out.println("Задача 2");
        int maxAmount = arr[0];
        int minAmount = arr[0];
        for (int i : arr) {
            if (i > maxAmount) {
                maxAmount = i;
            }
            if (i < minAmount) {
                minAmount = i;
            }
        }
        System.out.println("Минимальная сумма трат за день составила " + minAmount +
                            " руб.\nМаксимальная сумма трат за день составила " + maxAmount + " руб.\n");



//  Задача 3
//  Нужно написать программу, которая посчитает среднее значение трат за месяц (то есть сумму всех трат за месяц
//  поделить на количество дней), и вывести в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
//  Нужно сгенерировать массив, подать его в наш метод, а внутри метода подсчитать сумму элементов и вычислить среднее значение,
//  которое нужно вернуть из метода в виде результата. Метод нужно не просто написать, но еще и декомпозировать.
//  То есть для работы этого метода нужно будет создать еще методы (1 или более), которые его будут обслуживать и вычислять
//  промежуточные результаты. Среднее значение нужно вычислять в дробном виде, так как результат должен быть точным.
        System.out.println("Задача 3");
        int[] array = generateRandomArray();
        int totalAmount = calculateTotalAmountPerMonth(array);
        float averageAmountPerMonth = calculateAverageAmountPerMonth(array, totalAmount);
        printAverageAmount(averageAmountPerMonth);
        System.out.println("\n");

//  Задача 4
//  В нашей бухгалтерской книге появился баг. Что-то пошло нет так, и Ф.И.О. сотрудников начали отображаться в обратную сторону.
//  Данные с именами сотрудников хранятся в виде массива символов (char[]).Напишите код, который в случае такого бага будет
//  выводить Ф. И. О. сотрудников в корректном виде. В качестве данных для массива используйте:
//  char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
//  В результате в консоль должно быть выведено "Ivanov Ivan".
        System.out.println("Задача 4");
        char[] reverseFullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        for (int i = (reverseFullName.length - 1); i >= 0 ; i--) {
            System.out.print(reverseFullName[i]);
        }
        System.out.println();
    }
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static int calculateTotalAmountPerMonth(int[] arr) {
        generateRandomArray();
        int totalAmountPerMonth = 0;
        for (int i : arr) {
            totalAmountPerMonth += i;
        }
        return totalAmountPerMonth;
    }

    public static float calculateAverageAmountPerMonth(int[] arr, int totalAmountPerMonth) {
        return (float) totalAmountPerMonth / arr.length; // float - поскольку среднее значение может быть дробным числом
    }

    public static void printAverageAmount(float averageAmount) {
        System.out.printf("Средняя сумма трат за месяц составила %.2f руб.", averageAmount);
    }
}