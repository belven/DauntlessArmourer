package com.DauntlessArmourer.Effects;

public class Bloodless extends Effect
{
	public Bloodless()
	{
		super();
	}

	public Bloodless(int newlevel)
	{
		super(newlevel);
	}

	@Override
	public String getEffectText()
	{
		String text = "Reduces duration of Wounded status by %d%%";
		String extraText = "\nReduces duration of Crippling Wounded status by %d%%";

		switch (getLevel())
		{
		case 1:
			text = String.format(text, 50);
			break;
		case 2:
			text = String.format(text, 80);
			break;
		case 3:
			text = "Immune to Wounded status";
			break;
		case 4:
			text = String.format(extraText, 50);
			text += "Immune to Wounded status";
			break;
		case 5:
			text = String.format(extraText, 80);
			text += "Immune to Wounded status";
			break;
		case 6:
			text = "Immune to Wounded status";
			text += ", Immune to Crippling Wound status";
			break;
		}
		return text;
	}

}