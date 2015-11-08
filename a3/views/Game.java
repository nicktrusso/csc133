package a3.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import a3.commands.About;
import a3.commands.Breed;
import a3.commands.ContractNet;
import a3.commands.EmptyCommand;
import a3.commands.ExpandNet;
import a3.commands.Fight;
import a3.commands.Quit;
import a3.commands.Scoop;
import a3.commands.SoundOnOff;
import a3.commands.Tick;
import a3.controller.GameWorld;
import a3.movement.MoveDown;
import a3.movement.MoveLeft;
import a3.movement.MoveRight;
import a3.movement.MoveUp;
import a3.utilities.Utility;

/**
 * Dog Catcher game
 * created by: Nick Trusso 9/15
 * 
 * v1.0 9/15 	Assignment #1 building the skeleton of the game
 * v1.2			added concrete methods to subclasses that implement GameObject
 * v1.3			implemented interface for movement
 * 				created collection for game objects
 * v1.4 		minor bug fixes
 * v1.5			fixed contiains() method in net class, works prooperly now
 * 
 * v2.0 10/14 	Assignment #2 updates begin
 * 				modified Game and GameWorld to implement singleton pattern
 * 				added GameObjectFactory (Factory Builder Pattern)
 * v2.1 10/15 	modified fight() to scratch a random dog
 * v2.2 10/17 	Added GUI
 * 				GameObjectCollection now implements singleton
 * 				started building command objects
 * v2.4 10/18 	All command object created and linked
 * 				KeyBindings mapped and linked
 * v2.5	10/19	Menu items not attached to any specific command now implement EmptyCommand to print
 * 				to console
 * v3.0 10/28	
 */

@SuppressWarnings("serial")
public class Game extends JFrame{
	//Controller//
	private GameWorld gw;
	private static Game game;
	private boolean gameOver;
	private MapView mv;
	private ScoreView scoreView;
	private JPanel mainSouthPanel;
	private JPanel commandButtons; 
	private JPanel movement;
	private JMenuBar menuBar;
	//**********Commands*******************
	private ExpandNet expandCommand;
	private ContractNet contractCommand;
	private Scoop scoopCommand;
	private Breed breedCommand;
	private Fight fightCommand;
	private Tick tickCommand;
	private About aboutCommand;
	private Quit quitCommand;
	private SoundOnOff soundCommand;
	private MoveUp moveUpCommand;
	private MoveDown moveDownCommand;
	private MoveLeft moveLeftCommand;
	private MoveRight moveRightCommand;
	
	
	private Game(){
		gw = GameWorld.getGameWorld();
		gw.initLayout();
		gameOver = false;
		mv = MapView.getMapView();
		scoreView = ScoreView.getScoreView();
		gw.addObserver(mv);
		gw.addObserver(scoreView);
		createCommands();
		initView();
		setKeyBindings();
		printTitle();
	}
	
	public static Game getGame(){
		if(game == null)
			game = new Game();
		return game;
	}
	
	private void createCommands(){
		expandCommand = new ExpandNet();
		contractCommand = new ContractNet();
		scoopCommand = new Scoop();
		breedCommand = new Breed();
		fightCommand = new Fight();
		tickCommand = new Tick();
		aboutCommand = new About();
		quitCommand = new Quit();
		soundCommand = new SoundOnOff();
		moveUpCommand = new MoveUp();
		moveDownCommand = new MoveDown();
		moveLeftCommand = new MoveLeft();
		moveRightCommand = new MoveRight();
	}
	
	public boolean isGameOver(){
		return gameOver;
	}
	private void printTitle(){
		Utility.clearScreen();
		System.out.println("~~~~~~~~~~~~~~~~~~");
		System.out.println("Dog Catcher 2.2");
		System.out.println("~~~~~~~~~~~~~~~~~~");
	}
	
