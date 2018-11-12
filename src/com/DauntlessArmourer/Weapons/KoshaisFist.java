package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.ArmourerFactory;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class KoshaisFist extends Weapon
{

	public KoshaisFist(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.Hammer);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		ArrayList<Effect> effects = new ArrayList<>();

		effects.add(ArmourerFactory.getEffectByName("Sharpened", 1));

		return effects;
	}

	@Override
	public ArrayList<CellType> getCellTypes()
	{
		return new ArrayList<>(Arrays.asList(CellType.Power, CellType.Utility));
	}

}
