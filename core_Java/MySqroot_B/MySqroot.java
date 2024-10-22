package MySqroot_B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MySqroot {
    
    public static void main(String[] args){

        System.out.println("It's Started !!.. ");

        String filePath = "/home/kartiks/java/core_Java/MySqroot_B/Numbers.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

        double num = -1;
        try{
            if(line != null){
            num = Double.parseDouble(line);
            }
        }
        catch (NumberFormatException e) { 
            System.out.println("number not provided");
            continue;
        }
        double x; // this is the number whose sqroot is to be found.
        double z; // this will be my guess that what my sqroot would be.

    try{
        x = num;
       if(x > 0){ 
        z = 0;
        double newZ =1; 
       // int loopCount = 0;
        while(Math.abs(z-newZ) >= 0.0001){
            z = newZ;
            newZ = z - ((z*z - x)/(2*z));
          //  loopCount++;
        }
        System.out.printf("%.4f  %.4f\n",x,newZ);
       // System.out.println(loopCount);
        }
        else{
        System.out.printf("%.4f  Incorrect Number\n",x);
        }
    }
    catch(Exception e){
        System.out.println("Something went wrong");
    }
    }
} catch (IOException e) {
    e.printStackTrace();
}
     }
}
