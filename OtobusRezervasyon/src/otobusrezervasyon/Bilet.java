package otobusrezervasyon;

public class Bilet {

	private String biletNo;
	private int koltukNo;
	private Yolcu yolcu;

	public Bilet(String biletNo, int koltukNo, Yolcu yolcu) {	//YAPILANDIRICI METODUMUZ.
		this.biletNo = biletNo;
		this.koltukNo = koltukNo;
		this.yolcu = yolcu;
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
