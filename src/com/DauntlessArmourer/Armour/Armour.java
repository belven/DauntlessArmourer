package com.DauntlessArmourer.Armour;

import java.util.ArrayList;

import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public abstract class Armour
{
	int level = 0;
	Slot slot = Slot.Head;

	public Armour(int newLevel, Slot newSlot)
	{
		this.level = newLevel;
		this.slot = newSlot;
	}

	public abstract ArrayList<Effect> getEffects();

	public abstract ArrayList<CellType> getCellTypes();

	public String getName()
	{
		return this.getClass().getSimpleName();
	}

}