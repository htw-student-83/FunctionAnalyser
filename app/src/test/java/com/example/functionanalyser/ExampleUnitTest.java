package com.example.functionanalyser;

import com.example.functionanalyser.backend.Logic;
import com.example.functionanalyser.backend.VertragFirstDimension;
import com.example.functionanalyser.backend.VertragSecondDimension;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    VertragFirstDimension calulatorFirstDimension = new Logic();
    VertragSecondDimension calulatorSecondDimsion = new Logic();

    // - Test the first dimension
    @Test
    public void calculateTheIntersectionWithXaxisTest() {
        double steigung = 2.0;
        double intersection_yAxis = 1.0;
        double intersection_x = calulatorFirstDimension.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.5);
    }


    @Test
    public void calculateTheIntersectionWithXaxisTest2() {
        double steigung = 2.0;
        double intersection_yAxis = -1.0;
        double intersection_x = calulatorFirstDimension.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, 0.5);
    }


    @Test
    public void calculateTheIntersectionWithXaxis3() {
        double steigung = -2.0;
        double intersection_yAxis = 1.0;
        double intersection_x = calulatorFirstDimension.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, 0.5);
    }

    @Test
    public void calculateTheIntersectionWithXaxis4() {
        double steigung = -2.0;
        double intersection_yAxis = -1.0;
        double intersection_x = calulatorFirstDimension.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.5);
    }

    @Test
    public void calculateTheIntersectionWithXaxis5() {
        double steigung = -2.5;
        double intersection_yAxis = -1.5;
        double intersection_x = calulatorFirstDimension.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.6);
    }

    @Test
    public void calculateTheIntersectionWithXaxis6() {
        double steigung = -2.5;
        double intersection_yAxis = -1.0;
        double intersection_x = calulatorFirstDimension.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.4);
    }

    @Test
    public void calculateTheIntersectionWithXaxis7() {
        double steigung = -2.0;
        double intersection_yAxis = -1.5;
        double intersection_x = calulatorFirstDimension.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.75);
    }

    @Test
    public void calculateTheInterfaceTest() {
        double intersection_yAxis_f1 = 1.0;
        double intersection_yAxis_f2 = 3.0;
        double gradient_f1 = 2.0;
        double gradient_f2 = 4.0;
        String result = calulatorFirstDimension.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result,"(-1.0/-1.0)");
    }


    @Test
    public void calculateTheInterfaceTest2() {
        double intersection_yAxis_f1 = -1.0;
        double intersection_yAxis_f2 = -3.0;
        double gradient_f1 = -2.0;
        double gradient_f2 = -4.0;
        String result = calulatorFirstDimension.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result,"(-1.0/1.0)");
    }


    @Test
    public void calculateTheInterfaceTest5() {
        double intersection_yAxis_f1 = -1.5;
        double intersection_yAxis_f2 = -3.5;
        double gradient_f1 = 2.0;
        double gradient_f2 = -4.0;
        String result = calulatorFirstDimension.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result,"(-0.3/-2.2)");
    }


    @Test
    public void calculateTheIntersectionOfFunctionsTest7() {
        double gradient_f1 = 2.0;
        double gradient_f2 = 2.0;
        double intersection_yAxis_f1 = -1.5;
        double intersection_yAxis_f2 = -3.5;
        String result = calulatorFirstDimension.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result, "No value exists.");
    }

    @Test
    public void calculateTheParallelism() {
        double gradient_f1 = -2.2;
        double gradient_f2 = -2.2;
        double intersection_yAxis_f1 = -1.5;
        double intersection_yAxis_f2 = -3.5;
        String result = calulatorFirstDimension.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result, "No value exists.");
    }

    @Test
    public void calculateTheGradient() {
        double gradient_f = -2.4;
        double gradient = calulatorFirstDimension.calculateTheGradient(gradient_f);
        Assert.assertEquals(gradient, -2.4);
    }


    @Test
    public void calculateTheGradient2() {
        double gradient_f = -2.0;
        double gradient = calulatorFirstDimension.calculateTheGradient(gradient_f);
        Assert.assertEquals(gradient, -2.0);
    }

    @Test
    public void calculateTheGradient3() {
        double gradient_f = 2.0;
        double gradient = calulatorFirstDimension.calculateTheGradient(gradient_f);
        Assert.assertEquals(gradient, 2.0);
    }


    @Test
    public void calculateTheGradient4() {
        double gradient_f = -2.2;
        double gradient = calulatorFirstDimension.calculateTheGradient(gradient_f);
        Assert.assertEquals(gradient, -2.2);
    }

    @Test
    public void calculateTheAngle() {
        double gradient_f = 2.0;
        double angelBetweenFunctions = calulatorFirstDimension.calculateTheAngleToXaxis(gradient_f);
        Assert.assertEquals(angelBetweenFunctions, 63.43);
    }

    @Test
    public void calculateTheAngle3() {
        double gradient_f = -2.0;
        double gradient_g = -3.0;
        double angelEpsilon = calulatorFirstDimension.calculateTheAngleEpsilon(gradient_f, gradient_g);
        Assert.assertEquals(angelEpsilon,8.14);
    }

    @Test
    public void calculateTheAngle4() {
        double gradient_f = 2.0;
        double gradient_g = 3.0;
        double angelEpsilon = calulatorFirstDimension.calculateTheAngleEpsilon(gradient_f, gradient_g);
        Assert.assertEquals(angelEpsilon, 8.14);
    }


    @Test
    public void calculateTheParallelism2() {
        double gradient_f1 = -2.1;
        double gradient_f2 = -2.2;
        double intersection_yAxis_f1 = -1.5;
        double intersection_yAxis_f2 = -3.5;
        String result = calulatorFirstDimension.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result, "(-20.0/40.5)");
    }

    @Test
    public void calculateTheIntersectionWithYaxisTest() {
        double intersection_yAxis_f = 1.0;
        double intersectionPoint = calulatorFirstDimension.calculateTheIntersectionWithYaxis(intersection_yAxis_f);
        Assert.assertEquals(intersectionPoint, 1.0);
    }

    @Test
    public void calculateTheIntersectionWithYaxisTest2() {
        double intersection_yAxis_f = -1.0;
        double intersectionPoint = calulatorFirstDimension.calculateTheIntersectionWithYaxis(intersection_yAxis_f);
        Assert.assertEquals(intersectionPoint, -1.0);
    }


    @Test
    public void calculateTheIntersectionWithYaxisTest3() {
        double intersection_yAxis_f = 1.5;
        double intersectionPoint = calulatorFirstDimension.calculateTheIntersectionWithYaxis(intersection_yAxis_f);
        Assert.assertEquals(intersectionPoint, 1.5);
    }


    @Test
    public void calculateTheIntersectionWithYaxisTest4() {
        double intersection_yAxis_f = -1.5;
        double intersectionPoint = calulatorFirstDimension.calculateTheIntersectionWithYaxis(intersection_yAxis_f);
        Assert.assertEquals(intersectionPoint, -1.5);
    }

    @Test
    public void calculateTheOrthogonalLine1() {
        double gradient_f = 2.0;
        double y_value = 0.0;
        double x_value = 4.0;
        String orthogonalFunction = calulatorFirstDimension.calculateTheOrthogonalLine(gradient_f, x_value, y_value);
        Assert.assertEquals(orthogonalFunction, "-0.5x+2.0");
    }

    @Test
    public void calculateTheParalismLine1() {
        double gradient_f = 2.0;
        double y_value = 0.0;
        double x_value = 4.0;
        String parallelismFunction = calulatorFirstDimension.calculateTheParallelFunction(gradient_f, x_value, y_value);
        Assert.assertEquals(parallelismFunction, "2.0x-8.0");
    }

    //  - Test the second dimension

    /**
     * "Die Funktion hat 2 Nullstellen"
     */
    @Test
    public void calculateTheInterfaceWithXaxisTest1() {
        //Hinweis bei einer quadratischen Funktion gibt es keine, eine doppelte oder 2 Nullstellen
        //TODO Work at the method
        double a = 2.0;
        double b = 1.0;
        double c = 4.0;
        String interfacePoint = calulatorSecondDimsion.calculateTheIntersectionWithXaxis2DABC(a, b, c);
        Assert.assertEquals(interfacePoint,"[x1, x2]");
    }


    /**
     * "Die Funktion hat genau eine Nullstelle"
     */
    @Test
    public void calculateTheInterfaceWithXaxisTest2() {
        //TODO Work at the method
        double p = 2.0;
        double q = 1.0;
        String interfacePoint = calulatorSecondDimsion.calculateTheIntersectionWithXaxis2DPQ(p, q);
        Assert.assertEquals(interfacePoint, "[x]");
    }


    /**
     * ("Die Funktion hat keine Nullstelle"
     */
    @Test
    public void calculateTheInterfaceWithXaxisTest3() {
        //TODO Work at the method
        double p = 2.0;
        double q = 1.0;
        String interfacePoint = calulatorSecondDimsion.calculateTheIntersectionWithXaxis2DPQ(p, q);
        Assert.assertEquals(interfacePoint, "No value exists.");
    }

    @Test
    public void calculateTheInterfaceWithYaxisTest() {
        //TODO Work at the method
        double c = 2.0;
        String interfacePoint = calulatorSecondDimsion.calculateTheIntersectionWithYaxis2D(c);
        Assert.assertEquals(interfacePoint, "(0/2)");
    }

    @Test
    public void calculateTheInterfaceWithYaxisTest2() {
        //TODO Work at the method
        double c = -2.0;
        String interfacePoint = calulatorSecondDimsion.calculateTheIntersectionWithYaxis2D(c);
        Assert.assertEquals(interfacePoint, "(0/-2)");
    }

    @Test
    public void calculateTheIntegralTest() {
        //TODO Work at the method
        double limit = 2.0;
        double start = 0;
        double a = calulatorSecondDimsion.calculateTheIntegral(start, limit);
        Assert.assertEquals(a,2.34);
    }


    @Test
    public void calculateTheTangentialFunctionTest() {
        //TODO Work at the method
        String functionT = calulatorSecondDimsion.calculateTheTangentialFunction();
        Assert.assertEquals(functionT,"Function?");
    }

    @Test
    public void calculateTheInterfacesWithAlFunctionTest3() {
        //TODO Work at the method
        double[] values = calulatorSecondDimsion.calculateTheInterfacesWithAlFunction();
        Assert.assertEquals(values,"No value exists.");
    }

    @Test
    public void calculateTheInterfacesWithAlFunctionTest() {
        //TODO Work at the method
        double[] values = calulatorSecondDimsion.calculateTheInterfacesWithAlFunction();
        Assert.assertEquals(values,"[x1, y1]");
    }

    @Test
    public void calculateTheInterfacesWithAlFunctionTest2() {
        //TODO Work at the method
        double[] values = calulatorSecondDimsion.calculateTheInterfacesWithAlFunction();
        Assert.assertEquals(values,"[x1, y1, x2, y2]");
    }

    @Test
    public void calculateTheTurningpointTest() {
        //TODO Work at the method
        double[] values = calulatorSecondDimsion.calculateTheTurningpoint();
        Assert.assertEquals(values,"[x1, y1]");
    }

    @Test
    public void openTest() {
        //TODO Work at the method
        boolean result = calulatorSecondDimsion.isUpOpen();
        Assert.assertTrue(result);
    }

    @Test
    public void openTest2() {
        //TODO Work at the method
        boolean result = calulatorSecondDimsion.isUpOpen();
        Assert.assertFalse(result);
    }
}