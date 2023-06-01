import java.io.*;
import java.util.Scanner;


public class Task_2 {
    public static void main(String[] args) throws FileNotFoundException {

        File circleFile = new File(args[0]);
        File pointsFile = new File(args[1]);

        Scanner circleFileScanner = new Scanner(circleFile);
        String center = circleFileScanner.nextLine();
        String[] parts = center.split(" ");
        float x0 = Float.parseFloat(parts[0]);
        float y0 = Float.parseFloat(parts[1]);
        float radius =  Float.parseFloat(circleFileScanner.nextLine().trim());

        Scanner pointsFileScanner = new Scanner(pointsFile);
        int counter = 0;
        while(pointsFileScanner.hasNextLine()){
            String data = pointsFileScanner.nextLine();
            String[] partsPoints = data.split(" ");
            float x = Float.parseFloat(partsPoints[0]);
            float y = Float.parseFloat(partsPoints[1]);
            counter++;
            if(counter > 100){
                return;
            }
            float r = (float)Math.sqrt(Math.pow(x - x0,2) + Math.pow(y - y0,2));
            if (r < radius){
                System.out.println(1);
            }
            else if (r > radius){
                System.out.println(2);
            }
            else {
                System.out.println(0);
            }
        }
    }
}
