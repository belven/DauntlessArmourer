package com.DauntlessArmourer.Effects;

public class Acidic extends Effect
{
	public Acidic()
	{
		super();
	}

	public Acidic(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Converts +%d%% of Part Damage to Wound Damage";
		String extraText = "\n+%d%% Part damage";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 30);
			break;
		case 2:
			text = String.format(text, 40);
			break;
		case 3:
			text = String.format(text, 50);
			break;
		case 4:
			text = String.format(text, 50);
			text += String.format(extraText, 10);
			break;
		case 5:
			text = String.format(text, 50);
			text += String.format(extraText, 15);
			break;
		case 6:
			text = String.format(text, 50);
			text += String.format(extraText, 20);
			break;
		}
		return text;
	}

}