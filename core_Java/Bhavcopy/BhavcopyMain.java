package Bhavcopy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BhavcopyMain {
    public static void main(String[] args) {
        String csvFile = "Bhavcopy/20241011_NSE.csv";
        List<Bhavcopy> bhavcopyList = readCsvFile(csvFile);
        TopStocksFinder finder = new TopStocksFinder();
       // SeriesCount seriesCount = new SeriesCount();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n\nChoose an operation:");
            System.out.println("1. Get details of a particular stock");
            System.out.println("2. Enter SERIES to get count of all Symbols");
            System.out.println("3. GAIN");
            System.out.println("4. TOPBOT");
            System.out.println("5. Standard Deviation of Given Series");
            System.out.println("6. Top Gainers");
            System.out.println("7. Top Losers");
            System.out.println("8. HeigestVolume");
            System.out.println("9. LowestVolume");
            System.out.println("10. Highest and lowest traded (by TOTRDVAL) for a given series");

            System.out.println("12. Exit");//((HIGH - LOW) / LOW) > N%
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.println("Enter stock symbol: ");
                    String symbol = scanner.nextLine();
                    finder.printStockDetails(bhavcopyList, symbol);
                    break;
    
                case 2:
                    System.out.println("Count the number of symbols for a given SERIES: ");
                    String series = scanner.nextLine();
                    finder.countSeries(bhavcopyList, series);
                    break;
    
                case 3:
                    System.out.println("Enter Percentage: ");
                    double percentage = scanner.nextDouble();
                    scanner.nextLine();
                    finder.printRecordsGreaterThanPercentage(bhavcopyList, percentage);
                    break;
                case 4:
                    System.out.println("Enter Percentage: ");
                    double percentage1 = scanner.nextDouble();
                    scanner.nextLine();
                    finder.TOPBOT(bhavcopyList, percentage1);
                    break;

                case 5:
                    System.out.println("Enter Series: ");
                    String series1 = scanner.nextLine();
                    finder.standardDeviation(bhavcopyList, series1);
                    break;
                case 6:
                    System.out.println("Enter number of top gainers: ");
                    int topGainers = scanner.nextInt();
                    scanner.nextLine();
                    finder.topGainers(bhavcopyList, topGainers);
                    break;

                case 7:
                    System.out.println("Enter number of top losers: ");
                    int topLosers = scanner.nextInt();
                    scanner.nextLine();
                    finder.topLosers(bhavcopyList, topLosers);
                    break;
                case 8:
                   System.out.println("Enter number of top gainers: ");
                    int HeigestVolume = scanner.nextInt();              
                    scanner.nextLine();
                    finder.HeigestVolumes(bhavcopyList, HeigestVolume);
                    break;

                case 9:
                    System.out.println("Enter number of top losers: ");
                    int LowestVolume = scanner.nextInt();
                    scanner.nextLine();
                    finder.LowestVolumes(bhavcopyList, LowestVolume);
                    break;

                case 10:
                    System.out.println("Enter number of top gainers: ");
                    int topGainers1 = scanner.nextInt();
                    System.out.println("Enter number of top losers: ");
                    int topLosers1 = scanner.nextInt();
                    scanner.nextLine();
                    finder.TopTradebyTotrdval(bhavcopyList, topGainers1);
                    finder.LeastTradebyTotrdval(bhavcopyList, topLosers1);
                    break;
                case 12:
                    System.out.println("Exiting...");
                    scanner.close();
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static List<Bhavcopy> readCsvFile(String csvFile) {
        List<Bhavcopy> bhavcopyList = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                Bhavcopy bhavcopy = new Bhavcopy(
                    data[0], 
                    data[1], 
                    parseDoubleOrNull(data[2]), 
                    parseDoubleOrNull(data[3]), 
                    parseDoubleOrNull(data[4]), 
                    parseDoubleOrNull(data[5]), 
                    parseDoubleOrNull(data[6]), 
                    parseDoubleOrNull(data[7]), 
                    parseIntegerOrNull(data[8]), 
                    parseDoubleOrNull(data[9]), 
                    data[10], 
                    parseIntegerOrNull(data[11]), 
                    data[12]  
                );
                bhavcopyList.add(bhavcopy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bhavcopyList;
    }

    private static Double parseDoubleOrNull(String value) {
        try {
            return (value != null && !value.isEmpty()) ? Double.valueOf(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    
    private static Integer parseIntegerOrNull(String value) {
        try {
            return (value != null && !value.isEmpty()) ? Integer.valueOf(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
