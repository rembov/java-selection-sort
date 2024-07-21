import java.util.Random;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("res.txt", false);
        int[] ch = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            ch[i] = rand.nextInt(100);
            writer.append(ch[i] + ",");

            writer.flush();
        }
        writer.append("\n");

        writer.append("---------------------------------------------"
                + "------------------------------------------------"
                + "---------------------------------------------------"
                + "----------------------------------------------------"
                + "---------------------------");
        writer.append("\n");
        writer.flush();
        sort(ch);
        for (int i = 0; i < 100; i++) {
            writer.append(ch[i] + ",");

            writer.flush();

        }
        writer.append("\n");
        System.out.println("ok");

        try (FileReader reader = new FileReader("res.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }

        }
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {    // i - номер текущего шага
            int pos = i;
            int min = array[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;    // меняем местами наименьший с array[i]
        }
    }

}