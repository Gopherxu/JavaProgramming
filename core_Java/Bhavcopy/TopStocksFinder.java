package Bhavcopy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopStocksFinder {
    
    

    public void printStockDetails(List<Bhavcopy> bhavcopyList, String symbol) {
        for (Bhavcopy stock : bhavcopyList) {
            if (stock.Symbol.equalsIgnoreCase(symbol)) {
                System.out.println("Details for stock symbol '" + symbol + "':");
                System.out.println(stock);
                return; 
            }
        }
        System.out.println("Stock with symbol '" + symbol + "' not found.");
    }


    public void countSeries(List<Bhavcopy> bhavcopyList, String series){
        int count =0;
        for (Bhavcopy stock : bhavcopyList){
            if(stock.Series.equalsIgnoreCase(series)){
                count++;
            }
        }
        System.out.println(series + " : " + count);
    }

    public void printRecordsGreaterThanPercentage(List<Bhavcopy> bhavcopyList, double percentage){
        double percentageValue;
        for(Bhavcopy stock : bhavcopyList){
            percentageValue = ((stock.Close-stock.Open)/stock.Open)*100;
            if (percentageValue > percentage){
                System.out.printf(stock.Symbol+" ");
            }
        }
    }

    public void TOPBOT(List<Bhavcopy> bhavcopyList, double percentage){
        double percentageValue;
        for(Bhavcopy stock : bhavcopyList){
            percentageValue = ((stock.High-stock.Low)/stock.Low)*100;
            if (percentageValue > percentage){
                System.out.printf(stock.Symbol+" ");
            }
        }
    }

    public void standardDeviation(List<Bhavcopy> bhavcopyList, String Series){

      float mean ;
      float sum = 0;
      float standardDeviation;
      int count =0;
        for (Bhavcopy stock : bhavcopyList){
            if(stock.Series.equalsIgnoreCase(Series)){
                count++;
                sum += stock.Close;
            }
        }
        mean = sum/count;
        sum = 0;
        for (Bhavcopy stock : bhavcopyList){
            if(stock.Series.equalsIgnoreCase(Series)){
                sum += Math.pow(stock.Close-mean,2);
            }
        }
        standardDeviation = (float) Math.sqrt(sum/count);
        System.out.println("StandardDeviation :"+standardDeviation);
    }

    public void topGainers(List<Bhavcopy> bhavcopyList, int topGainers){

        List<Map.Entry<String, Double>> stockList = List(bhavcopyList);
        for (int i = 0; i < topGainers; i++) {
            System.out.println(stockList.get(i).getKey() + " : " + String.format("%.2f", stockList.get(i).getValue()));
        }
    }


    public void topLosers(List<Bhavcopy> bhavcopyList, int topLosers){

        List<Map.Entry<String, Double>> stockList = List(bhavcopyList);
        int i;
        int count =0;
        while(topLosers > 0){
            i = stockList.size() - count - 1;
            count++;
            System.out.println(stockList.get(i).getKey() + " : " + String.format("%.2f", stockList.get(i).getValue()));
            topLosers--;
        }
        
    }
    public List<Map.Entry<String, Double>> List(List<Bhavcopy> bhavcopyList) {

        Map<String, Double> stockMap = new HashMap<>();
        double gainValue;
        for (Bhavcopy stock : bhavcopyList) {    
        gainValue = ((stock.Close-stock.Open)/stock.Open)*100;
        stockMap.put(stock.Symbol, gainValue);
    }
    List<Map.Entry<String, Double>> stockList = new ArrayList<>(stockMap.entrySet());
    stockList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

    return stockList;
    }

    public List<Map.Entry<String, Integer>> VolumeList(List<Bhavcopy> bhavcopyList) {
        Map<String, Integer> stockMap = new HashMap<>();
        Integer volume;
        for (Bhavcopy stock : bhavcopyList) {
            volume = stock.TotalTrdeQty;
            stockMap.put(stock.Symbol, volume);
        }
        List<Map.Entry<String, Integer>> stockList = new ArrayList<>(stockMap.entrySet());
        stockList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        return stockList;
    }

    public List<Map.Entry<String, Double>> DeliveryVolumeList(List<Bhavcopy> bhavcopyList) {
        Map<String, Double> stockMap = new HashMap<>();
        Double volume;
        for (Bhavcopy stock : bhavcopyList) {
            volume = stock.TotalTrdVal;
            stockMap.put(stock.Symbol, volume);
        }
        List<Map.Entry<String, Double>> stockList = new ArrayList<>(stockMap.entrySet());
        stockList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        return stockList;
    }

    public void HeigestVolumes(List<Bhavcopy> bhavcopyList, int HeigestVolume){

        List<Map.Entry<String, Integer>> stockList = VolumeList(bhavcopyList);
        for (int i = 0; i < HeigestVolume; i++) {
            System.out.println(stockList.get(i).getKey() + " : " + stockList.get(i).getValue());
        }
    }

    public void LowestVolumes(List<Bhavcopy> bhavcopyList, int LowestVolume){
        List<Map.Entry<String, Integer>> stockList = VolumeList(bhavcopyList);
        int i;
        int count =0;
        while(LowestVolume > 0){
            i = stockList.size() - count - 1;
            count++;
            System.out.println(stockList.get(i).getKey() + " : " + stockList.get(i).getValue());
            LowestVolume--;
        }
    }

    public void TopTradebyTotrdval(List<Bhavcopy> bhavcopyList, int topGainers){

        List<Map.Entry<String, Double>> stockList = DeliveryVolumeList(bhavcopyList);
        System.out.println("\nTop  by TOTRDVAL : \n");
        for (int i = 0; i < topGainers; i++) {
            System.out.println(stockList.get(i).getKey() + " : " + String.format("%.2f", stockList.get(i).getValue()));
        }
    }

    public void LeastTradebyTotrdval(List<Bhavcopy> bhavcopyList, int topGainers){

        List<Map.Entry<String, Double>> stockList = DeliveryVolumeList(bhavcopyList);
        int i;
        int count =0;
        System.out.println("\nTop Losers by TOTRDVAL : \n");
        while(topGainers > 0){
            i = stockList.size() - count - 1;
            count++;
            System.out.println(stockList.get(i).getKey() + " : " + String.format("%.2f", stockList.get(i).getValue()));
            topGainers--;
        }
        
    }


    


}