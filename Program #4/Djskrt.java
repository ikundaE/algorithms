
public static void Dijkstra ( Graph g, int startVertex)
{	//for sorting distances after removing vertex from Queue
	
	float [] distantances = new float [g.getvCount ()];
	//for sortoring faterh id's after removing vertex from Queue
	int [] parents = new int [g.getvCount()];
	for (int i =0; i<g.getvCount(); i++)
	{
		parents[i] = -1;
	}
	//set up vertex queue
	PriorityQueue<Vertex> Q = new PriorityQueue <Vertex>();
	for (int i = 0 ; i <g.getvCount(); i++)
	{
		if (i != startVertex) 
		{
			q.add(new Vertex(i));
		}
	}
	//add startVertex
	Vertex node = new Vertex (startVertex);
	node.setDistance (0);
	Q.add(node);
	//loop through all vertices
	while(!Q.isEmpty())
	{//get vertex with shortes distance
		Vertex u = Q.remove();
		distance[u.getId()] = u.getDistance();
		// iterate through all neighbours
		Iterator<Edge> it = g.neighbours(u.getID()).iterator();
		while(it.hasNext())
		{
			Edge e = it.next();
			Iterator<vertex> it2 = Q.iterator();
			while(it2.hasNext())
			{//check if Vertex was visited already
				if(e.getEndPoint() != v.getId())
				{
					continue;
				}
				//check Distance
				if(v.getDistance() > u.getDistance() + e.getWeight())
				{
					v.setDistance(u.getDistance()+ e.getWeight());
					v.setParent(u);
					parents[u.getId()] = v.getParent().getId();
				}
			}
		}
	}
}


https://steemit.com/graphs/@drifter1/programming-java-graph-shortest-path-algorithm-dijkstra
http://ranger.uta.edu/~weems/NOTES2320/dijkstraHeap.java
