package com.DauntlessArmourer.Effects;

public class ShellshockResist extends Effect
{
	public ShellshockResist()
	{
		super();
	}

	public ShellshockResist(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Reduces Shell Shocked explosion damage and status effect duration by %d%%";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 10);
			break;
		case 2:
			text = String.format(text, 20);
			break;
		case 3:
			text = String.format(text, 40);
			break;
		case 4:
			text = String.format(text, 60);
			break;
		case 5:
			text = String.format(text, 80);
			break;
		case 6:
			text = "Immune to Shell Shocked explosion damage and status effect.";
			break;
		}
		return text;
	}

}