package com.DauntlessArmourer.Effects;

public class Ragehunter extends Effect
{
	public Ragehunter()
	{
		super();
	}

	public Ragehunter(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%d%% Damage vs Enraged Behemoths";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 5);
			break;
		case 2:
			text = String.format(text, 10);
			break;
		case 3:
			text = String.format(text, 20);
			break;
		case 4:
			text = String.format(text, 30);
			break;
		case 5:
			text = String.format(text, 40);
			break;
		case 6:
			text = String.format(text, 50);
			break;
		}
		return text;
	}

}