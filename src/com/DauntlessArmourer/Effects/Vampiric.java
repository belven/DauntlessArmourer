package com.DauntlessArmourer.Effects;

public class Vampiric extends Effect
{
	public Vampiric()
	{
		super();
	}

	public Vampiric(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Heal for %d whenever a Behemoth is Wounded";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 50);
			break;
		case 2:
			text = String.format(text, 75);
			break;
		case 3:
			text = String.format(text, 100);
			break;
		case 4:
			text = String.format(text, 125);
			break;
		case 5:
			text = String.format(text, 150);
			break;
		case 6:
			text = String.format(text, 200);
			break;
		}
		return text;
	}

}