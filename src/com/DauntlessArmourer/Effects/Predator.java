package com.DauntlessArmourer.Effects;

public class Predator extends Effect
{
	public Predator()
	{
		super();
	}

	public Predator(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Deal %d%% damage after not getting hit for 15 seconds. Bonus removed when hit.";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 104);
			break;
		case 2:
			text = String.format(text, 108);
			break;
		case 3:
			text = String.format(text, 114);
			break;
		case 4:
			text = String.format(text, 120);
			break;
		case 5:
			text = String.format(text, 127);
			break;
		case 6:
			text = String.format(text, 135);
			break;
		}
		return text;
	}

}