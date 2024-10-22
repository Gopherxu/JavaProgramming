package Assignments;
class MySqroot{
    public static void main(String[] args){

        System.out.println("It's Started !!.. ");
        String num = null;
        try{
        num = args[0];
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("number not provided");
            return;
        }
        double x; // this is the number whose sqroot is to be found.
        double z; // this will be my guess that what my sqroot would be.

    try{
        x = Double.parseDouble(num);
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
}