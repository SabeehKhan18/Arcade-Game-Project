package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import Game.Game;
import Game.Game.State;
import Window.Help;
import Window.Menu;
import Window.ScoreScreen;
import Window.WinScreen;

public class MouseInput implements MouseListener {
	private Menu menu;
	private Game game;
	private ScoreScreen ss;
	private WinScreen ws;
	private Help helpScreen;
	
	public MouseInput(Game game) {
		this.game = game;
		this.menu = game.getMenu();
		this.ss = game.getScoreScreen();
		this.ws = game.getWinScreen();
		this.helpScreen = game.getHelpScreen();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void mousePressed(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();
		Point2D clickedPoint = new Point2D.Double(mx,my);
		if (this.game.getState() == State.MENU) {
			// Play Button
			if (this.menu.getPlayButton().contains(clickedPoint)) {
				this.game.setState(State.GAME);
			}
			// Help Button
			if (this.menu.getHelpButton().contains(clickedPoint)) {
				this.game.setState(State.HELP);
			}
			// Quit Button
			if (this.menu.getQuitButton().contains(clickedPoint)) {
				this.game.setState(State.EXIT);
			}
		}
		if (this.game.getState() == State.SCORESCREEN) {
			//ScoreScreen toHome
			if (this.ss.getToHome().contains(clickedPoint)) {
				this.game.setState(State.MENU);
			}
			//ScoreScreen playAgain
			if (this.ss.getPlayAgain().contains(clickedPoint)) {
				this.game.setState(State.GAME);
			}
		}
		if (this.game.getState() == State.WIN) {
			//ScoreScreen toHome
			if (this.ws.getToHome().contains(clickedPoint)) {
				this.game.setState(State.MENU);
			}
			//ScoreScreen playAgain
			if (this.ws.getPlayAgain().contains(clickedPoint)) {
				this.game.setState(State.GAME);
			}
		}
		if (this.game.getState() == State.HELP) {
			if (this.helpScreen.getBackButton().contains(clickedPoint)) {
				this.game.setState(State.MENU);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub.

	}

}
