public class Planet {
    public double xxPos;       //current x position
    public double yyPos;       //current y position
    public double xxVel;       //current velocity in the x direction
    public double yyVel;       //current velocity in the y direction
    public double mass;        //its mass
    public String imgFileName; //name of file corresponding to images to describe the body
    public static double G = 6.67 * 1e-11;

    public Planet(double xP, double yP, double xV, double yV, double mass, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        this.mass = mass;
        imgFileName = img;
    }

    public Planet(Planet b) {
        this(b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
    }

    public double calcDistance(Planet b){
        return Math.sqrt(
            Math.pow(this.xxPos-b.xxPos, 2) + 
            Math.pow(this.yyPos-b.yyPos, 2)
        );
    }

    public double calcForceExertedBy(Planet b){
        double dist = this.calcDistance(b);
        return Planet.G * this.mass * b.mass / Math.pow(dist, 2);
    }

    public double calcForceExertedByX(Planet b){
        // force exerted on the x orient, F_1x
        double F = this.calcForceExertedBy(b);
        return F * (b.xxPos-this.xxPos)/this.calcDistance((b));
    }

    public double calcForceExertedByY(Planet b){
        // force exerted on the y orient, F_1y
        double F = this.calcForceExertedBy(b);
        return F * (b.yyPos-this.yyPos)/this.calcDistance((b));
    }

    public double calcNetForceExertedByX(Planet[] bs) {
        // netforce exerted by a bunch of planets
        double netF = 0;
        for (Planet b : bs) {
            if (this.equals(b)) continue;
            netF += this.calcForceExertedByX(b);
        }
        return netF;
    }

    public double calcNetForceExertedByY(Planet[] bs) {
        // netforce exerted by a bunch of planets
        double netF = 0;
        for (Planet b : bs) {
            if (this.equals(b)) continue;
            netF += this.calcForceExertedByY(b);
        }
        return netF;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX/this.mass, ay = fY/this.mass;
        double vx = ax*dt, vy = ay*dt;
        this.xxVel += vx; this.yyVel += vy;
        this.xxPos += dt*this.xxVel;
        this.yyPos += dt*this.yyVel;
    }

}