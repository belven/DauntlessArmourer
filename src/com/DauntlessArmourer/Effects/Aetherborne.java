package com.DauntlessArmourer.Effects;

public class Aetherborne extends Effect
{
	public Aetherborne()
	{
		super();
	}

	public Aetherborne(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "25%% chance not to consume an Aether Vent charge on use. %d additional Aether Vent healing.";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 25);
			break;
		case 2:
			text = String.format(text, 50);
			break;
		case 3:
			text = String.format(text, 75);
			break;
		case 4:
			text = String.format(text, 100);
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