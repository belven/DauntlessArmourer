package com.DauntlessArmourer.Effects;

public class NineLives extends Effect
{
	public NineLives()
	{
		super();
	}

	public NineLives(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{

		String text = "+%d%% chance to halve incoming damage.";
		String extraText = "\nThe first time you would be knocked out, stay up and heal for 400";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 5);
			break;
		case 2:
			text = String.format(text, 8);
			break;
		case 3:
			text = String.format(text, 12);
			break;
		case 4:
			text = String.format(text, 12);
			text += extraText;
			break;
		case 5:
			text = String.format(text, 16);
			text += extraText;
			break;
		case 6:
			text = String.format(text, 20);
			text += extraText + ", and become empowered for 10 seconds";
			break;
		}
		return text;
	}

}