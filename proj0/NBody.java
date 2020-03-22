public class NBody {
    /** Return the radius of the universe in the input file. */
    public static double readRadius(String file) {
        In in = new In(file);

        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /** Return an array pf planets corresponding to the planets in the file. */
    public static Planet[] readPlanets(String file) {
        In in = new In(file);

        int num = in.readInt();
        double radius = in.readDouble();

        Planet[] pArr = new Planet[num];
        int i;
        
        for (i = 0; i < num; i += 1) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();

            pArr[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        }

        return pArr;
    }

    public static void main(String[] args) {

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        /* Draw background. */
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");

        /* Draw all the planets. */
        for (Planet p : planets) {
            p.draw();
        }
        StdDraw.show();

        /* Animation. */
        StdDraw.enableDoubleBuffering();
        double time = 0.0;
        while (time <= T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            int i;
            for (i = 0; i < planets.length; i += 1) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (i = 0; i < planets.length; i += 1) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");

            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            
            time += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }

}
