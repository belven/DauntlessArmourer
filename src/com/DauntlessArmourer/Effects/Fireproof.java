package com.DauntlessArmourer.Effects;

public class Fireproof extends Effect
{
	public Fireproof()
	{
		super();
	}

	public Fireproof(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Reduces duration of On Fire status by %d%%";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 10);
			break;
		case 2:
			text = String.format(text, 20);
			break;
		case 3:
			text = String.format(text, 40);
			break;
		case 4:
			text = String.format(text, 60);
			break;
		case 5:
			text = String.format(text, 80);
			break;
		case 6:
			text = "Immune to being set on fire. ";
			break;
		}
		return text;
	}

}