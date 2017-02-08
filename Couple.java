import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
public class Couple{
    private Graph g;
    private int k;

    public Couple(Graph g, int k){
        //Lors de la création d'un couple il faut cloner un graph
        //a partir de celui passé en parametre pour ne pas modifier ce dernier
        this.k=k;
        Graph f = new SingleGraph("A modifier");
		this.g = Graphs.clone(g);
    }
    public int getK(){
        return this.k;
    }
    public void afficherGraph(){
        this.getG().display();
    }
    public Graph getG(){
        return this.g;
    }
}
