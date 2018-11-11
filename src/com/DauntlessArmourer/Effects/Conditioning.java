package com.DauntlessArmourer.Effects;

public class Conditioning extends Effect
{
	public Conditioning()
	{
		super();
	}

	public Conditioning(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%d Stamina Regeneration";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 50);
			break;
		case 2:
			text = String.format(text, 10);
			break;
		case 3:
			text = String.format(text, 15);
			break;
		case 4:
			text = String.format(text, 20);
			break;
		case 5:
			text = String.format(text, 25);
			break;
		case 6:
			text = String.format(text, 30);
			break;
		}
		return text;
	}

}