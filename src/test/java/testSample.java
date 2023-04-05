import java.io.FileNotFoundException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		DataDriven d=new DataDriven();
		ArrayList data=d.getData("Purchange");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		}

}
