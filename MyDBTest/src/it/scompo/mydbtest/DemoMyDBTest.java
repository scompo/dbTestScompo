package it.scompo.mydbtest;

import java.util.List;

import it.scompo.mydbtest.models.TestModel;

/**
 * @author mscomparin
 *
 */
public class DemoMyDBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestModel model = new TestModel();
		model.createTableInDB();
		model.first ="test_first";
		model.second ="test_second";
		model.create();
		List<Models> a = model.readAll();
		for(Models m : a){
			System.out.println(m);
		}
		Models ricercato = model.getModel(new Integer(1));
		System.out.println(ricercato);
	}

}
