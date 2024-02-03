package org.Baseclass;


	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {

		public static WebDriver driver;
		
		public static void LaunchBrowser() {
			WebDriverManager.chromedriver().setup(); //import maven dependency in pom.xml
			driver = new ChromeDriver();
		}
		public static void windowMaximize() {
			driver.manage().window().maximize();
		}
		public static void launchURL(String url) {
			driver.get(url);
		}
		public static String pagetitle() {
			String title = driver.getTitle();
			return title;
		}
		public static void pageUrl() {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
		}
		public static void passText(String txt, WebElement we) {
			we.sendKeys(txt);
		}
		public static void closeEntireBrowser() {
			driver.quit();
		}
		public static void clickBtn(WebElement we) {
			we.click();
		}
		public static void Screenshot(String imgName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File image = ts.getScreenshotAs(OutputType.FILE);
			File f = new File("location + file name");
		FileUtils.copyFile(image, f);
		}
		public static Actions a;	
		
		public void moveToCursor(WebElement targetWebelement) {
			a = new Actions(driver);
			a.moveToElement(targetWebelement).perform();;
		}
		
		public void dragDrop(WebElement DragWebelement, WebElement DropWebelement) {
			a = new Actions(driver);
			a.dragAndDrop(DragWebelement,DropWebelement);
		}
		
		public static JavascriptExecutor js;
		
		public void scrollPage( WebElement targetelement) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", targetelement);
		}
		
		public void scroll( WebElement targetelement) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false)", targetelement);
		}
		
		public void excelRead(String s, int r, int c, String writeData ) throws IOException {
			File f = new File(s);
			Workbook wb = new XSSFWorkbook();
			Sheet S = wb.getSheet("new");	
			Row row = S.getRow(r);
			Cell cell = row.getCell(c);
			int cellType = cell.getCellType();
			
			String val = "";
			if(cellType ==1) {
				String value = cell.getStringCellValue();
				System.out.println(value );
			}
			else if(DateUtil.isCellDateFormatted(cell))
			{
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpD = new SimpleDateFormat("dd-MM-yy");
				String format = simpD.format(dateCellValue);
				System.out.println(format);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long)numericCellValue;
				String valueOf = String.valueOf(l);
				System.out.println(valueOf);
			}	
		}
		
			public void createSheet(String s, int r, int c, String writeData ) throws IOException {
				File f = new File(s);
				Workbook wb = new XSSFWorkbook();
				Sheet S = wb.createSheet("new");	
				Row row = S.createRow(r);
				Cell cell = row.createCell(c);
				cell.setCellValue(writeData);	
				FileOutputStream fos = new FileOutputStream(f);
				wb.write(fos);
			}
			public void createCell(String s, int r, int c, String writeData ) throws IOException {
				File f = new File(s);
				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fis);
				Sheet S = wb.getSheet("new");	
				Row row = S.getRow(r);
				Cell cell = row.createCell(c);
				cell.setCellValue(writeData);	
				FileOutputStream fos = new FileOutputStream(f);
				wb.write(fos);
			}
			public void createRow(String s,	int r, int c, String writeData ) throws IOException {
				File f = new File(s);
				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fis);
				Sheet S = wb.getSheet("new");	
				Row row = S.createRow(r);
				Cell cell = row.createCell(c);
				cell.setCellValue(writeData);	
				FileOutputStream fos = new FileOutputStream(f);
				wb.write(fos);
			}
			public void updateParticularCell(String s, int r, int c, String writeData, String exiData ) throws IOException {
				File f = new File(s);
				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fis);
				Sheet S = wb.getSheet("new");	
				Row row = S.getRow(r);
				Cell cell = row.getCell(c);
				String cellValue = cell.getStringCellValue();
				if(cellValue.equals(exiData))
				cell.setCellValue(writeData);	
				FileOutputStream fos = new FileOutputStream(f);
				wb.write(fos);
			}
	}



	


