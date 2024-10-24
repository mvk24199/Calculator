# Calculator

This project is a simple **GUI-based calculator** built using **Java Swing**. It provides basic arithmetic operations such as addition, subtraction, multiplication, and division, along with additional functionalities like clearing input, deleting characters, and handling negative numbers.

## Features

- **Addition, Subtraction, Multiplication, Division** operations.
- **Decimal support** for floating-point arithmetic.
- **Clear (CLR)** button to reset the display.
- **Delete (DEL)** button to remove the last entered digit.
- **Negation (±)** button to toggle between positive and negative values.
- **Instant result display** upon clicking the equals (`=`) button.
- **User-friendly GUI** built with buttons for digits (0-9) and functions arranged in a grid.

## Technologies Used

- **Java Swing** for the graphical user interface.
- **ActionListeners** for button interactions.
- **GridLayout** for arranging buttons in a structured format.

## How to Run

1. Clone the repository.
2. Compile the `Calculator.java` file:
   ```bash
   javac Calculator.java
   ```
3. Run the program:
   ```bash
   java Calculator
   ```

## Project Structure

- The main functionality is handled by the `Calculator` class.
- GUI components include:
  - A `JTextField` for displaying the entered numbers and results.
  - Number buttons (0-9) and operation buttons (`+`, `-`, `*`, `/`).
  - Special function buttons like Clear (CLR), Delete, Equals (`=`), Decimal (`.`), and Negate (`(-)`).

## Future Enhancements

- Add support for advanced mathematical operations (e.g., square root, percentage).
- Implement keyboard shortcuts for better usability.
