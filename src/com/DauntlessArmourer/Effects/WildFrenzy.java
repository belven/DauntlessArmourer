package com.DauntlessArmourer.Effects;

public class WildFrenzy extends Effect
{
	public WildFrenzy()
	{
		super();
	}

	public WildFrenzy(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = " 	When under %d%% health, ncrease attack speed by %d%%";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 30, 5);
			break;
		case 2:
			text = String.format(text, 30, 8);
			break;
		case 3:
			text = String.format(text, 30, 10);
			break;
		case 4:
			text = String.format(text, 50, 15);
			break;
		case 5:
			text = String.format(text, 50, 20);
			break;
		case 6:
			text = String.format(text, 50, 25);
			break;
		}
		return text;
	}

}