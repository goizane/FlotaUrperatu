package kudeatzaileak;

public class Kudeatzaile {
	
	private static final Kudeatzaile kud = new Kudeatzaile();

	public static Kudeatzaile getInstantzia() {
		return kud;
	}
//euuuuuuuu
	private Kudeatzaile() {
		// Singleton patroia
	}
}