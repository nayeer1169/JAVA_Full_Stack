// -------------------------------------------------------------
// PART 1: INTERACTIVE TAB SWITCHING
// -------------------------------------------------------------
const tabLinks = document.querySelectorAll('.tab-link');
const codeBlocks = document.querySelectorAll('.code-block');

tabLinks.forEach(link => {
    link.addEventListener('click', () => {
        // Remove active class from all tabs
        tabLinks.forEach(t => t.classList.remove('active'));
        // Add active class to clicked tab
        link.classList.add('active');
        
        // Hide all code blocks
        codeBlocks.forEach(block => block.classList.remove('active'));
        // Show target code block
        const targetBlock = document.getElementById(`code-${link.dataset.file}`);
        if (targetBlock) {
            targetBlock.classList.add('active');
        }
    });
});

// -------------------------------------------------------------
// PART 2: LINE HIGHLIGHTING & EXPLANATION DETAILS
// -------------------------------------------------------------
const lines = document.querySelectorAll('.line[data-explain]');
const explanationBox = document.getElementById('explanation-box');

function highlightLineAndShowExplanation(lineNode) {
    // De-select all lines
    document.querySelectorAll('.line').forEach(l => l.classList.remove('selected-line'));
    // Select the current line
    lineNode.classList.add('selected-line');
    
    // Get parameters
    const lineNum = lineNode.dataset.line;
    const explainText = lineNode.dataset.explain;
    
    // Render explanation html in sidebar
    explanationBox.innerHTML = `
        <div class="explanation-card">
            <div class="explanation-title">Line ${lineNum} Details</div>
            <p class="explanation-text">${explainText}</p>
        </div>
    `;
}

lines.forEach(line => {
    line.addEventListener('click', () => {
        highlightLineAndShowExplanation(line);
    });
});

// -------------------------------------------------------------
// PART 3: CONCEPT CARDS LINKING TO CODE
// -------------------------------------------------------------
const conceptCards = document.querySelectorAll('.concept-card');

conceptCards.forEach(card => {
    card.addEventListener('click', () => {
        const targetFile = card.dataset.targetFile;
        const targetLine = card.dataset.targetLine;
        
        // Find tab link and trigger click
        const tabLink = document.querySelector(`.tab-link[data-file="${targetFile}"]`);
        if (tabLink) {
            tabLink.click();
            
            // Find line and highlight
            setTimeout(() => {
                const lineNode = document.querySelector(`#code-${targetFile} .line[data-line="${targetLine}"]`);
                if (lineNode) {
                    highlightLineAndShowExplanation(lineNode);
                    lineNode.scrollIntoView({ behavior: 'smooth', block: 'center' });
                }
            }, 100);
        }
    });
});

// -------------------------------------------------------------
// PART 4: COPY TO CLIPBOARD HELPER
// -------------------------------------------------------------
const copyBtns = document.querySelectorAll('.copy-btn');

copyBtns.forEach(btn => {
    btn.addEventListener('click', () => {
        const textToCopy = btn.dataset.copy;
        navigator.clipboard.writeText(textToCopy).then(() => {
            const originalText = btn.textContent;
            btn.textContent = "Copied!";
            btn.style.color = "var(--clr-primary)";
            btn.style.borderColor = "var(--clr-primary)";
            
            setTimeout(() => {
                btn.textContent = originalText;
                btn.style.color = "";
                btn.style.borderColor = "";
            }, 1500);
        });
    });
});

// -------------------------------------------------------------
// PART 5: JAVA TERMINAL SIMULATOR STATE MACHINE
// -------------------------------------------------------------
const terminalScreen = document.getElementById('terminal-screen');
const terminalInput = document.getElementById('terminal-input');
const shortcutBtns = document.querySelectorAll('.shortcut-btn');

// Simulated application state variables
let account = null; // Stored account object
let simState = 'menu'; // Tracks where the simulator is in input gathering
let tempAccount = {}; // Temp holder for dynamic account creation values

// Utility to append formatted text to the simulated terminal
function writeToTerminal(text, type = '') {
    const line = document.createElement('div');
    line.className = 'terminal-line';
    if (type) {
        line.classList.add(type);
    }
    line.textContent = text;
    terminalScreen.appendChild(line);
    // Smooth scroll to bottom
    terminalScreen.scrollTop = terminalScreen.scrollHeight;
}

// Print main menu structure
function printSimMenu() {
    writeToTerminal("\n--- MAIN MENU ---");
    writeToTerminal("1. Create Savings Account");
    writeToTerminal("2. Create Current Account");
    writeToTerminal("3. Deposit Money");
    writeToTerminal("4. Withdraw Money");
    writeToTerminal("5. Apply Savings Interest");
    writeToTerminal("6. Display Account Details");
    writeToTerminal("7. Reset System");
}

