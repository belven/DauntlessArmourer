package com.DauntlessArmourer.Effects;

public class Conduit extends Effect
{
	public Conduit()
	{
		super();
	}

	public Conduit(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Using your lantern hold ability grants %d%% attack speed to all Slayers for 8 seconds.";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 5);
			break;
		case 2:
			text = String.format(text, 7);
			break;
		case 3:
			text = String.format(text, 10);
			break;
		case 4:
			text = String.format(text, 14);
			break;
		case 5:
			text = String.format(text, 19);
			break;
		case 6:
			text = String.format(text, 25);
			break;
		}
		return text;
	}

}