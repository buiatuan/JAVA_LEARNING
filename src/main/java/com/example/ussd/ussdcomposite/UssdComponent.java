package com.example.ussd.ussdcomposite;


public interface UssdComponent {
    Integer DEFAULT_SIZE = 10;
    char KEY_NON_PRESS = 0x0;
    char KEY_ZERO = '0';
    char KEY_ONE = '1';
    char KEY_TWO = '2';
    char KEY_THREE = '3';
    char KEY_FOUR = '4';
    char KEY_FIVE = '5';
    char KEY_BACK = '*';

    void put(char key, UssdComponent component);

    UssdComponent getChild(char key);

    String getContent();

    void execute();
}
