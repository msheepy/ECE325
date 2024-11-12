public interface Hybrid {
    public String BatteryType;

    public int charge();

    public default BatteryType getBatteryType() {
        return BatteryType.SOMEDEFAULTTYPE;
    }
}
