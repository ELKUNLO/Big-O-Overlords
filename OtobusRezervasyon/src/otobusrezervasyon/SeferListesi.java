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
}
