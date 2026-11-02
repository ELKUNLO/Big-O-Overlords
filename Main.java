import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner girdi = new Scanner(System.in);
        DosyaYonetici dosyaIslemleri = new DosyaYonetici();
        dosyaIslemleri.verileriYukle();

        boolean devam = true;

        System.out.println("=====================================");
        System.out.println(" vy-012 otobus sefer ve bilet sistemi ");
        System.out.println("=====================================");

        while (devam){
            System.out.println("\n Bir islem sec:");
            System.out.println("1. seferleri goster");
            System.out.println("2. bilet islemleri (koltuk ayir / iptal");
            System.out.println("3. arama");
            System.out.println("4. kaydet ve cik");
            System.out.println("secim: ");

            int secim = girdi.nextInt();
            girdi.nextLine();

            switch(secim){
                case 1-> System.out.println("---seferler---");
                case 2-> System.out.println("---bilet islemleri---");
                case 3-> System.out.println("---arama---");
                case 4->{
                    System.out.println("kaydediliyor..");
                    dosyaIslemleri.verileriKaydet();
                    System.out.println("kaydedildi.");
                    devam = false;
                }
                default -> System.out.println("yanlis secim, 1 ile 4 arasi gir.");
            }
        }

        girdi.close();
    }
}