	//************ GUI ************************
	private void initView(){
		JMenuItem quit = new JMenuItem("Quit");
		JMenu file = new JMenu("File");
		JMenu commands = new JMenu("Commands");
		JMenuItem newMenu = new JMenuItem("New");
		JMenuItem saveMenu = new JMenuItem("Save");
		JMenuItem undoMenu = new JMenuItem("Undo");
		JCheckBoxMenuItem soundCheckBox = new JCheckBoxMenuItem("Sound");
		JMenuItem aboutMenu = new JMenuItem("About");
		JMenuItem expand = new JMenuItem("Expand Net");
		JMenuItem contract = new JMenuItem("Contract Net");
		JMenuItem breed = new JMenuItem("Breed");
		JMenuItem fight = new JMenuItem("Fight");
		JButton expandButton = new JButton("Expand");
		JButton contractButton = new JButton("Contract");
		JButton scoopButton = new JButton("Scoop");
		JButton rightButton = new JButton("Right");
		JButton leftButton = new JButton("Left");
		JButton upButton = new JButton("Up");
		JButton downButton = new JButton("Down");
		JButton breedButton = new JButton("Kitten");
		JButton fightButton = new JButton("Fight");
		JButton tickButton = new JButton("Tick");
		
		
		//**********************Action Listeners**********************
		expand.setAction(expandCommand);
		expandButton.setAction(expandCommand);
		contract.setAction(contractCommand);
		contractButton.setAction(contractCommand);
		scoopButton.setAction(scoopCommand);
		breedButton.setAction(breedCommand);
		breed.setAction(breedCommand);
		fightButton.setAction(fightCommand);
		fight.setAction(fightCommand);
		tickButton.setAction(tickCommand);
		aboutMenu.setAction(aboutCommand);
		quit.setAction(quitCommand);
		soundCheckBox.setAction(soundCommand);
		upButton.setAction(moveUpCommand);
		downButton.setAction(moveDownCommand);
		leftButton.setAction(moveLeftCommand);
		rightButton.setAction(moveRightCommand);
		newMenu.setAction(new EmptyCommand("New"));
		saveMenu.setAction(new EmptyCommand("Save"));
		undoMenu.setAction(new EmptyCommand("Undo"));
		
		
		setTitle("Dog Catcher v2.5");
		setLayout(new BorderLayout());
		mainSouthPanel = new JPanel();
		commandButtons = new JPanel();
		movement = new JPanel();
		menuBar = new JMenuBar();
		mainSouthPanel.setLayout(new BorderLayout());
		commandButtons.setLayout(new GridBagLayout());
		movement.setLayout(new GridBagLayout());
		
		//***************MENU BAR**************************
		file.add(newMenu);
		file.add(saveMenu);
		file.add(undoMenu);
		file.add(soundCheckBox);
		file.add(aboutMenu);
		commands.add(expand);
		commands.add(contract);
		commands.add(breed);
		commands.add(fight);
		commands.addSeparator();
		commands.add(quit);
		menuBar.add(file);
		menuBar.add(commands);
		
		//*****************Score and Commands**************
		GridBagConstraints commandConstraints = new GridBagConstraints();

		commandConstraints.fill = GridBagConstraints.HORIZONTAL;
		commandConstraints.gridx = 0;
		commandConstraints.gridy = 1;
		commandButtons.add(expandButton,commandConstraints);
		
		commandConstraints.fill = GridBagConstraints.HORIZONTAL;
		commandConstraints.gridx = 1;
		commandConstraints.gridy = 1;
		commandButtons.add(contractButton, commandConstraints);
		
		commandConstraints.fill = GridBagConstraints.HORIZONTAL;
		commandConstraints.gridx = 2;
		commandConstraints.gridy = 1;
		commandButtons.add(scoopButton, commandConstraints);
		
		commandConstraints.fill = GridBagConstraints.HORIZONTAL;
		commandConstraints.gridx = 3;
		commandConstraints.gridy = 1;
		commandButtons.add(breedButton, commandConstraints);
		
		commandConstraints.fill = GridBagConstraints.HORIZONTAL;
		commandConstraints.gridx = 4;
		commandConstraints.gridy = 1;
		commandButtons.add(fightButton, commandConstraints);
		
		commandConstraints.fill = GridBagConstraints.HORIZONTAL;
		commandConstraints.gridx = 5;
		commandConstraints.gridy = 1;
		commandButtons.add(tickButton, commandConstraints);
		
		commandConstraints.fill = GridBagConstraints.HORIZONTAL;
		commandConstraints.gridx = 2;
		commandConstraints.gridy = 0;
		movement.add(upButton,commandConstraints);
		
		commandConstraints.fill = GridBagConstraints.HORIZONTAL;
		commandConstraints.gridx = 2;
		commandConstraints.gridy = 2;
		movement.add(downButton,commandConstraints);
		
		commandConstraints.fill = GridBagConstraints.VERTICAL;
		commandConstraints.gridx = 3;
		commandConstraints.gridy = 1;
		movement.add(rightButton,commandConstraints);
		
		commandConstraints.fill = GridBagConstraints.VERTICAL;
		commandConstraints.gridx = 0;
		commandConstraints.gridy = 1;
		movement.add(leftButton,commandConstraints);
		
		
		//********************************************
		Dimension preferredMovementSize = new Dimension();
		Dimension preferredCommandSize = new Dimension();
		Dimension preferredMapViewSize = new Dimension();
		Dimension preferredFrameSize = new Dimension();
		movement.setBorder(BorderFactory.createEtchedBorder());
		commandButtons.setBorder(BorderFactory.createEtchedBorder());
		preferredCommandSize.height = 75;
		preferredCommandSize.width = GameWorld.WORLDSIZEX;
		preferredMovementSize.height = 95;
		preferredMovementSize.width = 200;
		preferredMapViewSize.height = GameWorld.WORLDSIZEY;
		preferredMapViewSize.width = GameWorld.WORLDSIZEX;
		preferredFrameSize.width = GameWorld.WORLDSIZEX;
		preferredFrameSize.height = 1000;
		commandButtons.setPreferredSize(preferredCommandSize);
		movement.setPreferredSize(preferredMovementSize);
		mv.setPreferredSize(preferredMapViewSize);
		add(menuBar,BorderLayout.NORTH);
		add(mv,BorderLayout.CENTER);
		add(mainSouthPanel,BorderLayout.SOUTH);
		mainSouthPanel.add(scoreView, BorderLayout.CENTER);
		mainSouthPanel.add(commandButtons,BorderLayout.SOUTH);
		mainSouthPanel.add(movement,BorderLayout.EAST);
		mainSouthPanel.setVisible(true);
		commandButtons.setVisible(true);
		movement.setVisible(true);
		setPreferredSize(preferredFrameSize);
		setLocationByPlatform(true);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void setKeyBindings(){
		int mapName = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap iMap = mainSouthPanel.getInputMap(mapName);
		ActionMap aMap = mainSouthPanel.getActionMap();
		KeyStroke key;
		
		//Movement Keys
		//up key
		key = KeyStroke.getKeyStroke("UP");
		iMap.put(key, "up");
		aMap.put("up", moveUpCommand);

		//down key
		key = KeyStroke.getKeyStroke("DOWN");
		iMap.put(key, "down");
		aMap.put("down", moveDownCommand);
		
		//left key
		key = KeyStroke.getKeyStroke("LEFT");
		iMap.put(key, "left");
		aMap.put("left", moveLeftCommand);
		
		//right key
		key = KeyStroke.getKeyStroke("RIGHT");
		iMap.put(key, "right");
		aMap.put("right", moveRightCommand);
		
		//Action Keys
		//expand key
		key = KeyStroke.getKeyStroke('e');
		iMap.put(key, "expand");
		aMap.put("expand", expandCommand);
		
		//contract key
		key = KeyStroke.getKeyStroke('c');
		iMap.put(key, "contract");
		aMap.put("contract", contractCommand);
		
		//scoop
		key = KeyStroke.getKeyStroke('s');
		iMap.put(key, "scoop");
		aMap.put("scoop", scoopCommand);
		
		//quit
		key = KeyStroke.getKeyStroke('q');
		iMap.put(key, "quit");
		aMap.put("quit", quitCommand);
		
		//breed
		key = KeyStroke.getKeyStroke('b');
		iMap.put(key, "breed");
		aMap.put("breed", breedCommand);
		
		//fight
		key = KeyStroke.getKeyStroke('f');
		iMap.put(key, "fight");
		aMap.put("fight", fightCommand);
		
		//tick
		key = KeyStroke.getKeyStroke('t');
		iMap.put(key, "tick");
		aMap.put("tick", tickCommand);
		
		
	}
}
