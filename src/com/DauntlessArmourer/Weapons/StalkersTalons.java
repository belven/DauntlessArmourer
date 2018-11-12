package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;

import com.DauntlessArmourer.ArmourerFactory;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class StalkersTalons extends Weapon
{
	public StalkersTalons(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.ChainBlades);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		ArrayList<Effect> effects = new ArrayList<>();

		effects.add(ArmourerFactory.getEffectByName("WildFrenzy", 1));

		return effects;
	}

	@Override
	public ArrayList<CellType> getCellTypes()
	{
		// Arrays.asList(CellType.Power, CellType.Utility) TODO
		return new ArrayList<>();
	}

}
