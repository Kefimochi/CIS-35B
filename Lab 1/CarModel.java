import org.w3c.dom.NameList;

class CarModel {
    private OptionSet opset[];
    private String name;
    private double basePrice;

    public CarModel() {
        opset = null;
        name = "";
        basePrice = 0.00;
    }

    public CarModel(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public CarModel(String name, double basePrice, int size) {
        this.name = name;
        this.basePrice = basePrice;
        opset = new OptionSet[size];
        for (int i = 0; i < opset.length; i++) {
            opset[i] = new OptionSet();
        }
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public OptionSet[] getOptionSet() {
        return opset;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setOptionSet(OptionSet opset[]) {
        this.opset = opset;
    }

    public int findOptionSetIndex(String name) {
        return 0; // <----------------------------------

    }

    public OptionSet findOptionSet(String name) {
        return null; // <------------------------
    }

    public OptionSet deleteOptionSet(String name) {
        return null; // <------------------------
    }

    public void updateOptionSet(String name, OptionSet newOpset) { // <------------------------

    }

    public void updateOptionSetName(String name, String newName) { // <------------------------

    }

    public boolean isNull() {
        return opset.equals(null);
    }

    public void print() { // <------------------------
        System.out.println("x");
    }

    // public boolean connect(UserInterface<T> endVertex) {
    // boolean result = false;

    // if (!this.equals(endVertex)) {
    // Iterator<UserInterface<T>> neighbors = this.getNeighborIterator();
    // boolean duplicateEdge = false;

    // while (!duplicateEdge && neighbors.hasNext()) {
    // UserInterface<T> nextNeighbor = neighbors.next();
    // if (endVertex.equals(nextNeighbor)) // if endVertex already exists in the
    // edge list, then connected
    // duplicateEdge = true;
    // } // end while

    // if (!duplicateEdge) {
    // this.friendsList.add(new Edge(endVertex));
    // result = true;
    // } // end if
    // } // end if
    // return result;
    // } // end connect

    // public Iterator<UserInterface<T>> getNeighborIterator() {
    // return new NeighborIterator();
    // } // end getNeighborIterator

    // public boolean hasNeighbor() {
    // return !friendsList.isEmpty();
    // } // end hasNeighbor

    // private class NeighborIterator implements Iterator<UserInterface<T>> {
    // private Iterator<Edge> edges;

    // private NeighborIterator() {
    // edges = friendsList.getIterator();
    // } // end default constructor

    // public boolean hasNext() {
    // return edges.hasNext();
    // } // end hasNext

    // public UserInterface<T> next() {
    // UserInterface<T> nextNeighbor = null;

    // if (edges.hasNext()) {
    // Edge edgeToNextNeighbor = edges.next();
    // nextNeighbor = edgeToNextNeighbor.getEndVertex();
    // } else
    // throw new NoSuchElementException();

    // return nextNeighbor;
    // } // end next

    // public void remove() {
    // throw new UnsupportedOperationException();
    // } // end remove
    // } // end NeighborIterator

    // public class Edge {
    // private UserInterface<T> vertex; // Vertex at end of edge

    // protected Edge(UserInterface<T> endVertex) {
    // vertex = endVertex;
    // } // end constructor

    // protected UserInterface<T> getEndVertex() {
    // return vertex;
    // } // end getEndVertex

    // protected double getWeight() {
    // return 0.0;
    // } // end getWeight

    // public void display() {
    // Iterator<UserInterface<T>> i = getNeighborIterator();

    // while (i.hasNext()) {
    // User<T> v = (User<T>) i.next();
    // System.out.print(v.getName() + " ");

    // } // end while
    // System.out.println();
    // }

    // public T getUser() {
    // return vertex.getName();
    // }
    // } // end Edge

    // public void display() // For testing
    // {
    // System.out.print(name + ": ");
    // Iterator<UserInterface<T>> i = getNeighborIterator();

    // while (i.hasNext()) {
    // User<T> v = (User<T>) i.next();
    // System.out.print(v.getName() + " ");

    // } // end while
    // System.out.println();
    // } // end display

    // // public void getFriends() {
    // // System.out.print("Getting all of " + name + "'s friends of friends:'");
    // // Iterator<UserInterface<T>> i = getNeighborIterator();

    // // while (i.hasNext()) {
    // // User<T> v = (User<T>) i.next();
    // // System.out.print(v.getName() + " ");

    // // } // end while
    // // System.out.println();
    // // } // end display

    // public Iterator<Edge> getFriendsIterator() {
    // return friendsList.getIterator();
    // }
} // end Vertex