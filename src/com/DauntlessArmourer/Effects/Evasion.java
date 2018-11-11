package com.DauntlessArmourer.Effects;

public class Evasion extends Effect
{
	public Evasion()
	{
		super();
	}

	public Evasion(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Increases Dodge invulnerability windows by %d%%";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 7);
			break;
		case 2:
			text = String.format(text, 14);
			break;
		case 3:
			text = String.format(text, 21);
			break;
		case 4:
			text = String.format(text, 28);
			break;
		case 5:
			text = String.format(text, 35);
			break;
		case 6:
			text = String.format(text, 42);
			break;
		}
		return text;
	}

}