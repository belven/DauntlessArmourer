package com.DauntlessArmourer.Effects;

public class Insulated extends Effect
{
	public Insulated()
	{
		super();
	}

	public Insulated(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = " 	Reduces duration of Shocked status by %d%%";
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
			text = String.format(text, 75);
			text += "\nReduces knockback and damage of hitting electrified shields";
			break;
		case 5:
			text = String.format(text, 75);
			text += "\nPrevents  knockback and damage of hitting electrified shields";
			break;
		case 6:
			text =  	"Immune to Shocked status";
			text += "\nPrevents  knockback and damage of hitting electrified shields";
			break;
		}
		return text;
	}

}