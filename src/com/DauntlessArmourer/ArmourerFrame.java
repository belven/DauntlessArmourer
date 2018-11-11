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

import javax.swing.JTextArea;

import com.DauntlessArmourer.Armour.Armour;
import com.DauntlessArmourer.Armour.BloodfireArms;
import com.DauntlessArmourer.Armour.BloodfireChest;
import com.DauntlessArmourer.Armour.BloodfireHead;
import com.DauntlessArmourer.Armour.BloodfireLegs;
import com.DauntlessArmourer.Armour.Slot;
import com.DauntlessArmourer.Cells.CellType;
import com.DauntlessArmourer.Effects.Effect;

public class ArmourerFrame extends Frame
{
	private static final long serialVersionUID = -8058037007378215466L;
	private JTextArea headEffects = new JTextArea();
	private JTextArea chestEffects = new JTextArea();
	private JTextArea armEffects = new JTextArea();
	private JTextArea legEffects = new JTextArea();

	private JTextArea totalEffectsText = new JTextArea();

	private Choice effectChoice = new Choice();
	private JTextArea effectArmourList = new JTextArea();

	private Choice cellChoice = new Choice();
	private JTextArea cellArmourList = new JTextArea();

	private Choice headArmour = new Choice();
	private Choice chestArmour = new Choice();
	private Choice armArmour = new Choice();
	private Choice legArmour = new Choice();

	private Choice headArmourCellChoice = new Choice();
	private Choice chestArmourCellChoice = new Choice();
	private Choice armArmourCellChoice = new Choice();
	private Choice legArmourCellChoice = new Choice();

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

		updateArmourText(headArmourSelected.getName(), Slot.Head);
		updateArmourText(chestArmourSelected.getName(), Slot.Chest);
		updateArmourText(armArmourSelected.getName(), Slot.Arms);
		updateArmourText(legArmourSelected.getName(), Slot.Legs);

		updateEffectChoice(effectChoice.getItem(0));
		updateCellChoice(cellChoice.getItem(0));

		updateEffects();

