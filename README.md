# Rock Paper Scissors

This is a simple Rock Paper Scissors console application, here's some information about the project.

## Structure

**Packages**
- `com.github.lucasls.rockpaperscissors`: The root package
  - `.domain`: Contains the game logic, decoupled from the application, highly covered by Unit Tests.  
    - `.value`: Contains "Value Object", basically data classes and enums, basically used to carry information.
    - `.player`: Contains the `Player` interface and its implementations 
  - `.application`: Contains a console text-based implementation of the application. The components are Wired according to
 the final application needs. Covered by Integration Tests
    - `.config`: Conatins a config file that injects the dependencies into components to wire the application
    - `.ui`: Contains a UI Handler, that presents the game rounds and result in a text-based console application making
     use of Emoji :)
   
## Entry points

The application can be mannually started by running the `main` method of the `RockPaperScissorsApplication.kt` file.

The game logic starts on method `startGame` of the `GameService` class.

## Expected application output (Example)

```
ROCK X PAPER X SCISSORS
----------------------------------------------------------------
Round 1:   Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 2:   Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 3:   Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 4:   Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 5:   Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 6:   Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 7:   Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 8:   Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 9:   Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 10:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 11:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 12:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 13:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 14:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 15:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 16:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 17:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 18:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 19:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 20:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 21:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 22:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 23:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 24:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 25:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 26:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 27:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 28:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 29:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 30:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 31:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 32:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 33:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 34:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 35:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 36:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 37:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 38:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 39:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 40:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 41:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 42:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 43:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 44:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 45:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 46:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 47:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 48:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 49:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 50:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 51:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 52:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 53:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 54:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 55:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 56:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 57:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 58:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 59:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 60:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 61:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 62:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 63:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 64:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 65:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 66:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 67:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 68:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 69:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 70:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 71:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 72:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 73:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 74:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 75:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 76:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 77:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 78:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 79:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 80:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 81:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 82:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 83:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 84:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 85:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 86:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 87:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 88:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 89:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 90:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 91:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 92:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 93:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 94:  Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 95:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 96:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 97:  Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 98:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 99:  Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 100: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 101: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 102: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 103: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 104: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 105: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 106: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 107: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 108: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 109: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 110: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 111: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 112: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 113: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 114: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 115: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 116: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 117: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 118: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 119: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 120: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 121: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 122: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 123: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 124: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 125: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 126: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 127: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 128: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 129: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 130: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 131: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 132: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 133: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 134: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 135: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 136: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 137: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 138: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 139: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 140: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 141: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 142: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 143: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 144: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 145: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 146: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 147: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 148: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 149: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 150: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 151: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 152: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 153: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 154: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 155: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 156: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 157: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 158: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 159: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 160: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 161: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 162: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 163: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 164: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 165: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 166: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 167: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 168: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 169: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 170: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 171: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 172: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 173: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 174: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 175: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 176: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 177: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 178: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 179: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 180: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 181: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 182: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 183: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 184: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 185: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 186: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 187: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 188: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 189: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 190: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
Round 191: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 192: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 193: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 194: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 195: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 196: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 197: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 198: Player 1 🧐 ✊ X ✊ 🧐 Player 2 ... ❌ It's a Draw ❌
Round 199: Player 1 🧐 ✋ X ✊ 🧐 Player 2 ... 🏆 Player 1 wins 🧐
Round 200: Player 1 🧐 ✌️ X ✊ 🧐 Player 2 ... 🏆 Player 2 wins 🤪
----------------------------------------------------------------
Final Result: 🏆 Player 1 wins 🧐
🧐 Player 1 victories: 78
🤪 Player 2 victories: 57
❌ Number of draws: 65
```