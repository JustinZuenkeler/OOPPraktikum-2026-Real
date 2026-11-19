package fileCreatorsZuenkeler;

public class ConcreteCreator extends ReaderCreatorZuenkeler{

	@Override
	public ReaderProductZuenkeler factoryMethod(String type) {
		if(type.equals("csv")){
			return new ConcreteCsvProduct();
		}
		else {
			return new ConcreteTxtProduct();

		}
	}
	
}
