package com.example.ussd.ussdcomposite;

import com.example.ussd.CallApiViettel;
import com.example.ussd.params.UssdParamModel;

import java.util.HashMap;
import java.util.Map;

public class InitComposite implements UssdComponent {

    private static final String TITLE = "Welcome to viettel's Morrer de rir service\n"
            + "where you can find the best jokes and the best comedians.\n"
            + "Please choose what you want\n";
    private UssdParamModel ussdParamModel;

    private final Map<Character, UssdComponent> initMapUssdComponent;

    public InitComposite(UssdParamModel ussdParamModel) {
        this.ussdParamModel = ussdParamModel;
        this.initMapUssdComponent = new HashMap<>(DEFAULT_SIZE);
    }

    @Override
    public void put(char key, UssdComponent component) {
        initMapUssdComponent.put(key, component);
    }

    @Override
    public UssdComponent getChild(char key) {
        return initMapUssdComponent.get(key);
    }

    @Override
    public String getContent() {
        return TITLE + getSubMenu();
    }

    @Override
    public void execute() {
        CallApiViettel.getInstance().callApiViettelSendMenu(getContent(), ussdParamModel);
    }

    public String getSubMenu() {
        StringBuilder response = new StringBuilder();
        for (Map.Entry<Character, UssdComponent> entry : initMapUssdComponent.entrySet()) {
            response.append("Press ").append(entry.getKey()).append(": ").append(entry.getValue().getContent()).append("\n");
        }
        return response.toString();
    }
}
