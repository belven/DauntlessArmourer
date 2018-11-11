package com.DauntlessArmourer.Effects;

public class Cunning extends Effect
{
	public Cunning()
	{
		super();
	}

	public Cunning(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "%d%% chance to deal double damage";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 1);
			break;
		case 2:
			text = String.format(text, 2);
			break;
		case 3:
			text = String.format(text, 3);
			break;
		case 4:
			text = String.format(text, 5);
			break;
		case 5:
			text = String.format(text, 7);
			break;
		case 6:
			text = String.format(text, 10);
			break;
		}
		return text;
	}

}