package com.DauntlessArmourer;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JTextArea;

import com.DauntlessArmourer.Armour.Armour;
import com.DauntlessArmourer.Armour.BloodfireArms;
import com.DauntlessArmourer.Armour.BloodfireChest;
import com.DauntlessArmourer.Armour.BloodfireHead;
import com.DauntlessArmourer.Armour.BloodfireLegs;
import com.DauntlessArmourer.Armour.Slot;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;
import com.DauntlessArmourer.Weapons.BloodfireBlades;
import com.DauntlessArmourer.Weapons.Weapon;
import com.DauntlessArmourer.Weapons.WeaponType;

public class ArmourerFrame extends Frame
{
	private static final long serialVersionUID = -8058037007378215466L;

	private JTextArea weaponEffects = new JTextArea();
	private JTextArea headEffects = new JTextArea();
	private JTextArea chestEffects = new JTextArea();
	private JTextArea armEffects = new JTextArea();
	private JTextArea legEffects = new JTextArea();

	private JTextArea totalEffectsText = new JTextArea();

	private Choice effectChoice = new Choice();
	private JTextArea effectArmourList = new JTextArea();

	private Choice cellChoice = new Choice();
	private JTextArea cellArmourList = new JTextArea();

	private Choice weaponChoiceFilter = new Choice();
	private Choice weaponChoice = new Choice();

	private Choice headArmour = new Choice();
	private Choice chestArmour = new Choice();
	private Choice armArmour = new Choice();
	private Choice legArmour = new Choice();

	private Choice headArmourCellChoice = new Choice();
	private Choice chestArmourCellChoice = new Choice();
	private Choice armArmourCellChoice = new Choice();
	private Choice legArmourCellChoice = new Choice();

	private Weapon weaponSelected = new BloodfireBlades(6);
	private Armour headArmourSelected = new BloodfireHead(6);
	private Armour chestArmourSelected = new BloodfireChest(6);
	private Armour armArmourSelected = new BloodfireArms(6);
	private Armour legArmourSelected = new BloodfireLegs(6);

	private Effect headCell = null;
	private Effect chestCell = null;
	private Effect armCell = null;
	private Effect legCell = null;

	public ArmourerFrame() throws HeadlessException
	{
		super();

		setupFrame();
		setupFonts();
		addListeners();
		setupLists();

		setupPositions();

		setVisible(true);

		headArmour.select(0);
		chestArmour.select(0);
		armArmour.select(0);
		legArmour.select(0);

		updateCellCombos(Slot.Head);
		updateCellCombos(Slot.Chest);
		updateCellCombos(Slot.Arms);
		updateCellCombos(Slot.Legs);

		updateItemText(headArmourSelected.getName(), Slot.Head);
		updateItemText(chestArmourSelected.getName(), Slot.Chest);
		updateItemText(armArmourSelected.getName(), Slot.Arms);
		updateItemText(legArmourSelected.getName(), Slot.Legs);

		updateEffectChoice(effectChoice.getItem(0));
		updateCellChoice(cellChoice.getItem(0));

		updateEffects();

		pack();
	}

