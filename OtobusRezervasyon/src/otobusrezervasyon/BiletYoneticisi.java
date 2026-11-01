package otobusrezervasyon;

public class BiletYoneticisi {

	// KOLTUK DİZİSİ HER SEFERİN İÇİNDE (Sefer.koltuklar). METOTLAR HANGİ SEFER ÜZERİNDE ÇALIŞACAKLARINI PARAMETRE OLARAK ALIYOR.

	public boolean biletKes(Sefer sefer, Bilet bilet) { // SEÇİLEN SEFERDEKİ BOŞ KOLTUĞA BİLET KESME / KAYDETME METODU
		if (sefer == null) { // SEFERİN BULUNUP BULUNMADIĞINI KONTROL EDEN İF BLOĞU
			System.out.println("Hata: Sefer bulunamadı!");
			return false;
		}
		if (bilet == null) { // BOŞ (NULL) BİLETİN KOLTUĞA YAZILIP BAŞARILI SAYILMASINI ENGELLEYEN İF BLOĞU
			System.out.println("Hata: Bilet bilgisi boş!");
			return false;
		}
		int koltukNo = bilet.getKoltukNo(); // KOLTUK NUMARASI BİLETİN İÇİNDEN ALINIR, BÖYLECE BİLET VE DİZİ İNDEKSİ HEP AYNI KALIR
		Bilet[] koltuklar = sefer.koltuklar;
		if (koltukNo < 0 || koltukNo >= koltuklar.length) { // DİZİ SINIRLARI DIŞINDAKİ VEYA 0 DAN KÜÇÜK KOLTUK NUMARASINI DENETLEYEN İF BLOĞU
			System.out.println("Geçersiz koltuk numarası! (0-" + (koltuklar.length - 1) + " arasında olmalıdır)");
			return false;
		}
		if (koltuklar[koltukNo] != null) { // KOLTUĞUN DOLU OLUP OLMADIĞINI KONTROL EDEN İF BLOĞU
			System.out.println("Hata: Bu koltuk zaten dolu!");
			return false;
		}
		koltuklar[koltukNo] = bilet; // MÜSAİT OLAN KOLTUĞA BİLETİN KESİLME İŞLEMİ
		System.out.println(sefer.seferNo + " numaralı seferde " + koltukNo + " numaralı koltuğa bilet başarıyla kesildi. (Bilet No: "
				+ bilet.getBiletNo() + ")");
		return true;
	}

	public boolean biletIptal(Sefer sefer, int koltukNo) { // BİLET İPTAL EDİLDİĞİNDE SEÇİLEN SEFERDEKİ KOLTUĞU BOŞALTAN METOD
		if (sefer == null) { // SEFERİN BULUNUP BULUNMADIĞINI KONTROL EDEN İF BLOĞU
			System.out.println("Hata: Sefer bulunamadı!");
			return false;
		}
		Bilet[] koltuklar = sefer.koltuklar;
		if (koltukNo < 0 || koltukNo >= koltuklar.length) { // DİZİ SINIRLARI DIŞINDAKİ VEYA 0 DAN KÜÇÜK KOLTUK NUMARASINI DENETLEYEN İF BLOĞU
			System.out.println("Geçersiz koltuk numarası! (0-" + (koltuklar.length - 1) + " arasında olmalıdır)");
			return false;
		}
		if (koltuklar[koltukNo] == null) { // KOLTUĞUN BOŞ OLUP OLMADIĞINI KONTROL EDEN İF BLOĞU
			System.out.println("Hata: Bu koltuk zaten boş!");
			return false;
		}
		koltuklar[koltukNo] = null; // KOLTUĞU BOŞALT
		System.out.println(sefer.seferNo + " numaralı seferde " + koltukNo + " numaralı koltuk iptal edildi ve boşaltıldı.");
		return true;
	}

