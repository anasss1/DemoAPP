

package com.example.ui;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import com.yourcompany.model.Ticket;
import com.yourcompany.service.TicketService;

public class TicketCreationPanel extends JPanel {

    private TicketService ticketService;

    public TicketCreationPanel() {
        setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField(20);
        add(titleLabel, "cell 0 0");
        add(titleField, "cell 1 0");

        JLabel descriptionLabel = new JLabel("Description:");
        JTextArea descriptionArea = new JTextArea(5, 20);
        add(descriptionLabel, "cell 0 1");
        add(descriptionArea, "cell 1 1");

        JLabel priorityLabel = new JLabel("Priority:");
        JComboBox<String> priorityComboBox = new JComboBox<>(new String[]{"Low", "Medium", "High"});
        add(priorityLabel, "cell 0 2");
        add(priorityComboBox, "cell 1 2");

        JLabel categoryLabel = new JLabel("Category:");
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"Network", "Hardware", "Software", "Other"});
        add(categoryLabel, "cell 0 3");
        add(categoryComboBox, "cell 1 3");

        JButton createButton = new JButton("Create Ticket");
        createButton.addActionListener(e -> {
            Ticket newTicket = new Ticket();
            newTicket.setTitle(titleField.getText());
            newTicket.setDescription(descriptionArea.getText());
            newTicket.setPriority((String) priorityComboBox.getSelectedItem());
            newTicket.setCategory((String) categoryComboBox.getSelectedItem());
            ticketService.createTicket(newTicket);
        });
        add(createButton, "cell 0 4 2 1");
    }
}