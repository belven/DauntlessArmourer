package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class Rezakatana extends Weapon
{

	public Rezakatana(int newLevel)
	{
		super(newLevel);
		setType(WeaponType.Sword);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		return new ArrayList<>();
	}

	@Override
	public ArrayList<CellType> getCellTypes()
	{
		return new ArrayList<>(Arrays.asList(CellType.Technique, CellType.Utility));
	}

}
