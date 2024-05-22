# Tic-Tac-Toe-Game
The provided Java code implements a simple command-line version of the Tic Tac Toe game. Here's a brief description of the key components and functionality:

TicTacToe Class:

Manages the game state, including the game board.
Provides methods to initialize the board, display the board, place marks, and check for win/draw conditions.
Player Abstract Class:

Defines the structure for players in the game, including their name and mark (X or O).
Contains an abstract method makeMove() for making moves and another abstract method isValid() for validating moves.
HumanPlayer Class:

Extends the Player class to represent a human player.
Implements the makeMove() method to accept user input for moves and isValid() method to validate the move's legality.
ComputerPlayer Class:

Extends the Player class to represent a computer player.
Implements the makeMove() method to generate random moves and isValid() method to validate the move's legality.
Main Method:

Initiates the game by creating an instance of TicTacToe.
Instantiates a human player and a computer player.
Manages the game loop where players take turns making moves until a win or draw condition is met.
Game Logic Methods:

checkRow(), checkCol(), and checkDiag(): Check if there's a winning configuration in rows, columns, or diagonals.
checkDraw(): Checks if the game has ended in a draw by verifying if the board is full.
