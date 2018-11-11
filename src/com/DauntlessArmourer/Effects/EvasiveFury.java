package com.DauntlessArmourer.Effects;

public class EvasiveFury extends Effect
{
	public EvasiveFury()
	{
		super();
	}

	public EvasiveFury(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%d%% Attack Speed for 8 seconds after dodging through an attack";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 4);
			break;
		case 2:
			text = String.format(text, 8);
			break;
		case 3:
			text = String.format(text, 12);
			break;
		case 4:
			text = String.format(text, 16);
			break;
		case 5:
			text = String.format(text, 20);
			break;
		case 6:
			text = String.format(text, 25);
			break;
		}
		return text;
	}

}