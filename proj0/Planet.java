public class Planet {
    static final double G = 6.67 * Math.pow(10, -11);

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /** Return the distance between two planets. */
    public double calcDistance(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    /** Return the force exerted on this planet by the given planet. */
    public double calcForceExertedBy(Planet p) {
        double F = (Planet.G * mass * p.mass) / Math.pow(calcDistance(p), 2);
        return F;
    }

    /** Return the force exerted in the X direction. */
    public double calcForceExertedByX(Planet p) {
        double F = calcForceExertedBy(p);
        double Fx = F * (p.xxPos - xxPos) / calcDistance(p);
        return Fx;
    }

    /** Return the force exerted in the Y direction. */
    public double calcForceExertedByY(Planet p) {
        double F = calcForceExertedBy(p);
        double Fy = F * (p.yyPos - yyPos) / calcDistance(p);
        return Fy;
    }

    /** Return net force exerted by all planets in X directions. */
    public double calcNetForceExertedByX(Planet[] ps) {
        double res = 0.0;
        int i;
        for (i = 0; i < ps.length; i += 1) {
            if (ps[i].equals(this)) {
                continue;
            }
            res += calcForceExertedByX(ps[i]);
        }
        return res;
    }

    /** Return net force exerted by all planets in Y directions. */
    public double calcNetForceExertedByY(Planet[] ps) {
        double res = 0.0;
        int i;
        for (i = 0; i < ps.length; i += 1) {
            if (ps[i].equals(this)) {
                continue;
            }
            res += calcForceExertedByY(ps[i]);
        }
        return res;
    }

    /** Update planet's velocity and postion in a small period time with forces exerted. */
    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    /** Draw this planet at correct position. */
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }

}
