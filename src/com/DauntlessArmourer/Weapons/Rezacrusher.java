package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class Rezacrusher extends Weapon
{

	public Rezacrusher(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.Hammer);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		return new ArrayList<>();
	}

	@Override
	public ArrayList<CellType> getCellTypes()
	{
		return new ArrayList<>(Arrays.asList(CellType.Power, CellType.Mobility));
	}

}
