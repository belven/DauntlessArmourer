package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.ArmourerFactory;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class Moonsaber extends Weapon
{

	public Moonsaber(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.Sword);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		ArrayList<Effect> effects = new ArrayList<>();

		Effect effect1 = ArmourerFactory.getEffectByName("EvasiveFury", 1);
		effects.add(effect1);
		return effects;
	}

	@Override
	public ArrayList<CellType> getCellTypes()
	{
		return new ArrayList<>(Arrays.asList(CellType.Mobility, CellType.Mobility));
	}

}
