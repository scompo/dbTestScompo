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
		List<Models> a = TestModel.readAll();
		for(Models m : a){
			System.out.println(m);
		}
		TestModel ricercato = (TestModel)TestModel.getModel(new Integer(1));
		System.out.println(ricercato);
		ricercato.first="test";
		ricercato.second="test2";
		ricercato.update();
		System.out.println(ricercato);
		ricercato.delete();
		a = TestModel.readAll();
		for(Models m : a){
			System.out.println(m);
		}
	}

}
