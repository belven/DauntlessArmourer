package com.DauntlessArmourer.Effects;

public class AethericFrenzy extends Effect
{
	public AethericFrenzy()
	{
		super();
	}

	public AethericFrenzy(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%.1f Lantern Charge on Hit";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 3);
			break;
		case 2:
			text = String.format(text, 4);
			break;
		case 3:
			text = String.format(text, 5);
			break;
		case 4:
			text = String.format(text, 7.5);
			break;
		case 5:
			text = String.format(text, 10);
			break;
		case 6:
			text = String.format(text, 12.5);
			break;
		}
		return text;
	}

}