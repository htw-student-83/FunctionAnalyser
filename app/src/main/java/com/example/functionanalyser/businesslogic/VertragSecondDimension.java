package com.example.functionanalyser.businesslogic;

public interface VertragSecondDimension {
    String calculateTheIntersectionWithXaxis2DABC(double a, double b, double c);

    String calculateTheIntersectionWithXaxis2DPQ(double p, double q);

    String calculateTheIntersectionWithYaxis2D(double c);

    double calculateTheIntegral(double start, double limit);

    String calculateTheTangentialFunction();

    double[] calculateTheInterfacesWithAlFunction();

    double[] calculateTheTurningpoint();

    boolean isUpOpen();
}
