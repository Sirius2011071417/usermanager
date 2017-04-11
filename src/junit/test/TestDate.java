package junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class TestDate {
	
	@Test
	public void test() throws ParseException {
		DateLocaleConverter dlc = new DateLocaleConverter();
		System.out.println(dlc.convert("2017-02-16", "yyyy-MM-dd"));
	}
}
