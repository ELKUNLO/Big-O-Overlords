package otobusrezervasyon;

public class SeferListesi {

    Sefer head;   //listenin başı (birinci sefere işaret etmek için)

    public SeferListesi() {
        this.head = null;
    }

    public void seferEkle(Sefer yeniSefer) {

        if (head == null) {
            head = yeniSefer;
        } else {
            Sefer temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = yeniSefer;
        }

    }

    public void seferleriGoruntule() {
        if (head == null) {
            System.out.println("sefer bulunmamaktadr");
            return;
        }

        Sefer temp = head;
        System.out.println("\n --- MEVCUT SEFERLER ---");
        while (temp != null) {
            System.out.println("Sefer No : " + temp.seferNo
                    + " |Guzergah : " + temp.kalkis + " -> " + temp.varis
                    + " |Tarih : " + temp.tarih
                    + " |Saat : " + temp.saat
                    + " |Fiyat : " + temp.fiyat + " TL");
            temp = temp.next;
        }
        System.out.println(" --------------------------\n");
    }

    public Sefer seferBul(int seferNo) {   //sefer numarasina gore listeyi bastan sona gezer, bulamazsa null doner
        Sefer temp = head;
        while (temp != null) {
            if (temp.seferNo == seferNo) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean seferSil(int seferNo) {
        if (head == null) {
            System.out.println("Hata... : sefer listesi bos, silinecek sefer yok");
            return false;
        }

        BiletYoneticisi by = new BiletYoneticisi();

        if (head.seferNo == seferNo) {
            if (by.doluKoltukSayisi(head) > 0) {
                System.out.println("Hata: " + seferNo + " numarali seferde satilmis biletler var, silinmez");
                return false;
            }
            head = head.next;
            System.out.println(seferNo + " numarali sefer basariyla silindi");
            return true;
        }

        Sefer temp = head;
        while (temp.next != null && temp.next.seferNo != seferNo) {
            temp = temp.next;
        }
        
        if(temp.next == null){
            System.out.println("Hata : " + seferNo + " numarali sefer bulunmadi");
            return false;
        }
        
        if(by.doluKoltukSayisi(temp.next) > 0){
            System.out.println("Hata: " + seferNo + "numarali seferde satilmis biletler var, silinmez!");
            return false;
        }
        
        temp.next = temp.next.next;
        System.out.println(seferNo + " numarali sefer basariyla silindi");
        return true;
    }
}
