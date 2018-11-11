package com.DauntlessArmourer.Effects;

public class Medic extends Effect
{
	public Medic()
	{
		super();
	}

	public Medic(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "When reviving an ally, they are healed an additional %d%%.";
		String extraText = "\nIncreases Revive Speed by 66%";

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
			text += extraText;
			break;
		case 5:
			text = String.format(text, 30);
			text += extraText;
			break;
		case 6:
			text = String.format(text, 40);
			text += extraText;
			text += "\nGrants a 300 health shield for 20 seconds after reviving an ally. ";
			break;
		}
		return text;
	}

}