		pack();
	}

	private void setupPositions()
	{
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(2, 2, 2, 20);
		c.gridx = 0;
		c.gridy = 0;
		add(headArmour, c);

		c.gridx = 1;
		c.gridy = 0;
		add(headArmourCellChoice, c);

		c.gridx = 2;
		c.gridy = 0;
		add(headEffects, c);

		c.gridx = 0;
		c.gridy = 1;
		add(chestArmour, c);

		c.gridx = 1;
		c.gridy = 1;
		add(chestArmourCellChoice, c);

		c.gridx = 2;
		c.gridy = 1;
		add(chestEffects, c);

		c.gridx = 0;
		c.gridy = 2;
		add(armArmour, c);

		c.gridx = 1;
		c.gridy = 2;
		add(armArmourCellChoice, c);

		c.gridx = 2;
		c.gridy = 2;
		add(armEffects, c);

		c.gridx = 0;
		c.gridy = 3;
		add(legArmour, c);

		c.gridx = 1;
		c.gridy = 3;
		add(legArmourCellChoice, c);

		c.gridx = 2;
		c.gridy = 3;
		add(legEffects, c);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.ipady = 100;
		add(totalEffectsText, c);

		totalEffectsText.setEditable(false);

		c.gridwidth = 0;
		c.ipady = 0;

		c.gridx = 0;
		c.gridy = 5;
		add(effectChoice, c);

		c.gridx = 1;
		c.gridy = 5;
		add(effectArmourList, c);

		c.gridx = 0;
		c.gridy = 6;
		add(cellChoice, c);

		c.gridx = 1;
		c.gridy = 6;
		add(cellArmourList, c);
	}

	private void updateEffects()
	{
		StringBuilder sb = new StringBuilder();

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

		for (Effect e : totalEffects.values())
		{
			sb.append(e.getName() + " " + e.getLevel() + "\n" + e.getEffectText() + "\n");
		}

		totalEffectsText.setText(sb.toString());
		// pack();
	}

	private void updateEffectLevel(HashMap<String, Effect> totalEffects, Effect effect)
	{
		if (!totalEffects.containsKey(effect.getName()))
		{
			totalEffects.put(effect.getName(), effect);
		} else
		{
			Effect effectFound = totalEffects.get(effect.getName());
			effectFound.setLevel(effectFound.getLevel() + effect.getLevel());
		}
	}

	private void updateCellCombos(Slot slot)
	{
		List<String> effectsForHeadCell = ArmourerFactory.getEffectsForCell(headArmourSelected.getCellTypes().get(0));
		List<String> effectsForChestCell = ArmourerFactory.getEffectsForCell(chestArmourSelected.getCellTypes().get(0));
		List<String> effectsForArmCell = ArmourerFactory.getEffectsForCell(armArmourSelected.getCellTypes().get(0));
		List<String> effectsForLegCell = ArmourerFactory.getEffectsForCell(legArmourSelected.getCellTypes().get(0));

		switch (slot)
		{
		case Head:
		{
			headArmourCellChoice.removeAll();
			for (String s : effectsForHeadCell)
			{
				headArmourCellChoice.add(s);
			}
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
			chestCell = ArmourerFactory.getEffectByName(effectsForHeadCell.get(0), 3);
			break;
		}
		case Arms:
		{
			armArmourCellChoice.removeAll();
			for (String s : effectsForArmCell)
			{
				armArmourCellChoice.add(s);
			}
			armCell = ArmourerFactory.getEffectByName(effectsForHeadCell.get(0), 3);
			break;
		}
		case Legs:
		{
			legArmourCellChoice.removeAll();
			for (String s : effectsForLegCell)
			{
				legArmourCellChoice.add(s);
			}
			legCell = ArmourerFactory.getEffectByName(effectsForHeadCell.get(0), 3);
			break;
		}
		case Weapon:
			break;
		default:
			break;
		}
	}

	private void updateArmourText(String name, Slot slot)
	{
		switch (slot)
		{
		case Arms:
		{
			Armour armourFound = ArmourerFactory.getArmourByName(name, 6);
			armArmourSelected = armourFound;
			armEffects.setText(getArmourEffectsString(armourFound));
			updateCellCombos(Slot.Arms);
			updateEffects();
			break;
		}
		case Chest:
		{
			Armour armourFound = ArmourerFactory.getArmourByName(name, 6);
			chestArmourSelected = armourFound;
			chestEffects.setText(getArmourEffectsString(armourFound));
			updateCellCombos(Slot.Chest);
			updateEffects();
			break;
		}
		case Head:
		{
			Armour armourFound = ArmourerFactory.getArmourByName(name, 6);
			headArmourSelected = armourFound;
			headEffects.setText(getArmourEffectsString(armourFound));
			updateCellCombos(Slot.Head);
			updateEffects();
			break;
		}
		case Legs:
		{
			Armour armourFound = ArmourerFactory.getArmourByName(name, 6);
			legArmourSelected = armourFound;
			legEffects.setText(getArmourEffectsString(armourFound));
			updateCellCombos(Slot.Legs);
			updateEffects();
			break;
		}
		case Weapon:
		{
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

			if (amount % 3 == 0)
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

			if (amount % 3 == 0)
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
		effectChoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				String selectedEffect = e.getItem().toString();
				updateEffectChoice(selectedEffect);
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
				updateArmourText(e.getItem().toString(), Slot.Head);
			}
		});

		chestArmour.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{

				updateArmourText(e.getItem().toString(), Slot.Chest);
			}
		});

		armArmour.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				updateArmourText(e.getItem().toString(), Slot.Arms);
			}
		});

		legArmour.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				updateArmourText(e.getItem().toString(), Slot.Legs);
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
		ArrayList<String> headList = ArmourerFactory.getArmourBySlot(Slot.Head);
		ArrayList<String> chestList = ArmourerFactory.getArmourBySlot(Slot.Chest);
		ArrayList<String> armsList = ArmourerFactory.getArmourBySlot(Slot.Arms);
		ArrayList<String> legsList = ArmourerFactory.getArmourBySlot(Slot.Legs);
		ArrayList<String> effects = ArmourerFactory.getEffects();
		List<CellType> cells = Arrays.asList(CellType.values());

		Collections.sort(headList);
		Collections.sort(chestList);
		Collections.sort(armsList);
		Collections.sort(legsList);
		Collections.sort(effects);

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

	private String getArmourEffectsString(Armour armourFound)
	{
		ArrayList<Effect> armourEffects = armourFound.getEffects();
		Effect effect1 = armourEffects.get(0);
		Effect effect2 = armourEffects.get(1);

		String text = effect1.getName() + " " + effect1.getLevel() + ": " + effect1.getEffectText();
		text += "\n" + effect2.getName() + " " + effect2.getLevel() + ": " + effect2.getEffectText();
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
