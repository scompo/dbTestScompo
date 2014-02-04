package it.scompo.mydbtest;

/**
 * @author mscomparin
 *
 */
public class DemoMyDBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBInterface db = DBInterface.getInstance();
		db.getProperties();
	}

}
