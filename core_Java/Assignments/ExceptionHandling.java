package Assignments;

import java.util.Scanner;
class YoungerAgeException extends Exception{

    YoungerAgeException(String msg){
        super(msg);
    }
}

public class ExceptionHandling {
    
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.println("Enter Your Age : ");

        int age = s.nextInt();
        if (age < 18){
            try{
            throw new YoungerAgeException("You are too young");
            }
            catch(YoungerAgeException e){
                System.out.println(e.toString());
            }
        }
        else{
            System.out.println("You are eligible to vote");
        }

    }
}
