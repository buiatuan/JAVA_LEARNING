package com.example.ussd.ivrService;

import java.util.ArrayList;
import java.util.List;

interface USSDComponent {
    String process(String input);
}

class USSDMenu implements USSDComponent {
    private List<USSDComponent> children = new ArrayList<>();

    public void addComponent(USSDComponent component) {
        children.add(component);
    }

    public void removeComponent(USSDComponent component) {
        children.remove(component);
    }

    public String process(String input) {
        // Logic to process the menu options
        // You can implement custom logic here based on the input
        StringBuilder response = new StringBuilder("Please select an option:\n");

        for (USSDComponent child : children) {
            response.append(child.process(input)).append("\n");
        }

        return response.toString();
    }
}

class USSDAction implements USSDComponent {
    private String action;

    public USSDAction(String action) {
        this.action = action;
    }

    public String process(String input) {
        // Logic to perform the action based on the input
        // You can implement custom logic here based on the action
        return "Performing action: " + action;
    }
}

// Example usage
class USSDGateway {
    public static void main(String[] args) {
        // Create menu options
        USSDMenu menu = new USSDMenu();

        USSDMenu option1 = new USSDMenu();
        option1.addComponent(new USSDAction("Action 1"));
        option1.addComponent(new USSDAction("Action 2"));

        USSDMenu option2 = new USSDMenu();
        option2.addComponent(new USSDAction("Action 3"));

        menu.addComponent(option1);
        menu.addComponent(option2);

        // Process input
        String userInput = "1";
        String response = menu.process(userInput);
        System.out.println(response);
    }
}

