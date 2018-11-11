package com.DauntlessArmourer.Effects;

public class Deconstruction extends Effect
{
	public Deconstruction()
	{
		super();
	}

	public Deconstruction(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Deal %d%% damage to objects created by Behemoths";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 110);
			break;
		case 2:
			text = String.format(text, 120);
			break;
		case 3:
			text = String.format(text, 130);
			break;
		case 4:
			text = String.format(text, 150);
			break;
		case 5:
			text = String.format(text, 170);
			break;
		case 6:
			text = String.format(text, 200);
			break;
		}
		return text;
	}

}