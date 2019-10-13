import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class regex_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar date = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		//System.out.println(sdf.format(date.getTime()));
		date.add(Calendar.DAY_OF_YEAR, -3);
		System.out.println(sdf.format(date.getTime()));
	}
	
}
