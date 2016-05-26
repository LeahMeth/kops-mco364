package kops.mco364.ai;

import java.util.List;
import java.util.Random;

import kops.mco364.ai.Board.Piece;

public class BestMoveFinder {

	private static final Random RAND = new Random();

	// one-level method- finds best move for the active player
	public int getBestMove(Board parent) {
		Board.Piece activePlayer = parent.getActivePlayer();
		List<Integer> moves = parent.moves();
		int bestMove = -1;
		
		for (int move : moves) {
			Board child = new Board(parent);
			child.set(move, activePlayer);
			if (child.getWinner() == activePlayer) {
				return move;
			}
		}
		
		/*//if no winning move, check for move to block other player from winning
		int defendingMove = getDefensiveMove(parent);
		if(defendingMove != -1){
			return defendingMove;
		}*/
		
		getDefensiveMove(parent);
		
		return moves.get(RAND.nextInt(moves.size()));

	}

	// finds if other player can win on next move
	public void getDefensiveMove(Board parent){
		//Board.Piece activePlayer = parent.getActivePlayer() == Piece.X ? Piece.O : Piece.X;		
		
		parent.setActivePlayer(parent.getActivePlayer() == Piece.X ? Piece.O : Piece.X);
		/*List<Integer> moves = parent.moves();
		
		for(int move: moves){
			Board child = new Board(parent);
			child.set(move, activePlayer);
			if(child.getWinner() == activePlayer){
				return move;
			}
		}
		
		return moves.get(RAND.nextInt(moves.size()));*/
		
		
		
	}

	public static void main(String[] args) {

	}

}
