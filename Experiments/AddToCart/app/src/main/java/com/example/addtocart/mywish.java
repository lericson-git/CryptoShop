package com.example.addtocart;


/**
 * Input the total price and gets the outputs for various products
 */

public class mywish {
    double mywish_size_price;
    double armchair_price = 0;
    double smartWatch_price = 0;
    double ipad_price = 0;

    /**
     * Gets the price of the size
     * @return mywish_size_price
     */

    public double getMywish_size_price() {
        return mywish_size_price;
    }


    /**
     * Set the price and size
     * @param mywish_size_price
     */
    public void setMywish_size_price(double mywish_size_price) {
        this.mywish_size_price = mywish_size_price;
    }

    /**
     * Get Armchair Price
     * @return armchair_price
     */
    public double getArmchair_price() {
        return armchair_price;
    }

    /**
     * Set the armchair price
     * @param armchair_price
     */
    public void setArmchair_price(double armchair_price) {
        this.armchair_price = armchair_price;
    }

    /**
     * Get the SmartWatch price
     * @return smartWatch_price
     */
    public double getSmartWatch_price() {
        return smartWatch_price;
    }

    /**
     * set the smartWatch Price
     * @param smartWatch_price
     */
    public void setSmartWatch_price(double smartWatch_price) {
        this.smartWatch_price = smartWatch_price;
    }

    /**
     * Get the ipad price
     * @return ipad_price
     */
    public double getIpad_price() {
        return ipad_price;
    }

    /**
     * Set the ipad price
     * @param smartWatch_price
     */

    public void setIpad_price(double smartWatch_price) {
        this.ipad_price = ipad_price;
    }


}
