package Bhavcopy;

public class Bhavcopy {
    String Symbol;
    String Series;
    Double Open;    
    Double High;
    Double Low;
    Double Close;
    Double Last;
    Double PrevClose;
    Integer TotalTrdeQty; 
    Double TotalTrdVal;
    String Timestamp;
    Integer TotTrades;
    String Isin; 

    public Bhavcopy(String Symbol, String Series, Double Open, Double High, Double Low, Double Close, Double Last, Double PrevClose, Integer TotalTrdeQty, Double TotalTrdVal, String Timestamp, Integer TotTrades, String Isin) {
        this.Symbol = Symbol;
        this.Series = Series;
        this.Open = Open;
        this.High = High;
        this.Low = Low;
        this.Close = Close;
        this.Last = Last;
        this.PrevClose = PrevClose;
        this.TotalTrdeQty = TotalTrdeQty;
        this.TotalTrdVal = TotalTrdVal;
        this.Timestamp = Timestamp;
        this.TotTrades = TotTrades;
        this.Isin = Isin;
    }

    @Override
    public String toString() {
        return "Bhavcopy{" +
                "Symbol='" + Symbol + '\'' +
                ", Series='" + Series + '\'' +
                ", Open=" + Open +
                ", High=" + High +
                ", Low=" + Low +
                ", Close=" + Close +
                ", Last=" + Last +
                ", PrevClose=" + PrevClose +
                ", TotalTrdeQty=" + TotalTrdeQty +
                ", TotalTrdVal=" + TotalTrdVal +
                ", Timestamp='" + Timestamp + '\'' +
                ", TotTrades=" + TotTrades +
                ", Isin='" + Isin + '\'' +
                '}';
    }
}
