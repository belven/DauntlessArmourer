package com.DauntlessArmourer.Effects;

public class Merciless extends Effect
{
	public Merciless()
	{
		super();
	}

	public Merciless(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%d Wound Damage vs Staggered Behemoths";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 25);
			break;
		case 2:
			text = String.format(text, 40);
			break;
		case 3:
			text = String.format(text, 55);
			break;
		case 4:
			text = String.format(text, 70);
			break;
		case 5:
			text = String.format(text, 85);
			break;
		case 6:
			text = String.format(text, 100);
			break;
		}
		return text;
	}

}