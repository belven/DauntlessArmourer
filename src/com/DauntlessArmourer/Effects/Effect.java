package com.DauntlessArmourer.Effects;

public abstract class Effect
{
	private int level = 1;

	public Effect()
	{

	}

	public abstract String getEffectText();

	public Effect(int newlevel)
	{
		level = newlevel;
	}

	public String getName()
	{
		return this.getClass().getSimpleName();
	}

	public int getLevel()
	{
		return Math.min(6, level);
	}

	public void setLevel(int newLevel)
	{
		level = newLevel;
	}

}
