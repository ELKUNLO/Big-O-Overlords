package otobusrezervasyon;

public class Yolcu {

	private  final String tcNo;  // TC KİMLİK NUMARASI KİŞİYE AİTDİR DEĞİŞEMEZ O YÜZDEN FİNAL VE SET METODU BULUNMUYOR.
	private String ad; //KİŞİSEL BİLGİLER PRİVATE SAKLANIR
	private String soyad;//KİŞİSEL BİLGİLER PRİVATE SAKLANIR
	private String telefon;//KİŞİSEL BİLGİLER PRİVATE SAKLANIR

	public Yolcu(String tcNo, String ad, String soyad, String telefon) { 	//YAPILANDIRICI METODUMUZ.
		this.tcNo = tcNo;
		this.ad = ad;
		this.soyad = soyad;
		this.telefon = telefon;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getTcNo() {
		return tcNo;
	}

	public String toString() {		//NESNELERİ STRİNGE DÖNÜŞTÜRÜR VERİLERİ TXT DOSYASINDA SAKLAMAYI KOLAYLAŞTIRMAYI HEDEFLİYORUM
		return "Yolcu [tcNo=" + tcNo + ", ad=" + ad + ", soyad=" + soyad + ", telefon=" + telefon + "]";
	}
}
