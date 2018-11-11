package com.DauntlessArmourer.Effects;

public class Swift extends Effect
{
	public Swift()
	{
		super();
	}

	public Swift(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "While sheathed, increases Movement Speed by %d%%";

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
			break;
		case 5:
			text = String.format(text, 25);
			break;
		case 6:
			text = String.format(text, 30);
			text += "\nAlso affects other nearby Slayers.";
			break;
		}
		return text;
	}

}