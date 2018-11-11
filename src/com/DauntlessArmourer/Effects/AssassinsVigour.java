package com.DauntlessArmourer.Effects;

public class AssassinsVigour extends Effect
{
	public AssassinsVigour()
	{
		super();
	}

	public AssassinsVigour(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Heal %d when you break a part";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 50);
			break;
		case 2:
			text = String.format(text, 100);
			break;
		case 3:
			text = String.format(text, 150);
			break;
		case 4:
			text = String.format(text, 200);
			break;
		case 5:
			text = String.format(text, 250);
			break;
		case 6:
			text = String.format(text, 300);
			break;
		}
		return text;
	}

}