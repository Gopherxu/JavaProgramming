package MyFixed2csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MyFixed2csv {
    
    public static void main(String[] args) {
      String  fileName = args[0];
      int    NumberOfColumns = Integer.parseInt(args[1]);
      int[] Columns = new int[NumberOfColumns];
      int sum = 0;
      for(int i=0;i<NumberOfColumns;i++){
          Columns[i] = Integer.parseInt(args[i+2]);
          sum = sum + Columns[i];
      }
      System.out.println("File Name : "+fileName);
      System.out.println("Number of Columns : "+NumberOfColumns);
      for(int i=0;i<NumberOfColumns;i++){
          System.out.println("Column "+(i+1)+" : "+Columns[i]);
      }

      String[] subStringsArr = new String[NumberOfColumns];
      String csvFilePath = "MyFixed2csv/kartik.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
            int start=0;
            int end =Columns[0];
            for(int i=0;i<NumberOfColumns;i++){
              subStringsArr[i] = line.substring(start,end).trim();
              start = start + Columns[i];
              if(sum != end){
                end = end + Columns[i+1];      
              }  
              subStringsArr[i] = subStringsArr[i].replaceFirst("^0+(?!$)", "");   
            }   
            

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {  // Open in append mode
                StringBuilder sb = new StringBuilder();
            
                for (int i = 0; i < subStringsArr.length; i++) {
                    sb.append("\"").append(subStringsArr[i]).append("\"");
            
                    if (i < subStringsArr.length - 1) {
                        sb.append(",");
                    }
                }
            
                writer.write(sb.toString());
                writer.newLine();  // Add a new line after writing the current line
            
                System.out.println("Data appended to CSV file successfully!");
                
            } catch (IOException e) {
            e.printStackTrace();
        }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

}