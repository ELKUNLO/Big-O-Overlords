
public class Sefer {

    int seferNo;
    String kalkis;
    String varis;
    String tarih;
    String saat;
    double fiyat;
    
    Bilet[] koltuklar;
    
    Sefer next;
    
    public Sefer(int seferNo, String kalkis, String varis, String tarih, String saat, double fiyat){
        this.seferNo = seferNo;
        this.kalkis = kalkis;
        this.varis = varis;
        this.tarih = tarih;
        this.saat = saat;
        this.fiyat = fiyat;
        
        this.koltuklar = new Bilet[30];
        
        this.next = null;   
    }
}
