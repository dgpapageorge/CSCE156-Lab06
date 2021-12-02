package unl.cse;

/**
 * Demo driver class for the polymorphism activities
 *
 */
public class CourseDemo {

	public static void main(String args[]) {
		
		Undergraduate luke = new Undergraduate("1234", "Skywalker", "Luke");
		Undergraduate wedge = new Undergraduate("5678", "Antilles", "Wedge");
		
		Graduate ben = new Graduate("4411", "Kenobi", "Ben");
		Graduate mace = new Graduate("0021", "Windu", "Mace");
		
		Droid c3po = new Droid("C3PO", "Protocol");
		Droid r2d2 = new Droid("R2D2", "Astromech");
		

		Course<Undergraduate> c = new Course<Undergraduate>("CSCE", "156");		
		
		Section<Undergraduate> under = new Section<Undergraduate>("1324");
		Section<Graduate> grad = new Section<Graduate>("9812");
		
		under.enroll(luke);
		under.enroll(wedge);
		grad.enroll(ben);
		grad.enroll(mace);
		under.enroll(mace);
		under.enroll(c3po);
		grad.enroll(luke);
		
		c.addSection(under);
		c.addSection(grad);
		
		System.out.println(c);
		
	}
}