	public void koltuklariGoster(Sefer sefer) { // SEÇİLEN SEFERİN BOŞ/DOLU KOLTUKLARINI GÖSTEREN METODUMUZ
		if (sefer == null) { // SEFERİN BULUNUP BULUNMADIĞINI KONTROL EDEN İF BLOĞU
			System.out.println("Hata: Sefer bulunamadı!");
			return;
		}
		Bilet[] koltuklar = sefer.koltuklar;
		System.out.println("--- " + sefer.seferNo + " Numaralı Sefer (" + sefer.kalkis + " -> " + sefer.varis
				+ ") Koltuk ve Bilet Durumları ---");
		for (int i = 0; i < koltuklar.length; i++) { // KOLTUKLAR İSİMLİ DİZİYİ BAŞTAN SONA GEZİYOR BOŞ OLUP OLMADIĞINI
														// KONTROL EDİYOR
			if (koltuklar[i] == null) {
				System.out.println("Koltuk " + i + ": [BOŞ]");
			} else {
				System.out.println("Koltuk " + i + ": [DOLU] - Yolcu: " + koltuklar[i].getYolcu().getAd() + " "
						+ koltuklar[i].getYolcu().getSoyad() + " (Bilet No: " + koltuklar[i].getBiletNo() + ")");
			}
		}
	}

	public int doluKoltukSayisi(Sefer sefer) { // SEFERDE SATILMIŞ BİLET SAYISINI DÖNDÜRÜR (AKTİF BİLETİ OLAN SEFER SİLİNMESİN DİYE seferSil İÇİN)
		if (sefer == null) {
			return 0;
		}
		int sayi = 0;
		for (int i = 0; i < sefer.koltuklar.length; i++) { // DİZİYİ GEZİP NULL OLMAYAN (DOLU) KOLTUKLARI SAYIYOR
			if (sefer.koltuklar[i] != null) {
				sayi++;
			}
		}
		return sayi;
	}

	// TEST
	public static void main(String[] args) {
		SeferListesi liste = new SeferListesi();
		liste.seferEkle(new Sefer(421, "Malatya", "Istanbul", "12/3/2027", "14:00", 2000));
		liste.seferEkle(new Sefer(422, "Malatya", "Bursa", "23/6/2027", "18:30", 2200));

		BiletYoneticisi yonetici = new BiletYoneticisi();

		Yolcu yolcu1 = new Yolcu("11122233344", "Ahmet", "Yılmaz", "5551234567");
		Yolcu yolcu2 = new Yolcu("55566677788", "Ayşe", "Demir", "5559876543");
		Yolcu yolcu3 = new Yolcu("66644499911", "Mehmet", "Kul", "5554592144");

		Sefer istanbul = liste.seferBul(421);
		Sefer bursa = liste.seferBul(422);

		yonetici.biletKes(istanbul, new Bilet(5, yolcu1)); // BİLET NO OTOMATİK: B1
		yonetici.biletKes(bursa, new Bilet(5, yolcu2)); // AYNI KOLTUK NO FARKLI SEFERDE BOŞ OLMALI, BİLET NO: B2
		yonetici.biletKes(istanbul, new Bilet(5, yolcu2)); // DOLU KOLTUK HATASI BEKLENİYOR
		yonetici.biletKes(istanbul, new Bilet(30, yolcu2)); // GEÇERSİZ KOLTUK HATASI BEKLENİYOR
		yonetici.biletKes(liste.seferBul(999), new Bilet(1, yolcu2)); // OLMAYAN SEFER HATASI BEKLENİYOR
		yonetici.biletKes(istanbul, null); // BOŞ BİLET HATASI BEKLENİYOR

		Bilet dosyadanGelen = new Bilet("B20", 7, yolcu3); // DOSYADAN YÜKLENMİŞ GİBİ, SONRAKİ YENİ BİLET B21 OLMALI
		yonetici.biletKes(bursa, dosyadanGelen);
		yonetici.biletKes(bursa, new Bilet(8, yolcu1));

		yonetici.koltuklariGoster(istanbul);
		yonetici.koltuklariGoster(bursa);
		System.out.println("421 dolu koltuk sayısı: " + yonetici.doluKoltukSayisi(istanbul)); // 1 BEKLENİYOR
		System.out.println("422 dolu koltuk sayısı: " + yonetici.doluKoltukSayisi(bursa)); // 3 BEKLENİYOR

		yonetici.biletIptal(istanbul, 5);
		yonetici.biletIptal(istanbul, 5); // ZATEN BOŞ HATASI BEKLENİYOR
		System.out.println("421 dolu koltuk sayısı: " + yonetici.doluKoltukSayisi(istanbul)); // 0 BEKLENİYOR
		
		System.out.println("Bilet sahibi: " + yolcu1);
		System.out.println("Bilet sahibi: " + yolcu2);
		System.out.println("Bilet sahibi: " + yolcu3);
	}

}
