package com.demoblaze.utilities.utilities;

public class BrowserUtils {
      /*
    Method that will accept int  arg
    Wait for given second duration
    //1sec = 1000 milli seconds
    //1 * 1000 = 1000
        Thread.sleep(1000);
        Thread.sleep(2000);
        Thread.sleep(3000);
        BrowserUtils.sleep(1); --> 1 second
     */
    // TODO: 6/26/21 https://www.selenium.dev/documentation/en/webdriver/waits/    for more information about selenium

    public static void sleep(int second) {

        second *= 1000;

        try {

            Thread.sleep(second);

        } catch (InterruptedException e) {

            System.out.println("something happened in the sleep method");

        }

    }
}
