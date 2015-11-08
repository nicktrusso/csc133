package a3.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import a3.controller.GameWorld;

@SuppressWarnings("serial")
public class ScoreView extends JPanel implements Observer {
	private static GameWorld gameWorld;
	private static ScoreView sv;
	private JLabel totalPoints;
	private JLabel dogCap;
	private JLabel catCap;
	private JLabel dogRem;
	private JLabel catsRem;
	private JLabel soundOnOff;
	
	private ScoreView(Observable observable){
		gameWorld = (GameWorld) observable;
		gameWorld.addObserver(this);
		
		totalPoints = new JLabel("Total Points: 0");
		dogCap = new JLabel("Dogs Captured: 0");
		catCap = new JLabel("Cats Captured: 0");
		dogRem = new JLabel("Dogs Remaining: "+gameWorld.getDogsRemaining());
		catsRem = new JLabel("Cats Remaining: "+gameWorld.getCatsRemaining());
		soundOnOff = new JLabel();
		if(gameWorld.isSoundOn())
			soundOnOff.setText("Sound: On");		
		else
			soundOnOff.setText("Sound: Off");
		this.setLayout(new GridBagLayout());
		GridBagConstraints scoreConstraints = new GridBagConstraints();
		
		scoreConstraints.insets = new Insets(0,0,5,0);
		scoreConstraints.fill = GridBagConstraints.HORIZONTAL;
		scoreConstraints.gridx = 0;
		scoreConstraints.gridy = 0;
		add(totalPoints,scoreConstraints);
		
		scoreConstraints.insets = new Insets(0,20,5,0);
		scoreConstraints.fill = GridBagConstraints.HORIZONTAL;
		scoreConstraints.gridx = 1;
		scoreConstraints.gridy = 0;
		add(dogCap,scoreConstraints);
		
		scoreConstraints.fill = GridBagConstraints.HORIZONTAL;
		scoreConstraints.gridx = 2;
		scoreConstraints.gridy = 0;
		add(catCap,scoreConstraints);
		
		scoreConstraints.fill = GridBagConstraints.HORIZONTAL;
		scoreConstraints.gridx = 3;
		scoreConstraints.gridy = 0;
		add(dogRem,scoreConstraints);
		
		scoreConstraints.fill = GridBagConstraints.HORIZONTAL;
		scoreConstraints.gridx = 4;
		scoreConstraints.gridy = 0;
		add(catsRem,scoreConstraints);
		
		scoreConstraints.fill = GridBagConstraints.HORIZONTAL;
		scoreConstraints.gridx = 5;
		scoreConstraints.gridy = 0;
		add(soundOnOff,scoreConstraints);
		
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		setVisible(true);
		
	}
	public static ScoreView getScoreView(){
		if(sv == null)
			sv = new ScoreView(GameWorld.getGameWorld());
		return sv;
	}
	@Override
	public void update(Observable o, Object arg) {
		totalPoints.setText("Total Points: "+gameWorld.getTotalPoints());
		dogCap.setText("Dogs Captured: "+gameWorld.getDogsCaptured());
		dogRem.setText("Dogs Remaining: "+gameWorld.getDogsRemaining());
		catCap.setText("Cats Captured: "+gameWorld.getCatsCaptured());
		catsRem.setText("Cats Remaining: "+gameWorld.getCatsRemaining());
		if(gameWorld.isSoundOn())
			soundOnOff.setText("Sound: On");		
		else
			soundOnOff.setText("Sound: Off");
	}
}
