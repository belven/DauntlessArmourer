package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.ArmourerFactory;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class BloodfireSaber extends Weapon
{

	public BloodfireSaber(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.Sword);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		ArrayList<Effect> effects = new ArrayList<>();

		Effect effect1 = ArmourerFactory.getEffectByName("WildFrenzy", 1);
		effects.add(effect1);
		return effects;
	}

	@Override
	public ArrayList<CellType> getCellTypes()
	{
		return new ArrayList<>(Arrays.asList(CellType.Technique, CellType.Mobility));
	}

}
