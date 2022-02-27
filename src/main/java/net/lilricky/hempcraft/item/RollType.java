package net.lilricky.hempcraft.item;

public enum RollType {
	JOINT(1, 15*20),
	CONE(2, 45*20),
	BLUNT(3, 135*20);

	public final int InstantDuration;
	public final int EffectDuration;

	RollType(int instantHealthDuration, int effectDuration) {
		this.InstantDuration = instantHealthDuration;
		this.EffectDuration = effectDuration;
	}

	@Override
	public String toString()
	{
		return super.toString().toLowerCase();
	}
}
