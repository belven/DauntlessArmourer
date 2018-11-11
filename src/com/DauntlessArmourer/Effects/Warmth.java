package com.DauntlessArmourer.Effects;

public class Warmth extends Effect
{
	public Warmth()
	{
		super();
	}

	public Warmth(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Reduces duration of Frozen status by %d%%";
		String extratext = "Reduces duration of Chilled status by %d%%";
		
		switch (getLevel())
		{
		case 1:
			text = String.format(text, 30);
			break;
		case 2:
			text = String.format(text, 60);
			break;
		case 3:
			text = "Immune to being Frozen";
			break;
		case 4:
			text = "Immune to being Frozen";
			text += String.format(extratext, 30);
			break;
		case 5:
			text = "Immune to being Frozen";
			text += String.format(extratext, 60);
			break;
		case 6:
			text = "Immune to being Frozen";
			text = "Immune to being Chilled";
			break;
		}
		return text;
	}

}