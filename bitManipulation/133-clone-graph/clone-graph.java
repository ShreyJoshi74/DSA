/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node rootNode = new Node(node.val);
        
        Queue<Node> q = new LinkedList<>();

        Set<Node> set = new HashSet<>();
        q.add(node);
        set.add(node);
        Map<Node,Node> map = new HashMap<>();
        map.put(node,rootNode);

        while(!q.isEmpty()){
            Node currentNode = q.poll();
            Node newNode;
            if(map.containsKey(currentNode)){
                newNode = map.get(currentNode);
            }
            else {
                newNode = new Node(currentNode.val);
                map.put(currentNode,newNode);
            }


            for(Node nei : currentNode.neighbors){
                 Node adjNode ;
                    if(map.containsKey(nei)){
                        adjNode= map.get(nei);
                    }else{
                        adjNode = new Node(nei.val);
                        map.put(nei,adjNode);
                    }
                    newNode.neighbors.add(adjNode);
                if(!set.contains(nei)){
                    q.add(nei);
                    set.add(nei);
                   


                }
            }
        }
        return rootNode;

    }
}