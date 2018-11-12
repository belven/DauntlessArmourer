package com.DauntlessArmourer.Weapons;

import com.DauntlessArmourer.Item;
import com.DauntlessArmourer.Armour.Slot;

public abstract class Weapon extends Item
{
	WeaponType type = WeaponType.None;

	public Weapon(int newLevel)
	{
		super(newLevel, Slot.Weapon);
	}

	public WeaponType getType()
	{
		return type;
	}

	public void setType(WeaponType type)
	{
		this.type = type;
	}
}