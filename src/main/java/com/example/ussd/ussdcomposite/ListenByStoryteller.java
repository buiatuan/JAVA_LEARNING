package com.example.ussd.ussdcomposite;

import com.example.ussd.params.UssdParamModel;

import java.util.HashMap;
import java.util.Map;

public class ListenByStoryteller implements UssdComponent{

    private static final String TITLE = "To listen to the story by the storyteller" ;
    private UssdParamModel ussdParamModel;
    private final Map<Character, UssdComponent> componentMap;
    private final UssdComponent parentComponent;

    public ListenByStoryteller(UssdComponent component, UssdParamModel ussdParamModel) {
        this.parentComponent = component;
        this.ussdParamModel = ussdParamModel;
        componentMap = new HashMap<>(DEFAULT_SIZE);
    }

    @Override
    public void put(char key, UssdComponent component) {
        componentMap.put(key, component);
    }

    @Override
    public UssdComponent getChild(char key) {
        return componentMap.get(key);
    }

    @Override
    public String getContent() {
        return TITLE + getSubMenu();
    }

    @Override
    public void execute() {


        // call soap api viettel with msg "response".
    }

    public String getSubMenu() {
        StringBuilder response = new StringBuilder();
        for (Map.Entry<Character, UssdComponent> entry : componentMap.entrySet()) {
            response.append("Press ").append(entry.getKey()).append(": ").append(entry.getValue().getContent()).append("\n");
        }
        return response.toString();
    }
}
