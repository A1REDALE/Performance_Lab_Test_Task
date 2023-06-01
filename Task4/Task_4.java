import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(args[0]));
        int num = Integer.parseInt(scanner.nextLine());
        List<Integer> data = new ArrayList<>();
        data.add(num);
        float cma = data.get(0);
        int counter = 1;
        while (scanner.hasNextLine()) {
            num = Integer.parseInt(scanner.nextLine());
            data.add(num);
            cma += (num - cma) / (counter + 1);
            counter++;
        }
        int avg = (int) Math.floor(cma);
        int totalSteps = 0;
        for (Integer datum : data) {
            totalSteps += Math.abs(datum - avg);
        }
        System.out.println(totalSteps);
    }
}



