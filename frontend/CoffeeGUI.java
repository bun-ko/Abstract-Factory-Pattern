package frontend;
import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CoffeeGUI extends JFrame 
{
    private CoffeeShop currentFactory;
    private final JComboBox<String> coffeeSelector = new JComboBox<>();
    private final JTextArea displayArea = new JTextArea(10, 30);
    private final JRadioButton regBtn = new JRadioButton("Regular Coffee Shop");
    private final JRadioButton decafBtn = new JRadioButton("Decaf Coffee Shop");

    public CoffeeGUI() 
    {
        super("Abstract Factory Coffee GUI");

        // Layout
        setLayout(new BorderLayout(10, 10));

        // Title
        JLabel title = new JLabel("Coffee Factory Selector");
        title.setFont(new Font("ComicSans", Font.BOLD, 18));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // Factory selection
        ButtonGroup group = new ButtonGroup();
        group.add(regBtn);
        group.add(decafBtn);
        regBtn.setSelected(true);
        currentFactory = new RegStyleCoffeeShop();

        JPanel factoryPanel = new JPanel();
        factoryPanel.add(regBtn);
        factoryPanel.add(decafBtn);
        add(factoryPanel, BorderLayout.WEST);

        // Coffee selector
        coffeeSelector.addItem("espresso");
        coffeeSelector.addItem("darkroast");
        coffeeSelector.addItem("latte");
        coffeeSelector.addItem("cappuccino");

        JButton createButton = new JButton("Create Coffee");
        createButton.addActionListener(this::handleCreateButton);
        JPanel inputPanel = new JPanel();
        inputPanel.add(coffeeSelector);
        inputPanel.add(createButton);
        add(inputPanel, BorderLayout.CENTER);

        // Output area
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Window settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleCreateButton(ActionEvent e) 
    {
        String coffeeType = (String) coffeeSelector.getSelectedItem();
        if (coffeeType == null) 
            {
            displayArea.setText("Please select a coffee type.");
            return;
        }

        // Determine which shop
        if (regBtn.isSelected()) 
            {
            currentFactory = new RegStyleCoffeeShop();
        }
        else 
        {
            currentFactory = new DecafStyleCoffeeShop();
        }

        // Capture console output (brew/pour/etc.)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;

        System.setOut(ps);
        Coffee result = currentFactory.orderCoffee(coffeeType);
        System.out.flush();
        System.setOut(old);
        if (result == null) 
        {
            displayArea.setText("Unknown coffee type.");
        }
        else
        {
            displayArea.setText(baos.toString());
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(CoffeeGUI::new);
    }
}