	private void setupPositions()
	{
		int row = 0;

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(2, 2, 2, 20);

		{
			c.gridx = 0;
			c.gridy = row;
			c.gridwidth = 3;
			add(weaponChoiceFilter, c);
			c.gridwidth = 1;

			row++;
		}

		{
			c.gridx = 0;
			c.gridy = row;
			add(weaponChoice, c);

			c.gridx = 1;
			c.gridy = row;
			add(weaponEffects, c);

			row++;
		}

		{
			c.gridx = 0;
			c.gridy = row;
			add(headArmour, c);

			c.gridx = 1;
			c.gridy = row;
			add(headArmourCellChoice, c);

			c.gridx = 2;
			c.gridy = row;
			add(headEffects, c);

			row++;
		}

		{
			c.gridx = 0;
			c.gridy = row;
			add(chestArmour, c);

			c.gridx = 1;
			c.gridy = row;
			add(chestArmourCellChoice, c);

			c.gridx = 2;
			c.gridy = row;
			add(chestEffects, c);

			row++;
		}

		{
			c.gridx = 0;
			c.gridy = row;
			add(armArmour, c);

			c.gridx = 1;
			c.gridy = row;
			add(armArmourCellChoice, c);

			c.gridx = 2;
			c.gridy = row;
			add(armEffects, c);

			row++;
		}

		{
			c.gridx = 0;
			c.gridy = row;
			add(legArmour, c);

			c.gridx = 1;
			c.gridy = row;
			add(legArmourCellChoice, c);

			c.gridx = 2;
			c.gridy = row;
			add(legEffects, c);

			row++;
		}

		{
			c.gridx = 0;
			c.gridy = row;
			c.gridwidth = 3;
			c.ipady = 100;
			add(totalEffectsText, c);

			totalEffectsText.setEditable(false);

			c.gridwidth = 0;
			c.ipady = 0;

			row++;
		}

		{
			c.gridx = 0;
			c.gridy = row;
			add(effectChoice, c);

			c.gridx = 1;
			c.gridy = row;
			add(effectArmourList, c);

			row++;
		}

		{
			c.gridx = 0;
			c.gridy = row;
			add(cellChoice, c);

			c.gridx = 1;
			c.gridy = row;
			add(cellArmourList, c);

			row++;
		}
	}

	private void updateEffects()
	{
		StringBuilder sb = new StringBuilder();
		totalEffectsText.setText("");

		HashMap<String, Effect> totalEffects = new HashMap<>();

		for (Effect e : headArmourSelected.getEffects())
		{
			updateEffectLevel(totalEffects, e);
		}

		for (Effect e : chestArmourSelected.getEffects())
		{
			updateEffectLevel(totalEffects, e);
		}

		for (Effect e : armArmourSelected.getEffects())
		{
			updateEffectLevel(totalEffects, e);
		}

		for (Effect e : legArmourSelected.getEffects())
		{
			updateEffectLevel(totalEffects, e);
		}

		if (headCell != null)
		{
			updateEffectLevel(totalEffects, headCell);
		}

		if (chestCell != null)
		{
			updateEffectLevel(totalEffects, chestCell);
		}

		if (armCell != null)
		{
			updateEffectLevel(totalEffects, armCell);
		}

		if (legCell != null)
		{
			updateEffectLevel(totalEffects, legCell);
		}

		for (Effect e : weaponSelected.getEffects())
		{
			updateEffectLevel(totalEffects, e);
		}

		for (Effect e : totalEffects.values())
		{
			sb.append(e.getName() + " " + e.getLevel() + "\n" + e.getEffectText() + "\n");
		}

		totalEffectsText.setText(sb.toString());
		// pack();
	}

	private void calculateArmour()
	{
		CellType cell = null;
		HashMap<Slot, Armour> armourResult = new HashMap<>();

		String selectedEffect = effectChoice.getSelectedItem();

		// Find Armour that contains the effects
		findArmourForSlot(armourResult, ArmourerFactory.getArmourByEffect(selectedEffect));

		// FInd Cells that have the effects, then find armour that has those cells
		for (Entry<CellType, List<String>> t : ArmourerFactory.getCellEffects().entrySet())
		{
			if (t.getValue().contains(selectedEffect))
			{
				cell = t.getKey();
				findArmourForSlot(armourResult, ArmourerFactory.getArmourByCell(cell.toString()));
				break;
			}
		}

		// Select all the armour found
		for (Entry<Slot, Armour> ar : armourResult.entrySet())
		{
			switch (ar.getKey())
			{
			case Head:
				headArmour.select(ar.getValue().getName());
				break;
			case Chest:
				chestArmour.select(ar.getValue().getName());
				break;
			case Arms:
				armArmour.select(ar.getValue().getName());
				break;
			case Legs:
				legArmour.select(ar.getValue().getName());
				break;
			default:
				break;
			}

			updateItemText(ar.getValue().getName(), ar.getKey());
		}

		// Update the text
		updateEffects();

		// Update the cell combos with the new lists
		for (Slot s : Slot.values())
		{
			updateCellCombos(s);
		}

		if (cell != null)
		{
			for (Entry<Slot, Armour> ar : armourResult.entrySet())
			{
				if (ar.getValue().getCellTypes().contains(cell))
				{
					switch (ar.getKey())
					{
					case Head:
						headArmourCellChoice.select(selectedEffect);
						headCell = ArmourerFactory.getEffectByName(selectedEffect, 3);
						break;
					case Chest:
						chestArmourCellChoice.select(selectedEffect);
						chestCell = ArmourerFactory.getEffectByName(selectedEffect, 3);
						break;
					case Arms:
						armArmourCellChoice.select(selectedEffect);
						armCell = ArmourerFactory.getEffectByName(selectedEffect, 3);
						break;
					case Legs:
						legArmourCellChoice.select(selectedEffect);
						legCell = ArmourerFactory.getEffectByName(selectedEffect, 3);
						break;
					default:
						break;
					}
				}
			}
		}

		// Update the text
		updateEffects();

	}

