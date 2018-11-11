package com.DauntlessArmourer.Effects;

public class Sturdy extends Effect
{
	public Sturdy()
	{
		super();
	}

	public Sturdy(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Prevents you from being staggered (%d second cooldown)";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 120);
			break;
		case 2:
			text = String.format(text, 100);
			break;
		case 3:
			text = String.format(text, 80);
			break;
		case 4:
			text = String.format(text, 60);
			break;
		case 5:
			text = String.format(text, 40);
			break;
		case 6:
			text = String.format(text, 15);
			break;
		}
		return text;
	}

}