// Main logic router for inputs
function handleTerminalInput(input) {
    const cleanInput = input.trim();
    writeToTerminal(`$ ${input}`, 'text-muted');

    switch (simState) {
        case 'menu':
            switch (cleanInput) {
                case '1':
                    simState = 'create_savings_num';
                    writeToTerminal("Enter Account Number (e.g. SA101):", 'text-success');
                    break;
                case '2':
                    simState = 'create_current_num';
                    writeToTerminal("Enter Account Number (e.g. CA101):", 'text-success');
                    break;
                case '3':
                    if (!account) {
                        writeToTerminal("Error: Please create an account first (Option 1 or 2)!", 'text-danger');
                        printSimMenu();
                    } else {
                        simState = 'deposit_amt';
                        writeToTerminal(`[Account: ${account.number}] Enter deposit amount:`, 'text-success');
                    }
                    break;
                case '4':
                    if (!account) {
                        writeToTerminal("Error: Please create an account first (Option 1 or 2)!", 'text-danger');
                        printSimMenu();
                    } else {
                        simState = 'withdraw_amt';
                        writeToTerminal(`[Account: ${account.number}] Enter withdrawal amount:`, 'text-success');
                    }
                    break;
                case '5':
                    if (!account) {
                        writeToTerminal("Error: Please create an account first!", 'text-danger');
                        printSimMenu();
                    } else if (account.type !== 'Savings') {
                        writeToTerminal("Error: Interest can only be applied to a Savings Account!", 'text-danger');
                        printSimMenu();
                    } else {
                        // Apply interest
                        const interest = account.balance * (account.interestRate / 100);
                        account.balance += interest;
                        writeToTerminal(`Interest of ${interest.toFixed(2)} applied at ${account.interestRate}%. New Balance: ${account.balance.toFixed(2)}`, 'text-accent');
                        printSimMenu();
                    }
                    break;
                case '6':
                    if (!account) {
                        writeToTerminal("Error: Please create an account first!", 'text-danger');
                        printSimMenu();
                    } else {
                        // Display Details
                        writeToTerminal("\n----------------------------------------");
                        if (account.type === 'Savings') {
                            writeToTerminal("           SAVINGS ACCOUNT DETAILS      ");
                            writeToTerminal("----------------------------------------");
                            writeToTerminal(`Account Number : ${account.number}`);
                            writeToTerminal(`Account Holder : ${account.name}`);
                            writeToTerminal(`Current Balance: $${account.balance.toFixed(2)}`);
                            writeToTerminal(`Interest Rate  : ${account.interestRate}%`);
                        } else {
                            writeToTerminal("           CURRENT ACCOUNT DETAILS      ");
                            writeToTerminal("----------------------------------------");
                            writeToTerminal(`Account Number  : ${account.number}`);
                            writeToTerminal(`Account Holder  : ${account.name}`);
                            writeToTerminal(`Current Balance : $${account.balance.toFixed(2)}`);
                            writeToTerminal(`Overdraft Limit : $${account.overdraftLimit.toFixed(2)}`);
                        }
                        writeToTerminal("----------------------------------------");
                        printSimMenu();
                    }
                    break;
                case '7':
                    account = null;
                    writeToTerminal("System Reset. All active accounts cleared.", 'text-warning');
                    printSimMenu();
                    break;
                default:
                    writeToTerminal("Error: Invalid choice! Please select an option between 1 and 7.", 'text-danger');
                    printSimMenu();
            }
            break;

        // SAVINGS CREATION FLOW
        case 'create_savings_num':
            if (!cleanInput) {
                writeToTerminal("Error: Number cannot be empty. Enter Account Number:", 'text-danger');
                break;
            }
            tempAccount.number = cleanInput;
            simState = 'create_savings_name';
            writeToTerminal("Enter Account Holder Name:", 'text-success');
            break;
        case 'create_savings_name':
            if (!cleanInput) {
                writeToTerminal("Error: Name cannot be empty. Enter Account Holder Name:", 'text-danger');
                break;
            }
            tempAccount.name = cleanInput;
            simState = 'create_savings_bal';
            writeToTerminal("Enter Initial Deposit Amount:", 'text-success');
            break;
        case 'create_savings_bal':
            const saBal = parseFloat(cleanInput);
            if (isNaN(saBal) || saBal < 0) {
                writeToTerminal("Error: Enter a valid positive number for deposit:", 'text-danger');
                break;
            }
            tempAccount.balance = saBal;
            simState = 'create_savings_rate';
            writeToTerminal("Enter Interest Rate (e.g. 4.5):", 'text-success');
            break;
        case 'create_savings_rate':
            const saRate = parseFloat(cleanInput);
            if (isNaN(saRate) || saRate < 0) {
                writeToTerminal("Error: Enter a valid positive interest rate:", 'text-danger');
                break;
            }
            account = {
                type: 'Savings',
                number: tempAccount.number,
                name: tempAccount.name,
                balance: tempAccount.balance,
                interestRate: saRate
            };
            writeToTerminal("Success: Savings Account created successfully!", 'text-success');
            simState = 'menu';
            printSimMenu();
            break;

        // CURRENT CREATION FLOW
        case 'create_current_num':
            if (!cleanInput) {
                writeToTerminal("Error: Number cannot be empty. Enter Account Number:", 'text-danger');
                break;
            }
            tempAccount.number = cleanInput;
            simState = 'create_current_name';
            writeToTerminal("Enter Account Holder Name:", 'text-success');
            break;
        case 'create_current_name':
            if (!cleanInput) {
                writeToTerminal("Error: Name cannot be empty. Enter Account Holder Name:", 'text-danger');
                break;
            }
            tempAccount.name = cleanInput;
            simState = 'create_current_bal';
            writeToTerminal("Enter Initial Deposit Amount:", 'text-success');
            break;
        case 'create_current_bal':
            const caBal = parseFloat(cleanInput);
            if (isNaN(caBal) || caBal < 0) {
                writeToTerminal("Error: Enter a valid positive deposit:", 'text-danger');
                break;
            }
            tempAccount.balance = caBal;
            simState = 'create_current_limit';
            writeToTerminal("Enter Overdraft Limit (e.g. 5000):", 'text-success');
            break;
        case 'create_current_limit':
            const caLimit = parseFloat(cleanInput);
            if (isNaN(caLimit) || caLimit < 0) {
                writeToTerminal("Error: Enter a valid positive limit:", 'text-danger');
                break;
            }
            account = {
                type: 'Current',
                number: tempAccount.number,
                name: tempAccount.name,
                balance: tempAccount.balance,
                overdraftLimit: caLimit
            };
            writeToTerminal("Success: Current Account created successfully!", 'text-success');
            simState = 'menu';
            printSimMenu();
            break;

        // DEPOSIT FLOW
        case 'deposit_amt':
            const depAmt = parseFloat(cleanInput);
            if (isNaN(depAmt) || depAmt <= 0) {
                writeToTerminal("Error: Deposit amount must be positive. Enter deposit amount:", 'text-danger');
                break;
            }
            account.balance += depAmt;
            writeToTerminal(`Successfully deposited ${depAmt.toFixed(2)}. New Balance: ${account.balance.toFixed(2)}`, 'text-accent');
            simState = 'menu';
            printSimMenu();
            break;

        // WITHDRAWAL FLOW
        case 'withdraw_amt':
            const wAmt = parseFloat(cleanInput);
            if (isNaN(wAmt) || wAmt <= 0) {
                writeToTerminal("Error: Withdrawal amount must be positive. Enter withdrawal amount:", 'text-danger');
                break;
            }

            if (account.type === 'Savings') {
                if (account.balance >= wAmt) {
                    account.balance -= wAmt;
                    writeToTerminal(`Successfully withdrew ${wAmt.toFixed(2)}. Remaining Balance: ${account.balance.toFixed(2)}`, 'text-accent');
                } else {
                    writeToTerminal("Error: Insufficient funds! Withdrawal failed.", 'text-danger');
                }
            } else {
                // Current account overdraft check
                if (account.balance + account.overdraftLimit >= wAmt) {
                    account.balance -= wAmt;
                    writeToTerminal(`Successfully withdrew ${wAmt.toFixed(2)}. Remaining Balance: ${account.balance.toFixed(2)}`, 'text-accent');
                } else {
                    writeToTerminal("Error: Overdraft limit exceeded! Withdrawal failed.", 'text-danger');
                }
            }
            simState = 'menu';
            printSimMenu();
            break;
    }
}

// Input Listener (Enter key)
terminalInput.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
        const val = terminalInput.value;
        terminalInput.value = '';
        handleTerminalInput(val);
    }
});

// Sidebar Buttons Action triggers
shortcutBtns.forEach(btn => {
    btn.addEventListener('click', () => {
        const choice = btn.dataset.choice;
        if (choice === '7') {
            handleTerminalInput('7'); // Force Reset
        } else {
            // If in the middle of inputs, reset to menu state to let them select another option
            if (simState !== 'menu') {
                writeToTerminal("[Action cancelled. Resetting back to menu]", 'text-warning');
                simState = 'menu';
                printSimMenu();
            }
            handleTerminalInput(choice);
        }
    });
});
