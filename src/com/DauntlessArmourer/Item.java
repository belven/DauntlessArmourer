package com.DauntlessArmourer;

import java.util.ArrayList;

import com.DauntlessArmourer.Armour.Slot;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public abstract class Item
{
	protected int level = 0;
	Slot slot = Slot.Head;

	public Item(int newLevel, Slot newSlot)
	{
		this.level = newLevel;
		this.slot = newSlot;
	}

	public Slot getSlot()
	{
		return slot;
	}

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

}
