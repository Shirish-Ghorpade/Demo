package com.aurionpro.abstractfactory.test;

import java.util.Scanner;

import com.aurionpro.abstractfactory.model.CurrentAccountFactory;
import com.aurionpro.abstractfactory.model.IAccount;
import com.aurionpro.abstractfactory.model.IAccountFactory;
import com.aurionpro.abstractfactory.model.SavingAccountFactory;

public class AccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double amount;

		boolean exitOption = false;
		IAccountFactory accountFactory;
		IAccount account = null;

		while (!exitOption) {
			System.out.println("----------------------------------------------------------------");

			System.out.println("1. Create Saving account");
			System.out.println("2. Create Current account");
			System.out.println("3. Check Balance");
			System.out.println("4. Deposit Money");
			System.out.println("5. Withdraw Money");
			System.out.println("6. Exit");
			System.out.println("Please choose an option: ");
			int response = scanner.nextInt();
			switch (response) {
			case 1:
				accountFactory = new SavingAccountFactory();
				account = accountFactory.makeAccount();
				break;
			case 2:
				accountFactory = new CurrentAccountFactory();
				account = accountFactory.makeAccount();
				break;
			case 3:
				System.out.println("Current balance of account number " + account.getAccountNumber() + " is "
						+ account.getBalance());
				break;
			case 4:
				System.out.println("Enter the deposit amount");
				amount = scanner.nextLong();
				account.credit(amount);
				break;

			case 5:
				System.out.println("Enter the withdrawl amount");
				amount = scanner.nextLong();
				account.debit(amount);
				break;
			case 6:
				exitOption = true;
				System.out.println("Thank You !!!");
				break;
			default:
				System.out.println("Invalid input");
			}
		}

	}

}


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell();
    }

    @Test
    void testCreatedCellIsEmpty() {
        assertTrue(cell.isCellEmpty());
    }

    @Test
    void testSetMark_checkIfCanMarkX() throws CellAlreadyMarkedException {
        cell.setMark(MarkType.X);
        assertEquals(MarkType.X, cell.getMark());
    }

    @Test
    void testSetMark_checkIfCanMarkO() throws CellAlreadyMarkedException {
        cell.setMark(MarkType.O);
        assertEquals(MarkType.O, cell.getMark());
    }

    @Test
    void testSetMark_throwsCellAlreadyMarkedExceptionWhenMarkedTwice() {
        assertThrows(CellAlreadyMarkedException.class, () -> {
            cell.setMark(MarkType.X);
            cell.setMark(MarkType.O);
        });
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testCreateBoard_allNineCellsAreEmpty() {
        for (Cell cell : board.getCells()) {
            assertTrue(cell.isCellEmpty());
        }
    }

    @Test
    void testSetCellMark_ableToMarkAtSpecificLocation() throws CellAlreadyMarkedException {
        board.setCellMark(0, MarkType.X);
        assertEquals(MarkType.X, board.getCells()[0].getMark());
    }

    @Test
    void testSetCellMark_throwsInvalidLocationExceptionForInvalidCellLocation() {
        assertThrows(IllegalArgumentException.class, () -> {
            board.setCellMark(9, MarkType.X);
        });
    }

    @Test
    void testIsBoardFull_checkTrueIfBoardIsFull() throws CellAlreadyMarkedException {
        for (int i = 0; i < 9; i++) {
            board.setCellMark(i, MarkType.X);
        }
        assertTrue(board.isBoardFull());
    }

    @Test
    void testSetCellMark_throwsCellAlreadyMarkedExceptionIfCellMarkedTwice() {
        assertThrows(CellAlreadyMarkedException.class, () -> {
            board.setCellMark(0, MarkType.X);
            board.setCellMark(0, MarkType.O);
        });
    }
}

