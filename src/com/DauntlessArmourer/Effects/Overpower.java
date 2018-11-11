package com.DauntlessArmourer.Effects;

public class Overpower extends Effect
{
	public Overpower()
	{
		super();
	}

	public Overpower(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%d%% Damage vs Staggered Behemoths";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 10);
			break;
		case 2:
			text = String.format(text, 15);
			break;
		case 3:
			text = String.format(text, 20);
			break;
		case 4:
			text = String.format(text, 25);
			break;
		case 5:
			text = String.format(text, 30);
			break;
		case 6:
			text = String.format(text, 35);
			break;
		}
		return text;
	}

}