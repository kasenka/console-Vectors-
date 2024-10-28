package some;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vectors {
    public static double[] first_vector;
    public static double[] second_vector;


    private static void setVector(int amount){
        Scanner s = new Scanner(System.in);

        first_vector = Arrays.stream(s.nextLine().split(" "))
                .mapToDouble(num -> Double.parseDouble(num))
                .toArray();
        if (amount == 2) {
            second_vector = Arrays.stream(s.nextLine().split(" "))
                    .mapToDouble(num -> Double.parseDouble(num))
                    .toArray();
        }
    }
    public static void scalarProduct(){
        setVector(2);
        double result = first_vector[0]*second_vector[0] +
                first_vector[1]*second_vector[1] +
                first_vector[2]*second_vector[2];
        System.out.println("Скалярное произведение : "+result);
    }

    public static void vectorProduct(){
        setVector(2);
        double i = first_vector[1]*second_vector[2] -
                first_vector[2]*second_vector[1];
        double j = first_vector[2]*second_vector[0] -
                first_vector[0]*second_vector[2];
        double k = first_vector[0]*second_vector[1] -
                first_vector[1]*second_vector[0];
        System.out.println("Векторное произведение : "+ i + " " + j + " " + k );
    }

    public static void vectorSum() {
        setVector(2);
        double i = first_vector[0]+second_vector[0];
        double j = first_vector[1]+second_vector[1];
        double k = first_vector[2]+second_vector[2];
        System.out.println("Сумма векторов : "+ i + " " + j + " " + k );

    }

    public static void vectorDiff() {
        setVector(2);
        double i = first_vector[0]-second_vector[0];
        double j = first_vector[1]-second_vector[1];
        double k = first_vector[2]-second_vector[2];
        System.out.println("Разность векторов : "+ i + " " + j + " " + k );

    }

    public static void vectorModule() {
        setVector(1);
        double result = Math.sqrt((Math.pow(first_vector[0],2) +
                Math.pow(first_vector[1],2) +
                Math.pow(first_vector[2],2)));
        System.out.println("Модуль вектора : "+result);
    }

    public static void angle() {
        setVector(2);
        double sc = first_vector[0]*second_vector[0] +
                first_vector[1]*second_vector[1] +
                first_vector[2]*second_vector[2];
        double modA = Math.sqrt((Math.pow(first_vector[0],2) +
                Math.pow(first_vector[1],2) +
                Math.pow(first_vector[2],2)));
        double modB = Math.sqrt((Math.pow(second_vector[0],2) +
                Math.pow(second_vector[1],2) +
                Math.pow(second_vector[2],2)));
        double result = sc / (modA * modB);
        System.out.println("Угол между двумя векторами cos A: "+result);
    }

    public static void vectorMatrix() {
        setVector(1);

        System.out.println("Введите матрицу поворота");
        Scanner s = new Scanner(System.in);
        double[] matrix_1 = Arrays.stream(s.nextLine().split(" "))
                .mapToDouble(num -> Double.parseDouble(num))
                .toArray();
        double[] matrix_2 = Arrays.stream(s.nextLine().split(" "))
                .mapToDouble(num -> Double.parseDouble(num))
                .toArray();
        double[] matrix_3 = Arrays.stream(s.nextLine().split(" "))
                .mapToDouble(num -> Double.parseDouble(num))
                .toArray();

        double i = matrix_1[0]*first_vector[0] + matrix_1[1]*first_vector[1] + matrix_1[2]*first_vector[2];
        double j = matrix_2[0]*first_vector[0] + matrix_2[1]*first_vector[1] + matrix_2[2]*first_vector[2];
        double k = matrix_3[0]*first_vector[0] + matrix_3[1]*first_vector[1] + matrix_3[2]*first_vector[2];
        System.out.println("Вращение вектора по заданной матрице поворота. : "+ i + " " + j + " " + k );
    }

    public static void vectorProjection() {
        setVector(1);
        System.out.println("Введите плоскость проекции xy,xz,yz");
        Scanner s = new Scanner(System.in);
        String p = s.nextLine();
        switch (p){
            case ("xy"):
                System.out.println("Проекция : "+first_vector[0]+" "+first_vector[1]+ " 0");
                break;
            case ("yz"):
                System.out.println("Проекция : 0 "+first_vector[2]+" "+first_vector[2]);
                break;
            case ("xz"):
                System.out.println("Проекция : "+first_vector[0]+" 0 "+first_vector[2]);
                break;
        }
    }

    public static void vectorParallelism(){
        setVector(2);
        double i = first_vector[1]*second_vector[2] -
                first_vector[2]*second_vector[1];
        double j = first_vector[2]*second_vector[0] -
                first_vector[0]*second_vector[2];
        double k = first_vector[0]*second_vector[1] -
                first_vector[1]*second_vector[0];
        boolean parallelism = (i == 0 && j == 0 && k == 0)? true : false;
        System.out.println("Векторы параллельны : "+ parallelism );
    }

    public static void vectorPerpendicularity(){
        setVector(2);
        double result = first_vector[0]*second_vector[0] +
                first_vector[1]*second_vector[1] +
                first_vector[2]*second_vector[2];
        boolean perpendicularity = (result == 0)? true : false;
        System.out.println("Векторы перпендикулярны : "+ perpendicularity );
    }

    public static void doubleToBin(){
        setVector(1);
        System.out.println("Введите действие : \n1 - побитовый оператор «НЕ»\n" +
                "2 - сдвиг влево на 3 бита\n" +
                "3 - сдвиг вправо на 3 бита");
        Scanner s = new Scanner(System.in);
        String action = s.nextLine();

        Integer[] vector = new Integer[]{(int)first_vector[0],(int)first_vector[1],(int)first_vector[2]};
        System.out.println("Исходный вектор целых чисел : "+vector[0]+" "+vector[1]+" "+vector[2]);

        String[] binaryVector = new String[]{Integer.toBinaryString(vector[0]),
                Integer.toBinaryString(vector[1]),
                Integer.toBinaryString(vector[2])};

        switch (action){
            case ("1"):
                String[] repBinaryVector = Arrays.stream(binaryVector)
                        .map(binaryStr -> binaryStr.replace("0","*")
                                        .replace("1","0")
                                        .replace("*","1")).toArray(String[]::new);
                System.out.println("Побитовый оператор «НЕ» : "+repBinaryVector[0]+" "+repBinaryVector[1]+" "+repBinaryVector[2]);
                break;
            case ("2"):
                String[] leftwardShift = Arrays.stream(binaryVector)
                        .map(x -> Integer.toBinaryString(Integer.parseInt(x, 2) << 3))
                        .toArray(String[]::new);
                System.out.println("Cдвиг влево на 3 бита : "+leftwardShift[0]+" "+leftwardShift[1]+" "+leftwardShift[2]);
                break;
            case ("3"):
                String[] rightwardShift = Arrays.stream(binaryVector)
                        .map(x -> Integer.toBinaryString(Integer.parseInt(x, 2) >> 3))
                        .toArray(String[]::new);
                System.out.println("Cдвиг вправо на 3 бита : "+rightwardShift[0]+" "+rightwardShift[1]+" "+rightwardShift[2]);
                break;
        }
    }

    private static String intArrayToHexString(int[] array) {
        return Arrays.stream(array)
                .mapToObj(x -> "0x" + Integer.toHexString(x))
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }

    public static void doubleToHex() {
        setVector(2);
        System.out.println("Введите действие : \n1 - побитовый оператор «И»\n" +
                "2 - побитовый оператор “ИЛИ”\n" +
                "3 - побитовое исключающее “ИЛИ”");
        Scanner s = new Scanner(System.in);
        String action = s.nextLine();

        Integer[] vector1 = new Integer[]{(int) first_vector[0], (int) first_vector[1], (int) first_vector[2]};
        Integer[] vector2 = new Integer[]{(int) second_vector[0], (int) second_vector[1], (int) second_vector[2]};

        System.out.println("Исходный 1 вектор целых чисел : " + vector1[0] + " " + vector1[1] + " " + vector1[2]);
        System.out.println("Исходный 2 вектор целых чисел : " + vector2[0] + " " + vector2[1] + " " + vector2[2]);

        String[] binary1Vector = new String[]{Integer.toBinaryString(vector1[0]),
                Integer.toBinaryString(vector1[1]),
                Integer.toBinaryString(vector1[2])};
        String[] binary2Vector = new String[]{Integer.toBinaryString(vector2[0]),
                Integer.toBinaryString(vector2[1]),
                Integer.toBinaryString(vector2[2])};

        switch (action) {
            case ("1"):
                int[] bitwiseAnd = IntStream.range(0, 3)
                        .map(i -> vector1[i] & vector2[i])
                        .toArray();
                System.out.println("Побитовый оператор «И» : " + intArrayToHexString(bitwiseAnd));
                break;
            case ("2"):
                int[] bitwiseOr = IntStream.range(0, 3)
                        .map(i -> vector1[i] | vector2[i])
                        .toArray();
                System.out.println("Побитовый оператор “ИЛИ” : " + intArrayToHexString(bitwiseOr));
                break;
            case ("3"):
                int[] bitwiseXor = IntStream.range(0, 3)
                        .map(i -> vector1[i] ^ vector2[i])
                        .toArray();
                System.out.println("Побитовое исключающее “ИЛИ” : " + intArrayToHexString(bitwiseXor));
                break;
        }
    }

    public static void vectorCounter(){
        setVector(1);
        Map<Integer, String> numToAlf = Map.of(
                0, "ноль",
                1, "один",
                2, "два",
                3, "три",
                4, "четыре",
                5, "пять",
                6, "шесть",
                7, "семь",
                8, "восемь",
                9, "девять");
        String[] residues = Arrays.stream(first_vector).mapToObj(x -> numToAlf.get((int)x % 10)).toArray(String[]::new);

        String together = Arrays.stream(residues).collect(Collectors.joining());

        Map<Character, Integer> counter = new HashMap<>();
        together.chars().forEach(c -> counter.merge((char) c, 1, Integer::sum));

        System.out.println("Остатки от деления на 10 : " + residues[0] + " " + residues[1] + " " +residues[2]);
        System.out.println("Уникальность букв :");
        counter.forEach((key, value) -> System.out.printf("'%c' : %d%n", key, value));
        System.out.println("Уникальность букв но в верхнем регистре :) ");
        counter.forEach((key, value) -> System.out.printf("'%s' : %d%n", key.toString().toUpperCase(), value));
    }
    

    public static void main(String[] args) {
//        scalarProduct();
//        vectorProduct();
//        vectorSum();
//        vectorDiff();
//        vectorModule();
//        angle();
//        vectorMatrix();
//        vectorProjection();
//        vectorParallelism();
//        vectorPerpendicularity();
//        doubleToBin();
//        doubleToHex();
//        vectorCounter();

    }
}
