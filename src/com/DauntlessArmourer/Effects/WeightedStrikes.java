package com.DauntlessArmourer.Effects;

public class WeightedStrikes extends Effect
{
	public WeightedStrikes()
	{
		super();
	}

	public WeightedStrikes(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%d Stagger Damage on Hit.";
		String extraText = "\n+%d Stagger after dodging through an attack";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 5);
			break;
		case 2:
			text = String.format(text, 10);
			break;
		case 3:
			text = String.format(text, 15);
			break;
		case 4:
			text = String.format(text, 20);
			text += String.format(extraText, 200);
			break;
		case 5:
			text = String.format(text, 30);
			text += String.format(extraText, 200);
			break;
		case 6:
			text = String.format(text, 40);
			text += String.format(extraText, 400);
			text += "\nRanged swings and missiles interrupt unstable Behemoth attacks";
			break;
		}
		return text;
	}

}