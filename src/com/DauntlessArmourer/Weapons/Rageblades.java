package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.ArmourerFactory;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class Rageblades extends Weapon
{

	public Rageblades(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.ChainBlades);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		ArrayList<Effect> effects = new ArrayList<>();

		Effect effect1 = ArmourerFactory.getEffectByName("Rage", 1);
		Effect effect2 = ArmourerFactory.getEffectByName("Ragehunter", 2);

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
		return new ArrayList<>(Arrays.asList(CellType.Technique, CellType.Utility));
	}

}
