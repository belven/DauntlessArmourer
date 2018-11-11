package com.DauntlessArmourer.Effects;

public class AethericAttunement extends Effect
{
	public AethericAttunement()
	{
		super();
	}

	public AethericAttunement(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "+%d%% Lantern Charge";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 10);
			break;
		case 2:
			text = String.format(text, 20);
			break;
		case 3:
			text = String.format(text, 30);
			break;
		case 4:
			text = String.format(text, 42);
			break;
		case 5:
			text = String.format(text, 54);
			break;
		case 6:
			text = String.format(text, 66);
			break;
		}
		return text;
	}

}