	private void findArmourForSlot(HashMap<Slot, Armour> armourResult, List<Armour> armourFound)
	{
		for (Armour a : armourFound)
		{
			if (!armourResult.containsKey(a.getSlot()))
			{
				armourResult.put(a.getSlot(), a);
			}
		}
	}

	private void updateEffectLevel(HashMap<String, Effect> totalEffects, Effect effect)
	{
		if (!totalEffects.containsKey(effect.getName()))
		{
			totalEffects.put(effect.getName(), effect);
			System.out.println("Updated effect: " + effect.getName() + " " + effect.getLevel());
		} else
		{
			Effect effectFound = totalEffects.get(effect.getName());
			effectFound.setLevel(effectFound.getLevel() + effect.getLevel());
			System.out.println("Updated effect: " + effectFound.getName() + " " + effectFound.getLevel());
		}
	}

	private void updateCellCombos(Slot slot)
	{
		List<String> effectsForHeadCell = ArmourerFactory.getEffectsForCell(headArmourSelected.getCellTypes().get(0));
		List<String> effectsForChestCell = ArmourerFactory.getEffectsForCell(chestArmourSelected.getCellTypes().get(0));
		List<String> effectsForArmCell = ArmourerFactory.getEffectsForCell(armArmourSelected.getCellTypes().get(0));
		List<String> effectsForLegCell = ArmourerFactory.getEffectsForCell(legArmourSelected.getCellTypes().get(0));

		List<String> effectsForWeaponCells = new ArrayList<>();

		for (CellType ct : weaponSelected.getCellTypes())
		{
			effectsForWeaponCells.addAll(ArmourerFactory.getEffectsForCell(ct));
		}

		switch (slot)
		{
		case Head:
		{
			headArmourCellChoice.removeAll();
			for (String s : effectsForHeadCell)
			{
				headArmourCellChoice.add(s);
			}
			headArmourCellChoice.select(effectsForHeadCell.get(0));
			headCell = ArmourerFactory.getEffectByName(effectsForHeadCell.get(0), 3);
			break;
		}
		case Chest:
		{
			chestArmourCellChoice.removeAll();
			for (String s : effectsForChestCell)
			{
				chestArmourCellChoice.add(s);
			}
			chestArmourCellChoice.select(effectsForChestCell.get(0));
			chestCell = ArmourerFactory.getEffectByName(effectsForChestCell.get(0), 3);
			break;
		}
		case Arms:
		{
			armArmourCellChoice.removeAll();
			for (String s : effectsForArmCell)
			{
				armArmourCellChoice.add(s);
			}
			armArmourCellChoice.select(effectsForArmCell.get(0));
			armCell = ArmourerFactory.getEffectByName(effectsForArmCell.get(0), 3);
			break;
		}
		case Legs:
		{
			legArmourCellChoice.removeAll();
			for (String s : effectsForLegCell)
			{
				legArmourCellChoice.add(s);
			}
			legArmourCellChoice.select(effectsForLegCell.get(0));
			legCell = ArmourerFactory.getEffectByName(effectsForLegCell.get(0), 3);
			break;
		}
		case Weapon:
//			weaponCellChoiceA.removeAll();
//			weaponCellChoiceB.removeAll();
//			
//			for (String s : effectsForWeaponCells)
//			{
//				weaponCellChoiceA.add(s);
//			}
//			legArmourCellChoice.select(effectsForWeaponCells.get(0));
//			legCell = ArmourerFactory.getEffectByName(effectsForWeaponCells.get(0), 3);
			break;
		default:
			break;
		}
	}

