package otobusrezervasyon;

public class BiletYoneticisi {

	private Bilet[] koltuklar = new Bilet[30]; // 30 KİŞİLİK SABİT KOLTUK DİZİSİ (BİLET DİZİSİNİ TUTUYOR)

	public boolean biletKes(int koltukNo, Bilet bilet) { // BOŞ KOLTUĞA BİLET KESME / KAYDETME METODU
		if (koltukNo < 0 || koltukNo >= 30) { // 29 DAN BÜYÜK VEYA 0 DAN KÜÇÜK KOLTUK NUMARASINI DENETLEYEN İF CASE
			System.out.println("Geçersiz koltuk numarası! (0-29 arasında olmalıdır)");
			return false;
		}
		if (koltuklar[koltukNo] != null) { // KOLTUĞUN DOLU OLUP OLMADIĞINI KONTROL EDEN İF CASE
			System.out.println("Hata: Bu koltuk zaten dolu!");
			return false;
		}
		koltuklar[koltukNo] = bilet; // MÜSAİT OLAN KOLTUĞA BİLETİN KESİLME İŞLEMİ
		System.out.println(koltukNo + " numaralı koltuğa bilet başarıyla kesildi.");
		return true;
	}

	public boolean biletIptal(int koltukNo) { // BİLET İPTAL EDİLDİĞİNDE KOLTUĞU BOŞALTAN METOD
		if (koltukNo < 0 || koltukNo >= 30) { // 29 DAN BÜYÜK VEYA 0 DAN KÜÇÜK KOLTUK NUMARASINI DENETLEYEN İF CASE
			System.out.println("Geçersiz koltuk numarası! (0-29 arasında olmalıdır)");
			return false;
		}
		if (koltuklar[koltukNo] == null) { // KOLTUĞUN BOŞ OLUP OLMADIĞINI KONTROL EDEN İF CASE
			System.out.println("Hata: Bu koltuk zaten boş!");
			return false;
		}
		koltuklar[koltukNo] = null; // KOLTUĞU BOŞALT
		System.out.println(koltukNo + " numaralı koltuk iptal edildi ve boşaltıldı.");
		return true;
	}

	public void koltuklariGoster() { // BOŞ KOLTUKLARI GÖSTEREN METODUMUZ
		System.out.println("--- Otobüs Koltuk ve Bilet Durumları ---");
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

	// TEST 
	public static void main(String[] args) {
		BiletYoneticisi yonetici = new BiletYoneticisi();

		Yolcu yolcu1 = new Yolcu("11122233344", "Ahmet", "Yılmaz", "5551234567");
		Bilet bilet1 = new Bilet("B01", 5, yolcu1);

		yonetici.biletKes(5, bilet1);
		yonetici.koltuklariGoster();
	}

}
