package com.example.functionanalyser.businesslogic;

public class Logic implements VertragFirstDimension, VertragSecondDimension {


    @Override
    public String calculateTheIntersectionWithXaxis(double gradient_f, double n) {
        double x_point = -n/gradient_f;
        return "("+Math.round(x_point * 100) / 100.+"/0)";
    }

    @Override
    public double calculateTheGradient(double gradient_f) {
        return 0;
    }

    @Override
    public String calculateTheParallelFunction(double gradient_f1, double x, double y) {
        double y_intersection = y - (gradient_f1 * x);
        double y_intersectionRound = Math.round(y_intersection*100) / 100.;
        if(y_intersectionRound<0){
            return gradient_f1 + "x" + y_intersectionRound;
        }else{
            return gradient_f1 + "x + " + y_intersectionRound;
        }
    }

    @Override
    public String calculateTheIntersectionWithYaxis(double intersection_yAxis_f) {
        return "(0/"+intersection_yAxis_f+")";
    }

    @Override
    public double calculateTheAngleToXaxis(double gradient_f) {
        // ist die Steigung als Winkel < 0?
        // dann [180° - die Steigung als Winkel] anwenden
        if(gradient_f<0){
            double radiend = Math.atan(gradient_f);
            double angel = Math.toDegrees(radiend);
            double angelRound = Math.round(angel*100)/100.;
            double postiveAngelRound = angelRound*(-1);
            return  180 - postiveAngelRound;
        }else{
            double radiend = Math.atan(gradient_f);
            double angel = Math.toDegrees(radiend);
            return Math.round(angel*100)/100.;
        }
    }

    @Override
    public double calculateTheAngleEpsilon(double gradient_f, double gradient_g) {
        double angelBetweenFunction = 0.0;
        double angeldifferent = 0.0;
        double angleToXaxis_f = calculateTheAngleToXaxis(gradient_f);
        double angleToXaxis_g = calculateTheAngleToXaxis(gradient_g);
        if(angleToXaxis_f > angleToXaxis_g){
            angeldifferent = angleToXaxis_f - angleToXaxis_g;
            angelBetweenFunction = Math.round(angeldifferent * 100) / 100.;
        }else {
            angeldifferent =  angleToXaxis_g - angleToXaxis_f;
            angelBetweenFunction = Math.round(angeldifferent * 100) / 100.;
        }
        return angelBetweenFunction;
    }

    @Override
    public String calculateTheInterface(double n_f1, double m_f2, double gradiend_f1, double gradiend_f2) {
        return null;
    }

    @Override
    public String calculateTheOrthogonalLine(double gradient_f, double x_value, double y_value) {
        double reziprokeValue = -1/gradient_f;
        double reziprokeValueRound = Math.round(reziprokeValue*100)/100.;
        double y_intersection =  y_value - (reziprokeValueRound * x_value);
        if(y_intersection<0){
            return reziprokeValueRound + "x " + y_intersection;
        }else{
            return reziprokeValueRound + "x + " + y_intersection;
        }
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
