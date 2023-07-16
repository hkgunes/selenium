1.	Proje java da spring boot framework ile yazılmış olup test koşumu için testng, selenium kullandım.
2.	 kodlar "src/main/test/java/tr/com/demoApp/e2e/demoe2e" altında bulunmaktadır. 
       3.Testler  "module" kısmında  bulunmaktadır. maddelere göre classların sonuna numaraları eklenmiştir.
4.	Driver projenin altında "externals" klasörunun altında bulunmaktadır.
5.	 Proje nin demo-e2e\src\main\resources altında application.yaml ve testng.xml dosyası bulunur.  
       testng.xml dosyasında koşulacak testler bulunur._~~****
       application.yml
       app:
       baseUrl: https://useinsider.com/
       select: chrome  --> chrome yada firefox yazarak browser  seçimi yapılır.
       driver:
       path: externals/drivers/chromedriver.exe
       type: webdriver.chrome.driver
       driverClass: org.openqa.selenium.chrome.ChromeDriver
       driverFirefox:
       path: externals/drivers/geckodriver.exe
       type: webdriver.gecko.driver
       driverClass: org.openqa.selenium.firefox.FirefoxDriver
