package com.example.functionanalyser.businesslogic;

public interface VertragFirstDimension {
    String calculateTheIntersectionWithXaxis(double steigung, double n);
    double calculateTheGradient(double gradient_f);
    String calculateTheParallelFunction(double gradient_f1, double x, double y);
    String calculateTheIntersectionWithYaxis(double intersection_yAxis_f);
    double calculateTheAngleToXaxis(double gradient_f);
    double calculateTheAngleEpsilon(double gradient_f, double gradient_g);
    String calculateTheInterface(double n_f1, double m_f2, double gradiend_f1, double gradiend_f2);
    String calculateTheOrthogonalLine(double gradient_f, double x_value, double y_value);
}
