package otobusrezervasyon;

public class SiralamaArama {
public void fiyataGoreSirala(SeferListesi liste) {
		for (Sefer i = liste.head; i != null; i = i.next) {
			Sefer enKucuk = i;
			for (Sefer j = i.next; j != null; j = j.next) {
				if (j.fiyat < enKucuk.fiyat) {
					enKucuk = j;
				}
			}
			if (enKucuk != i) {
				takasEt(i, enKucuk);
			}
		}
	}

	public void saateGoreSirala(SeferListesi liste) {
		for (Sefer i = liste.head; i != null; i = i.next) {
			Sefer enErken = i;
			for (Sefer j = i.next; j != null; j = j.next) {
				if (dakikaya(j.saat) < dakikaya(enErken.saat)) {
					enErken = j;
				}
			}
			if (enErken != i) {
				takasEt(i, enErken);
			}
		}
	}

	private int dakikaya(String saat) { // "9:05" GİBİ SAATLER DE DOĞRU SIRALANSIN DİYE SAATİ DAKİKAYA ÇEVİRİR
		try {
			String[] parca = saat.split(":");
			return Integer.parseInt(parca[0].trim()) * 60 + Integer.parseInt(parca[1].trim());
		} catch (Exception e) {
			return Integer.MAX_VALUE; // HATALI SAAT YAZILMIŞSA LİSTENİN SONUNA GİDER
		}
	}

	private void takasEt(Sefer a, Sefer b) { // İKİ DÜĞÜMÜN VERİLERİNİ DEĞİŞTİRİR, next REFERANSLARINA DOKUNMAZ
		int seferNo = a.seferNo;		a.seferNo = b.seferNo;		b.seferNo = seferNo;
		String kalkis = a.kalkis;		a.kalkis = b.kalkis;		b.kalkis = kalkis;
		String varis = a.varis;			a.varis = b.varis;			b.varis = varis;
		String tarih = a.tarih;			a.tarih = b.tarih;			b.tarih = tarih;
		String saat = a.saat;			a.saat = b.saat;			b.saat = saat;
		double fiyat = a.fiyat;			a.fiyat = b.fiyat;			b.fiyat = fiyat;
		Bilet[] koltuklar = a.koltuklar; a.koltuklar = b.koltuklar;	b.koltuklar = koltuklar;
	}
public static void main(String[] args) {
		SeferListesi liste = new SeferListesi();
		liste.seferEkle(new Sefer(421, "Malatya", "Istanbul", "12/3/2027", "14:00", 2000));
		liste.seferEkle(new Sefer(422, "Malatya", "Bursa", "23/6/2027", "18:30", 2200));
		liste.seferEkle(new Sefer(423, "Ankara", "Izmir", "1/4/2027", "9:15", 1500));
		liste.seferEkle(new Sefer(424, "Malatya", "İstanbul", "13/3/2027", "07:45", 1800));

		BiletYoneticisi by = new BiletYoneticisi();
		Yolcu ahmet = new Yolcu("11122233344", "Ahmet", "Yılmaz", "5551234567");
		Yolcu ayse = new Yolcu("55566677788", "Ayşe", "Demir", "5559876543");
		by.biletKes(liste.seferBul(421), new Bilet(5, ahmet)); // B1
		by.biletKes(liste.seferBul(423), new Bilet(0, ayse)); // B2

		SiralamaArama sa = new SiralamaArama();

		sa.fiyataGoreSirala(liste);
		liste.seferleriGoruntule(); // 423, 424, 421, 422 BEKLENİYOR
		sa.saateGoreSirala(liste);
		liste.seferleriGoruntule(); // 424, 423, 421, 422 BEKLENİYOR
		System.out.println("423 koltuk 0: " + liste.seferBul(423).koltuklar[0].getYolcu()); // SIRALAMADAN SONRA HÂLÂ AYŞE
    }
}