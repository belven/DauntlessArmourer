package com.DauntlessArmourer.Effects;

public class KnockoutKing extends Effect
{
	public KnockoutKing()
	{
		super();
	}

	public KnockoutKing(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%d%% Stagger Damage.";
		String extraText = "\nAfter dodging through an attack, the next weapon attack's Stagger is increased by %d%%";

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
			text += String.format(extraText, 50);
			break;
		case 5:
			text = String.format(text, 25);
			text += String.format(extraText, 50);
			break;
		case 6:
			text = String.format(text, 30);
			text += String.format(extraText, 100);
			break;
		}
		return text;
	}

}