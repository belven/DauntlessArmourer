package com.DauntlessArmourer.Effects;

public class Agility extends Effect
{
	public Agility()
	{
		super();
	}

	public Agility(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "-%d%% Dodge Roll Stamina Cost";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 10);
			break;
		case 2:
			text = String.format(text, 20);
			break;
		case 3:
			text = String.format(text, 30);
			break;
		case 4:
			text = String.format(text, 40);
			break;
		case 5:
			text = String.format(text, 55);
			break;
		case 6:
			text = String.format(text, 70);
			break;
		}
		return text;
	}

}