package otobusrezervasyon;

public class Bilet {

	private static int sayac = 0; // KESİLEN EN BÜYÜK BİLET NUMARASI. TÜM BİLETLER İÇİN ORTAK (STATİC) OLDUĞU İÇİN AYNI NUMARA İKİ KEZ VERİLMEZ.

	private String biletNo;
	private int koltukNo;
	private Yolcu yolcu;

	public Bilet(int koltukNo, Yolcu yolcu) {	//YENİ BİLET İÇİN YAPILANDIRICI. BİLET NUMARASI OTOMATİK VERİLİR (B1, B2, B3...)
		this("B" + (sayac + 1), koltukNo, yolcu);
	}

	public Bilet(String biletNo, int koltukNo, Yolcu yolcu) {	//BİLET NUMARASI BELLİ OLAN BİLET İÇİN (ÖRN. DOSYADAN YÜKLERKEN)
		this.biletNo = biletNo;
		this.koltukNo = koltukNo;
		this.yolcu = yolcu;
		sayacGuncelle(biletNo);
	}

	private static void sayacGuncelle(String biletNo) { // DOSYADAN B7 GİBİ BİR BİLET YÜKLENİRSE SONRAKİ YENİ BİLET B8 DEN DEVAM ETSİN DİYE SAYACI İLERLETİR
		if (biletNo == null || !biletNo.startsWith("B")) {
			return;
		}
		try {
			int numara = Integer.parseInt(biletNo.substring(1));
			if (numara > sayac) {
				sayac = numara;
			}
		} catch (NumberFormatException e) {
			// B İLE BAŞLAYIP SAYI İLE DEVAM ETMEYEN NUMARALAR SAYACI ETKİLEMEZ
		}
	}

	public String getBiletNo() {
		return biletNo;
	}

	public int getKoltukNo() {
		return koltukNo;
	}

	public Yolcu getYolcu() {
		return yolcu;
	}

}
