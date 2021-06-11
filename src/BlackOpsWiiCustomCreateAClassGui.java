import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class BlackOpsWiiCustomCreateAClassGui extends JFrame
{
	// GUI Elements
	JTextArea area = new JTextArea(12, 28);
	JScrollPane pane = new JScrollPane(area);
	JButton[] button = new JButton[6];
	JCheckBox[] checkbox = new JCheckBox[19];
	@SuppressWarnings("rawtypes")
	JComboBox[] combobox = new JComboBox[19];
	int classOffset = 32;
	int globalAddress = 788573;
	int startAddress;
	int startAddressC0Equip;
	int startAddressC0Primary;
	int startAddressC0Camo;
	int startAddressC0Lethal;
	int startAddressC0Secondary;
	int startAddressC0Tactical;
	int startAddressC0Perks;
	String[] classNames =
			{"Class 1", "Class 2", "Class 3", "Class 4", "Class 5"};
	String[] checkboxTexts =
			{"Uniform", "Equipment", "Primary Weapon", "1st Attachment",
					"2nd Attachment", "3rd Attachment", "4th Attachment", "Camo",
					"Lethal", "Secondary Weapon", "1st Attachment", "2nd Attachment",
					"3rd Attachment", "4th Attachment", "Tactical Grenade", "1st Perk",
					"2nd Perk", "3rd Perk", "Combat Training"};
	String[] images =
			{"Generate Code.jpg", "Reset.jpg", "Information.jpg", "BullyWiiHacks.jpg",
					"YouTube.jpg", "Donate.jpg"};
	String[] toolTipTexts = {"Generate the gecko code", "Reset all selections", "Receive more information", "Visit the author's website", "Visit the author's youtube channel", "Donate to the author"};
	// Class Data
	String[] uniformNames =
			{"LIGHTWEIGHT", "SCAVENGER", "GHOST", "FLAK JACKET", "HARDLINE"};
	String[] uniformValues =
			{"26", "36", "46", "56", "66"};
	// MP5K
	String[] MP5KN_2 =
			{"NONE", "SUPPRESSOR"};
	String[] MP5KV_2 =
			{"00", "40"};
	String[] MP5KN_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT"};
	String[] MP5KV_3 =
			{"00", "20", "30", "40"};
	String[] MP5KN_4 =
			{"NONE", "EXTENDED MAGS", "RAPIDFIRE"};
	String[] MP5KV_4 =
			{"00", "10", "60"};
	// SCORPION
	String[] SCORPIONN_1 =
			{"NONE", "GRIP"};
	String[] SCORPIONV_1 =
			{"00", "20"};
	String[] SCORPIONN_2 =
			{"NONE", "SUPPRESSOR"};
	String[] SCORPIONV_2 =
			{"00", "40"};
	String[] SCORPIONN_4 =
			{"NONE", "EXTENDED MAGS"};
	String[] SCORPIONV_4 =
			{"00", "10"};
	// MAC_11
	String[] MAC_11N_1 =
			{"NONE", "GRIP"};
	String[] MAC_11V_1 =
			{"00", "40"};
	String[] MAC_11N_2 =
			{"NONE", "SUPPRESSOR"};
	String[] MAC_11V_2 =
			{"00", "60"};
	String[] MAC_11N_3 =
			{"NONE", "RED DOT SIGHT", "REFLEX SIGHT"};
	String[] MAC_11V_3 =
			{"00", "20", "30"};
	String[] MAC_11N_4 =
			{"NONE", "EXTENDED MAGS", "RAPIDFIRE"};
	String[] MAC_11V_4 =
			{"00", "10", "70"};
	// AK74U
	String[] AK74UN_1 =
			{"NONE", "GRIP", "GRENADE LAUNCHER"};
	String[] AK74UV_1 =
			{"00", "60", "80"};
	String[] AK74UN_2 =
			{"NONE", "SUPPRESSOR"};
	String[] AK74UV_2 =
			{"00", "70"};
	String[] AK74UN_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT"};
	String[] AK74UV_3 =
			{"00", "30", "40", "50"};
	String[] AK74UN_4 =
			{"NONE", "EXTENDED MAGS", "DUAL MAGS", "RAPIDFIRE"};
	String[] AK74UV_4 =
			{"00", "10", "20", "90"};
	// UZI
	String[] UZIN_1 =
			{"NONE", "GRIP"};
	String[] UZIV_1 =
			{"00", "50"};
	String[] UZIN_2 =
			{"NONE", "SUPPRESSOR"};
	String[] UZIV_2 =
			{"00", "60"};
	String[] UZIN_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT"};
	String[] UZIV_3 =
			{"00", "20", "30", "40"};
	String[] UZIN_4 =
			{"NONE", "EXTENDED MAGS", "RAPIDFIRE"};
	String[] UZIV_4 =
			{"00", "10", "70"};
	// PM63
	String[] PM63N_1 =
			{"NONE", "GRIP"};
	String[] PM63V_1 =
			{"00", "20"};
	String[] PM63N_4 =
			{"NONE", "EXTENDED MAGS", "RAPIDFIRE"};
	String[] PM63V_4 =
			{"00", "10", "40"};
	// MPL
	String[] MPLN_1 =
			{"NONE", "GRIP"};
	String[] MPLV_1 =
			{"00", "50"};
	String[] MPLN_2 =
			{"NONE", "SUPPRESSOR"};
	String[] MPLV_2 =
			{"00", "60"};
	String[] MPLN_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT"};
	String[] MPLV_3 =
			{"00", "20", "30", "40"};
	String[] MPLN_4 =
			{"NONE", "DUAL MAGS", "RAPIDFIRE"};
	String[] MPLV_4 =
			{"00", "10", "70"};
	// SPECTRE
	String[] SPECTREN_1 =
			{"NONE", "GRIP"};
	String[] SPECTREV_1 =
			{"00", "50"};
	String[] SPECTREN_2 =
			{"NONE", "SUPPRESSOR"};
	String[] SPECTREV_2 =
			{"00", "60"};
	String[] SPECTREN_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT"};
	String[] SPECTREV_3 =
			{"00", "20", "30", "40"};
	String[] SPECTREN_4 =
			{"NONE", "EXTENDED MAGS", "RAPIDFIRE"};
	String[] SPECTREV_4 =
			{"00", "10", "70"};
	// KIPARIS
	String[] KIPARISN_1 =
			{"NONE", "GRIP"};
	String[] KIPARISV_1 =
			{"00", "50"};
	String[] KIPARISN_2 =
			{"NONE", "SUPPRESSOR"};
	String[] KIPARISV_2 =
			{"00", "70"};
	String[] KIPARISN_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT"};
	String[] KIPARISV_3 =
			{"00", "20", "30", "40"};
	String[] KIPARISN_4 =
			{"NONE", "EXTENDED MAGS", "RAPIDFIRE"};
	String[] KIPARISV_4 =
			{"00", "10", "80"};
	// M16 ENFIELD FAMAS GALIL AUG FN_FAL AK_47 COMMANDO
	String[] M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_1 =
			{"NONE", "MASTERKEY", "GRENADE LAUNCHER"};
	String[] M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1 =
			{"00", "60", "90"};
	String[] M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_2 =
			{"NONE", "SUPPRESSOR"};
	String[] M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2 =
			{"00", "80"};
	String[] M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT", "INFRARED SCOPE"};
	String[] M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3 =
			{"00", "30", "40", "50", "70"};
	String[] M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_4 =
			{"NONE", "EXTENDED MAGS", "DUAL MAGS"};
	String[] M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4 =
			{"00", "10", "20"};
	// M14
	String[] M14N_1 =
			{"NONE", "GRIP", "MASTERKEY", "GRENADE LAUNCHER"};
	String[] M14V_1 =
			{"00", "50", "60", "90"};
	String[] M14N_2 =
			{"NONE", "SUPPRESSOR"};
	String[] M14V_2 =
			{"00", "80"};
	String[] M14N_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT", "INFRARED SCOPE"};
	String[] M14V_3 =
			{"00", "20", "30", "40", "70"};
	String[] M14N_4 =
			{"NONE", "EXTENDED MAGS"};
	String[] M14V_4 =
			{"00", "10"};
	// G11
	String[] G11N_3 =
			{"NONE", "LOW ENERGY SCOPE", "VARIABLE ZOOM"};
	String[] G11V_3 =
			{"00", "10", "20"};
	// STAKEOUT
	String[] STAKEOUTN_1 =
			{"NONE", "GRIP"};
	String[] STAKEOUTV_1 =
			{"00", "10"};
	// SPAS-12
	String[] SPAS12N_2 =
			{"NONE", "SUPPRESSOR"};
	String[] SPAS12V_2 =
			{"00", "10"};
	// HK-21
	String[] HK21N_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT", "INFRARED SCOPE"};
	String[] HK21V_3 =
			{"00", "20", "30", "40", "50"};
	String[] HK21N_4 =
			{"NONE", "EXTENDED MAGS"};
	String[] HK21V_4 =
			{"10"};
	// RPK
	String[] RPKN_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT", "INFRARED SCOPE"};
	String[] RPKV_3 =
			{"00", "30", "40", "50", "60"};
	String[] RPKN_4 =
			{"NONE", "EXTENDED MAGS", "DUAL MAGS"};
	String[] RPKV_4 =
			{"00", "10", "20"};
	// M60
	String[] M60N_1 =
			{"NONE", "GRIP"};
	String[] M60V_1 =
			{"00", "50"};
	String[] M60N_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "REFLEX SIGHT", "INFRARED SCOPE"};
	String[] M60V_3 =
			{"00", "20", "30", "40", "50"};
	String[] M60N_4 =
			{"NONE", "EXTENDED MAGS"};
	String[] M60V_4 =
			{"00", "10"};
	// Stoner 63
	String[] STONERN_3 =
			{"NONE", "ACOG SIGHT", "RED DOT SIGHT", "INFRARED SCOPE", "REFLEX SIGHT"};
	String[] STONERV_3 =
			{"00", "10", "20", "40", "50"};
	String[] STONERN_4 =
			{"NONE", "EXTENDED MAGS"};
	String[] STONERV_4 =
			{"00", "30"};
	// Snipers
	String[] attachmentNamesAmmoTypeSniper2 =
			{"NONE", "SUPPRESSOR"};
	String[] attachmentValuesAmmoTypeSniper2 =
			{"00", "40"};
	String[] attachmentNamesSightsSniper3 =
			{"NONE", "ACOG SIGHT", "INFRARED SCOPE", "VARIABLE ZOOM"};
	String[] attachmentValuesSightsSniper3 =
			{"00", "20", "30", "50"};
	String[] attachmentNamesMagazineSniper4 =
			{"NONE", "EXTENDED MAGS"};
	String[] attachmentValuesMagazineSniper4 =
			{"00", "10"};
	// M1911 MAKAROV
	String[] M1911_MAKAROV_N_2 =
			{"NONE", "SUPPRESSOR"};
	String[] M1911_MAKAROV_V_2 =
			{"00", "40"};
	String[] M1911_MAKAROV_N_3 =
			{"NONE", "UPGRADED IRON SIGHTS"};
	String[] M1911_MAKAROV_V_3 =
			{"00", "10"};
	String[] M1911_MAKAROV_N_4 =
			{"NONE", "EXTENDED MAGS"};
	String[] M1911_MAKAROV_V_4 =
			{"00", "20"};
	// PYTHON
	String[] PYTHONN_2 =
			{"NONE", "SNUB NOSE"};
	String[] PYTHONV_2 =
			{"00", "20"};
	String[] PYTHONN_3 =
			{"NONE", "ACOG SIGHTS"};
	String[] PYTHONV_3 =
			{"00", "10"};
	String[] PYTHONN_4 =
			{"NONE", "SPEED LOADER"};
	String[] PYTHONV_4 =
			{"00", "30"};
	// CZ75
	String[] CZ75N_2 =
			{"NONE", "SUPPRESSOR"};
	String[] CZ75V_2 =
			{"00", "40"};
	String[] CZ75N_3 =
			{"NONE", "UPGRADED IRON SIGHTS"};
	String[] CZ75V_3 =
			{"00", "10"};
	String[] CZ75N_4 =
			{"NONE", "EXTENDED MAGS", "FULL AUTO"};
	String[] CZ75V_4 =
			{"00", "20", "50"};

	// Other Class Values
	String[] camoNames =
			{"NONE", "DUSTY", "ICE", "RED", "OLIVE", "NEVADA", "SAHARA", "ERDL",
					"TIGER", "BERLIN", "WARSHAW", "SIBERIA", "YUKON", "WOODLAND",
					"FLORA", "GOLD"};
	String[] camoValues =
			{"00", "10", "20", "30", "40", "50", "60", "70", "80", "90", "A0", "B0",
					"C0", "D0", "E0", "F0"};
	String[] equipmentNames =
			{"NONE", "MPL", "G11", "STAKEOUT", "SEMTEX", "ASP", "PM-63", "GALIL",
					"OLYMPIA", "TOMAHAWK", "CZ 75", "SCORPION", "M14", "SPAS-12",
					"M1911", "SPECTRE", "M16", "HS-10 DUAL WIELD", "WILLY PETE",
					"MAKAROV", "UZI", "NOVA GAS", "PYTHON", "KIPARIS DUAL WIELD",
					"HK 21", "M72 LAW", "FLASHBANG", "M60", "ASP DUAL WIELD",
					"MAC-11 DUAL WIELD", "RPG", "CONCUSSION GRENADE", "RPK",
					"CZ 75 DUAL WIELD", "PM-63 DUAL WIELD", "STRELA-3", "DECOY",
					"STONER 63", "M1911 DUAL WIELD", "SCORPION DUAL WIELD", "CROSSBOW",
					"GRENADE LAUNCHER", "MAKAROV DUAL WIELD", "CLAYMORE",
					"PYTHON DUAL WIELD", "AK-47", "DRAGUNOV", "C4", "AUG", "L96A1",
					"SCRAMBLER", "AK-74U", "COMMANDO", "PSG1", "TACTICAL INSERTION",
					"KIPARIS", "ENFIELD", "MOTION SENSOR", "WA2000", "MAC-11", "FAMAS",
					"BALLISTIC KNIFE", "MP5K", "FN FAL", "HS-10", "FRAG"};
	String[] equipmentValues =
			{"00", "01", "02", "03", "04", "10", "11", "12", "13", "14", "20", "21",
					"22", "23", "30", "31", "32", "33", "34", "40", "41", "44", "50",
					"51", "52", "53", "54", "60", "61", "62", "63", "64", "70", "71",
					"72", "73", "74", "80", "81", "82", "83", "90", "93", "94", "A0",
					"A1", "A2", "A4", "B1", "B2", "B4", "C0", "C1", "C2", "C4", "D0",
					"D1", "D2", "E0", "E1", "E3", "E4", "F0", "F1", "F2", "F3"};
	String[] lethalNames =
			{"NONE", "MPL", "G11", "STAKEOUT", "SEMTEX", "ASP", "PM-63", "GALIL",
					"OLYMPIA", "TOMAHAWK", "CZ 75", "SCORPION", "M14", "SPAS-12",
					"M1911", "SPECTRE", "M16", "HS-10 DUAL WIELD", "WILLY PETE",
					"MAKAROV", "UZI", "NOVA GAS", "PYTHON", "KIPARIS DUAL WIELD",
					"HK 21", "M72 LAW", "FLASHBANG", "ASP DUAL WIELD",
					"MAC-11 DUAL WIELD", "M60", "RPG", "CONCUSSION GRENADE",
					"CZ 75 DUAL WIELD", "PM-63 DUAL WIELD", "RPK", "STRELA-3", "DECOY",
					"M1911 DUAL WIELD", "SCORPION DUAL WIELD", "STONER 63", "CROSSBOW",
					"MAKAROV DUAL WIELD", "GRENADE LAUNCHER", "PYTHON DUAL WIELD",
					"AK-47", "DRAGUNOV", "AUG", "L96A1", "AK-74U", "COMMANDO", "PSG1",
					"KIPARIS", "ENFIELD", "WA2000", "MAC-11", "FAMAS",
					"BALLISTIC KNIFE", "MP5K", "FN FAL", "HS-10", "FRAG"};
	String[] lethalValues =
			{"00", "01", "02", "03", "04", "10", "11", "12", "13", "14", "20", "21",
					"22", "23", "30", "31", "32", "33", "34", "40", "41", "44", "50",
					"51", "52", "53", "54", "60", "61", "62", "63", "64", "70", "71",
					"72", "73", "74", "80", "81", "82", "83", "90", "93", "A0", "A1",
					"A2", "B1", "B2", "C0", "C1", "C2", "D0", "D1", "D2", "E0", "E1",
					"E3", "F0", "F1", "F2", "F3"};
	String[] tacticalNames =
			{"NONE", "WILLY PETE", "NOVA GAS", "FLASHBANG", "CONCUSSION GRENADE",
					"DECOY"};
	String[] tacticalValues =
			{"00", "34", "44", "54", "64", "74"};
	String[] perkNames =
			{"NONE", "STEADY AIM PRO", "HACKER PRO", "SCOUT PRO", "TACTICAL MASK PRO",
					"HARDENED PRO", "LIGHTWEIGHT PRO", "SLEIGHT OF HAND PRO",
					"SCAVENGER PRO", "WARLORD PRO", "GHOST PRO", "MARATHON PRO",
					"FLAK JACKET PRO", "NINJA PRO", "HARDLINE PRO", "SECOND CHANCE PRO"};
	String[] perkValues =
			{"00", "1A", "1B", "3A", "3B", "5A", "79", "7A", "99", "9A", "B9", "BA",
					"D9", "DA", "F9", "FA"};

	void updateAddresses()
	{
		if (checkbox[18].isSelected())
		{
			startAddress = globalAddress + 113220;
		} else
		{
			startAddress = globalAddress;
		}
		startAddressC0Equip = startAddress + 2;
		startAddressC0Primary = startAddress + 3;
		startAddressC0Camo = startAddress + 9;
		startAddressC0Lethal = startAddress + 11;
		startAddressC0Secondary = startAddress + 16;
		startAddressC0Tactical = startAddress + 28;
		startAddressC0Perks = startAddress + 29;
	}

	void setCopyRight()
	{
		area.setText("Copyright \u00a9 2012 - 2013 Bully@WiiPlaza Productions");
	}

	void untickAttachments(int comboBoxIndex, int checkBoxIndex)
	{
		if (combobox[comboBoxIndex].getItemCount() == 0)
			checkbox[checkBoxIndex].setSelected(false);
	}

	void emptyComboBox(int comboBoxIndex, int checkBoxIndex)
	{
		if (combobox[comboBoxIndex].getItemCount() == 0)
		{
			checkbox[checkBoxIndex].setSelected(false);
			JOptionPane
					.showMessageDialog(rootPane,
							"Nope! Select a gun which can have attachments in this slot.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	void printNibbles(String addressLine, String[] valueType, int comboboxNumber)
	{
		area.append("\nC0000000 00000006");
		area.append(addressLine);
		area.append("\n896C0000 616B00F0");
		area.append("\n716B00"
				+ valueType[combobox[comboboxNumber].getSelectedIndex()]
				.charAt(0) + "F 996C0000");
		area.append("\n896C0001 616B000F");
		area.append("\n716B00F"
				+ valueType[combobox[comboboxNumber].getSelectedIndex()]
				.charAt(1) + " 996C0001");
		area.append("\n4E800020 00000000");
	}

	void printAttachments(String weaponName, String[] arrayName,
	                      int WeaponComboBox, int AttachmentBox)
	{
		if (combobox[WeaponComboBox].getSelectedItem() == weaponName)
		{
			area.append(arrayName[combobox[AttachmentBox].getSelectedIndex()]);
		}
	}

	void clearAttachments(int checkBoxStart, String offset)
	{
		if (!checkbox[checkBoxStart].isSelected()
				&& !checkbox[checkBoxStart + 1].isSelected()
				&& !checkbox[checkBoxStart + 2].isSelected()
				&& !checkbox[checkBoxStart + 3].isSelected())
		{
			if (offset.length() == 1)
				area.append("\n1000000" + offset + " " + "00040000");
			if (offset.length() == 2)
				area.append("\n100000" + offset + " " + "00040000");
		}
	}

	String getNibbleWriteAddress(int startAddress)
	{
		return ("\n3D80933"
				+ (Integer.toHexString((startAddress + classOffset
				* combobox[18].getSelectedIndex())).toUpperCase())
				.charAt(0)
				+ " 618C"
				+ (Integer.toHexString((startAddress + classOffset
				* combobox[18].getSelectedIndex())).toUpperCase())
				.charAt(1)
				+ (Integer.toHexString((startAddress + classOffset
				* combobox[18].getSelectedIndex())).toUpperCase())
				.charAt(2)
				+ (Integer.toHexString((startAddress + classOffset
				* combobox[18].getSelectedIndex())).toUpperCase())
				.charAt(3) + (Integer
				.toHexString((startAddress + classOffset
						* combobox[18].getSelectedIndex())).toUpperCase())
				.charAt(4));
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	void drawGui()
	{

		//  Attributes
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Black Ops Wii: Ultimate Create-A-Class v1.24");
		setSize(580, 690);

		// Initializing GUI
		for (int i = 0; i < checkbox.length; i++)
		{
			checkbox[i] = new JCheckBox(checkboxTexts[i]);
		}
		for (int i = 0; i < button.length; i++)
		{
			button[i] = new JButton(new ImageIcon(getClass()
					.getResource("images/" + images[i])));
			button[i].setToolTipText(toolTipTexts[i]);
		}

		combobox[0] = new JComboBox(uniformNames);
		combobox[0].setBackground(Color.CYAN);
		checkbox[0].setBackground(Color.CYAN);
		combobox[1] = new JComboBox(equipmentNames);
		combobox[1].setBackground(Color.GRAY);
		checkbox[1].setBackground(Color.GRAY);
		combobox[2] = new JComboBox(lethalNames);
		combobox[2].setBackground(Color.RED);
		checkbox[2].setBackground(Color.RED);
		combobox[3] = new JComboBox();
		combobox[4] = new JComboBox();
		combobox[5] = new JComboBox();
		combobox[6] = new JComboBox();
		combobox[3].setBackground(Color.lightGray);
		checkbox[3].setBackground(Color.lightGray);
		combobox[4].setBackground(Color.lightGray);
		checkbox[4].setBackground(Color.lightGray);
		combobox[5].setBackground(Color.lightGray);
		checkbox[5].setBackground(Color.lightGray);
		combobox[6].setBackground(Color.lightGray);
		checkbox[6].setBackground(Color.lightGray);
		combobox[7] = new JComboBox(camoNames);
		combobox[7].setBackground(Color.MAGENTA);
		checkbox[7].setBackground(Color.MAGENTA);
		combobox[8] = new JComboBox(lethalNames);
		combobox[8].setBackground(Color.ORANGE);
		checkbox[8].setBackground(Color.ORANGE);
		combobox[9] = new JComboBox(lethalNames);
		combobox[9].setBackground(Color.RED);
		checkbox[9].setBackground(Color.RED);
		combobox[10] = new JComboBox();
		combobox[11] = new JComboBox();
		combobox[12] = new JComboBox();
		combobox[13] = new JComboBox();
		combobox[10].setBackground(Color.lightGray);
		checkbox[10].setBackground(Color.lightGray);
		combobox[11].setBackground(Color.lightGray);
		checkbox[11].setBackground(Color.lightGray);
		combobox[12].setBackground(Color.lightGray);
		checkbox[12].setBackground(Color.lightGray);
		combobox[13].setBackground(Color.lightGray);
		checkbox[13].setBackground(Color.lightGray);
		combobox[14] = new JComboBox(tacticalNames);
		combobox[14].setBackground(Color.pink);
		checkbox[14].setBackground(Color.pink);
		combobox[15] = new JComboBox(perkNames);
		combobox[16] = new JComboBox(perkNames);
		combobox[17] = new JComboBox(perkNames);
		combobox[15].setBackground(Color.green);
		checkbox[15].setBackground(Color.green);
		combobox[16].setBackground(Color.green);
		checkbox[16].setBackground(Color.green);
		combobox[17].setBackground(Color.green);
		checkbox[17].setBackground(Color.green);
		combobox[18] = new JComboBox(classNames);
		combobox[18].setBackground(Color.white);

		getContentPane().add(combobox[18]);
		getContentPane().add(checkbox[18]);
		checkbox[18].setBackground(Color.yellow);

		for (int i = 0; i < combobox.length - 1; i++)
		{
			getContentPane().add(checkbox[i]);
			getContentPane().add(combobox[i]);
		}

		for (int i = 0; i < button.length; i++)
		{
			getContentPane().add(button[i]);
		}

		getContentPane().add(pane);
		area.setBackground(Color.yellow);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/Icon.png")));

		setVisible(true);
		updateAddresses();
		setCopyRight();

		checkbox[18].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				updateAddresses();
			}
		});

		// Attachment Display 1
		combobox[2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				checkbox[2].setSelected(true);

				combobox[3].removeAllItems();
				combobox[4].removeAllItems();
				combobox[5].removeAllItems();
				combobox[6].removeAllItems();

				untickAttachments(3, 3);
				untickAttachments(4, 4);
				untickAttachments(5, 5);
				untickAttachments(6, 6);

				// MP5K
				if (combobox[2].getSelectedItem() == "MP5K")
				{
					for (int q = 0; q < MP5KN_2.length; q++)
					{
						combobox[4].insertItemAt(MP5KN_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < MP5KN_3.length; q++)
					{
						combobox[5].insertItemAt(MP5KN_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < MP5KN_4.length; q++)
					{
						combobox[6].insertItemAt(MP5KN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// SCORPION
				if (combobox[2].getSelectedItem() == "SCORPION")
				{

					for (int q = 0; q < SCORPIONN_1.length; q++)
					{
						combobox[3].insertItemAt(SCORPIONN_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < SCORPIONN_2.length; q++)
					{
						combobox[4].insertItemAt(SCORPIONN_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < SCORPIONN_4.length; q++)
					{
						combobox[6].insertItemAt(SCORPIONN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// MAC-11
				if (combobox[2].getSelectedItem() == "MAC-11")
				{

					for (int q = 0; q < MAC_11N_1.length; q++)
					{
						combobox[3].insertItemAt(MAC_11N_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < MAC_11N_2.length; q++)
					{
						combobox[4].insertItemAt(MAC_11N_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < MAC_11N_3.length; q++)
					{
						combobox[5].insertItemAt(MAC_11N_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < MAC_11N_4.length; q++)
					{
						combobox[6].insertItemAt(MAC_11N_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// AK74U
				if (combobox[2].getSelectedItem() == "AK-74U")
				{

					for (int q = 0; q < AK74UN_1.length; q++)
					{
						combobox[3].insertItemAt(AK74UN_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < AK74UN_2.length; q++)
					{
						combobox[4].insertItemAt(AK74UN_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < AK74UN_3.length; q++)
					{
						combobox[5].insertItemAt(AK74UN_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < AK74UN_4.length; q++)
					{
						combobox[6].insertItemAt(AK74UN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// UZI
				if (combobox[2].getSelectedItem() == "UZI")
				{

					for (int q = 0; q < UZIN_1.length; q++)
					{
						combobox[3].insertItemAt(UZIN_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < UZIN_2.length; q++)
					{
						combobox[4].insertItemAt(UZIN_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < UZIN_3.length; q++)
					{
						combobox[5].insertItemAt(UZIN_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < UZIN_4.length; q++)
					{
						combobox[6].insertItemAt(UZIN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// PM63
				if (combobox[2].getSelectedItem() == "PM-63")
				{

					for (int q = 0; q < PM63N_1.length; q++)
					{
						combobox[3].insertItemAt(PM63N_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < PM63N_4.length; q++)
					{
						combobox[6].insertItemAt(PM63N_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// MPL
				if (combobox[2].getSelectedItem() == "MPL")
				{

					for (int q = 0; q < MPLN_1.length; q++)
					{
						combobox[3].insertItemAt(MPLN_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < MPLN_2.length; q++)
					{
						combobox[4].insertItemAt(MPLN_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < MPLN_3.length; q++)
					{
						combobox[5].insertItemAt(MPLN_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < MPLN_4.length; q++)
					{
						combobox[6].insertItemAt(MPLN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// SPECTRE
				if (combobox[2].getSelectedItem() == "SPECTRE")
				{

					for (int q = 0; q < SPECTREN_1.length; q++)
					{
						combobox[3].insertItemAt(SPECTREN_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < SPECTREN_2.length; q++)
					{
						combobox[4].insertItemAt(SPECTREN_2[q], q);
						combobox[4].setSelectedIndex(0);
					}

					for (int q = 0; q < SPECTREN_3.length; q++)
					{
						combobox[5].insertItemAt(SPECTREN_3[q], q);
						combobox[5].setSelectedIndex(0);
					}

					for (int q = 0; q < SPECTREN_4.length; q++)
					{
						combobox[6].insertItemAt(SPECTREN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// KIPARIS
				if (combobox[2].getSelectedItem() == "KIPARIS")
				{

					for (int q = 0; q < KIPARISN_1.length; q++)
					{
						combobox[3].insertItemAt(KIPARISN_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < KIPARISN_2.length; q++)
					{
						combobox[4].insertItemAt(KIPARISN_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < KIPARISN_3.length; q++)
					{
						combobox[5].insertItemAt(KIPARISN_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < KIPARISN_4.length; q++)
					{
						combobox[6].insertItemAt(KIPARISN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// M16 ENFIELD FAMAS GALIL AUG FN_FAL AK_47 COMMANDO
				if (combobox[2].getSelectedItem() == "M16"
						|| combobox[2].getSelectedItem() == "ENFIELD"
						|| combobox[2].getSelectedItem() == "FAMAS"
						|| combobox[2].getSelectedItem() == "GALIL"
						|| combobox[2].getSelectedItem() == "AUG"
						|| combobox[2].getSelectedItem() == "FN FAL"
						|| combobox[2].getSelectedItem() == "AK-47"
						|| combobox[2].getSelectedItem() == "COMMANDO")
				{

					for (int q = 0; q < M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_1.length; q++)
					{
						combobox[3]
								.insertItemAt(
										M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_1[q],
										q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_2.length; q++)
					{
						combobox[4]
								.insertItemAt(
										M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_2[q],
										q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_3.length; q++)
					{
						combobox[5]
								.insertItemAt(
										M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_3[q],
										q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_4.length; q++)
					{
						combobox[6]
								.insertItemAt(
										M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_4[q],
										q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// M14
				if (combobox[2].getSelectedItem() == "M14")
				{

					for (int q = 0; q < M14N_1.length; q++)
					{
						combobox[3].insertItemAt(M14N_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < M14N_2.length; q++)
					{
						combobox[4].insertItemAt(M14N_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < M14N_3.length; q++)
					{
						combobox[5].insertItemAt(M14N_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < M14N_4.length; q++)
					{
						combobox[6].insertItemAt(M14N_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// G11
				if (combobox[2].getSelectedItem() == "G11")
				{
					for (int q = 0; q < G11N_3.length; q++)
					{
						combobox[5].insertItemAt(G11N_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
				}

				// STAKEOUT
				if (combobox[2].getSelectedItem() == "STAKEOUT")
				{

					for (int q = 0; q < STAKEOUTN_1.length; q++)
					{
						combobox[3].insertItemAt(STAKEOUTN_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
				}

				// SPAS-12
				if (combobox[2].getSelectedItem() == "SPAS-12")
				{

					for (int q = 0; q < SPAS12N_2.length; q++)
					{
						combobox[4].insertItemAt(SPAS12N_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
				}

				// HK21
				if (combobox[2].getSelectedItem() == "HK 21")
				{

					for (int q = 0; q < HK21N_3.length; q++)
					{
						combobox[5].insertItemAt(HK21N_3[q], q);
						combobox[5].setSelectedIndex(0);
					}

					for (int q = 0; q < HK21N_4.length; q++)
					{
						combobox[6].insertItemAt(HK21N_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// RPK
				if (combobox[2].getSelectedItem() == "RPK")
				{

					for (int q = 0; q < RPKN_3.length; q++)
					{
						combobox[5].insertItemAt(RPKN_3[q], q);
						combobox[5].setSelectedIndex(0);
					}

					for (int q = 0; q < RPKN_4.length; q++)
					{
						combobox[6].insertItemAt(RPKN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// M60
				if (combobox[2].getSelectedItem() == "M60")
				{
					for (int q = 0; q < M60N_1.length; q++)
					{
						combobox[3].insertItemAt(M60N_1[q], q);
						combobox[3].setSelectedIndex(0);
					}
					for (int q = 0; q < M60N_3.length; q++)
					{
						combobox[5].insertItemAt(M60N_3[q], q);
						combobox[5].setSelectedIndex(0);
					}

					for (int q = 0; q < M60N_4.length; q++)
					{
						combobox[6].insertItemAt(M60N_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// STONER 63
				if (combobox[2].getSelectedItem() == "STONER 63")
				{

					for (int q = 0; q < STONERN_3.length; q++)
					{
						combobox[5].insertItemAt(STONERN_3[q], q);
						combobox[5].setSelectedIndex(0);
					}

					for (int q = 0; q < STONERN_4.length; q++)
					{
						combobox[6].insertItemAt(STONERN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// Sniper
				if (combobox[2].getSelectedItem() == "DRAGUNOV"
						|| combobox[2].getSelectedItem() == "WA2000"
						|| combobox[2].getSelectedItem() == "L96A1"
						|| combobox[2].getSelectedItem() == "PSG1")
				{

					for (int q = 0; q < attachmentNamesAmmoTypeSniper2.length; q++)
					{
						combobox[4].insertItemAt(
								attachmentNamesAmmoTypeSniper2[q], q);
						combobox[4].setSelectedIndex(0);
					}

					for (int q = 0; q < attachmentNamesSightsSniper3.length; q++)
					{
						combobox[5].insertItemAt(
								attachmentNamesSightsSniper3[q], q);
						combobox[5].setSelectedIndex(0);
					}

					for (int q = 0; q < attachmentNamesMagazineSniper4.length; q++)
					{
						combobox[6].insertItemAt(
								attachmentNamesMagazineSniper4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}
				// M1911
				if (combobox[2].getSelectedItem() == "M1911")
				{

					for (int q = 0; q < M1911_MAKAROV_N_2.length; q++)
					{
						combobox[4].insertItemAt(M1911_MAKAROV_N_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < M1911_MAKAROV_N_3.length; q++)
					{
						combobox[5].insertItemAt(M1911_MAKAROV_N_3[q], q);
						combobox[5].setSelectedIndex(0);
					}

					for (int q = 0; q < M1911_MAKAROV_N_4.length; q++)
					{
						combobox[6].insertItemAt(M1911_MAKAROV_N_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// MAKAROV
				if (combobox[2].getSelectedItem() == "MAKAROV")
				{

					for (int q = 0; q < M1911_MAKAROV_N_2.length; q++)
					{
						combobox[4].insertItemAt(M1911_MAKAROV_N_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < M1911_MAKAROV_N_3.length; q++)
					{
						combobox[5].insertItemAt(M1911_MAKAROV_N_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < M1911_MAKAROV_N_4.length; q++)
					{
						combobox[6].insertItemAt(M1911_MAKAROV_N_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// PYTHON
				if (combobox[2].getSelectedItem() == "PYTHON")
				{

					for (int q = 0; q < PYTHONN_2.length; q++)
					{
						combobox[4].insertItemAt(PYTHONN_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < PYTHONN_3.length; q++)
					{
						combobox[5].insertItemAt(PYTHONN_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < PYTHONN_4.length; q++)
					{
						combobox[6].insertItemAt(PYTHONN_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

				// CZ 75
				if (combobox[2].getSelectedItem() == "CZ 75")
				{

					for (int q = 0; q < CZ75N_2.length; q++)
					{
						combobox[4].insertItemAt(CZ75N_2[q], q);
						combobox[4].setSelectedIndex(0);
					}
					for (int q = 0; q < CZ75N_3.length; q++)
					{
						combobox[5].insertItemAt(CZ75N_3[q], q);
						combobox[5].setSelectedIndex(0);
					}
					for (int q = 0; q < CZ75N_4.length; q++)
					{
						combobox[6].insertItemAt(CZ75N_4[q], q);
						combobox[6].setSelectedIndex(0);
					}
				}

			}
		});

		// Attachment Display 2
		combobox[9].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				checkbox[9].setSelected(true);

				combobox[10].removeAllItems();
				combobox[11].removeAllItems();
				combobox[12].removeAllItems();
				combobox[13].removeAllItems();

				untickAttachments(10, 10);
				untickAttachments(11, 11);
				untickAttachments(12, 12);
				untickAttachments(13, 13);

				// MP5K
				if (combobox[9].getSelectedItem() == "MP5K")
				{
					for (int q = 0; q < MP5KN_2.length; q++)
					{
						combobox[11].insertItemAt(MP5KN_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < MP5KN_3.length; q++)
					{
						combobox[12].insertItemAt(MP5KN_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < MP5KN_4.length; q++)
					{
						combobox[13].insertItemAt(MP5KN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// SCORPION
				if (combobox[9].getSelectedItem() == "SCORPION")
				{

					for (int q = 0; q < SCORPIONN_1.length; q++)
					{
						combobox[10].insertItemAt(SCORPIONN_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < SCORPIONN_2.length; q++)
					{
						combobox[11].insertItemAt(SCORPIONN_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < SCORPIONN_4.length; q++)
					{
						combobox[13].insertItemAt(SCORPIONN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// MAC-11
				if (combobox[9].getSelectedItem() == "MAC-11")
				{

					for (int q = 0; q < MAC_11N_1.length; q++)
					{
						combobox[10].insertItemAt(MAC_11N_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < MAC_11N_2.length; q++)
					{
						combobox[11].insertItemAt(MAC_11N_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < MAC_11N_3.length; q++)
					{
						combobox[12].insertItemAt(MAC_11N_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < MAC_11N_4.length; q++)
					{
						combobox[13].insertItemAt(MAC_11N_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// AK74U
				if (combobox[9].getSelectedItem() == "AK-74U")
				{

					for (int q = 0; q < AK74UN_1.length; q++)
					{
						combobox[10].insertItemAt(AK74UN_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < AK74UN_2.length; q++)
					{
						combobox[11].insertItemAt(AK74UN_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < AK74UN_3.length; q++)
					{
						combobox[12].insertItemAt(AK74UN_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < AK74UN_4.length; q++)
					{
						combobox[13].insertItemAt(AK74UN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// UZI
				if (combobox[9].getSelectedItem() == "UZI")
				{

					for (int q = 0; q < UZIN_1.length; q++)
					{
						combobox[10].insertItemAt(UZIN_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < UZIN_2.length; q++)
					{
						combobox[11].insertItemAt(UZIN_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < UZIN_3.length; q++)
					{
						combobox[12].insertItemAt(UZIN_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < UZIN_4.length; q++)
					{
						combobox[13].insertItemAt(UZIN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// PM63
				if (combobox[9].getSelectedItem() == "PM-63")
				{

					for (int q = 0; q < PM63N_1.length; q++)
					{
						combobox[10].insertItemAt(PM63N_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < PM63N_4.length; q++)
					{
						combobox[13].insertItemAt(PM63N_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// MPL
				if (combobox[9].getSelectedItem() == "MPL")
				{

					for (int q = 0; q < MPLN_1.length; q++)
					{
						combobox[10].insertItemAt(MPLN_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < MPLN_2.length; q++)
					{
						combobox[11].insertItemAt(MPLN_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < MPLN_3.length; q++)
					{
						combobox[12].insertItemAt(MPLN_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < MPLN_4.length; q++)
					{
						combobox[13].insertItemAt(MPLN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// SPECTRE
				if (combobox[9].getSelectedItem() == "SPECTRE")
				{

					for (int q = 0; q < SPECTREN_1.length; q++)
					{
						combobox[10].insertItemAt(SPECTREN_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < SPECTREN_2.length; q++)
					{
						combobox[11].insertItemAt(SPECTREN_2[q], q);
						combobox[11].setSelectedIndex(0);
					}

					for (int q = 0; q < SPECTREN_3.length; q++)
					{
						combobox[12].insertItemAt(SPECTREN_3[q], q);
						combobox[12].setSelectedIndex(0);
					}

					for (int q = 0; q < SPECTREN_4.length; q++)
					{
						combobox[13].insertItemAt(SPECTREN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// KIPARIS
				if (combobox[9].getSelectedItem() == "KIPARIS")
				{

					for (int q = 0; q < KIPARISN_1.length; q++)
					{
						combobox[10].insertItemAt(KIPARISN_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < KIPARISN_2.length; q++)
					{
						combobox[11].insertItemAt(KIPARISN_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < KIPARISN_3.length; q++)
					{
						combobox[12].insertItemAt(KIPARISN_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < KIPARISN_4.length; q++)
					{
						combobox[13].insertItemAt(KIPARISN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// M16 ENFIELD FAMAS GALIL AUG FN_FAL AK_47 COMMANDO
				if (combobox[9].getSelectedItem() == "M16"
						|| combobox[9].getSelectedItem() == "ENFIELD"
						|| combobox[9].getSelectedItem() == "FAMAS"
						|| combobox[9].getSelectedItem() == "GALIL"
						|| combobox[9].getSelectedItem() == "AUG"
						|| combobox[9].getSelectedItem() == "FN FAL"
						|| combobox[9].getSelectedItem() == "AK-47"
						|| combobox[9].getSelectedItem() == "COMMANDO")
				{

					for (int q = 0; q < M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_1.length; q++)
					{
						combobox[10]
								.insertItemAt(
										M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_1[q],
										q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_2.length; q++)
					{
						combobox[11]
								.insertItemAt(
										M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_2[q],
										q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_3.length; q++)
					{
						combobox[12]
								.insertItemAt(
										M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_3[q],
										q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_4.length; q++)
					{
						combobox[13]
								.insertItemAt(
										M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDON_4[q],
										q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// M14
				if (combobox[9].getSelectedItem() == "M14")
				{

					for (int q = 0; q < M14N_1.length; q++)
					{
						combobox[10].insertItemAt(M14N_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < M14N_2.length; q++)
					{
						combobox[11].insertItemAt(M14N_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < M14N_3.length; q++)
					{
						combobox[12].insertItemAt(M14N_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < M14N_4.length; q++)
					{
						combobox[13].insertItemAt(M14N_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// G11
				if (combobox[9].getSelectedItem() == "G11")
				{
					for (int q = 0; q < G11N_3.length; q++)
					{
						combobox[12].insertItemAt(G11N_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
				}

				// STAKEOUT
				if (combobox[9].getSelectedItem() == "STAKEOUT")
				{

					for (int q = 0; q < STAKEOUTN_1.length; q++)
					{
						combobox[10].insertItemAt(STAKEOUTN_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
				}

				// SPAS-12
				if (combobox[9].getSelectedItem() == "SPAS-12")
				{

					for (int q = 0; q < SPAS12N_2.length; q++)
					{
						combobox[11].insertItemAt(SPAS12N_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
				}

				// HK21
				if (combobox[9].getSelectedItem() == "HK 21")
				{

					for (int q = 0; q < HK21N_3.length; q++)
					{
						combobox[12].insertItemAt(HK21N_3[q], q);
						combobox[12].setSelectedIndex(0);
					}

					for (int q = 0; q < HK21N_4.length; q++)
					{
						combobox[13].insertItemAt(HK21N_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// RPK
				if (combobox[9].getSelectedItem() == "RPK")
				{

					for (int q = 0; q < RPKN_3.length; q++)
					{
						combobox[12].insertItemAt(RPKN_3[q], q);
						combobox[12].setSelectedIndex(0);
					}

					for (int q = 0; q < RPKN_4.length; q++)
					{
						combobox[13].insertItemAt(RPKN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// M60
				if (combobox[9].getSelectedItem() == "M60")
				{

					for (int q = 0; q < M60N_1.length; q++)
					{
						combobox[10].insertItemAt(M60N_1[q], q);
						combobox[10].setSelectedIndex(0);
					}
					for (int q = 0; q < M60N_3.length; q++)
					{
						combobox[12].insertItemAt(M60N_3[q], q);
						combobox[12].setSelectedIndex(0);
					}

					for (int q = 0; q < M60N_4.length; q++)
					{
						combobox[13].insertItemAt(M60N_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// STONER 63
				if (combobox[9].getSelectedItem() == "STONER 63")
				{

					for (int q = 0; q < STONERN_3.length; q++)
					{
						combobox[12].insertItemAt(STONERN_3[q], q);
						combobox[12].setSelectedIndex(0);
					}

					for (int q = 0; q < STONERN_4.length; q++)
					{
						combobox[13].insertItemAt(STONERN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// Sniper
				if (combobox[9].getSelectedItem() == "DRAGUNOV"
						|| combobox[9].getSelectedItem() == "WA2000"
						|| combobox[9].getSelectedItem() == "L96A1"
						|| combobox[9].getSelectedItem() == "PSG1")
				{

					for (int q = 0; q < attachmentNamesAmmoTypeSniper2.length; q++)
					{
						combobox[11].insertItemAt(
								attachmentNamesAmmoTypeSniper2[q], q);
						combobox[11].setSelectedIndex(0);
					}

					for (int q = 0; q < attachmentNamesSightsSniper3.length; q++)
					{
						combobox[12].insertItemAt(
								attachmentNamesSightsSniper3[q], q);
						combobox[12].setSelectedIndex(0);
					}

					for (int q = 0; q < attachmentNamesMagazineSniper4.length; q++)
					{
						combobox[13].insertItemAt(
								attachmentNamesMagazineSniper4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}
				// M1911
				if (combobox[9].getSelectedItem() == "M1911")
				{

					for (int q = 0; q < M1911_MAKAROV_N_2.length; q++)
					{
						combobox[11].insertItemAt(M1911_MAKAROV_N_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < M1911_MAKAROV_N_3.length; q++)
					{
						combobox[12].insertItemAt(M1911_MAKAROV_N_3[q], q);
						combobox[12].setSelectedIndex(0);
					}

					for (int q = 0; q < M1911_MAKAROV_N_4.length; q++)
					{
						combobox[13].insertItemAt(M1911_MAKAROV_N_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// MAKAROV
				if (combobox[9].getSelectedItem() == "MAKAROV")
				{

					for (int q = 0; q < M1911_MAKAROV_N_2.length; q++)
					{
						combobox[11].insertItemAt(M1911_MAKAROV_N_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < M1911_MAKAROV_N_3.length; q++)
					{
						combobox[12].insertItemAt(M1911_MAKAROV_N_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < M1911_MAKAROV_N_4.length; q++)
					{
						combobox[13].insertItemAt(M1911_MAKAROV_N_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// PYTHON
				if (combobox[9].getSelectedItem() == "PYTHON")
				{

					for (int q = 0; q < PYTHONN_2.length; q++)
					{
						combobox[11].insertItemAt(PYTHONN_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < PYTHONN_3.length; q++)
					{
						combobox[12].insertItemAt(PYTHONN_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < PYTHONN_4.length; q++)
					{
						combobox[13].insertItemAt(PYTHONN_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

				// CZ 75
				if (combobox[9].getSelectedItem() == "CZ 75")
				{

					for (int q = 0; q < CZ75N_2.length; q++)
					{
						combobox[11].insertItemAt(CZ75N_2[q], q);
						combobox[11].setSelectedIndex(0);
					}
					for (int q = 0; q < CZ75N_3.length; q++)
					{
						combobox[12].insertItemAt(CZ75N_3[q], q);
						combobox[12].setSelectedIndex(0);
					}
					for (int q = 0; q < CZ75N_4.length; q++)
					{
						combobox[13].insertItemAt(CZ75N_4[q], q);
						combobox[13].setSelectedIndex(0);
					}
				}

			}
		});

		// Generate Code
		button[0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int j = 0;

				for (int i = 0; i < checkbox.length - 1; i++)
				{
					if (checkbox[i].isSelected() == true)
						j++;
				}

				if (j == 0)
				{
					JOptionPane.showMessageDialog(rootPane, "Nothing ticked!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				area.setText("");
				if (checkbox[18].isSelected())
					area.append("Combat Training ");
				else
					area.append("Public ");
				area.append(classNames[combobox[18].getSelectedIndex()]
						+ " Modifier [Bully@WiiPlaza]");
				area.append("\n201D6324 FFFFFFFA");
				if (checkbox[2].isSelected() || checkbox[3].isSelected()
						|| checkbox[4].isSelected()
						|| checkbox[5].isSelected()
						|| checkbox[6].isSelected()
						|| checkbox[9].isSelected()
						|| checkbox[10].isSelected()
						|| checkbox[11].isSelected()
						|| checkbox[12].isSelected()
						|| checkbox[13].isSelected())
				{
					area.append("\n4A000000 933"
							+ Integer.toHexString(
							(startAddress + classOffset
									* combobox[18]
									.getSelectedIndex()))
							.toUpperCase());
				}

				if (checkbox[0].isSelected())
				{
					printNibbles(getNibbleWriteAddress(startAddress),
							uniformValues, 0);
				}

				// Equipment
				if (checkbox[1].isSelected())
					printNibbles(
							getNibbleWriteAddress(startAddressC0Equip),
							equipmentValues, 1);

				// Primary Weapon
				if (checkbox[2].isSelected())
				{
					printNibbles(
							getNibbleWriteAddress(startAddressC0Primary),
							lethalValues, 2);
					clearAttachments(3, "5");
				}

				int AttachmentIndex;
				int weaponIndex;

				// 1st Attachment
				if (checkbox[3].isSelected())
				{
					area.append("\n10000005 000000");

					weaponIndex = 2;
					AttachmentIndex = 3;

					printAttachments("SCORPION", SCORPIONV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("MAC-11", MAC_11V_1, weaponIndex,
							AttachmentIndex);
					printAttachments("AK-74U", AK74UV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("UZI", UZIV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("PM-63", PM63V_1, weaponIndex,
							AttachmentIndex);
					printAttachments("MPL", MPLV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("SPECTRE", SPECTREV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("KIPARIS", KIPARISV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("M16",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("ENFIELD",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("FAMAS",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("GALIL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("AUG",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("FN FAL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("AK-47",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("COMMANDO",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("M14", M14V_1, weaponIndex,
							AttachmentIndex);
					printAttachments("STAKEOUT", STAKEOUTV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("M60", M60V_1, weaponIndex,
							AttachmentIndex);
				}

				// 2nd Attachment
				if (checkbox[4].isSelected())
				{
					area.append("\n10000006 000000");

					weaponIndex = 2;
					AttachmentIndex = 4;

					printAttachments("MP5K", MP5KV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("SCORPION", SCORPIONV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("MAC-11", MAC_11V_2, weaponIndex,
							AttachmentIndex);
					printAttachments("AK-74U", AK74UV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("UZI", UZIV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("MPL", MPLV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("SPECTRE", SPECTREV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("KIPARIS", KIPARISV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("M16",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("ENFIELD",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("FAMAS",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("GALIL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("AUG",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("FN FAL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("AK-47",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("COMMANDO",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("M14", M14V_2, weaponIndex,
							AttachmentIndex);
					printAttachments("SPAS-12", SPAS12V_2, weaponIndex,
							AttachmentIndex);
					printAttachments("DRAGUNOV",
							attachmentValuesAmmoTypeSniper2, weaponIndex,
							AttachmentIndex);
					printAttachments("WA2000",
							attachmentValuesAmmoTypeSniper2, weaponIndex,
							AttachmentIndex);
					printAttachments("L96A1",
							attachmentValuesAmmoTypeSniper2, weaponIndex,
							AttachmentIndex);
					printAttachments("PSG1",
							attachmentValuesAmmoTypeSniper2, weaponIndex,
							AttachmentIndex);
					printAttachments("M1911", M1911_MAKAROV_V_2,
							weaponIndex, AttachmentIndex);
					printAttachments("MAKAROV", M1911_MAKAROV_V_2,
							weaponIndex, AttachmentIndex);
					printAttachments("PYTHON", PYTHONV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("CZ 75", CZ75V_2, weaponIndex,
							AttachmentIndex);
				}

				// 3rd Attachment
				if (checkbox[5].isSelected())
				{
					area.append("\n10000007 000000");

					weaponIndex = 2;
					AttachmentIndex = 5;

					printAttachments("MP5K", MP5KV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("MAC-11", MAC_11V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("AK-74U", AK74UV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("UZI", UZIV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("MPL", MPLV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("SPECTRE", SPECTREV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("KIPARIS", KIPARISV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("M16",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("ENFIELD",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("FAMAS",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("GALIL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("AUG",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("FN FAL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("AK-47",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("COMMANDO",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("M14", M14V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("G11", G11V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("HK 21", HK21V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("RPK", RPKV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("M60", M60V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("STONER 63", STONERV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("DRAGUNOV",
							attachmentValuesSightsSniper3, weaponIndex,
							AttachmentIndex);
					printAttachments("WA2000",
							attachmentValuesSightsSniper3, weaponIndex,
							AttachmentIndex);
					printAttachments("L96A1",
							attachmentValuesSightsSniper3, weaponIndex,
							AttachmentIndex);
					printAttachments("PSG1", attachmentValuesSightsSniper3,
							weaponIndex, AttachmentIndex);
					printAttachments("M1911", M1911_MAKAROV_V_3,
							weaponIndex, AttachmentIndex);
					printAttachments("MAKAROV", M1911_MAKAROV_V_3,
							weaponIndex, AttachmentIndex);
					printAttachments("PYTHON", PYTHONV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("CZ 75", CZ75V_3, weaponIndex,
							AttachmentIndex);
				}

				// 4th Attachment
				if (checkbox[6].isSelected())
				{
					area.append("\n10000008 000000");

					weaponIndex = 2;
					AttachmentIndex = 6;

					printAttachments("MP5K", MP5KV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("SCORPION", SCORPIONV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("MAC-11", MAC_11V_4, weaponIndex,
							AttachmentIndex);
					printAttachments("AK-74U", AK74UV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("UZI", UZIV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("PM-63", PM63V_4, weaponIndex,
							AttachmentIndex);
					printAttachments("MPL", MPLV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("SPECTRE", SPECTREV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("KIPARIS", KIPARISV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("M16",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("ENFIELD",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("FAMAS",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("GALIL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("AUG",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("FN FAL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("AK-47",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("COMMANDO",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("M14", M14V_4, weaponIndex,
							AttachmentIndex);
					printAttachments("HK 21", HK21V_4, weaponIndex,
							AttachmentIndex);
					printAttachments("RPK", RPKV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("M60", AK74UV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("STONER 63", STONERV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("DRAGUNOV",
							attachmentValuesMagazineSniper4, weaponIndex,
							AttachmentIndex);
					printAttachments("WA2000",
							attachmentValuesMagazineSniper4, weaponIndex,
							AttachmentIndex);
					printAttachments("L96A1",
							attachmentValuesMagazineSniper4, weaponIndex,
							AttachmentIndex);
					printAttachments("PSG1",
							attachmentValuesMagazineSniper4, weaponIndex,
							AttachmentIndex);
					printAttachments("M1911", M1911_MAKAROV_V_4,
							weaponIndex, AttachmentIndex);
					printAttachments("MAKAROV", M1911_MAKAROV_V_4,
							weaponIndex, AttachmentIndex);
					printAttachments("PYTHON", PYTHONV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("CZ 75", CZ75V_4, weaponIndex,
							AttachmentIndex);
				}

				// Camo
				if (checkbox[7].isSelected())
					printNibbles(getNibbleWriteAddress(startAddressC0Camo),
							camoValues, 7);

				// Lethal
				if (checkbox[8].isSelected())
					printNibbles(
							getNibbleWriteAddress(startAddressC0Lethal),
							lethalValues, 8);

				// Secondary Weapon
				if (checkbox[9].isSelected())
				{
					printNibbles(
							getNibbleWriteAddress(startAddressC0Secondary),
							lethalValues, 9);
					clearAttachments(10, "12");
				}

				// 1st Attachment S
				if (checkbox[10].isSelected())
				{
					area.append("\n10000012 000000");

					weaponIndex = 9;
					AttachmentIndex = 10;

					printAttachments("SCORPION", SCORPIONV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("MAC-11", MAC_11V_1, weaponIndex,
							AttachmentIndex);
					printAttachments("AK-74U", AK74UV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("UZI", UZIV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("PM-63", PM63V_1, weaponIndex,
							AttachmentIndex);
					printAttachments("MPL", MPLV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("SPECTRE", SPECTREV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("KIPARIS", KIPARISV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("M16",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("ENFIELD",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("FAMAS",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("GALIL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("AUG",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("FN FAL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("AK-47",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("COMMANDO",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_1,
							weaponIndex, AttachmentIndex);
					printAttachments("M14", M14V_1, weaponIndex,
							AttachmentIndex);
					printAttachments("STAKEOUT", STAKEOUTV_1, weaponIndex,
							AttachmentIndex);
					printAttachments("M60", M60V_1, weaponIndex,
							AttachmentIndex);
				}

				// 2nd Attachment S
				if (checkbox[11].isSelected())
				{
					area.append("\n10000013 000000");

					weaponIndex = 9;
					AttachmentIndex = 11;

					printAttachments("MP5K", MP5KV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("SCORPION", SCORPIONV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("MAC-11", MAC_11V_2, weaponIndex,
							AttachmentIndex);
					printAttachments("AK-74U", AK74UV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("UZI", UZIV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("MPL", MPLV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("SPECTRE", SPECTREV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("KIPARIS", KIPARISV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("M16",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("ENFIELD",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("FAMAS",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("GALIL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("AUG",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("FN FAL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("AK-47",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("COMMANDO",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_2,
							weaponIndex, AttachmentIndex);
					printAttachments("M14", M14V_2, weaponIndex,
							AttachmentIndex);
					printAttachments("SPAS-12", SPAS12V_2, weaponIndex,
							AttachmentIndex);
					printAttachments("DRAGUNOV",
							attachmentValuesAmmoTypeSniper2, weaponIndex,
							AttachmentIndex);
					printAttachments("WA2000",
							attachmentValuesAmmoTypeSniper2, weaponIndex,
							AttachmentIndex);
					printAttachments("L96A1",
							attachmentValuesAmmoTypeSniper2, weaponIndex,
							AttachmentIndex);
					printAttachments("PSG1",
							attachmentValuesAmmoTypeSniper2, weaponIndex,
							AttachmentIndex);
					printAttachments("M1911", M1911_MAKAROV_V_2,
							weaponIndex, AttachmentIndex);
					printAttachments("MAKAROV", M1911_MAKAROV_V_2,
							weaponIndex, AttachmentIndex);
					printAttachments("PYTHON", PYTHONV_2, weaponIndex,
							AttachmentIndex);
					printAttachments("CZ 75", CZ75V_2, weaponIndex,
							AttachmentIndex);
				}

				// 3rd Attachment S
				if (checkbox[12].isSelected())
				{
					area.append("\n10000014 000000");

					weaponIndex = 9;
					AttachmentIndex = 12;

					printAttachments("MP5K", MP5KV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("MAC-11", MAC_11V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("AK-74U", AK74UV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("UZI", UZIV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("MPL", MPLV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("SPECTRE", SPECTREV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("KIPARIS", KIPARISV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("M16",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("ENFIELD",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("FAMAS",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("GALIL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("AUG",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("FN FAL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("AK-47",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("COMMANDO",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_3,
							weaponIndex, AttachmentIndex);
					printAttachments("M14", M14V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("G11", G11V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("HK 21", HK21V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("RPK", RPKV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("M60", M60V_3, weaponIndex,
							AttachmentIndex);
					printAttachments("STONER 63", STONERV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("DRAGUNOV",
							attachmentValuesSightsSniper3, weaponIndex,
							AttachmentIndex);
					printAttachments("WA2000",
							attachmentValuesSightsSniper3, weaponIndex,
							AttachmentIndex);
					printAttachments("L96A1",
							attachmentValuesSightsSniper3, weaponIndex,
							AttachmentIndex);
					printAttachments("PSG1", attachmentValuesSightsSniper3,
							weaponIndex, AttachmentIndex);
					printAttachments("M1911", M1911_MAKAROV_V_3,
							weaponIndex, AttachmentIndex);
					printAttachments("MAKAROV", M1911_MAKAROV_V_3,
							weaponIndex, AttachmentIndex);
					printAttachments("PYTHON", PYTHONV_3, weaponIndex,
							AttachmentIndex);
					printAttachments("CZ 75", CZ75V_3, weaponIndex,
							AttachmentIndex);
				}

				// 4th Attachment S
				if (checkbox[13].isSelected())
				{
					area.append("\n10000015 000000");

					weaponIndex = 9;
					AttachmentIndex = 13;

					printAttachments("MP5K", MP5KV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("SCORPION", SCORPIONV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("MAC-11", MAC_11V_4, weaponIndex,
							AttachmentIndex);
					printAttachments("AK-74U", AK74UV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("UZI", UZIV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("PM-63", PM63V_4, weaponIndex,
							AttachmentIndex);
					printAttachments("MPL", MPLV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("SPECTRE", SPECTREV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("KIPARIS", KIPARISV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("M16",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("ENFIELD",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("FAMAS",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("GALIL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("AUG",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("FN FAL",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("AK-47",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("COMMANDO",
							M16ENFIELDFAMASGALILAUGFN_FALAK_47COMMANDOV_4,
							weaponIndex, AttachmentIndex);
					printAttachments("M14", M14V_4, weaponIndex,
							AttachmentIndex);
					printAttachments("HK 21", HK21V_4, weaponIndex,
							AttachmentIndex);
					printAttachments("RPK", RPKV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("M60", AK74UV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("STONER 63", STONERV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("DRAGUNOV",
							attachmentValuesMagazineSniper4, weaponIndex,
							AttachmentIndex);
					printAttachments("WA2000",
							attachmentValuesMagazineSniper4, weaponIndex,
							AttachmentIndex);
					printAttachments("L96A1",
							attachmentValuesMagazineSniper4, weaponIndex,
							AttachmentIndex);
					printAttachments("PSG1",
							attachmentValuesMagazineSniper4, weaponIndex,
							AttachmentIndex);
					printAttachments("M1911", M1911_MAKAROV_V_4,
							weaponIndex, AttachmentIndex);
					printAttachments("MAKAROV", M1911_MAKAROV_V_4,
							weaponIndex, AttachmentIndex);
					printAttachments("PYTHON", PYTHONV_4, weaponIndex,
							AttachmentIndex);
					printAttachments("CZ 75", CZ75V_4, weaponIndex,
							AttachmentIndex);
				}

				// Tactical
				if (checkbox[14].isSelected())
					printNibbles(
							getNibbleWriteAddress(startAddressC0Tactical),
							tacticalValues, 14);

				// Perk 1
				if (checkbox[15].isSelected())
					printNibbles(
							getNibbleWriteAddress(startAddressC0Perks),
							perkValues, 15);

				// Perk 2
				if (checkbox[16].isSelected())
					printNibbles(
							getNibbleWriteAddress(startAddressC0Perks + 1),
							perkValues, 16);

				// Perk 3
				if (checkbox[17].isSelected())
					printNibbles(
							getNibbleWriteAddress(startAddressC0Perks + 2),
							perkValues, 17);

				// Code Ending
				area.append("\nE0000000 80008000");
				area.append("\n*Credits to strakn, Savage & MasterQ9999*");

				Clipboard cb = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				StringSelection stringSelection = new StringSelection(area
						.getText());
				cb.setContents(stringSelection, stringSelection);

				JOptionPane.showMessageDialog(rootPane,
						"Code saved to clipboard!", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		checkbox[3].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				emptyComboBox(3, 3);
			}
		});

		checkbox[4].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				emptyComboBox(4, 4);
			}
		});

		checkbox[5].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				emptyComboBox(5, 5);
			}
		});

		checkbox[6].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				emptyComboBox(6, 6);
			}
		});

		checkbox[10].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				emptyComboBox(10, 10);
			}
		});

		checkbox[11].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				emptyComboBox(11, 11);
			}
		});

		checkbox[12].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				emptyComboBox(12, 12);
			}
		});

		checkbox[13].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				emptyComboBox(13, 13);
			}
		});

		// Reset
		button[1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				for (int i = 0; i < combobox.length; i++)
				{
					if (combobox[i].getSelectedIndex() != -1)
					{
						combobox[i].setSelectedIndex(0);
					}
				}

				for (int i = 0; i < checkbox.length; i++)
				{
					checkbox[i].setSelected(false);
				}

				setCopyRight();
			}
		});

		button[2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane
						.showMessageDialog(
								rootPane,
								"- In order to generate your code, you have to tick at least one option and then press the 'Code' button\n- Reset your class if the code doesn't appear to be working properly\n- A custom class name modifier won't be included\n- To use dual wielded weapons, select '<WEAPON NAME> DUAL WIELD' from the list\n- To have more than one same lethal or tactical grenade at a time,\n   replace your primary / secondary weapon, lethal or equipment\n- The uniform is independent from the perks you use\n- Copy classes from slot 1-5 to 6-10 to own more than 5 modded classes at a time\n- To modify Combat Training classes, tick that option before creating the code\n- Slots have the following priority when stacked with lethals / tacticals:\n  Secondary Weapon, Primary Weapon, Lethal, Tactical and Equipment\n- Do not create attachment codes without using the same gun (!) also\n\nReport any bugs or suggestions to 'Bully@WiiPlaza'!", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		button[3].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (java.awt.Desktop.isDesktopSupported())
				{
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE))
					{
						java.net.URI uri = null;
						try
						{
							uri = new java.net.URI("http://adf.ly/BwiXw");
						} catch (URISyntaxException e1)
						{
							e1.printStackTrace();
						}
						try
						{
							desktop.browse(uri);
						} catch (IOException e1)
						{
							e1.printStackTrace();
						}

					}
				}
			}
		});

		button[4].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (java.awt.Desktop.isDesktopSupported())
				{
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE))
					{
						java.net.URI uri = null;
						try
						{
							uri = new java.net.URI("http://adf.ly/BuhQm");
						} catch (URISyntaxException e1)
						{
							e1.printStackTrace();
						}
						try
						{
							desktop.browse(uri);
						} catch (IOException e1)
						{
							e1.printStackTrace();
						}

					}
				}
			}
		});

		button[5].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (java.awt.Desktop.isDesktopSupported())
				{
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE))
					{
						java.net.URI uri = null;
						try
						{
							uri = new java.net.URI(
									"https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=DN644F3DPVGZ6");
						} catch (URISyntaxException e1)
						{
							e1.printStackTrace();
						}
						try
						{
							desktop.browse(uri);
						} catch (IOException e1)
						{
							e1.printStackTrace();
						}

					}
				}
			}
		});
	}
}