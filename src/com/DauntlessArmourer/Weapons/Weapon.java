package com.DauntlessArmourer.Weapons;

import java.util.ArrayList;

import com.DauntlessArmourer.Armour.Slot;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public abstract class Weapon
{
	int level = 0;
	Slot slot = Slot.Weapon;
	WeaponType type = WeaponType.None;

	public abstract ArrayList<Effect> getEffects();

	public abstract ArrayList<CellType> getCellTypes();

	public String getName()
	{
		return this.getClass().getSimpleName();
	}

	public void setLevel(int newLevel)
	{
		this.level = newLevel;
	}

	public Weapon(int newLevel)
	{
		this.level = newLevel;
	}

	public WeaponType getType()
	{
		return type;
	}

	public void setType(WeaponType type)
	{
		this.type = type;
	}

	public Slot getSlot()
	{
		return slot;
	}
}