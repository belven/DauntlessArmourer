package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.ArmourerFactory;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class ShrowdSlicer extends Weapon
{

	public ShrowdSlicer(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.Sword);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		ArrayList<Effect> effects = new ArrayList<>();

		Effect effect1 = ArmourerFactory.getEffectByName("Cunning", 2);

		if (level >= 6)
		{
			effect1.setLevel(3);

		}

		effects.add(effect1);
		return effects;
	}

	@Override
	public ArrayList<CellType> getCellTypes()
	{
		return new ArrayList<>(Arrays.asList(CellType.Power, CellType.Utility));
	}

}
