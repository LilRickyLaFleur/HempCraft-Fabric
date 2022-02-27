import net.minecraft.util.Rarity;

public enum Grade {
	A(Rarity.COMMON),
	AA(Rarity.UNCOMMON), 
	AAA(Rarity.RARE);

	public final rarity

	Grade(Rarity rarity) {
		this.rarity = rarity;
	}
}