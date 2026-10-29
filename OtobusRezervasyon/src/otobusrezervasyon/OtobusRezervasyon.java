package otobusrezervasyon;

public class OtobusRezervasyon {

    public static void main(String[] args) {
        
        SeferListesi Liste = new SeferListesi();
        
        Liste.seferleriGoruntule();
        
        Sefer sefer_1 = new Sefer(421, "Malatya", "Istanbul", "12/3/2027", "14:00", 2000);
        Sefer sefer_2 = new Sefer(421, "Malatya", "Bursa", "23/6/2027", "18:30", 2200);
        
        Liste.seferEkle(sefer_1);
        Liste.seferEkle(sefer_2);
        
        Liste.seferleriGoruntule();
    }
    
}
