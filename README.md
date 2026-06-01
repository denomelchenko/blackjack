# Blackjack in Java - Project Overview

Welcome to the **Blackjack in Java** project! This is a comprehensive implementation of the classic card game Blackjack, built with Java and Maven, following best practices such as Test-Driven Development (TDD), CI/CD with GitHub Actions, and clean code architecture. Whether you're a beginner learning Java or an experienced developer exploring game development, this project provides a solid foundation and clear structure.

---

## 🚀 What is Included?

- **Fully functional game logic**: Implemented rules, scoring, blackjack detection, and game flow.
- **Object-Oriented Design**: Classes for cards, deck, hands, players, and dealer.
- **Unit Tests**: Extensive testing for core components using JUnit 5.
- **CI/CD Pipeline**: Automated testing with GitHub Actions.
- **Console UI**: Interactive command-line game allowing real gameplay.
- **Version Control**: Managed with Git, ready for collaboration or further development.

---

## 🔧 Technologies & Tools

- **Java 17**
- **Maven** for project management and dependencies
- **JUnit 5** for testing
- **GitHub** for version control and CI/CD
- **IntelliJ IDEA** as the IDE (recommended)

---

## 📂 Project Structure

```
blackjack/
├── .github/workflows/ci.yml          # CI/CD configuration
├── pom.xml                           # Maven configuration
└── src/
    ├── main/java/blackjack/          # Main source code
    │   ├── model/                    # Card, Suit, Rank, Deck, Hand
    │   ├── player/                   # Player and Dealer classes
    │   ├── BlackjackGame.java        # Game logic
    │   ├── RoundResult.java          # Enum for game outcomes
    │   └── Main.java                   # Entry point and UI
    └── test/java/blackjack/           # Tests for core components
        ├── CardTest.java
        ├── DeckTest.java
        ├── HandTest.java
        ├── PlayerTest.java
        └── BlackjackGameTest.java
```

---

## 📝 How to Run

### Setting Up

1. Clone the repository:
```bash
git clone https://github.com/YOUR_LOGIN/blackjack.git
cd blackjack
```

2. Open the project in IntelliJ IDEA or your preferred IDE.

### Running Tests

- To ensure everything works correctly, run:
```bash
mvn clean test
```

### Playing the Game

- Launch the game by running `Main.java`.
- Follow the on-screen prompts to place bets, hit or stand, and enjoy the game.

---

## 🛠️ How It Works

### Core Components

- **Card**: Represents a playing card with suit and rank.
- **Deck**: Contains 52 cards, shuffles, and deals.
- **Hand**: Manages a collection of cards, calculates score, handles aces.
- **Player & Dealer**: Manage player actions, balance, and dealer strategies.
- **Game Logic**: Determines winners, handles blackjack, busts, and pushes.
- **Console UI**: Interactive prompts for user input, displays game state.

### Development Process

- Followed TDD methodology: write failing tests, implement code, refactor.
- Committed frequently to ensure stability.
- Used GitHub Actions for continuous testing on push.

---

## 🤝 Collaboration & Contribution

Feel free to fork, clone, and enhance this project! To contribute:

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Make your changes.
4. Run tests to verify.
5. Push your branch and open a pull request.

---

## 🎓 Learning Outcomes

- Building a complete Java application with object-oriented principles.
- Implementing game logic and user interaction via console.
- Writing and maintaining automated tests.
- Setting up CI/CD pipelines.
- Collaborating effectively with version control.

---

## 🚀 Next Steps

- Add GUI version with JavaFX or Swing.
- Extend with online multiplayer.
- Implement betting strategies or AI opponents.
- Improve user experience and input validation.

---

## 📢 Acknowledgments

Thanks for exploring this project! Whether you're here to learn, contribute, or just enjoy the game, happy coding!

---

## 📬 Contact & Feedback

Questions or feedback? Reach out via GitHub issues or fork this repository and send a pull request.

---