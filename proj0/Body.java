public class Body {
    public double xxPos;       //current x position
    public double yyPos;       //current y position
    public double xxVel;       //current velocity in the x direction
    public double yyVel;       //current velocity in the y direction
    public double mass;        //its mass
    public String imgFileName; //name of file corresponding to images to describe the body

    public Body(double xP, double yP, double xV, double yV, double mass, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        this.mass = mass;
        imgFileName = img;
    }

    public Body(Body b) {
        this(b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
    }

    public double calcDistance(Body b){
        return Math.sqrt(
            Math.pow(this.xxPos-b.xxPos, 2) + 
            Math.pow(this.yyPos-b.yyPos, 2)
        );
    }
}
