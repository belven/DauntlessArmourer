package com.DauntlessArmourer;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.DauntlessArmourer.Armour.Armour;
import com.DauntlessArmourer.Armour.Slot;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;
import com.DauntlessArmourer.Weapons.Weapon;
import com.DauntlessArmourer.Weapons.WeaponType;

public class ArmourerFactory
{
	private static HashMap<CellType, List<String>> CellEffects = new HashMap<>();
	// private static HashMap<String, Armour> armourCreated = new HashMap<>();
	// private static HashMap<String, Effect> effectsCreated = new HashMap<>();
	//// private static HashMap<String, Weapon> weaponsCreated = new HashMap<>();

	private static ArrayList<String> effects = new ArrayList<>();
	private static ArrayList<String> armour = new ArrayList<>();
	private static ArrayList<String> weapons = new ArrayList<>();

	static
	{
		CellEffects.put(CellType.Defence, Arrays.asList("AssassinsVigour", "Bloodless", "Fireproof", "Fortress",
				"Insulated", "NineLives", "ShellshockResist", "Sturdy", "Tough", "Warmth"));

		CellEffects.put(CellType.Mobility,
				Arrays.asList("Agility", "Conditioning", "Endurance", "Evasion", "FleetFooted", "Nimble", "Swift"));

		CellEffects.put(CellType.Power, Arrays.asList("Aetherhunter", "Deconstruction", "Overpower", "Pacifier", "Rage",
				"Ragehunter", "Sharpened", "KnockoutKing"));

		CellEffects.put(CellType.Technique, Arrays.asList("Acidic", "Barbed", "Bladestorm", "Cunning", "EvasiveFury",
				"Merciless", "Savagery", "Predator", "WeightedStrikes", "WildFrenzy"));

		CellEffects.put(CellType.Utility, Arrays.asList("Aetherborne", "AethericAttunement", "AethericFrenzy",
				"Conduit", "Energized", "Medic", "StunningVigour", "Vampiric"));

		effects.addAll(Arrays.asList("AssassinsVigour", "Bloodless", "Fireproof", "Fortress", "Insulated", "NineLives",
				"ShellshockResist", "Sturdy", "Tough", "Warmth", "Agility", "Conditioning", "Endurance", "Evasion",
				"FleetFooted", "Nimble", "Swift", "Aetherhunter", "Deconstruction", "Overpower", "Pacifier", "Rage",
				"Ragehunter", "Sharpened", "Acidic", "Barbed", "Bladestorm", "Cunning", "EvasiveFury", "Merciless",
				"Savagery", "Predator", "WeightedStrikes", "WildFrenzy", "Aetherborne", "AethericAttunement",
				"AethericFrenzy", "Conduit", "Energized", "Medic", "StunningVigour", "Vampiric", "KnockoutKing"));

		armour.addAll(Arrays.asList("RiftstalkerLegs", "RiftstalkerArms", "RiftstalkerChest", "RiftstalkerHead",
				"KoshaiLegs", "KoshaiArms", "KoshaiChest", "KoshaiHead", "ShrowdLegs", "ShrowdArms", "ShrowdChest",
				"ShrowdHead", "RezakiriLegs", "RezakiriArms", "RezakiriChest", "RezakiriHead", "MoonreaverLegs",
				"MoonreaverArms", "MoonreaverChest", "MoonreaverHead", "BloodfireLegs", "BloodfireArms",
				"BloodfireChest", "BloodfireHead", "DeadeyeLegs", "DeadeyeArms", "DeadeyeChest", "DeadeyeHead",
				"FrostbackLegs", "FrostbackArms", "FrostbackChest", "FrostbackHead", "RazorwingLegs", "RazorwingArms",
				"RazorwingChest", "RazorwingHead", "ShockjawLegs", "ShockjawArms", "ShockjawChest", "ShockjawHead",
				"FirebrandLegs", "FirebrandArms", "FirebrandChest", "FirebrandHead", "RagetailLegs", "RagetailArms",
				"RagetailChest", "RagetailHead"));

		weapons.addAll(Arrays.asList("BloodfireBlades", "Deadblades"));

		for (String s : armour)
		{
			ArmourerFactory.getArmourByName(s, 6);
		}

		for (String s : effects)
		{
			ArmourerFactory.getEffectByName(s, 6);
		}

		for (String s : weapons)
		{
			ArmourerFactory.getWeaponByName(s, 6);
		}
	}

	public static ArrayList<Weapon> getWeaponByEffect(String name)
	{
		ArrayList<Weapon> armourFound = new ArrayList<>();

		for (String s : ArmourerFactory.getWeapons())
		{
			Weapon w = ArmourerFactory.getWeaponByName(s, 6);

			ArrayList<Effect> armourEffects = w.getEffects();

			for (Effect e : armourEffects)
			{
				if (e.getName().equals(name))
				{
					armourFound.add(w);
					break;
				}
			}
		}

		return armourFound;
	}

