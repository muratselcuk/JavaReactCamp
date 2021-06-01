Mernis servisini eklemek için
Projeye sağ tıklayıp New>Other>Web Service >Web Service Client kısmına tıklayıp yukarıda yazan Browse kısmına https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?wsdl yazıp finish diyin.

Service bağlı olası hataların olası çözümü için
Projeye sağ tıklayıp en altta Properties>Java Complier>Configure Workspace Settings...(Sağ üstte yazıyor tıklayın)>açılan sayfada Complier compliance level kısmını 1.8 yapın> ardından Use default compliance settings tikini kaldırın. Apply and Close diyin.

Console ekranında kırmızı olarak gelen hatanın çözümü için
Projeye sağ tık yapıp New>Folder diyip yeni bir klasör oluşturun.
Klasöre aşağıdaki linkten .zip dosyasını indirip, dosya içindeki her iki .jar dosyasını bu klasöre sürükleyip atın.
Ardından projeye sağ tıklayıp Properties>Java Build Path>Libraries(üst menü)>Add JARs(sağ yan menü)>proje içinde oluşturduğunuz klasöre girip içindeki her iki jar dosyasını aynı şekilde ekleyin.

Kaynak:

https://karcanozbal.medium.com/java-web-servis-client-mernis-kimlik-do%C4%9Frulama-sistemi-86163b6286f9
