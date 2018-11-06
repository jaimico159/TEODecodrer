package testing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		System.out.println(format.parse("2018/7/20 3:9:41"));
		System.out.println(new Date());
	}
}
