package com.example.ussd.ussdcomposite;

import java.util.HashMap;

public class ComponentGetWay {

    private final HashMap<String, UssdComponent> allComponents = new HashMap<>();

    public static ComponentGetWay getInstance() {
        return ComponentGetWayHolder.INSTANCE;
    }

    private ComponentGetWay() {

    }

    public void register(String branchIndex, UssdComponent component) {
        if (allComponents.containsKey(branchIndex)) {
            throw new IllegalStateException("Branch index " + branchIndex + " is already registered");
        }
        allComponents.put(branchIndex, component);
    }

    public void goToBranch(String branchIndex) {
        UssdComponent component = getComponent(branchIndex);
        if (component == null) {
            throw new IllegalStateException("Branch index " + branchIndex + " is not registered");
        }
        component.execute();
    }

    public UssdComponent getComponent(String branchIndex) {
        return allComponents.get(branchIndex);
    }

    void clearComponent() {
        allComponents.clear();
    }

    private static final class ComponentGetWayHolder {
        private static final ComponentGetWay INSTANCE = new ComponentGetWay();
    }
}
