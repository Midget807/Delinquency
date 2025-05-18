package net.midget807.trapsntrickery.seamoon.entity.interfaces;

public interface Extractable {
    int getExtractionProgress();
    int getMaxExtraction();
    void setExtractionProgress(int progress);
    void setMaxExtractionProgress(int max);
}
