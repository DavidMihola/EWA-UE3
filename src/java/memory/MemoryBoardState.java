package memory;

public enum MemoryBoardState {
	NEW_TURN,		// zu Beginn eines neuen Zugs, bevor die erste Karte aufgedeckt wird
	UNFINISHED_TURN, 	// nachdem die erste Karte eines Zuges aufgedeckt wird
	PAIR_FOUND, 		// wenn die beiden Karten zusammenpassen
	NO_PAIR_FOUND, 		// wenn die beiden Karten nicht zusammenpassen
	GAME_OVER		// alle Karten aufgedeckt, alle Paare gefunden
}