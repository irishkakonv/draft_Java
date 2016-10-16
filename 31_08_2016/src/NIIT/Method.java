package NIIT;

abstract class PieMaker{
	protected abstract String makeDough();
	protected abstract String addThings();
	protected void bake (String d, String t){
		System.out.println(d + " pie with " + t + " done.");
	}
	
	public void buildPie() {
		String dough = makeDough();
		String things = addThings();
		bake(dough, things);
	}
}

class BiscuitPie extends PieMaker{

	@Override
	protected String makeDough() {
		return "Biscuit";
	}

	@Override
	protected String addThings() {
		return "cherry";
	}
	
}


class ShortbreadPie extends PieMaker{

	@Override
	protected String makeDough() {
		return "Shortbread";
	}

	@Override
	protected String addThings() {
		return "raisins";
	}
	
}

public class Method {
	private static void makePie(PieMaker pm) {
		pm.buildPie();
	}
	
	public static void main(String[] args) {
		makePie(new BiscuitPie());
		makePie(new ShortbreadPie());
	}

}
