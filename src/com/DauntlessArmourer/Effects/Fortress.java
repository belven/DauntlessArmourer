package com.DauntlessArmourer.Effects;

public class Fortress extends Effect
{
	public Fortress()
	{
		super();
	}

	public Fortress(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Grants a %d health shield after not getting hit for 10s";

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
			text = String.format(text, 100);
			break;
		}
		return text;
	}

}