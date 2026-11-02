# Big-O-Overlords — Otobüs Sefer ve Bilet Rezervasyon Sistemi

## Proje Tanımı

Bir otobüs firmasının seferlerini ve bilet satışlarını yöneten, konsol tabanlı bir Java uygulamasıdır. Kullanıcı seferleri listeleyebilir, yeni sefer ekleyip silebilir, seçtiği seferde boş bir koltuğa bilet alabilir veya biletini iptal edebilir. Seferler fiyata ya da kalkış saatine göre sıralanabilir, bilet numarası veya yolcu adına göre arama yapılabilir. Tüm veriler program kapanırken bir metin dosyasına kaydedilir ve program açılırken geri yüklenir.

## Kullanılan Teknolojiler

| Alan | Seçim |
|---|---|
| Dil | Java |
| Arayüz | Konsol (metin tabanlı menü). Swing / JavaFX kullanılmayacaktır. |
| Veri saklama | Projeye özel uzantılı metin dosyası |
| IDE | NetBeans, Eclipse |
| Sürüm kontrolü | Git & GitHub |

## Ekip Üyeleri ve İş Bölümü

| # | Üye | GitHub | Sorumluluk | Veri yapısı / konu |
|---|---|---|---|---|
| 1 | Omar (Takım Lideri) | [@ELKUNLO](https://github.com/ELKUNLO) | Sefer Yönetimi | Tek yönlü bağlı liste |
| 2 | Arda | [@ardaxyz](https://github.com/ardaxyz) | Koltuk ve Yolcu/Bilet Yönetimi | Sabit boyutlu dizi |
| 3 | *[Ad Soyad]* | *[@kullanici]* | Sıralama, Arama ve Dokümantasyon | Selection Sort, doğrusal arama |
| 4 | HASAN Alhusen | [@hasaneng2007] | Dosya İşlemleri ve Ana Menü | Dosya okuma/yazma |

### 1. Öğrenci (Takım Lideri) — Sefer Yönetimi
- [x] `Sefer` sınıfı (Sefer No, Kalkış, Varış, Tarih, Saat, Bilet Fiyatı)
- [x] Seferleri birbirine bağlayan bağlı liste yapısı (`SeferListesi`)
- [x] Yeni sefer ekleme ve tüm seferleri listeleme
- [x] Üzerinde satılmış aktif bilet bulunmayan seferi silme

### 2. Öğrenci — Koltuk ve Yolcu/Bilet Yönetimi
- [x] `Yolcu` (Ad, Soyad, TC No, İletişim) ve `Bilet` (Bilet No, Koltuk No, Yolcu) sınıfları
- [x] Her otobüs için 30 kişilik sabit koltuk dizisinin (`Bilet[] koltuklar`) yönetimi
- [x] Boş koltuğa bilet kesme, iptalde koltuğu boşaltma (`null`), boş/dolu koltukları gösterme (`BiletYoneticisi`)

### 3. Öğrenci — Sıralama, Arama ve Dokümantasyon
- [ ] Seferleri bilet fiyatına veya kalkış saatine göre sıralama (Selection Sort)
- [ ] Bilet numarasına veya yolcu adına göre arama, sefer sorgulama
- [ ] README dosyası ve test için örnek sefer/yolcu verileri

### 4. Öğrenci — Dosya İşlemleri ve Ana Menü
- [ ] Program açılırken dosyadaki verileri okuyup bağlı liste ve dizilere yükleme
- [ ] Çıkışta veya "Kaydet" seçildiğinde tüm verileri dosyaya yeniden yazma
- [ ] Konsol ana menüsü (1: Seferleri Listele, 2: Bilet Al, 3: Arama Yap, 4: Kaydet ve Çık, …)

## Temel İşlevler ve Kullanılan Veri Yapıları

| İşlev | Veri yapısı | Neden tercih edildi? |
|---|---|---|
| Seferleri saklama, ekleme, silme, listeleme | **Tek yönlü bağlı liste** (`SeferListesi`, düğüm: `Sefer`) | Sefer sayısı önceden belli değildir ve sürekli değişir. Bağlı liste ihtiyaç kadar büyür, ortadan sefer silerken dizideki gibi elemanları kaydırmak gerekmez; yalnızca bağlantılar güncellenir. |
| Bir seferin koltuklarını yönetme | **Sabit boyutlu dizi** (`Bilet[30]`) | Otobüsün kapasitesi sabittir (30 koltuk). Koltuk numarası doğrudan dizi indeksi olarak kullanıldığından bir koltuğa erişmek, dolu/boş kontrolü yapmak ve bilet kesmek O(1) sürer. Boş koltuk `null` ile gösterilir. |
| Seferleri fiyata / kalkış saatine göre sıralama | **Selection Sort** | Sefer sayısı küçük olduğu için O(n²) maliyet sorun yaratmaz. Ek bellek gerektirmez ve derste işlendiği için anlaşılması ve anlatılması kolaydır. |
| Bilet no / yolcu adına göre arama | **Doğrusal arama** | Bağlı listede indeksle doğrudan erişim olmadığından liste baştan sona gezilir; her seferin koltuk dizisi de aynı şekilde taranır. |
| Verileri kalıcı saklama | **Metin dosyası** | Bağlı liste ve diziler programın her açılışında dosyadan yeniden oluşturulur; kapanışta dosya baştan yazılır. |

## Sınıf Diyagramı (UML)

```mermaid
classDiagram
    direction LR

    class Sefer {
        +int seferNo
        +String kalkis
        +String varis
        +String tarih
        +String saat
        +double fiyat
        +Bilet[] koltuklar
        +Sefer next
    }

    class SeferListesi {
        +Sefer head
        +seferEkle(Sefer yeniSefer) void
        +seferleriGoruntule() void
        +seferBul(int seferNo) Sefer
        +seferSil(int seferNo) boolean
    }

    class Yolcu {
        -String tcNo
        -String ad
        -String soyad
        -String telefon
        +getAd() String
        +getSoyad() String
        +getTelefon() String
        +getTcNo() String
        +toString() String
    }

    class Bilet {
        -String biletNo
        -int koltukNo
        -Yolcu yolcu
        +getBiletNo() String
        +getKoltukNo() int
        +getYolcu() Yolcu
    }

    class BiletYoneticisi {
        +biletKes(Sefer sefer, Bilet bilet) boolean
        +biletIptal(Sefer sefer, int koltukNo) boolean
        +koltuklariGoster(Sefer sefer) void
        +doluKoltukSayisi(Sefer sefer) int
    }

    class SiralamaArama {
        +fiyataGoreSirala(SeferListesi liste) void
        +saateGoreSirala(SeferListesi liste) void
        +biletNoIleAra(SeferListesi liste, String biletNo) Bilet
        +yolcuAdiIleAra(SeferListesi liste, String ad) void
    }

    class DosyaYoneticisi {
        +verileriYukle(String dosyaYolu) SeferListesi
        +verileriKaydet(SeferListesi liste, String dosyaYolu) void
    }

    class OtobusRezervasyon {
        +main(String[] args) void
    }

    SeferListesi --> Sefer
    Sefer --> Bilet
    Bilet --> Yolcu
    BiletYoneticisi ..> Sefer
    BiletYoneticisi ..> Bilet
    SiralamaArama ..> SeferListesi
    DosyaYoneticisi ..> SeferListesi
    OtobusRezervasyon ..> SeferListesi
    OtobusRezervasyon ..> BiletYoneticisi