	public static ArrayList<Armour> getArmourByEffect(String name)
	{
		ArrayList<Armour> armourFound = new ArrayList<>();

		for (String s : ArmourerFactory.getArmour())
		{
			Armour a = ArmourerFactory.getArmourByName(s, 6);

			ArrayList<Effect> armourEffects = a.getEffects();

			for (Effect e : armourEffects)
			{
				if (e.getName().equals(name))
				{
					armourFound.add(a);
					break;
				}
			}
		}

		return armourFound;
	}

	public static ArrayList<Weapon> getWeaponsByType(WeaponType type)
	{
		ArrayList<Weapon> weaponsFound = new ArrayList<>();

		for (String s : ArmourerFactory.getWeapons())
		{
			Weapon w = ArmourerFactory.getWeaponByName(s, 6);

			if (w.getType() == type)
			{
				weaponsFound.add(w);
			}
		}

		return weaponsFound;
	}

	public static ArrayList<Weapon> getWeaponByCell(String name)
	{
		ArrayList<Weapon> weaponsFound = new ArrayList<>();

		for (String s : ArmourerFactory.getWeapons())
		{
			Weapon w = ArmourerFactory.getWeaponByName(s, 6);

			ArrayList<CellType> armourCells = w.getCellTypes();

			for (CellType ct : armourCells)
			{
				if (ct.toString().equals(name))
				{
					weaponsFound.add(w);
					break;
				}
			}
		}

		return weaponsFound;
	}

	public static ArrayList<String> getWeapons()
	{
		return weapons;
	}

	public static void setWeapons(ArrayList<String> weapons)
	{
		ArmourerFactory.weapons = weapons;
	}

	public static ArrayList<Armour> getArmourByCell(String name)
	{
		ArrayList<Armour> armourFound = new ArrayList<>();

		for (String s : ArmourerFactory.getArmour())
		{
			Armour a = ArmourerFactory.getArmourByName(s, 6);

			ArrayList<CellType> armourCells = a.getCellTypes();

			for (CellType ct : armourCells)
			{
				if (ct.toString().equals(name))
				{
					armourFound.add(a);
					break;
				}
			}
		}

		return armourFound;
	}

	public static ArrayList<String> getArmourBySlot(Slot type)
	{
		ArrayList<String> list = new ArrayList<>();

		for (String s : getArmour())
		{
			if (s.contains(type.toString()))
			{
				list.add(s);
			}
		}

		return list;
	}

	public static Weapon getWeaponByName(String name, int level)
	{
//		if (weaponsCreated.containsKey(name))
//		{
//			Weapon weapon2 = weaponsCreated.get(name);
//			weapon2.setLevel(level);
//			return weapon2;
//		}

		try
		{
			Class<?> classFound = Class.forName("com.DauntlessArmourer.Weapons." + name);
			Constructor<?> declaredConstructor = classFound.getDeclaredConstructor(int.class);
			Weapon weapon = (Weapon) declaredConstructor.newInstance(level);
			return weapon;
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static Armour getArmourByName(String name, int level)
	{
//		if (armourCreated.containsKey(name))
//		{
//			Armour armour2 = armourCreated.get(name);
//			armour2.setLevel(level);
//			return armour2;
//		}

		try
		{
			Class<?> classFound = Class.forName("com.DauntlessArmourer.Armour." + name);
			Constructor<?> declaredConstructor = classFound.getDeclaredConstructor(int.class);
			Armour armour = (Armour) declaredConstructor.newInstance(level);
			return armour;
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static HashMap<CellType, List<String>> getCellEffects()
	{
		return CellEffects;
	}

	public static Effect getEffectByName(String name, int level)
	{
//		if (effectsCreated.containsKey(name))
//		{
//			Effect effectFound = effectsCreated.get(name);
//			effectFound.setLevel(level);
//			return effectFound;
//		}

		try
		{
			Class<?> classFound = Class.forName("com.DauntlessArmourer.Effects." + name);
			Constructor<?> declaredConstructor = classFound.getDeclaredConstructor(int.class);
			Effect newInstance = (Effect) declaredConstructor.newInstance(level);
			return newInstance;
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static ArrayList<String> getEffects()
	{
		return effects;
	}

	public static ArrayList<String> getArmour()
	{
		return armour;
	}

	public static List<String> getEffectsForCell(CellType type)
	{
		return CellEffects.get(type);
	}

	public Effect createEffectForCell(String name)
	{
		return getEffectByName(name, 3);
	}
}
