package com.DauntlessArmourer.Effects;

public class Barbed extends Effect
{
	public Barbed()
	{
		super();
	}

	public Barbed(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%d wound damage on hit.";
		String extraText = "\nAfter dodging through an attack, the next attack's expose damage is increased by +%d";

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
			break;
		}
		return text;
	}

}