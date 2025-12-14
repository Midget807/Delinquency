package net.midget807.delinquency.entity.custom.interfaces;

public interface Slimeable {
    int getSlimedTicks();
    void setSlimedTicks(int ticks);
    int getMinSlimedTicks();
    float getSlimedScale();
    boolean isSlimed();
    void setIsSlimed(boolean bl);

    int getMagmaSlimedTicks();
    void setMagmaSlimedTicks(int ticks);
    int getMinMagmaSlimedTicks();
    float getMagmaSlimedScale();
    boolean isMagmaSlimed();
    void setIsMagmaSlimed(boolean bl);
}
