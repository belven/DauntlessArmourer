package com.DauntlessArmourer.Armour;

import java.util.ArrayList;
import java.util.Arrays;

import com.DauntlessArmourer.ArmourerFactory;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class KoshaiLegs extends Armour
{

	public KoshaiLegs(int newLevel)
	{
		super(newLevel, Slot.Legs);
	}

	@Override
	public ArrayList<Effect> getEffects()
	{
		ArrayList<Effect> effects = new ArrayList<>();

		Effect effect1 = ArmourerFactory.getEffectByName("EvasiveFury", 1);
		Effect effect2 = ArmourerFactory.getEffectByName("Predator", 1);

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
		return new ArrayList<>(Arrays.asList(CellType.Utility));
	}
}
