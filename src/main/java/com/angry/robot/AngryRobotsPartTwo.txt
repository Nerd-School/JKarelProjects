package com.angry.robot;
//Angry Robots
//CS1 and Physics - Integrated Projectile Project

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class AngryRobots {
   // global variables
   // these can be referenced anywhere in the program
   public static double Ay = -9.8; //y acceleration (gravity)
   public static double Ax = 0;    //x acceleration (0 for this simulation)
   public static double dt = 0.1;  //time between calculations      
    
   public static void main(String[] args){
      // variables this method will be using
      double v0 = 0; //initial velocity of the projectile 
      double angleDegrees = 0; //launch angle 
   
      // Open default map and set speed
      Display.setSize(100,100);
      Display.setSpeed(8);
       
      // User input to define initial velocity and launch angle
      // the parseDouble method converts the string input to a double
      v0 = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial velocity in m/s"));
      angleDegrees = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial angle in degrees"));
   
     calculateProjectile(v0,angleDegrees);

     findBestAngle(v0, true);

     gravityTest(v0);

     horizontalWindTest(v0, 15);

     hitTargetFromAngle(30, angleDegrees);
   }
   
   public static double calculateV0X(double v0, double angleDegrees) {
      return Math.cos(Math.toRadians(angleDegrees)) * v0;
   }
   
   public static double calculateV0Y(double v0, double angleDegrees) {
      return Math.sin(Math.toRadians(angleDegrees)) * v0;
   }
   
   public static double calculateX(double v0x, double time) {
      return v0x * time + 0.5 * Ax * time * time;
   }

   public static double calculateY(double v0y, double time) {
      return v0y * time + 0.5 * Ay * time * time;
   }
   public static void calculateProjectile(double v0, double angleDegrees){
      double t = 0; //time elapsed since launch 
      double x = 0; //current x coordinate of the projectile
      double y = 0; //current y coordinate of the projectile

	  double v0x = calculateV0X(v0, angleDegrees); //initial x velocity of the projectile
	  double v0y = calculateV0Y(v0, angleDegrees); //initial y velocity of the projectile
      
      System.out.println("V0x: " + v0x);
      System.out.println("V0y: " + v0y);
   
      do {
         x = calculateX(v0x, t);
         y = calculateY(v0y, t);
         t += dt;
         new Robot((int) x, (int) y, Display.NORTH, 0);
         System.out.println (t + "," + x + ", " + y);
      } while (y >= 0);
   }
   
   // TODO: Part 2 methods will be added here 
   public static double findBestAngle(double v0, boolean printResults) {
      int bestAngle = 0;
      double bestDistance = 0;
      for(int angle = 0; angle <= 90; angle++){
         double t = 0; //time elapsed since launch
         double x = 0; //current x coordinate of the projectile
         double y = 0; //current y coordinate of the projectile

         double v0x = calculateV0X(v0, angle); //initial x velocity of the projectile
         double v0y = calculateV0Y(v0, angle); //initial y velocity of the projectile

         do {
            x = calculateX(v0x, t);
            y = calculateY(v0y, t);
            t += dt;
         } while (y >= 0);

         if (x > bestDistance) {
            bestAngle = angle;
            bestDistance = x;
         }
      }

      if (printResults) {System.out.println("The optimal angle for a velocity of " + v0 + " is " + bestAngle + " degrees with a distance of " + bestDistance); }
      return bestAngle;
   }

   public static void gravityTest(double v0){
      // setting gravity to the gravity of the moon
      Ay = -1.62;
      double bestMoonAngle = findBestAngle(v0, false);

      // setting gravity to the gravity of Earth
      Ay = -9.8;
      double bestEarthAngle = findBestAngle(v0,false);

      // setting gravity to the gravity of Jupiter
      Ay = -24.79;
      double bestJupiterAngle = findBestAngle(v0, false);

      // reset gravity
      Ay = -9.8;

      System.out.println("The best angles on different celestial bodies:\nMoon: " + bestMoonAngle + "\nEarth: " + bestEarthAngle + "\nJupiter: " + bestJupiterAngle);
   }

   public static void horizontalWindTest(double v0, double windSpeed){
      Ax = windSpeed;


      int optimalAngle = 10000000;
      double optimalDistance = 1000000;

      for (int angle = 179; angle >= 1; angle--) {
         double x;
         double y;
         double t = 0;
         double v0x = calculateV0X(v0, angle);
         double v0y = calculateV0Y(v0, angle);
         do {
            x = calculateX(v0x, t);
            y = calculateY(v0y, t);
            t += dt;
         } while (y >= 0);
         System.out.println("WINDTEST; " + angle + " degrees puts you at " + x);
         if (Math.abs(x) < Math.abs(optimalDistance)) {
            optimalAngle = angle;
            optimalDistance = x;
         }
      }

      Ax = 0;
      System.out.println("To get the projectile to return to the origin with a wind speed of " + windSpeed + " and a initial velocity of " + v0 + " you need to launch at an angle of " + optimalAngle + " which places you at x = " + optimalDistance);
   }

   public static void hitTargetFromAngle(double xDist, double angle) {
      boolean success = false;
      double bestVelocity = 0;
      double testVelocity = 0;

      while (!success) {
         double x;
         double y = 0;
         double t = 0;

         double v0x = calculateV0X(testVelocity, angle);
         double v0y = calculateV0Y(testVelocity, angle);

         do {
            x = calculateX(v0x, t);
            y = calculateY(v0y, t);
            t += dt;
         } while(y>=0);

         if (x < xDist + 0.5 && x > xDist - 0.5) {
            success = true;
            bestVelocity = testVelocity;
         }

         testVelocity += 0.5;
      }

      System.out.println("The best velocity to hit a target is " + bestVelocity);
   }



}