	private void updateItemText(String name, Slot slot)
	{
		switch (slot)
		{
		case Arms:
		{
			Armour armourFound = ArmourerFactory.getArmourByName(name, 6);
			armArmourSelected = armourFound;
			armEffects.setText(getItemEffectsString(armourFound));
			updateCellCombos(Slot.Arms);
			updateEffects();
			break;
		}
		case Chest:
		{
			Armour armourFound = ArmourerFactory.getArmourByName(name, 6);
			chestArmourSelected = armourFound;
			chestEffects.setText(getItemEffectsString(armourFound));
			updateCellCombos(Slot.Chest);
			updateEffects();
			break;
		}
		case Head:
		{
			Armour armourFound = ArmourerFactory.getArmourByName(name, 6);
			headArmourSelected = armourFound;
			headEffects.setText(getItemEffectsString(armourFound));
			updateCellCombos(Slot.Head);
			updateEffects();
			break;
		}
		case Legs:
		{
			Armour armourFound = ArmourerFactory.getArmourByName(name, 6);
			legArmourSelected = armourFound;
			legEffects.setText(getItemEffectsString(armourFound));
			updateCellCombos(Slot.Legs);
			updateEffects();
			break;
		}
		case Weapon:
		{
			Weapon weaponFound = ArmourerFactory.getWeaponByName(name, 6);
			weaponSelected = weaponFound;
			weaponEffects.setText(getItemEffectsString(weaponFound));
			updateCellCombos(Slot.Weapon);
			updateEffects();
			break;
		}
		default:
			break;

		}
	}

	private void updateCellChoice(String selectedEffect)
	{
		int amount = 0;
		StringBuilder sb = new StringBuilder();

		for (Armour a : ArmourerFactory.getArmourByCell(selectedEffect))
		{
			amount++;
			sb.append(a.getName() + ", ");

			if (amount % 5 == 0)
			{
				sb.append("\n");
			}
		}

		if (sb.length() > 0)
		{
			String armourFound = sb.toString();
			cellArmourList.setText(armourFound.substring(0, armourFound.lastIndexOf(", ")));
		}
	}

	private void updateEffectChoice(String selectedEffect)
	{
		int amount = 0;
		StringBuilder sb = new StringBuilder();

		for (Armour a : ArmourerFactory.getArmourByEffect(selectedEffect))
		{
			amount++;
			sb.append(a.getName() + ", ");

			if (amount % 5 == 0)
			{
				sb.append("\n");
			}
		}

		if (sb.length() > 0)
		{
			String armourFound = sb.toString();
			effectArmourList.setText(armourFound.substring(0, armourFound.lastIndexOf(", ")));
		}
	}

