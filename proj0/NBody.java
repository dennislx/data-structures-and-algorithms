public class NBody {

    public static double readRadius(String path){
        In in = new In(path);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int N = in.readInt(); 
        in.readDouble();
        Planet[] res = new Planet[N];
        for (int i=0; i<N; i++){
            double xp = in.readDouble(), yp=in.readDouble(), xv = in.readDouble(), yv = in.readDouble(), mass = in.readDouble();
            String p = in.readString();
            res[i] = new Planet(xp,yp,xv,yv,mass,p);
        }
        return res;
    }

    public static void main(String[] args) {
        double T = Double.valueOf(args[0]), dt = Double.valueOf(args[1]);
        path = args[2];
        Planet[] all = readPlanets(path);
        double radius = readRadius(path);
        
    }
}