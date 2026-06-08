# Blackjack — Requirements Document

## Game Description
Blackjack (21) is a card game where the player competes against the dealer.
The goal is to get a hand value as close to 21 as possible without exceeding it.

## Sources
- https://en.wikipedia.org/wiki/Blackjack
- https://bicyclecards.com/how-to-play/blackjack/

## Game Rules
- Cards 2–10 have face value
- Face cards (J, Q, K) are worth 10
- Ace is worth 11 or 1 (depending on total)
- Blackjack = Ace + face card in first 2 cards (pays 3:2)
- Dealer draws until reaching at least 17
- Exceeding 21 = bust = loss

## Functional Requirements
- FR1: Player can place a bet before each round
- FR2: Player can hit or stand
- FR3: System automatically handles dealer logic
- FR4: System detects blackjack, bust and push
- FR5: Player starts with $1000 and plays until bankrupt

## Non-functional Requirements
- NFR1: Project builds and tests via Maven
- NFR2: Every PR goes through CI (GitHub Actions)
- NFR3: Key logic covered by unit tests (TDD)