	private void addListeners()
	{
		weaponChoiceFilter.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				String weaponType = e.getItem().toString();
				weaponChoice.removeAll();

				for (Weapon w : ArmourerFactory.getWeaponsByType(WeaponType.valueOf(weaponType)))
				{
					weaponChoice.add(w.getName());
				}

				updateEffects();
			}
		});

		weaponChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				updateItemText(e.getItem().toString(), Slot.Weapon);
			}
		});

		effectChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				String selectedEffect = e.getItem().toString();
				updateEffectChoice(selectedEffect);
				calculateArmour();
			}
		});

		cellChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				String selectedEffect = e.getItem().toString();

				updateCellChoice(selectedEffect);
			}
		});

		headArmour.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				updateItemText(e.getItem().toString(), Slot.Head);
			}
		});

		chestArmour.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				updateItemText(e.getItem().toString(), Slot.Chest);
			}
		});

		armArmour.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				updateItemText(e.getItem().toString(), Slot.Arms);
			}
		});

		legArmour.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				updateItemText(e.getItem().toString(), Slot.Legs);
			}
		});

		headArmourCellChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				headCell = ArmourerFactory.getEffectByName(e.getItem().toString(), 3);
				updateEffects();
			}
		});

		chestArmourCellChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				chestCell = ArmourerFactory.getEffectByName(e.getItem().toString(), 3);
				updateEffects();
			}
		});

		armArmourCellChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				armCell = ArmourerFactory.getEffectByName(e.getItem().toString(), 3);
				updateEffects();
			}
		});

		legArmourCellChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				legCell = ArmourerFactory.getEffectByName(e.getItem().toString(), 3);
				updateEffects();
			}
		});
	}

	private void setupFonts()
	{
		Font f = new Font("Calibri", Font.PLAIN, 16);

		weaponChoice.setFont(f);
		weaponEffects.setFont(f);
		weaponChoiceFilter.setFont(f);

		effectChoice.setFont(f);
		effectArmourList.setFont(f);

		cellChoice.setFont(f);
		cellArmourList.setFont(f);

		headEffects.setFont(f);
		chestEffects.setFont(f);
		armEffects.setFont(f);
		legEffects.setFont(f);

		headArmourCellChoice.setFont(f);
		chestArmourCellChoice.setFont(f);
		armArmourCellChoice.setFont(f);
		legArmourCellChoice.setFont(f);

		headArmour.setFont(f);
		chestArmour.setFont(f);
		armArmour.setFont(f);
		legArmour.setFont(f);

		totalEffectsText.setFont(f);
	}

	private void setupLists()
	{
		List<CellType> cells = Arrays.asList(CellType.values());
		ArrayList<String> effects = ArmourerFactory.getEffects();
		List<WeaponType> weaponTypes = Arrays.asList(WeaponType.values());

		ArrayList<String> legsList = ArmourerFactory.getArmourBySlot(Slot.Legs);
		ArrayList<String> armsList = ArmourerFactory.getArmourBySlot(Slot.Arms);
		ArrayList<String> headList = ArmourerFactory.getArmourBySlot(Slot.Head);
		ArrayList<String> chestList = ArmourerFactory.getArmourBySlot(Slot.Chest);

		Collections.sort(cells);
		Collections.sort(effects);
		Collections.sort(legsList);
		Collections.sort(armsList);
		Collections.sort(headList);
		Collections.sort(chestList);
		Collections.sort(weaponTypes);

		for (WeaponType wt : weaponTypes)
		{
			if (wt != WeaponType.None)
			{
				weaponChoiceFilter.add(wt.toString());
			}
		}

		for (String s : headList)
		{
			headArmour.add(s);
		}

		for (String s : chestList)
		{
			chestArmour.add(s);
		}

		for (String s : armsList)
		{
			armArmour.add(s);
		}

		for (String s : legsList)
		{
			legArmour.add(s);
		}

		for (String s : effects)
		{
			if (ArmourerFactory.getArmourByEffect(s).size() > 0)
			{
				effectChoice.add(s);
			}
		}

		for (CellType ct : cells)
		{
			cellChoice.add(ct.toString());
		}
	}

	private String getItemEffectsString(Item itemFound)
	{
		ArrayList<Effect> itemEffects = itemFound.getEffects();
		Effect effect1 = itemEffects.get(0);

		String text = effect1.getName() + " " + effect1.getLevel() + ": " + effect1.getEffectText();

		if (itemEffects.size() > 1)
		{
			Effect effect2 = itemEffects.get(1);
			text += "\n" + effect2.getName() + " " + effect2.getLevel() + ": " + effect2.getEffectText();
		}
		return text;
	}

	private void setupFrame()
	{
		GridBagLayout bag = new GridBagLayout();

		setLayout(bag);

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}

}
