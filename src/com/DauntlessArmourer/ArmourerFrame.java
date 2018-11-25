package com.DauntlessArmourer;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JFileChooser;
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

	private Choice weaponCellAChoice = new Choice();
	private Choice weaponCellBChoice = new Choice();

	private Weapon weaponSelected = new BloodfireBlades(6);
	private Armour headArmourSelected = new BloodfireHead(6);
	private Armour chestArmourSelected = new BloodfireChest(6);
	private Armour armArmourSelected = new BloodfireArms(6);
	private Armour legArmourSelected = new BloodfireLegs(6);

	private Effect weaponCellA = null;
	private Effect weaponCellB = null;

	private Effect headCell = null;
	private Effect chestCell = null;
	private Effect armCell = null;
	private Effect legCell = null;

	Font font = new Font("Calibri", Font.PLAIN, 16);

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
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(2, 2, 2, 20);

		{
			c.gridx = 0;
			c.gridy = row;
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
			add(weaponCellAChoice, c);

			c.gridx = 1;
			c.gridy = row;
			add(weaponCellBChoice, c);

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

			c.gridwidth = 1;
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

		{
			Button b = new Button();
			b.setFont(font);
			b.setLabel("Export To File");
			b.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						exportToFile();
					} catch (IOException e1)
					{
						e1.printStackTrace();
					}
				}
			});

			c.gridx = 0;
			c.gridy = row;
			add(b, c);

			row++;
		}
	}

	private void exportToFile() throws IOException
	{
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File f = fc.getSelectedFile();

			if (!f.createNewFile())
			{
				f.delete();
				f.createNewFile();
			} else
			{
				f = new File(f.getPath() + ".txt");
			}

			PrintWriter pw = new PrintWriter(f);

			pw.println("Weapon: " + weaponSelected.getName());

			if (weaponCellA != null)
				pw.println(weaponCellA.getName());

			if (weaponCellB != null)
				pw.println(weaponCellB.getName());

			pw.println("Head: " + headArmourSelected.getName());
			pw.println(headCell.getName());
			pw.println();

			pw.println("Chest: " + chestArmourSelected.getName());
			pw.println(chestCell.getName());
			pw.println();

			pw.println("Arms: " + armArmourSelected.getName());
			pw.println(armCell.getName());
			pw.println();

			pw.println("Legs: " + legArmourSelected.getName());
			pw.println(legCell.getName());

			pw.println();
			pw.println();
			pw.println();

			int amount = 1;

			for (String s : totalEffectsText.getText().split("\n"))
			{
				pw.println(s);

				//				if (amount % 2 )
				//				{
				//					pw.println();
				//				}
				//				amount++;
			}

			pw.close();

		}

	}

	private void updateEffects()
	{
		StringBuilder sb = new StringBuilder();
		totalEffectsText.setText("");

		HashMap<String, Effect> totalEffects = new HashMap<>();

		if (weaponCellA != null)
		{
			updateEffectLevel(totalEffects, weaponCellA);
		}

		if (weaponCellB != null)
		{
			updateEffectLevel(totalEffects, weaponCellB);
		}

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
			//sb.append("\n");
		}

		totalEffectsText.setText(sb.toString());
		//pack();
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
			totalEffects.put(effectFound.getName(), effectFound);
			System.out.println("Updated effect: " + effectFound.getName() + " " + effectFound.getLevel());
		}
	}

	private void updateCellCombos(Slot slot)
	{
		switch (slot)
		{
		case Head:
		{
			List<String> effectsForHeadCell = ArmourerFactory
					.getEffectsForCell(headArmourSelected.getCellTypes().get(0));
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
			List<String> effectsForChestCell = ArmourerFactory
					.getEffectsForCell(chestArmourSelected.getCellTypes().get(0));
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
			List<String> effectsForArmCell = ArmourerFactory.getEffectsForCell(armArmourSelected.getCellTypes().get(0));
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
			List<String> effectsForLegCell = ArmourerFactory.getEffectsForCell(legArmourSelected.getCellTypes().get(0));
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
		{
			weaponCellAChoice.removeAll();
			weaponCellBChoice.removeAll();

			ArrayList<CellType> cellTypes = weaponSelected.getCellTypes();
			if (cellTypes.size() > 0)
			{

				List<String> effectsForWeaponACell = ArmourerFactory.getEffectsForCell(cellTypes.get(0));

				for (String s : effectsForWeaponACell)
				{
					weaponCellAChoice.add(s);
				}
				weaponCellAChoice.select(effectsForWeaponACell.get(0));
				weaponCellA = ArmourerFactory.getEffectByName(effectsForWeaponACell.get(0), 3);

				if (cellTypes.size() > 1)
				{
					List<String> effectsForWeaponBCell = ArmourerFactory.getEffectsForCell(cellTypes.get(1));

					for (String s : effectsForWeaponBCell)
					{
						weaponCellBChoice.add(s);
					}
					weaponCellBChoice.select(effectsForWeaponBCell.get(0));
					weaponCellB = ArmourerFactory.getEffectByName(effectsForWeaponBCell.get(0), 3);
				}
				break;
			}
		}
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

		for (Weapon w : ArmourerFactory.getWeaponByCell(selectedEffect))
		{
			amount++;
			sb.append(w.getName() + ", ");

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

		for (Weapon w : ArmourerFactory.getWeaponByEffect(selectedEffect))
		{
			amount++;
			sb.append(w.getName() + ", ");

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

		weaponCellAChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				weaponCellA = ArmourerFactory.getEffectByName(e.getItem().toString(), 3);
				updateEffects();
			}
		});

		weaponCellBChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				weaponCellB = ArmourerFactory.getEffectByName(e.getItem().toString(), 3);
				updateEffects();
			}
		});

		effectChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				String selectedEffect = e.getItem().toString();
				updateEffectChoice(selectedEffect);
				// calculateArmour();
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
		weaponChoice.setFont(font);
		weaponEffects.setFont(font);
		weaponChoiceFilter.setFont(font);

		weaponCellAChoice.setFont(font);
		weaponCellBChoice.setFont(font);

		effectChoice.setFont(font);
		effectArmourList.setFont(font);

		cellChoice.setFont(font);
		cellArmourList.setFont(font);

		headEffects.setFont(font);
		chestEffects.setFont(font);
		armEffects.setFont(font);
		legEffects.setFont(font);

		headArmourCellChoice.setFont(font);
		chestArmourCellChoice.setFont(font);
		armArmourCellChoice.setFont(font);
		legArmourCellChoice.setFont(font);

		headArmour.setFont(font);
		chestArmour.setFont(font);
		armArmour.setFont(font);
		legArmour.setFont(font);

		totalEffectsText.setFont(font);
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
			effectChoice.add(s);

		}

		for (CellType ct : cells)
		{
			cellChoice.add(ct.toString());
		}
	}

	private String getItemEffectsString(Item itemFound)
	{
		ArrayList<Effect> itemEffects = itemFound.getEffects();
		String text = "";

		if (itemEffects.size() > 0)
		{
			Effect effect1 = itemEffects.get(0);

			text = effect1.getName() + " " + effect1.getLevel() + ": " + effect1.getEffectText();

			if (itemEffects.size() > 1)
			{
				Effect effect2 = itemEffects.get(1);
				text += "\n" + effect2.getName() + " " + effect2.getLevel() + ": " + effect2.getEffectText();
			}
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
