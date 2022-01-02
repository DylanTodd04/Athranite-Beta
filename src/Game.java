import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Game{



	JFrame window;
	Container con;
	JPanel bgPanel,playerStatsPanel2, mapPanel, returnPanel ,partyDisplayPanel, charIconPanel ,mapReturnPanel ,titlePanel,partyPanel ,nextPanel, equipPanel ,mainAreaPanel, inventoryPanel, playerStatsPanel ,startButtonPanel,armorPanel,optionsPopUp, returnToGamePanel ,choiceButtonPanel, imageDisplayPanel, optionsPanel, inventoryButtonsPanel, extraStatsPanel;
	JPanel partyPanel1, partyPanel2, partyList, partyPanel3, partyPanel4, partyAdd1,partyAdd2,partyAdd3;
	JLabel titleLabel, backgroundImage, mainImageLabel,armorLabel,armorLabelValue ,hpLabel, hpLabelValue, weaponLabel, weaponLabelValue;
	JLabel hp,damage,name,rarity,hpValue,damageValue,nameValue,rarityValue, charIconLabel;
	JLabel partyIcon1, partyIcon2, partyIcon3, partyIconName1, partyIconName2, partyIconName3;
	JLabel partyIcons1, partyIcons2, partyIcons3;
	JButton startButton, mainTextAreaButton, mapButton,partyButton, returnTitleButton, returnGameButton ,inventoryButton, optionsButton, equipButton, unequipButton ,returnToTitleButton ,returnToGameButton, returnToGameButton2;
	JButton choice1, choice2, choice3, choice4, partyAddButton1, partyAddButton2, partyAddButton3;
	JButton removeParty1, removeParty2, removeParty3;
	JButton[] inventoryButtons = new JButton [20];
	JButton[] partyButtons = new JButton[20];


	JTextArea mainTextArea;
	ImageIcon startingScreen,mapIcon ,athraniteMap,startButtonImage,taniaIcon ,athranite, athraniteLogo, optionsIcon, inventoryIcon;

	JButton muteAudioButton = new JButton("Mute Audio");
	JButton returnToTitle = new JButton("Return to Title");
	JButton saveGame = new JButton("Save Game");

	ImageIcon forestAreaImage,taniaFace,fitzFace, kayneFace,forestRoadEncounterImage ,deathImage, forestRoad ,forestEncounterImage ,forestTrailImage, mountainImage, mountainDoorImage, clearingImage, plusLogo;

	static musicStuff musicObject;
	static soundStuff soundObject;

	Font defaultFont = new Font("Segoe Print", Font.PLAIN, 30);
	Font smallFont = new Font("Segoe Print", Font.PLAIN, 25);

	Color lime = new Color(173,255,47);
	Color darkRed = new Color(128,0,0);
	Color darkGreen = new Color(51,102,0);

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	nextDialogueHandler next = new nextDialogueHandler();
	optionButtonHandler optionHandler = new optionButtonHandler();
	muteButtonHandler muteButton = new muteButtonHandler();
	InventoryScreenHandler inventoryHandler = new InventoryScreenHandler();
	returnToGameHandler returnHandler = new returnToGameHandler();
	returnToTitleHandler titleHandler = new returnToTitleHandler();
	inventoryButtonHandler inventoryButtonHandler = new inventoryButtonHandler();
	equipButtonHandler equipHandler = new equipButtonHandler();
	unequipButtonHandler unequipHandler = new unequipButtonHandler();
	mapButtonHandler mapHandler = new mapButtonHandler();
	partyButtonHandler partyHandler = new partyButtonHandler();
	partyArrayButtonHandler partyArrayHandler = new partyArrayButtonHandler();
	removeButtonHandler removeHandler = new removeButtonHandler();
	partyAddHandler addHandler = new partyAddHandler();

	static ArrayList<String> inventory = new ArrayList<String>();

	int playerHP, playerDefaultHP = 15;

	int partyMembers = 0;

	int partyButtonCounter;

	int itemDamage;
	String itemName = "N/A", itemRarity = "N/A", itemHP = "N/A";

	String weapon, currentLocation, armor = "None";
	static String filepath;

	Boolean optionsOpened = false;
	Boolean muteAudio = false;
	Boolean hasKey = false;
	Boolean full = false;
	Boolean fullParty = false;
	Boolean encounterTrail = false;
	Boolean trailEncounter = false;
	Boolean choiceOpened = false;
	Boolean nextOpened = false;
	Boolean add = false;
	Boolean partySlot1, partySlot2, partySlot3;






	public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException
	{
		new Game();

		KeyClass keyInput = new KeyClass();


	}

	public Game()
	{



		filepath = "Music/introMusic.wav";

		musicObject = new musicStuff();
		soundObject = new soundStuff();

		if (muteAudio != true)
		{
			musicObject.playMusic(filepath);
		}

		//Window -------------------------------------------------------------------------------------------------------



		window = new JFrame();
		window.setSize(1200, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows closure of the window
		window.getContentPane().setBackground(Color.black); //Sets window colour
		window.setLayout(null); //disables default layout, but I'm creating my own
		window.setResizable(false); //Stops the window from being resizable
		//window.setIconImage();
		con = window.getContentPane(); //gets the information of window for con

		athraniteLogo = new ImageIcon("Assets/Misc/Athranite logo.jpg");

		//--------------------------------------------------------------------------------------------------------------

		athranite = new ImageIcon ("Assets/TitleScreen/Athranite!.png");

		titlePanel = new JPanel();
		titlePanel.setBounds(30,50,700,200);
		titlePanel.setBackground(Color.black);
		titlePanel.setVisible(true);

		titleLabel = new JLabel();
		titleLabel.setIcon(athranite);
		titleLabel.setForeground(lime);
		titlePanel.add(titleLabel);



		con.add(titlePanel);

		//---

		startButtonImage = new ImageIcon("Assets/TitleScreen/startButton.png");

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(200,600,300,120);
		startButtonPanel.setBackground(Color.black);
		startButtonPanel.setVisible(true);

		startButton = new JButton();
		startButton.setIcon(startButtonImage);
		startButton.setBackground(Color.black);
		startButton.setForeground(lime);
		startButton.addActionListener(tsHandler);
		startButton.setVisible(true);
		startButton.setFocusPainted(false);  //removes jpanel outline
		startButton.setBorderPainted(false); //removes button outline
		startButton.setContentAreaFilled(true);
		startButtonPanel.add(startButton);

		con.add(startButtonPanel);

		//---------------------------------


		mapReturnPanel = new JPanel();
		mapReturnPanel.setBounds(1025,700,150,50);
		mapReturnPanel.setBackground(Color.black);
		mapReturnPanel.setVisible(false);
		mapReturnPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		mapReturnPanel.setLayout(new GridLayout(1,1));
		con.add(mapReturnPanel);

		returnToGameButton2 = new JButton("Return to Game");
		returnToGameButton2.setFocusPainted(false);
		returnToGameButton2.setBackground(Color.black);
		returnToGameButton2.setForeground(Color.white);
		returnToGameButton2.addActionListener(returnHandler);
		mapReturnPanel.add(returnToGameButton2);


		//---------------------------------

		startingScreen = new ImageIcon("Assets/TitleScreen/startScreen.png");

		bgPanel = new JPanel();
		bgPanel.setBounds(0,0,1200,800);
		bgPanel.setBackground(Color.black);
		bgPanel.setVisible(true);

		backgroundImage = new JLabel();
		backgroundImage.setBounds(0,0,1200,800);
		bgPanel.add(backgroundImage);

		backgroundImage.setIcon(startingScreen);

		con.add(bgPanel);
		window.setVisible(true);
	}

	public void createGameScreen()
	{
		titlePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		bgPanel.setVisible(false);

		//------------------------------------------------------
		//all the image icons that will be used in the game

		forestAreaImage = new ImageIcon("Assets/Forest/ForestStart.png");

		deathImage = new ImageIcon("Assets/Misc/Death.jpg");

		forestTrailImage = new ImageIcon("Assets/Forest/forestTrail.png");

		mountainImage = new ImageIcon("Assets/Mountain/MountainArea.png");

		mountainDoorImage = new ImageIcon("Assets/Mountain/MountainDoor.jpg");

		clearingImage = new ImageIcon("Assets/Forest/clearing.png");

		forestEncounterImage = new ImageIcon("Assets/Forest/forestTrailEncounter.png");

		athraniteMap = new ImageIcon("Assets/Misc/Athranite.jpg");

		mapIcon = new ImageIcon("Assets/Misc/mapIcon.png");

		taniaIcon = new ImageIcon("Assets/Misc/TaniaIcon.png");

		forestRoad = new ImageIcon("Assets/Forest/forestRoad.png");

		forestRoadEncounterImage = new ImageIcon("Assets/Forest/forestRoadEncounter.png");

		taniaFace = new ImageIcon("Assets/Misc/TaniaFace.png");

		fitzFace = new ImageIcon("Assets/Misc/FitzFace.png");

		kayneFace = new ImageIcon("Assets/Misc/KayneFace.png");

		plusLogo = new ImageIcon("Assets/Misc/PlusLogo.png");

		//------------------------------------------------------
		imageDisplayPanel = new JPanel();
		imageDisplayPanel.setBounds(300,100,600,350);
		imageDisplayPanel.setBackground(Color.black);
		imageDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		con.add(imageDisplayPanel);

		mainImageLabel = new JLabel();
		mainImageLabel.setVisible(false);
		imageDisplayPanel.add(mainImageLabel);

		//---------------------------------
		//options 

		optionsIcon = new ImageIcon("Assets/Misc/optionsIcon.png");


		optionsPanel = new JPanel();
		optionsPanel.setBounds(1050,558,30,30);
		optionsPanel.setBackground(Color.black);
		optionsPanel.setLayout(new GridLayout(1,1));
		con.add(optionsPanel);

		optionsButton = new JButton();
		optionsButton.setFocusPainted(false);
		optionsButton.setBorderPainted(false);
		optionsButton.setContentAreaFilled(true);
		optionsButton.setForeground(Color.DARK_GRAY);
		optionsButton.setBackground(Color.black);
		optionsButton.setIcon(optionsIcon);
		optionsButton.addActionListener(optionHandler);
		optionsPanel.add(optionsButton);

		optionsPopUp = new JPanel();
		optionsPopUp.setVisible(false);
		optionsPopUp.setBounds(940,351,150,200);
		optionsPopUp.setBorder(BorderFactory.createLineBorder(Color.white));
		optionsPopUp.setBackground(Color.black);
		optionsPopUp.setLayout(new GridLayout(3,1));
		con.add(optionsPopUp);

		muteAudioButton.setFocusPainted(false);
		muteAudioButton.setBackground(Color.black);
		muteAudioButton.setForeground(darkGreen);
		muteAudioButton.addActionListener(muteButton);
		optionsPopUp.add(muteAudioButton);

		saveGame.setFocusPainted(false);
		saveGame.setBackground(Color.black);
		saveGame.setForeground(Color.white);
		//saveGame.addActionListener();
		optionsPopUp.add(saveGame);

		returnToTitle.setFocusPainted(false);
		returnToTitle.setForeground(Color.white);
		returnToTitle.setBackground(Color.black);
		returnToTitle.addActionListener(titleHandler);
		optionsPopUp.add(returnToTitle);
		//------------------------------------------

		mapPanel = new JPanel();
		mapPanel.setBounds(80,700,65,60);
		mapPanel.setBackground(Color.black);
		mapPanel.setLayout(new GridLayout(1,1));
		con.add(mapPanel);

		mapButton = new JButton();
		mapButton.setFocusPainted(false);
		mapButton.setContentAreaFilled(false);
		mapButton.setBorderPainted(false);
		mapButton.setIcon(mapIcon);
		mapButton.addActionListener(mapHandler);
		mapPanel.add(mapButton);

		//-----------------------------------------

		nextPanel = new JPanel();
		nextPanel.setBounds(1001,655,80,40);
		nextPanel.setBackground(Color.black);
		nextPanel.setLayout(new GridLayout(1,1));
		con.add(nextPanel);


		charIconPanel = new JPanel();
		charIconPanel.setBounds(930,560,100,130);
		charIconPanel.setBackground(Color.black);
		charIconPanel.setVisible(false);
		con.add(charIconPanel);

		charIconLabel = new JLabel();
		charIconPanel.add(charIconLabel);

		returnPanel = new JPanel();
		returnPanel.setBackground(Color.black);
		returnPanel.setBounds(880,690,300,60);
		returnPanel.setLayout(new GridLayout(1,2));
		returnPanel.setVisible(false);
		con.add(returnPanel);

		returnTitleButton = new JButton("Return to Title");
		returnTitleButton.setFocusPainted(false);
		returnTitleButton.setContentAreaFilled(false);
		returnTitleButton.addActionListener(titleHandler);
		returnPanel.add(returnTitleButton);

		returnGameButton = new JButton("Return to Game");
		returnGameButton.setFocusPainted(false);
		returnGameButton.setContentAreaFilled(false);
		returnGameButton.addActionListener(returnHandler);
		returnPanel.add(returnGameButton);

		mainTextAreaButton = new JButton("Next");
		mainTextAreaButton.setForeground(Color.DARK_GRAY);
		mainTextAreaButton.setFocusPainted(false);
		mainTextAreaButton.setContentAreaFilled(false);
		mainTextAreaButton.setBorderPainted(false);
		mainTextAreaButton.addActionListener(next);
		nextPanel.add(mainTextAreaButton);

		mainAreaPanel = new JPanel();
		mainAreaPanel.setBounds(90,550,1000,150);
		mainAreaPanel.setBackground(Color.black);
		mainAreaPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		con.add(mainAreaPanel);

		mainTextArea = new JTextArea();
		mainTextArea.setBounds(90,500,900,200);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.gray);
		mainTextArea.setEditable(false);
		mainTextArea.setSelectionColor(Color.black);
		mainTextArea.setFont(defaultFont);
		mainTextArea.setLineWrap(true);
		mainAreaPanel.add(mainTextArea);

		//Party system--------------------------------------------------------------------------------------------------------------------

		removeParty1 = new JButton("Remove");
		removeParty1.setForeground(darkRed);
		removeParty1.setFocusPainted(false);
		removeParty1.setVisible(false);
		removeParty1.setBorderPainted(false);
		removeParty1.setBackground(Color.black);
		removeParty1.setBounds(110,50,100,30);
		removeParty1.addActionListener(removeHandler);
		removeParty1.setActionCommand("r1");
		con.add(removeParty1);

		removeParty2 = new JButton("Remove");
		removeParty2.setForeground(darkRed);
		removeParty2.setFocusPainted(false);
		removeParty2.setBorderPainted(false);
		removeParty2.setVisible(false);
		removeParty2.setBackground(Color.black);
		removeParty2.setBounds(110,228,100,30);
		removeParty2.addActionListener(removeHandler);
		removeParty2.setActionCommand("r2");
		con.add(removeParty2);

		removeParty3 = new JButton("Remove");
		removeParty3.setForeground(darkRed);
		removeParty3.setFocusPainted(false);
		removeParty3.setBorderPainted(false);
		removeParty3.setVisible(false);
		removeParty3.setBackground(Color.black);
		removeParty3.setBounds(110,400,100,30);
		removeParty3.addActionListener(removeHandler);
		removeParty3.setActionCommand("r3");
		con.add(removeParty3);

		partyAdd1 = new JPanel();
		partyAdd1.setBounds(20,75,100,100);
		partyAdd1.setBackground(Color.black);
		partyAdd1.setVisible(false);
		con.add(partyAdd1);

		partyAddButton1 = new JButton(plusLogo);
		partyAddButton1.setBorderPainted(false);
		partyAddButton1.setFocusPainted(false);
		partyAddButton1.setBackground(Color.black);
		partyAddButton1.addActionListener(addHandler);
		partyAddButton1.setActionCommand("b1");
		partyAdd1.add(partyAddButton1);

		partyAdd2 = new JPanel();
		partyAdd2.setBounds(20,275,100,100);
		partyAdd2.setBackground(Color.black);
		partyAdd2.setVisible(false);
		con.add(partyAdd2);

		partyAddButton2 = new JButton(plusLogo);
		partyAddButton2.setBorderPainted(false);
		partyAddButton2.setFocusPainted(false);
		partyAddButton2.setBackground(Color.black);
		partyAddButton2.addActionListener(addHandler);
		partyAddButton2.setActionCommand("b2");
		partyAdd2.add(partyAddButton2);

		partyAdd3 = new JPanel();
		partyAdd3.setBounds(20,475,100,100);
		partyAdd3.setBackground(Color.black);
		partyAdd3.setVisible(false);
		con.add(partyAdd3);

		partyAddButton3 = new JButton(plusLogo);
		partyAddButton3.setBorderPainted(false);
		partyAddButton3.setFocusPainted(false);
		partyAddButton3.setBackground(Color.black);
		partyAddButton3.addActionListener(addHandler);
		partyAddButton3.setActionCommand("b3");
		partyAdd3.add(partyAddButton3);


		partyDisplayPanel = new JPanel();
		partyDisplayPanel.setBounds(10,20,300,700);
		partyDisplayPanel.setBackground(Color.black);
		partyDisplayPanel.setLayout(new GridLayout(4,1));
		partyDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		partyDisplayPanel.setVisible(false);
		con.add(partyDisplayPanel);

		partyPanel1 = new JPanel();
		partyPanel1.setBackground(Color.black);
		partyPanel1.setVisible(false);
		partyPanel1.setLayout(new GridLayout(2,2));
		partyDisplayPanel.add(partyPanel1);

		partyPanel2 = new JPanel();
		partyPanel2.setBackground(Color.black);
		partyPanel2.setVisible(false);
		partyPanel2.setLayout(new GridLayout(2,2));
		partyDisplayPanel.add(partyPanel2);

		partyPanel3 = new JPanel();
		partyPanel3.setBackground(Color.black);
		partyPanel3.setVisible(false);
		partyPanel3.setLayout(new GridLayout(2,2));
		partyDisplayPanel.add(partyPanel3);

		partyPanel4 = new JPanel();
		partyPanel4.setBackground(Color.black);
		partyPanel4.setVisible(false);
		partyPanel4.setLayout(new GridLayout(2,2));
		partyDisplayPanel.add(partyPanel4);

		partyPanel = new JPanel();
		partyPanel.setBounds(20,90,150,400);
		partyPanel.setBackground(Color.black);
		partyPanel.setLayout(new GridLayout(4,2));
		partyPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		partyPanel.setVisible(false);
		con.add(partyPanel);

		partyIconName1 = new JLabel();
		partyIconName1.setBounds(10,10,150,50);
		partyIconName1.setFont(defaultFont);
		partyIconName1.setForeground(Color.white);
		partyPanel1.add(partyIconName1);

		partyIconName2 = new JLabel();
		partyIconName2.setBounds(10,10,150,50);
		partyIconName2.setFont(defaultFont);
		partyIconName2.setForeground(Color.white);
		partyPanel2.add(partyIconName2);

		partyIconName3 = new JLabel();
		partyIconName3.setBounds(10,10,150,50);
		partyIconName3.setFont(defaultFont);
		partyIconName3.setForeground(Color.white);
		partyPanel3.add(partyIconName3);

		partyIcon1 = new JLabel();
		partyIcon1.setBounds(10,10,75,75);
		partyPanel.add(partyIcon1);

		partyIcon2 = new JLabel();
		partyIcon2.setBounds(0,0,75,75);
		partyPanel.add(partyIcon2);

		partyIcon3 = new JLabel();
		partyIcon3.setBounds(0,0,75,75);
		partyPanel.add(partyIcon3);

		partyButton = new JButton("Party");
		partyButton.setBackground(Color.black);
		partyButton.setForeground(Color.white);
		partyButton.setFont(smallFont);
		partyButton.setBounds(0,0,150,50);
		partyButton.setFocusPainted(false);
		partyButton.setContentAreaFilled(false);
		partyButton.addActionListener(partyHandler);
		partyPanel.add(partyButton);

		partyList = new JPanel();
		partyList.setBounds(400,50,650,600);
		partyList.setBackground(Color.black);
		partyList.setLayout(new GridLayout(5,2));
		partyList.setVisible(false);
		con.add(partyList);

		partyIcons1 = new JLabel();
		partyIcons1.setBounds(10,10,75,75);
		partyPanel1.add(partyIcons1);

		partyIcons2 = new JLabel();
		partyIcons2.setBounds(10,10,75,75);
		partyPanel2.add(partyIcons2);

		partyIcons3 = new JLabel();
		partyIcons3.setBounds(10,10,75,75);
		partyPanel3.add(partyIcons3);


		//player stats-------------------------------------------------------------------------

		playerStatsPanel = new JPanel();
		playerStatsPanel.setBounds(350,10,200,60);
		playerStatsPanel.setBackground(Color.black);
		playerStatsPanel.setLayout(new GridLayout(1,4));
		con.add(playerStatsPanel);

		playerStatsPanel2 = new JPanel();
		playerStatsPanel2.setBounds(650,10,300,60);
		playerStatsPanel2.setBackground(Color.black);
		playerStatsPanel2.setLayout(new GridLayout(1,4));
		con.add(playerStatsPanel2);

		hpLabel = new JLabel("HP:");
		hpLabel.setFont(defaultFont);
		hpLabel.setForeground(Color.white);
		playerStatsPanel.add(hpLabel);

		hpLabelValue = new JLabel();
		hpLabelValue.setFont(defaultFont);
		hpLabelValue.setForeground(Color.white);
		playerStatsPanel.add(hpLabelValue);

		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(defaultFont);
		weaponLabel.setForeground(Color.white);
		playerStatsPanel2.add(weaponLabel);

		weaponLabelValue = new JLabel();
		weaponLabelValue.setFont(defaultFont);
		weaponLabelValue.setForeground(Color.white);
		playerStatsPanel2.add(weaponLabelValue);



		//4 choice buttons------------------------------------------------------------



		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(90,510,1000,40);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(1,4));
		choiceButtonPanel.setVisible(false);
		con.add(choiceButtonPanel);

		choice1 = new JButton();
		choice1.setFocusPainted(false);
		choice1.setContentAreaFilled(false);
		choice1.setForeground(Color.gray);
		choice1.setFont(defaultFont);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		choice2 = new JButton();
		choice2.setFocusPainted(false);
		choice2.setContentAreaFilled(false);
		choice2.setForeground(Color.gray);
		choice2.setFont(defaultFont);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		choice3 = new JButton();
		choice3.setFocusPainted(false);
		choice3.setContentAreaFilled(false);
		choice3.setForeground(Color.gray);
		choice3.setFont(defaultFont);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);

		choice4 = new JButton();
		choice4.setFocusPainted(false);
		choice4.setContentAreaFilled(false);
		choice4.setForeground(Color.gray);
		choice4.setFont(defaultFont);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);

		playerSetup();

		//------------------------------------------------------------------------------------------------------------------------
		//Inventory

		inventoryIcon = new ImageIcon("Assets/Misc/InventoryIcon.png");

		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(2,696,75,70);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(1,1));
		con.add(inventoryPanel);

		inventoryButton = new JButton();
		inventoryButton.setFocusPainted(false);
		inventoryButton.setContentAreaFilled(false);
		inventoryButton.setBorderPainted(false);
		inventoryButton.setIcon(inventoryIcon);
		inventoryButton.setForeground(Color.black);
		inventoryButton.addActionListener(inventoryHandler);
		inventoryPanel.add(inventoryButton);

		inventoryButtonsPanel = new JPanel();
		inventoryButtonsPanel.setBounds(50,150,800,500);
		inventoryButtonsPanel.setBackground(Color.black);
		inventoryButtonsPanel.setVisible(false);
		inventoryButtonsPanel.setLayout(new GridLayout(5,4));
		con.add(inventoryButtonsPanel);

		extraStatsPanel = new JPanel();
		extraStatsPanel.setBounds(860,150,300,400);
		extraStatsPanel.setBackground(Color.black);
		extraStatsPanel.setVisible(false);
		extraStatsPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		extraStatsPanel.setLayout(new GridLayout(4,2));
		con.add(extraStatsPanel);

		returnToGamePanel = new JPanel();
		returnToGamePanel.setBounds(860,560,300,90);
		returnToGamePanel.setBackground(Color.black);
		returnToGamePanel.setVisible(false);
		returnToGamePanel.setBorder(BorderFactory.createLineBorder(Color.white));
		returnToGamePanel.setLayout(new GridLayout(2,1));
		con.add(returnToGamePanel);

		returnToGameButton = new JButton("Return to Game");
		returnToGameButton.setFocusPainted(false);
		returnToGameButton.setBackground(Color.black);
		returnToGameButton.setForeground(Color.white);
		returnToGameButton.addActionListener(returnHandler);
		returnToGamePanel.add(returnToGameButton);

		returnToTitleButton = new JButton("Return to Title");
		returnToTitleButton.setFocusPainted(false);
		returnToTitleButton.setBackground(Color.black);
		returnToTitleButton.setForeground(Color.white);
		returnToTitleButton.addActionListener(titleHandler);
		returnToGamePanel.add(returnToTitleButton);

		armorPanel = new JPanel();
		armorPanel.setBounds(10,15,300,50);
		armorPanel.setBackground(Color.black);
		armorPanel.setLayout(new GridLayout(1,3));
		armorPanel.setVisible(false);
		con.add(armorPanel);

		armorLabel = new JLabel("Armor:");
		armorLabel.setFont(defaultFont);
		armorLabel.setForeground(Color.white);
		armorPanel.add(armorLabel);

		armorLabelValue = new JLabel(armor);
		armorLabelValue.setFont(smallFont);
		armorLabelValue.setForeground(Color.white);
		armorPanel.add(armorLabelValue);

		name = new JLabel("Name:");
		name.setFont(smallFont);
		name.setForeground(Color.white);
		extraStatsPanel.add(name);

		nameValue = new JLabel(itemName);
		nameValue.setFont(smallFont);
		nameValue.setForeground(Color.white);
		extraStatsPanel.add(nameValue);

		hp = new JLabel("HP:");
		hp.setFont(smallFont);
		hp.setForeground(Color.white);
		extraStatsPanel.add(hp);

		hpValue = new JLabel("" + itemHP);
		hpValue.setFont(smallFont);
		hpValue.setForeground(Color.white);
		extraStatsPanel.add(hpValue);

		damage = new JLabel("DMG:");
		damage.setFont(smallFont);
		damage.setForeground(Color.white);
		extraStatsPanel.add(damage);

		damageValue = new JLabel("" + itemDamage);
		damageValue.setFont(smallFont);
		damageValue.setForeground(Color.white);
		extraStatsPanel.add(damageValue);

		rarity = new JLabel("Rarity:");
		rarity.setFont(smallFont);
		rarity.setForeground(Color.white);
		extraStatsPanel.add(rarity);

		rarityValue = new JLabel(itemRarity);
		rarityValue.setFont(smallFont);
		rarityValue.setForeground(Color.white);
		extraStatsPanel.add(rarityValue);

		equipPanel = new JPanel();
		equipPanel.setBounds(860,560,300,90);
		equipPanel.setBackground(Color.black);
		equipPanel.setVisible(false);
		equipPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		equipPanel.setLayout(new GridLayout(2,1));
		con.add(equipPanel);


		equipButton = new JButton("Equip");
		equipButton.setFocusPainted(false);
		equipButton.setBackground(Color.black);
		equipButton.setForeground(Color.white);
		equipButton.addActionListener(equipHandler);
		equipPanel.add(equipButton);

		unequipButton = new JButton("Unequip");
		unequipButton.setFocusPainted(false);
		unequipButton.setBackground(Color.black);
		unequipButton.setForeground(Color.white);
		unequipButton.addActionListener(unequipHandler);
		equipPanel.add(unequipButton);

		//--------------------------------------------------------------------------------------------


	}


	public void playerSetup()
	{
		playerHP = 15;
		weapon = "None";

		weaponLabelValue.setText(weapon);
		hpLabelValue.setText("" + playerHP);

		mainImageLabel.setVisible(true);
		forestStart();
	}

	public void death()
	{
		currentLocation = "death";

		nextPanel.setVisible(true);
		choiceButtonPanel.setVisible(false);

		mainImageLabel.setIcon(deathImage);

		mainTextArea.setText("You have died. Clearly this place wasnt meant for you. \nIf you're lucky you'll be reborn with a better mind.");
	}

	public void forestStart()
	{	

		if (filepath != "Music/ForestMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/ForestMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}


		currentLocation = "forestStart";

		mainImageLabel.setIcon(forestAreaImage);

		nextPanel.setVisible(true);
		choiceButtonPanel.setVisible(false);

		mainTextArea.setText("You wake up, with no memories of who you are, and the \nonly thing you know is your name.");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}
	}

	public void forestStartOptions()
	{

		if (filepath != "Music/ForestMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/ForestMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		mainImageLabel.setIcon(forestAreaImage);

		musicObject.playMusic("buttonClick.wav");
		currentLocation = "forestStartOptions";

		choiceButtonPanel.setVisible(true);
		nextPanel.setVisible(false);

		mainTextArea.setText("North is a trail, south is a mountain, west is a road and \neast is a clearing. Where do you go?");
		choice1.setText("North");
		choice2.setText("South");
		choice3.setText("West");
		choice4.setText("East");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}
	}

	public void forestTrail()
	{
		currentLocation = "forestTrail";

		choiceButtonPanel.setVisible(true);
		nextPanel.setVisible(false);

		mainImageLabel.setIcon(forestTrailImage);

		if (filepath != "Music/ForestMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/ForestMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}

		if (Math.random() < 0.1 && inventory.contains("Shiny Ring") == false)
		{

			mainTextArea.setText("You walk up the forest trail and find a shiny ring. Nice!");

			inventory.add("Shiny Ring");

			choice1.setText("Continue");
			choice2.setText("Back");
			choice3.setText("");
			choice4.setText("");

		}
		else
		{
			mainTextArea.setText("You hike and trudge your way through the forest trail.");
			choice1.setText("Continue");
			choice2.setText("Back");
			choice3.setText("");
			choice4.setText("");
		}
	}

	public void forestTrailContinued()
	{
		currentLocation = "forestTrailContinued";

		mainImageLabel.setIcon(forestTrailImage);

		if (filepath != "Music/ForestMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/ForestMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}

		if (trailEncounter == false)
		{

			nextPanel.setVisible(true);
			choiceButtonPanel.setVisible(false);

			mainTextArea.setText("You happen to pass by wounded travellers. \nThere are 3 people, they look poor.");
			mainImageLabel.setIcon(forestEncounterImage);
		}
		else
		{

			nextPanel.setVisible(false);
			choiceButtonPanel.setVisible(true);

			mainTextArea.setText("You continue walking through the trail, you see blood \nalong the path. There seems to have been a battle.");
			mainImageLabel.setIcon(forestTrailImage);

			choice1.setText("Continue");
			choice2.setText("Back");
			choice3.setText("");
			choice4.setText("");
		}

	}


	public void forestTrailContinuedOptions()
	{
		currentLocation = "forestTrailContinuedOptions";
		trailEncounter = true;

		mainImageLabel.setIcon(forestEncounterImage);

		choiceButtonPanel.setVisible(true);
		nextPanel.setVisible(false);

		if (filepath != "Music/ForestMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/ForestMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		nextPanel.setVisible(false);
		choiceButtonPanel.setVisible(true);

		mainTextArea.setText("What do you do?");
		choice1.setText("Talk");
		choice2.setText("Continue");
		choice3.setText("Back");
		choice4.setText("");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}

	}

	public void forestTrailTalk()
	{
		currentLocation = "forestTrailTalk";

		if (filepath != "Music/ForestMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/ForestMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		choiceButtonPanel.setVisible(false);
		nextPanel.setVisible(true);

		charIconPanel.setVisible(true);
		charIconLabel.setIcon(taniaIcon);

		mainTextArea.setText("Hey, you look pretty worse for wear! Hahaha \nWe have a little issue we need help with.");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}
	}

	public void forestTrailTalkContinued()
	{
		currentLocation = "forestTrailTalkContinued";

		if (filepath != "Music/ForestMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/ForestMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		choiceButtonPanel.setVisible(true);
		nextPanel.setVisible(false);

		charIconPanel.setVisible(true);
		charIconLabel.setIcon(taniaIcon);

		mainTextArea.setText("We're being chased by bandits, we need your help. \nJoin our party, and let's beat them together yeah?");
		choice1.setText("Accept");
		choice2.setText("Decline");
		choice3.setText("");
		choice4.setText("");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);


		}


	}


	public void forestTrailParty()
	{
		currentLocation = "forestTrailParty";

		mainImageLabel.setIcon(forestTrailImage);

		if (filepath != "Music/ForestMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/ForestMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		nextPanel.setVisible(true);
		choiceButtonPanel.setVisible(false);

		mainTextArea.setText("Thanks, partner! ");
		mainImageLabel.setIcon(forestEncounterImage);

		partyPanel.setVisible(true);

		partyMembers = 3;



		partyIcon1.setIcon(taniaFace);


		partyIcon2.setIcon(fitzFace);
		partyIcon3.setIcon(kayneFace);

		partyIcons1.setIcon(taniaFace);
		partyIcons2.setIcon(fitzFace);
		partyIcons3.setIcon(kayneFace);

		partyIconName1.setText("Tania");
		partyIconName2.setText("Fitz");
		partyIconName3.setText("Kayne");

		partySlot1 = true;
		partySlot2 = true;
		partySlot3 = true;




	}


	public void mountain()
	{

		if (filepath != "Music/MountainMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/MountainMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		currentLocation = "mountain";
		mainImageLabel.setIcon(mountainImage);

		nextPanel.setVisible(true);
		choiceButtonPanel.setVisible(false);

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}

		mainTextArea.setText("You come across a beautiful white mountain \nThere's mist flowing below and you see a huge door.");
	}

	public void mountainOptions()
	{

		if (filepath != "Music/MountainMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/MountainMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		mainImageLabel.setIcon(mountainImage);

		currentLocation = "mountainOptions";

		nextPanel.setVisible(false);
		choiceButtonPanel.setVisible(true);

		mainTextArea.setText("The door is inscribed with intricate patterns, \nWhat do you do?");
		choice1.setText("Continue");
		choice2.setText("Back");
		choice3.setText("");
		choice4.setText("");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}
	}

	public void mountainUnworthy()
	{

		if (filepath != "Music/MountainMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/MountainMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		currentLocation = "mountainUnworthy";

		mainImageLabel.setIcon(mountainDoorImage);

		nextPanel.setVisible(false);
		choiceButtonPanel.setVisible(true);

		mainTextArea.setText("The door doesnt budge no matter what. \nYou decide to leave the area.");
		choice1.setText("Back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}

	}

	public void clearing()
	{

		if (filepath != "Music/clearingMusic.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/clearingMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		mainImageLabel.setIcon(clearingImage);

		nextPanel.setVisible(false);
		choiceButtonPanel.setVisible(true);

		currentLocation = "clearing";

		mainTextArea.setText("You gaze at the open field, and you see an opening. \nThere's nothing but animals and rocks.");
		choice1.setText("Back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}

	}

	public void westRoad()
	{

		if (filepath != "Music/westRoad.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/westRoad.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		currentLocation = "westRoad";

		mainImageLabel.setIcon(forestRoad);

		nextPanel.setVisible(true);
		choiceButtonPanel.setVisible(false);

		mainTextArea.setText("You walk down the road, which looks newly built, and see\nsomeone up ahead.");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);
		}

	}

	public void westRoadContinued()
	{
		if (filepath != "Music/westRoad.wav")
		{
			musicObject.stopMusic();
			filepath = "Music/westRoad.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}
		}

		currentLocation = "westRoadContinued";

		mainImageLabel.setIcon(forestRoadEncounterImage);

		nextPanel.setVisible(false);
		choiceButtonPanel.setVisible(true);

		mainTextArea.setText("He looks fatally wounded, unable to do anything. \nHe gestures towards you. What do you do?");
		choice1.setText("Continue");
		choice2.setText("Talk");
		choice3.setText("Kill");
		choice4.setText("Back");

		if (partyActive() == true)
		{
			partyPanel.setVisible(true);

		}

	}


	//--------------------------------------------------------------------------------------------------------------------------------

	public void returnToGame()
	{

		musicObject.playMusic("buttonClick.wav");

		switch(currentLocation)
		{
		case "forestStart": forestStart(); break;
		case "death": death(); break;
		case "forestStartOptions": forestStartOptions(); choiceButtonPanel.setVisible(true); break;
		case "mountain": mountain(); break;
		case "mountainOptions": mountainOptions(); choiceButtonPanel.setVisible(true); break;
		case "mountainUnworthy": mountainUnworthy(); break;
		case "forestTrail": forestTrail(); choiceButtonPanel.setVisible(true); break;
		case "clearing": clearing(); choiceButtonPanel.setVisible(true); break;
		case "forestTrailContinued": forestTrailContinued(); break;
		case "forestTrailContinuedOptions": forestTrailContinuedOptions(); choiceButtonPanel.setVisible(true); break;
		case "forestTrailTalk": forestTrailTalk(); choiceButtonPanel.setVisible(false);
		case "forestTrailTalkContinued": forestTrailTalkContinued();
		case "forestTrailParty": forestTrail(); break;
		case "westRoad": westRoad(); break;
		case "westRoadContinued": westRoadContinued(); break;


		}

	}

	//--------------------------------------------------------------------------------------------------------------------------------


	public Boolean partyActive()
	{
		Boolean isPartyActive;

		if (partyMembers > 0)
		{
			isPartyActive = true;
		}

		else
		{
			isPartyActive = false;
		}

		return isPartyActive;
	}


	public void placePartyMember(Icon source)
	{
		partyButtons[partyButtonCounter].setIcon(source);

		partyButtonCounter = partyButtonCounter + 1;
	}

	public void invItem(int x)
	{

		if (inventory.size() > 0 && x < inventory.size())
		{
			if (inventory.get(x) != null)
			{
				
				//Shiny Ring -------------------------------------
				
				if (inventory.get(x).equals("Shiny Ring"))
				{

					nameValue.setText("Shiny ring");
					damageValue.setText("0");
					hpValue.setText("1");
					rarityValue.setText("*");

					equipPanel.setVisible(true);
					returnToGamePanel.setVisible(false);

					unequipButton.setActionCommand("Shiny Ring");
					equipButton.setActionCommand("Shiny Ring");

				}
					else
				{

				}

			}
		}
	}


	//--------------------------------------------------------------------------------------------------------------------------------

	public void createInventoryScreen()
	{

		if (Math.random() < 0.3)
		{
			soundObject.setFile("Music/SFX/buttonClick.wav");
			soundObject.play();
		}
		else if (Math.random() < 0.6)
		{
			soundObject.setFile("Music/SFX/buttonClick2.wav");
			soundObject.play();
		}
		else
		{
			soundObject.setFile("Music/SFX/buttonClick3.wav");
			soundObject.play();
		}

		nextPanel.setVisible(false);
		mainAreaPanel.setVisible(false);
		inventoryPanel.setVisible(false);
		choiceButtonPanel.setVisible(false);
		imageDisplayPanel.setVisible(false);
		optionsPanel.setVisible(false);
		optionsPopUp.setVisible(false);
		mapPanel.setVisible(false);
		charIconPanel.setVisible(false);
		partyPanel.setVisible(false);

		returnToGamePanel.setVisible(true);
		inventoryButtonsPanel.setVisible(true);
		extraStatsPanel.setVisible(true);
		armorPanel.setVisible(true);

		musicObject.stopMusic();
		filepath = "Music/InventoryMusic.wav";

		if(muteAudio != true)
		{
			musicObject.playMusic(filepath);
		}

		if (full == false)
		{
			for (int x = 0; x <= inventoryButtons.length-1; x++)
			{

				inventoryButtons[x] = new JButton();
				inventoryButtons[x].setFocusPainted(false);
				inventoryButtons[x].setBackground(Color.black);
				inventoryButtons[x].setForeground(Color.white);
				inventoryButtons[x].setActionCommand("" + x);
				inventoryButtons[x].addActionListener(inventoryButtonHandler);
				inventoryButtonsPanel.add(inventoryButtons[x]);
				full = true;
			}
		}

		if (inventory.size() > 0)
		{
			for (int y = 0; y < inventory.size(); y++)
			{
				inventoryButtons[y].setText(inventory.get(y));
			}
		}


	}

	public void createPartyButtons()
	{
		partyList.setVisible(true);

		if(fullParty==false)
		{
			for (int x = 0; x <= partyButtons.length-1; x++)
			{
				partyButtons[x] = new JButton();
				partyButtons[x].setFocusPainted(false);
				partyButtons[x].setBackground(Color.black);
				partyButtons[x].setActionCommand("" + x);
				partyButtons[x].addActionListener(partyArrayHandler);
				partyList.add(partyButtons[x]);
				fullParty = true;


			}
		}
	}


	//--------------------------------------------------------------------------------------------------------------------------------


	public class TitleScreenHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}


			if (currentLocation != null)
			{
				optionsOpened = false;

				titlePanel.setVisible(false);
				startButtonPanel.setVisible(false);
				bgPanel.setVisible(false);


				mainAreaPanel.setVisible(true);
				inventoryPanel.setVisible(true);
				imageDisplayPanel.setVisible(true);
				optionsPanel.setVisible(true);
				mapPanel.setVisible(true);
				returnToGame();
			}
			else

				createGameScreen();



		}
	}

	public class InventoryScreenHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			createInventoryScreen();
		}
	}

	public class returnToGameHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			returnToGame();

			mainAreaPanel.setVisible(true);
			inventoryPanel.setVisible(true);
			imageDisplayPanel.setVisible(true);
			optionsPanel.setVisible(true);
			mapPanel.setVisible(true);
			playerStatsPanel.setVisible(true);
			playerStatsPanel2.setVisible(true);

			mapReturnPanel.setVisible(false);
			returnToGamePanel.setVisible(false);
			inventoryButtonsPanel.setVisible(false);
			extraStatsPanel.setVisible(false);
			armorPanel.setVisible(false);
			bgPanel.setVisible(false);
			returnPanel.setVisible(false);
			partyDisplayPanel.setVisible(false);
			removeParty1.setVisible(false);
			removeParty2.setVisible(false);
			removeParty3.setVisible(false);
			partyList.setVisible(false);
			partyAdd1.setVisible(false);
			partyAdd2.setVisible(false);
			partyAdd3.setVisible(false);
		}
	}

	public class optionButtonHandler implements ActionListener
	{


		public void actionPerformed(ActionEvent event)
		{

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}



			if (optionsOpened == false)
			{
				optionsOpened = true;
				optionsPopUp.setVisible(true);

				if (choiceButtonPanel.isVisible() == true)
				{
					choiceButtonPanel.setVisible(false);
					choiceOpened = true;
				}

				if (nextPanel.isVisible() == true)
				{
					nextPanel.setVisible(false);
					nextOpened = true;
				}
			}
			else
			{
				optionsOpened = false;
				optionsPopUp.setVisible(false);

				if (choiceOpened == true)
				{
					choiceButtonPanel.setVisible(true);
					choiceOpened = false;
				}

				if (nextOpened == true)
				{
					nextPanel.setVisible(true);
					nextOpened = false;
				}
			}


		}
	}

	public class equipButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String item = event.getActionCommand();

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			if (inventory.size() > 0)
			{

				if (item.equals("Shiny Ring"))
				{
					if (armor == "None")
					{
						playerHP = playerHP + 1;
						hpLabelValue.setText("" + playerHP);
						armor = "Shiny Ring";
						armorLabelValue.setText(armor);

						for (int x = 0; x < inventory.size(); x++)
						{	
							if (inventory.get(x).equals(armor))
							{
								inventoryButtons[x].setBackground(Color.DARK_GRAY);
							}
						}

					}
				}

				else if (item.equals("test"))
				{

					if (weapon == "None")
					{
						playerHP = playerHP + 4;
						hpLabelValue.setText("" + playerHP);
						weapon = "test";
						weaponLabelValue.setText(weapon);
						itemDamage = 3;

						for (int x = 0; x < inventory.size(); x++)
						{
							if (inventory.get(x).equals(weapon))
							{
								inventoryButtons[x].setBackground(Color.DARK_GRAY);
							}
						}

					}
				}

			}

			equipPanel.setVisible(false);
			returnToGamePanel.setVisible(true);

		}

	}

	public class unequipButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String item = event.getActionCommand();

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			if (inventory.size() > 0)
			{


				if (item.equals("Shiny Ring"))
				{
					if (armor.equals("Shiny Ring"))
					{
						playerHP = playerHP - 1;
						hpLabelValue.setText("" + playerHP);
						armor = "None";
						armorLabelValue.setText(armor);

						for (int x = 0; x < inventory.size(); x++)
						{
							if (inventory.get(x) == "Shiny Ring")
							{
								inventoryButtons[x].setBackground(Color.black);
							}
						}
					}
				}

				else if (item.equals("test"))
				{
					if (weapon.equals("test"))
					{
						playerHP = playerHP - 4;
						hpLabelValue.setText("" + playerHP);
						weapon = "None";
						weaponLabelValue.setText(weapon);
						itemDamage = 0;

						for (int x = 0; x < inventory.size(); x++)
						{
							if (inventory.get(x) == "test")
							{
								inventoryButtons[x].setBackground(Color.black);
							}
						}


					}
				}
			}


			equipPanel.setVisible(false);
			returnToGamePanel.setVisible(true);

		}
	}

	public class partyAddHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			String whichButton = event.getActionCommand();

			if (whichButton.equals("b1"))
			{
				if (partyAddButton1.getBackground().equals(lime))
				{
					add = false;
					partyAddButton1.setBackground(Color.black);
				}
				
				else
				{
					partyAddButton2.setBackground(Color.black);
					partyAddButton3.setBackground(Color.black);
					partyAddButton1.setBackground(lime);
					add = true;
				}
			}
			
			if(whichButton.equals("b2"))
			{
				if (partyAddButton2.getBackground().equals(lime))
				{
					add = false;
					partyAddButton2.setBackground(Color.black);
				}
				
				else
				{
					partyAddButton1.setBackground(Color.black);
					partyAddButton3.setBackground(Color.black);
					partyAddButton2.setBackground(lime);
					add = true;
				}
			}
			
			if(whichButton.equals("b3"))
			{
				if (partyAddButton3.getBackground().equals(lime))
				{
					add = false;
					partyAddButton3.setBackground(Color.black);
				}
				
				else
				{
					partyAddButton1.setBackground(Color.black);
					partyAddButton2.setBackground(Color.black);
					partyAddButton3.setBackground(lime);
					add = true;
				}
			}
		}
	}

	public class muteButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			if (muteAudio == false)
			{
				muteAudio = true;
				muteAudioButton.setForeground(darkRed);
				musicObject.pauseMusic();
			}
			else
			{
				muteAudio = false;
				muteAudioButton.setForeground(darkGreen);
				musicObject.playMusic(filepath);
			}

		}
	}

	public class returnToTitleHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			optionsOpened = false;

			returnPanel.setVisible(false);
			partyDisplayPanel.setVisible(false);
			nextPanel.setVisible(false);
			mainAreaPanel.setVisible(false);
			inventoryPanel.setVisible(false);
			choiceButtonPanel.setVisible(false);
			imageDisplayPanel.setVisible(false);
			optionsPanel.setVisible(false);
			optionsPopUp.setVisible(false);
			returnToGamePanel.setVisible(false);
			inventoryButtonsPanel.setVisible(false);
			extraStatsPanel.setVisible(false);
			armorPanel.setVisible(false);
			mapPanel.setVisible(false);
			charIconPanel.setVisible(false);
			partyPanel.setVisible(false);
			removeParty1.setVisible(false);
			removeParty2.setVisible(false);
			removeParty3.setVisible(false);
			partyList.setVisible(false);
			partyAdd1.setVisible(false);
			partyAdd2.setVisible(false);
			partyAdd3.setVisible(false);


			titlePanel.setVisible(true);
			startButtonPanel.setVisible(true);
			bgPanel.setVisible(true);

			backgroundImage.setIcon(startingScreen);

			musicObject.stopMusic();
			filepath = "Music/introMusic.wav";
			musicObject.playMusic(filepath);

		}
	}


	public class nextDialogueHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

			switch(currentLocation)
			{
			case"forestStart": forestStartOptions();
			break;

			case "Death": window.dispose();
			break;

			case "mountain": mountainOptions();
			break;

			case "forestTrailContinued": forestTrailContinuedOptions();
			break;

			case "forestTrailTalk": forestTrailTalkContinued();
			break;

			case "westRoad": westRoadContinued();
			break;
			}

		}
	}

	public class partyButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			musicObject.stopMusic();
			filepath = "Music/InventoryMusic.wav";

			if(muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}


			createPartyButtons();

			if (partySlot1 == false)
			{
				partyAdd1.setVisible(true);
			}

			if (partySlot2 == false)
			{
				partyAdd2.setVisible(true);
			}

			if (partySlot3 == false)
			{
				partyAdd3.setVisible(true);
			}


			nextPanel.setVisible(false);
			mainAreaPanel.setVisible(false);
			inventoryPanel.setVisible(false);
			choiceButtonPanel.setVisible(false);
			imageDisplayPanel.setVisible(false);
			optionsPanel.setVisible(false);
			optionsPopUp.setVisible(false);
			returnToGamePanel.setVisible(false);
			inventoryButtonsPanel.setVisible(false);
			extraStatsPanel.setVisible(false);
			armorPanel.setVisible(false);
			titlePanel.setVisible(false);
			startButtonPanel.setVisible(false);
			playerStatsPanel.setVisible(false);
			playerStatsPanel2.setVisible(false);
			mapPanel.setVisible(false);
			partyPanel.setVisible(false);
			charIconPanel.setVisible(false);


			returnPanel.setVisible(true);
			partyDisplayPanel.setVisible(true);
			partyPanel1.setVisible(true); 
			partyPanel2.setVisible(true); 
			partyPanel3.setVisible(true); 
			partyPanel4.setVisible(true); 

			if (partySlot1 == true)
			{
				removeParty1.setVisible(true);
			}
			if (partySlot2 == true)
			{
				removeParty2.setVisible(true);
			}
			if (partySlot3 == true)
			{
				removeParty3.setVisible(true);
			}

		}
	}

	public class partyArrayButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{	
			String myChoice = event.getActionCommand();
				if (myChoice.equals("0"))
				{
					
					if (partyButtons[0].getIcon() != null)
					{
					Icon tmp = partyButtons[0].getIcon();
					String name = "";
					
					
					if (tmp.equals(taniaFace))
					{
						name = "Tania";
					}
					else if (tmp.equals(fitzFace))
					{
						name = "Fitz";
					}
					else if (tmp.equals(kayneFace))
					{
						name = "Kayne";
					}
					if (partyAddButton1.getBackground().equals(lime))
					{
						
						partyIconName1.setText(name);
						partyAdd1.setVisible(false);
						partyIcons1.setVisible(true);
						partyIcons1.setIcon(tmp);
						
						partyIcon1.setVisible(true);
						partyIcon1.setIcon(tmp);
						
						removeParty1.setVisible(true);
						partySlot1 = true;
						partyMembers = partyMembers+1;
						
						partyAddButton1.setBackground(Color.black);
						partyButtons[0].setIcon(null);
						partyButtonCounter = partyButtonCounter-1;
					}
					
					else if (partyAddButton2.getBackground().equals(lime))
					{
						partyIconName2.setText(name);
						partyAdd2.setVisible(false);
						partyIcons2.setVisible(true);
						partyIcons2.setIcon(tmp);
						
						partyIcon2.setVisible(true);
						partyIcon2.setIcon(tmp);
						
						removeParty2.setVisible(true);
						partySlot2 = true;
						partyMembers = partyMembers+1;
						
						partyAddButton2.setBackground(Color.black);
						partyButtons[0].setIcon(null);
						partyButtonCounter = partyButtonCounter-1;
					}
					
					else if (partyAddButton3.getBackground().equals(lime))
					{
						partyIconName3.setText(name);
						partyAdd3.setVisible(false);
						partyIcons3.setVisible(true);
						partyIcons3.setIcon(tmp);
						
						partyIcon3.setVisible(true);
						partyIcon3.setIcon(tmp);
						
						removeParty3.setVisible(true);
						partySlot3 = true;
						partyMembers = partyMembers+1;
						
						partyAddButton3.setBackground(Color.black);
						partyButtons[0].setIcon(null);
						partyButtonCounter = partyButtonCounter-1;
					}
				}
				}
				else if (myChoice.equals("1"))
				{	
					
					if (partyButtons[1].getIcon() != null)
					{
					
					Icon tmp = partyButtons[1].getIcon();
					String name = "";
					if (tmp.equals(taniaFace))
					{
						name = "Tania";
					}
					else if (tmp.equals(fitzFace))
					{
						name = "Fitz";
					}
					else if (tmp.equals(kayneFace))
					{
						name = "Kayne";
					}
					
					if (partyAddButton1.getBackground().equals(lime))
					{
						partyIconName1.setText(name);
						partyAdd1.setVisible(false);
						partyIcons1.setVisible(true);
						partyIcons1.setIcon(tmp);
						
						partyIcon1.setVisible(true);
						partyIcon1.setIcon(tmp);
						
						removeParty1.setVisible(true);
						partySlot1 = true;
						partyMembers = partyMembers+1;
						
						partyAddButton1.setBackground(Color.black);
						partyButtons[1].setIcon(null);
						partyButtonCounter = partyButtonCounter-1;
					}
					
					else if (partyAddButton2.getBackground().equals(lime))
					{
						partyIconName2.setText(name);
						partyAdd2.setVisible(false);
						partyIcons2.setVisible(true);
						partyIcons2.setIcon(tmp);
						
						partyIcon2.setVisible(true);
						partyIcon2.setIcon(tmp);
						
						removeParty2.setVisible(true);
						partySlot2 = true;
						partyMembers = partyMembers+1;
						
						partyAddButton2.setBackground(Color.black);
						partyButtons[1].setIcon(null);
						partyButtonCounter = partyButtonCounter-1;
					}
					
					else if (partyAddButton3.getBackground().equals(lime))
					{
						partyIconName3.setText(name);
						partyAdd3.setVisible(false);
						partyIcons3.setVisible(true);
						partyIcons3.setIcon(tmp);
						
						partyIcon3.setVisible(true);
						partyIcon3.setIcon(tmp);
						
						removeParty3.setVisible(true);
						partySlot3 = true;
						partyMembers = partyMembers+1;
						
						partyAddButton3.setBackground(Color.black);
						partyButtons[1].setIcon(null);
						partyButtonCounter = partyButtonCounter-1;
					}
				}
				}
				else if (myChoice.equals("2"))
				{
					
					if (partyButtons[2].getIcon() != null)
					{
					
					Icon tmp = partyButtons[2].getIcon();
					String name = "";
					
					if (tmp.equals(taniaFace))
					{
						name = "Tania";
					}
					else if (tmp.equals(fitzFace))
					{
						name = "Fitz";
					}
					else if (tmp.equals(kayneFace))
					{
						name = "Kayne";
					}
					
					if (partyAddButton1.getBackground().equals(lime))
					{
						partyIconName1.setText(name);
						partyAdd1.setVisible(false);
						partyIcons1.setVisible(true);
						partyIcons1.setIcon(tmp);
						
						partyIcon1.setVisible(true);
						partyIcon1.setIcon(tmp);
						
						removeParty1.setVisible(true);
						partySlot1 = true;
						partyMembers = partyMembers+1;
					
						partyAddButton1.setBackground(Color.black);
						partyButtons[2].setIcon(null);
						partyButtonCounter = partyButtonCounter-1;
					}
					
					else if (partyAddButton2.getBackground().equals(lime))
					{
						partyIconName2.setText(name);
						partyAdd2.setVisible(false);
						partyIcons2.setVisible(true);
						partyIcons2.setIcon(tmp);
						
						partyIcon2.setVisible(true);
						partyIcon2.setIcon(tmp);
						
						removeParty2.setVisible(true);
						partySlot2 = true;
						partyMembers = partyMembers+1;
						
						partyAddButton2.setBackground(Color.black);
						partyButtons[2].setIcon(null);
						partyButtonCounter = partyButtonCounter-1;
					}
					
					else if (partyAddButton3.getBackground().equals(lime))
					{
						partyIconName3.setText(name);
						partyAdd3.setVisible(false);
						partyIcons3.setVisible(true);
						partyIcons3.setIcon(tmp);
						
						partyIcon3.setVisible(true);
						partyIcon3.setIcon(tmp);
						
						removeParty3.setVisible(true);
						partySlot3 = true;
						partyMembers = partyMembers+1;
						
						partyAddButton3.setBackground(Color.black);
						partyButtons[2].setIcon(null);
						partyButtonCounter = partyButtonCounter-1;
					}
			}
				}
			
		}
	}

	public class mapButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			bgPanel.setVisible(true);
			backgroundImage.setIcon(athraniteMap);


			nextPanel.setVisible(false);
			mainAreaPanel.setVisible(false);
			inventoryPanel.setVisible(false);
			choiceButtonPanel.setVisible(false);
			imageDisplayPanel.setVisible(false);
			optionsPanel.setVisible(false);
			optionsPopUp.setVisible(false);
			returnToGamePanel.setVisible(false);
			inventoryButtonsPanel.setVisible(false);
			extraStatsPanel.setVisible(false);
			armorPanel.setVisible(false);
			titlePanel.setVisible(false);
			startButtonPanel.setVisible(false);
			playerStatsPanel.setVisible(false);
			playerStatsPanel2.setVisible(false);
			mapPanel.setVisible(false);
			partyPanel.setVisible(false);

			mapReturnPanel.setVisible(true);

			musicObject.stopMusic();
			filepath = "Music/mapMusic.wav";
			if (muteAudio != true)
			{
				musicObject.playMusic(filepath);
			}


		}
	}

	public class removeButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			String whichButton = event.getActionCommand();



			if (whichButton.equals("r1"))
			{
				placePartyMember(partyIcon1.getIcon());

				partyIconName1.setText("");
				partyIcon1.setVisible(false);
				partyIcons1.setVisible(false);
				partySlot1 = false;
				removeParty1.setVisible(false);
				partyMembers = partyMembers-1;

				partyAdd1.setVisible(true);
			}
			else if (whichButton.equals("r2"))
			{
				placePartyMember(partyIcon2.getIcon());

				partyIconName2.setText("");
				partyIcon2.setVisible(false);
				partyIcons2.setVisible(false);
				removeParty2.setVisible(false);
				partySlot2 = false;
				partyMembers = partyMembers-1;

				partyAdd2.setVisible(true);
			}

			else
			{
				placePartyMember(partyIcon3.getIcon());

				partyIconName3.setText("");
				partyIcon3.setVisible(false);
				partyIcons3.setVisible(false);
				removeParty3.setVisible(false);
				partySlot3 = false;
				partyMembers = partyMembers-1;

				partyAdd3.setVisible(true);
				
				
			}



		}
	}

	public class inventoryButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String yourChoice = event.getActionCommand();

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			
			switch(yourChoice)
			{
			case "0": invItem(0);  break;
			case "1": invItem(1); break;
			case "2": invItem(2); break;
			case "3": invItem(3); break;
			case "4": invItem(4); break;
			case "5": invItem(5); break;
			case "6": invItem(6); break;
			case "7": invItem(7); break;
			case "8": invItem(8); break;
			case "9": invItem(9); break;
			case "10": invItem(10); break;
			case "11": invItem(11); break;
			case "12": invItem(12); break;
			case "13": invItem(13); break;
			case "14": invItem(14); break;
			case "15": invItem(15); break;
			case "16": invItem(16); break;
			case "17": invItem(17); break;
			case "18": invItem(18); break;
			case "19": invItem(19); break;
			case "20": invItem(20); break;
			}
		}
	}


	public class ChoiceHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String yourChoice = event.getActionCommand();

			if (Math.random() < 0.3)
			{
				soundObject.setFile("Music/SFX/buttonClick.wav");
				soundObject.play();
			}
			else if (Math.random() < 0.6)
			{
				soundObject.setFile("Music/SFX/buttonClick2.wav");
				soundObject.play();
			}
			else
			{
				soundObject.setFile("Music/SFX/buttonClick3.wav");
				soundObject.play();
			}

			switch(currentLocation)
			{
			case "forestStartOptions":
				switch(yourChoice)
				{
				case "c1": forestTrail(); break;
				case "c2": mountain(); break;
				case "c3": westRoad(); break;
				case "c4": clearing(); break;

				}
				break;

			case "forestTrail":
				switch(yourChoice)
				{
				case "c1": forestTrailContinued(); break;
				case "c2": forestStart(); break;
				case "c3": break;
				case "c4": break;
				}
				break;

			case "mountainOptions":
				switch(yourChoice)
				{
				case "c1": mountainUnworthy(); break;
				case "c2": forestStart(); break;
				case "c3": break;
				case "c4": break;
				}
				break;

			case "mountainUnworthy":
				switch(yourChoice)
				{
				case "c1": mountainOptions(); break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				break;

			case "clearing":
				switch(yourChoice)
				{
				case "c1": forestStartOptions(); break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				break;

			case "forestTrailContinued":
				switch(yourChoice)
				{
				case "c1": break;
				case "c2": forestTrail(); break;
				case "c3": break;
				case "c4": break;
				}
				break;

			case "forestTrailContinuedOptions":
				switch(yourChoice)
				{
				case "c1": forestTrailTalk(); break;
				case "c2": break;
				case "c3": forestTrail(); break;
				case "c4": break;
				}
				break;

			case "forestTrailTalkContinued":
				switch(yourChoice)
				{
				case "c1": forestTrailParty(); break;
				case "c2": forestTrailContinued(); charIconPanel.setVisible(false); break;
				case "c3": break;
				case "c4": break;
				}
				break;

			case "westRoadContinued":
				switch(yourChoice)
				{
				case "c1": break;
				case "c2": break;
				case "c3": break;
				case "c4": forestStart(); break;
				}
				break;

			}

		}
	}
}

