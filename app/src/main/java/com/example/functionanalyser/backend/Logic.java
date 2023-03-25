package com.example.functionanalyser.backend;

public class Logic implements VertragFirstDimension, VertragSecondDimension {


    @Override
    public double calculateTheIntersectionWithXaxis(double steigung, double n) {
        return 0;
    }

    @Override
    public double calculateTheGradient(double gradient_f) {
        return 0;
    }

    @Override
    public String calculateTheParallelFunction(double gradient_f1, double x, double y) {
        return null;
    }

    @Override
    public double calculateTheIntersectionWithYaxis(double intersection_yAxis_f) {
        return 0;
    }

    @Override
    public double calculateTheAngleToXaxis(double gradient_f) {
        return 0;
    }

    @Override
    public double calculateTheAngleEpsilon(double gradient_f, double gradient_g) {
        return 0;
    }

    @Override
    public String calculateTheInterface(double n_f1, double m_f2, double gradiend_f1, double gradiend_f2) {
        return null;
    }

    @Override
    public String calculateTheOrthogonalLine(double gradient_f, double x_value, double y_value) {
        return null;
    }

    @Override
    public String calculateTheIntersectionWithXaxis2DABC(double a, double b, double c) {
        return null;
    }

    @Override
    public String calculateTheIntersectionWithXaxis2DPQ(double p, double q) {
        return null;
    }

    @Override
    public String calculateTheIntersectionWithYaxis2D(double c) {
        return null;
    }

    @Override
    public double calculateTheIntegral(double start, double limit) {
        return 0;
    }

    @Override
    public String calculateTheTangentialFunction() {
        return null;
    }

    @Override
    public double[] calculateTheInterfacesWithAlFunction() {
        return new double[0];
    }

    @Override
    public double[] calculateTheTurningpoint() {
        return new double[0];
    }

    @Override
    public boolean isUpOpen() {
        return false;
    }
}
