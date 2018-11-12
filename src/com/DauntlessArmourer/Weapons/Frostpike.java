package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.ArmourerFactory;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class Frostpike extends Weapon
{

	public Frostpike(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.Warpike);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		ArrayList<Effect> effects = new ArrayList<>();

		Effect effect1 = ArmourerFactory.getEffectByName("WeightedStrikes", 1);
		Effect effect2 = ArmourerFactory.getEffectByName("Aetherhunter", 2);

		if (level >= 6)
		{
			effect1.setLevel(2);

		}

		effects.add(effect1);
		effects.add(effect2);

		return effects;
	}

	@Override
	public ArrayList<CellType> getCellTypes()
	{
		return new ArrayList<>(Arrays.asList(CellType.Technique, CellType.Defence));
	}

}
