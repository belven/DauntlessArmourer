package com.DauntlessArmourer.Effects;

public class Tough extends Effect
{
	public Tough()
	{
		super();
	}

	public Tough(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Increases Max Health by %d";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 50);
			break;
		case 2:
			text = String.format(text, 100);
			break;
		case 3:
			text = String.format(text, 150);
			break;
		case 4:
			text = String.format(text, 250);
			break;
		case 5:
			text = String.format(text, 350);
			break;
		case 6:
			text = String.format(text, 500);
			break;
		}
		return text;
	}

}