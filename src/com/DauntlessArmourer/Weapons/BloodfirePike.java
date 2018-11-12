package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class BloodfirePike extends Weapon
{

	public BloodfirePike(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.Warpike);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		return new ArrayList<>();
	}

	@Override
	public ArrayList<CellType> getCellTypes()
	{
		return new ArrayList<>(Arrays.asList(CellType.Technique, CellType.Mobility));
	}

}
